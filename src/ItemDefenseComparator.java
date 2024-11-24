import java.util.Comparator;
public class ItemDefenseComparator implements Comparator<Item>
{
    @Override
    public int compare(Item o1, Item o2)
    {
        return Integer.compare(o2.getDefenseBoost(), o1.getDefenseBoost());
    }
}
