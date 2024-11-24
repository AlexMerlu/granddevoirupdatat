import java.util.Comparator;
public class ItemHealthComparator implements Comparator<Item>
{
    @Override
    public int compare(Item o1, Item o2)
    {
        return Integer.compare(o2.getHealthBoost(), o1.getHealthBoost());
    }
}
