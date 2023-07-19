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
    
    public int capacity() {      //장바구니의 용량을 반환
        if (cart != null) {
            return cart.getCapacity();
        } else {
            return 2; // 2 반환 
        }
    }



 
    public void choose(Item item) {			//고객이 상품을 선택할때 호출되는 메소드

    	if (cart == null) {
    		cart = new Cart(2); 	 // -> 용량이 2인 카트 
    }
    	cart.addItem(item);	    // 상품 추가 
    	
    	if (item != null) {
        total += item.getPrice();
    }
}
    @Override
    public String toString() {					//문자열 표현 메소드
        StringBuilder sb = new StringBuilder(); 		
        sb.append(String.format("Customer{%s, ", name)); 	 //고객과 이름 포멧해서 추가
        if (cart != null) {							
            sb.append("[");
            List<Item>	 items = cart.getItems();      //상품 리스트 가져오기
            if (items.isEmpty()) {   //상품 리스트가 비어있으면 null출력
                sb.append("null, null, null, null, null");
            } else {
                for (Item item : items) {
                    sb.append(item).append(" ");
                }
                sb.setLength(sb.length() - 2); // 마지막으로 추가된 컴마 제거
            }
            sb.append("");
        }
        
        else {
        	sb.append("[");
        	sb.append("null,null");
        }
        
        	
        sb.append("]}");
        return sb.toString();
    
        }
    

    }
