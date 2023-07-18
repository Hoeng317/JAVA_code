package javastudy;

import java.util.ArrayList;
import java.util.List;


class Cart {
    private List<Item> items;
    private int capacity;

    public Cart(int capacity) {
        this.capacity = capacity;
        this.items = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isFull() {
        return items.size() >= capacity;
    }

    public boolean addItem(Item item) {
        if (!isFull()) {
            items.add(item);
            return true;
        }
        return false;
    }

    public List<Item> getItems() {
        return items;
    }

    @Override
    public String toString() {
        if (items.isEmpty()) {
            return "Empty";
        }

        StringBuilder sb = new StringBuilder();
        for (Item item : items) {
            sb.append(item.getName()).append(", ");
        }
        sb.setLength(sb.length() - 2); // Remove the trailing comma and space
        return sb.toString();
    }
}