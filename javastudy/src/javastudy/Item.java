package javastudy;

public class Item {
    private String name;
    private int price;

    public Item(String name, int price) {   //클래스의 생성자
        this.name = name;		
        this.price = price;		
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
        
    }

    @Override
    public String toString() {
        return String.format("Item{%s, %4d}", getName(), getPrice());  //아이템의 이름과 가격을 포맷하여 문자열로 반환
    }
}
// string.foramt 메서드 -> 문자열의 형식을 지정하는 메서드 %d (10진수 형식)
/* 
%s (문자열 형식)
%f (실수형 형식)
Locale 설정
%t (날짜시간 형식)
%c (유니코드 문자 형식) 올ㅋ
%o, %x(8진수, 16진수 형식)
*/