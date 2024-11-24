import java.util.Comparator;
public class ItemAttackComparator implements Comparator<Item>{
    @Override
    public int compare(Item o1,Item o2)
    {
        return Integer.compare(o2.getAttackBoost(),o1.getAttackBoost());
    }
}
