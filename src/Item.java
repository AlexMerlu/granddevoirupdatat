public class Item
{
    private String name;
    private int attackBoost;
    private int defenseBoost;
    private int healthBoost;

    public Item(String name, int attackBoost, int defenseBoost, int healthBoost)
    {
        this.name = name;
        this.attackBoost = attackBoost;
        this.defenseBoost = defenseBoost;
        this.healthBoost = healthBoost;
    }

    public String getName()
    {
        return name;
    }

    public int getAttackBoost()
    {
        return attackBoost;
    }

    public int getDefenseBoost()
    {
        return defenseBoost;
    }

    public int getHealthBoost()
    {
        return healthBoost;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", attackBoost=" + attackBoost +
                ", defenseBoost=" + defenseBoost +
                ", healthBoost=" + healthBoost +
                '}';
    }
}
