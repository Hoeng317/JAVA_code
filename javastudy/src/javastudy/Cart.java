package javastudy;

import java.util.ArrayList;
import java.util.List;

class Cart {
    private List<Item> items;   //아이템 리스트 생성
    private int capacity;		// 용량을 나타내는 capacity 생성

    public Cart(int capacity) {
        this.capacity = capacity;
        this.items = new ArrayList<>();   //아이템을 ArrayList로 초기화
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isFull() {
        return items.size() >= capacity; //아이템 크기가 capacity 이상이면 true 아니면 false
    }

    public boolean addItem(Item item) {   //주어진 아이템 카트에 추가하기
        if (!isFull()) {
            items.add(item);
            return true;
        }
        return false;   // 카트가 가득 찬 경우 
    }

    public List<Item> getItems() {
        return items;     //아이템 리스트 반환
    }

    @Override
    public String toString() {    //카트의 문자열 반환 비어있으면 Empty
        if (items.isEmpty()) {
            return "Empty";
        }

        StringBuilder sb = new StringBuilder();
        for (Item item : items) {
            sb.append(item.getName()).append(",");
        }
        sb.setLength(sb.length() - 2); 
        return sb.toString();
    }
}