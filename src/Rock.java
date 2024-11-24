public class Rock extends Gatherable {

    public Rock(int quantity, Quality quality) {
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
        System.out.println("Ai spart o piatra de calitate " + quality + " si ai colectat " + getQualityMultiplier() * quantity + " unitati de piatra.");
    }

    @Override
    public String toString() {
        return "Rock{" +
                "quantity=" + quantity +
                ", quality=" + quality +
                '}';
    }
}
