public class Tree extends Gatherable{

    public Tree(int quantity,Quality quality)
    {
        super(quantity,quality);
    }

    @Override
    public void gather()
    {
        int totalGathered= quantity * getQuality();
        System.out.println("You gathered" + totalGathered + "wood");
    }

    private int getQuality()
    {
        if( quality == Quality.COMMON)
        {
            return 1;
        }
        else if ( quality == Quality.RARE)
        {
            return 2;
        }
        else return 3;
    }

    @Override
    public String toString() {
        return "Tree{" +
                "quantity=" + quantity +
                ", quality=" + quality +
                '}';
    }

}
