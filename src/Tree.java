public class Tree extends Gatherable {

    public Tree(int quantity, Quality quality)
    {
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
        System.out.println("Ai taiat un copac de calitate " + quality + " si ai colectat " + getQualityMultiplier() * quantity + " unitati de lemn.");
    }

    @Override
    public String toString() {
        return "Tree{" +
                "quantity=" + quantity +
                ", quality=" + quality +
                '}';
    }
}
