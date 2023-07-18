package javastudy;

import java.util.List;


class Customer {
    private String name;
    private Cart cart;
    private int total;

    public Customer(String name) {
        this.name = name;
        this.cart = null;
        this.total = 0;
    }

    public Customer(String name, Cart cart) {
        this.name = name;
        this.cart = cart;
        this.total = 0;
    }

    public String getName() {
        return name;
    }

    public Cart getCart() {
        return cart;
    }

    public int getTotal() {
        return total;
    }

    public void choose(Item item) {
        if (cart != null) {
            if (cart.addItem(item)) {
                total += item.getPrice();
            }
        } else {
            total += item.getPrice();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Customer{%s, ", name));
        if (cart != null) {
            sb.append("[");
            List<Item> items = cart.getItems();
            if (items.isEmpty()) {
                sb.append("NULL");
            } else {
                for (Item item : items) {
                    sb.append(item).append(", ");
                }
                sb.setLength(sb.length() - 2); // Remove the trailing comma and space
            }
            sb.append("]");
        }
        sb.append("}");
        return sb.toString();
    }

    public int capacity() {
        if (cart != null) {
            return cart.getCapacity();
        } else {
            return 2; // Default capacity if no cart is assigned
        }
    }
}
