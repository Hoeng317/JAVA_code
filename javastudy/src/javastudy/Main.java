package javastudy;
import java.util.Random;

public class Main {
	public static void main(String[] args) {
		Random random = new Random();
		
		final int N_ITEM = 10;
		Item[] items = createItems(random, N_ITEM);
		System.out.println();
		
		final int N_CUSTOMER = 5;
		final int CART_CAPACITY = 5;
		Customer[] customers = createCustomers(random, N_CUSTOMER, CART_CAPACITY);
		System.out.println();
		
		doShopping(random, items, customers);
		System.out.println();
		
		summary(customers);
	}

	private static Item[] createItems(Random random, int n) {
		Item[] items = new Item[n];
		System.out.println("<Item List>");
		for (int i = 0; i < n; i++) {
			String itemName = String.valueOf((char)('a' + i));
			if (random.nextDouble() < 0.5) {  // randomly 50% of item is special
				items[i] = new SpecialItem(
						itemName, random.nextInt(100) * 50, random.nextInt(100) * 10);
			}
			else
				items[i] = new Item(itemName, random.nextInt(100) * 50);
			System.out.println(items[i]);
		}
		return items;
	}

	private static Customer[] createCustomers(Random random, int n, int capacity) {
		Customer[] customers = new Customer[n];	
		System.out.println("<Customer List>");
		for (int i = 0; i < n; i++) {
			String customerName = String.valueOf((char)('A' + i));
			if (random.nextDouble() < 0.5) {  // randomly 50% of customers use cart
				Cart cart = new Cart(capacity);
				customers[i] = new Customer(customerName, cart);
			}
			else  // other customers use hands
				customers[i] = new Customer(customerName);  
			
			System.out.println(customers[i]);
		}
		return customers;
	}

	private static void doShopping(Random random, Item[] items, Customer[] customers) {
		System.out.println("<Shopping>");
		for (Customer c : customers) {
			for (int i = 0; i < c.capacity(); i++)
				c.choose(items[random.nextInt(items.length)]);  // choose random item
			
			System.out.println(c);
		}
	}

	private static void summary(Customer[] customers) {
		System.out.println("<Summary>");
		final String FORMAT =  "Customer '%s' purchased a total of [%5d] won worth of items.";
		for (Customer c : customers) {
			System.out.println(String.format(FORMAT, c.getName(), c.getTotal()));
		}
	}
}
