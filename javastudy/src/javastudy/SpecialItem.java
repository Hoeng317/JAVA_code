package javastudy;

class SpecialItem extends Item {
    private int bonusPrice;

    public SpecialItem(String name, int price, int bonusPrice) {
        super(name, price);
        this.bonusPrice = bonusPrice;
    }

    public int getBonusPrice() {
        return bonusPrice;
    }

    @Override
    public int getPrice() {
        return super.getPrice() + bonusPrice;
    }

    @Override
    public String toString() {
        return super.toString() + " +";
    }
}