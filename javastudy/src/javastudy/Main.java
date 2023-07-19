package javastudy;

import java.util.Random;

public class Main {
	public static void main(String[] args) {
		Random random = new Random();         //랜덤 객체 생성 
		
		final int N_ITEM = 10;						// 아이템 수 -> 상수
		Item[] items = createItems(random, N_ITEM); 		//아이템 배열 저장 
		System.out.println();
		
		final int N_CUSTOMER = 5;					// 고객 수 -> 상수
		final int CART_CAPACITY = 5;				// 카트 용량 -> 상수
		Customer[] customers = createCustomers(random, N_CUSTOMER, CART_CAPACITY);   //고객 배열 저장
		System.out.println();
		
		doShopping(random, items, customers); 
		System.out.println();
		
		summary(customers);
	}

	private static Item[] createItems(Random random, int n) {   //주어진 개수 n에 따라 랜덤한 아이템 배열 생성
		Item[] items = new Item[n];   //아이템 배열이 n으로 생성
		System.out.println("<Item List>");		
		for (int i = 0; i < n; i++) {             // 크기 n의 item 배열 items 생성
			String itemName = String.valueOf((char)('a' + i));   //a부터 j까지 생성 (10개)
			if (random.nextDouble() < 0.5) {  // 50%확률 -> 안되면 스페셜아이템
				items[i] = new SpecialItem(
						itemName, random.nextInt(100) * 50, random.nextInt(100) * 10);   //임의 가격에 50을 곱하고 보너스 가격에 10곱함
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
		for (int i = 0; i < n; i++) {			//n명의 고객 생성
			String customerName = String.valueOf((char)('A' + i));   //A부터 고객 생성
			if (random.nextDouble() < 0.5) {     //50% 확률로 카트를 사용 여부 결정 
				Cart cart = new Cart(capacity);		//capacity 용량을 가진 cart 생성
				customers[i] = new Customer(customerName, cart);
			}											//  고객이름과 카트를 가지는 customer 생성 -> 배열에 넣음
			else  
				customers[i] = new Customer(customerName);   // 카트를 사용하지 않는 경우
			
			System.out.println(customers[i]);
		}
		return customers;
	}

	private static void doShopping(Random random, Item[] items, Customer[] customers) {
		System.out.println("<Shopping>");
		for (Customer c : customers) {     //해당 고객의 용량에 따라 반복문 실행
			for (int i = 0; i < c.capacity(); i++)
				c.choose(items[random.nextInt(items.length)]);  // 인덱스 범위 내에서 무작위로 아이템 선택 선택된 아이템운 카트에 저장 
			
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
