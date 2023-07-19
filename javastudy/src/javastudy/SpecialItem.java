package javastudy;

class SpecialItem extends Item {
    private int bonusPrice;

    public SpecialItem(String name, int price, int bonusPrice) {
        super(name, price);     			//아이템 클래스 생성자 호출
        this.bonusPrice = bonusPrice;
    }

    public int getBonusPrice() {
        return bonusPrice;
    }

    @Override
    public int getPrice() {
        return super.getPrice()+ bonusPrice;
    }

    @Override
public String toString() {
    String itemName = getName()+ "+";
    int price = getPrice();
    String BonusPrice = "" + getBonusPrice();
    return String.format("Item{%s, %s, %s}", itemName, price, BonusPrice);
    }
}