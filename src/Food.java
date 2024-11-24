public class Food extends Gatherable {

    public Food(int quantity, Quality quality) {
        super(quantity, quality);
    }

    public int getQualityMultiplier() {
        switch (quality) {
            case RARE:
                return 2;
            case EPIC:
                return 3;
            default:
                return 1;
        }
    }

    @Override
    public void gather() {
        System.out.println("Ai colectat hrana de calitate " + quality + " si ai obtinut " + getQualityMultiplier() * quantity + " unitati de hrana.");
    }

    @Override
    public String toString() {
        return "Food{" +
                "quantity=" + quantity +
                ", quality=" + quality +
                '}';
    }
}
