import java.util.ArrayList;
import java.util.List;
public class Player extends Character
{

    private int wood;
    private int stone;
    private int food;
    private List<Item> inventory;

    public Player(String name, int attack,int defense,int health)
    {
        super(name,attack,defense,health);
        this.wood=0;
        this.stone=0;
        this.food=0;
        this.alive=health>0;
        this.inventory=new ArrayList<>();
    }

    @Override
    public int damage()
    {
        return attack;
    }

    @Override
    public void takeDamage(int damage) {
        int actualDamage = damage - defense;

        if (actualDamage > 0) {
            health -= actualDamage;
            System.out.println(name + " a primit " + actualDamage + " daune. HP ramas: " + health);
        } else {
            System.out.println(name + " a blocat atacul.");
        }

        if (health <= 0) {
            die();
        }
    }




    public void collectItem(Item item)
    {
        inventory.add(item);
        System.out.println("Ai colectat un obiect: " + item.getName());
    }

    @Override
    public void die()
    {
        alive=false;
        System.out.println(name + " a murit. RIP bro xx");
    }

    public void collectWood(int amount)
    {
        wood = wood + amount;
    }
    public void collectStone(int amount)
    {
        stone= stone + amount;
    }
    public void collectFood(int amount)
    {
        food= food + amount;
    }

    public int getWood() {
        return wood;
    }

    public int getStone() {
        return stone;
    }

    public int getFood() {
        return food;
    }
    public int getHealth() {
        return health;
    }

    public List<Item> getInventory()
    {
        return inventory;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", attack=" + attack +
                ", defense=" + defense +
                ", health=" + health +
                ", alive=" + alive +
                ", wood=" + wood +
                ", stone=" + stone +
                ", food=" + food +
                '}';
    }
    public void applyItemEffects(Item item) {
        this.attack += item.getAttackBoost();
        this.defense += item.getDefenseBoost();
        this.health += item.getHealthBoost();

        System.out.println("Efectele obiectului aplicate: " +
                "Atac + " + item.getAttackBoost() +
                ", Aparare + " + item.getDefenseBoost() +
                ", Sanatate + " + item.getHealthBoost());
    }

    public boolean canBuild(Building building) {
        return wood >= building.getWoodCost() && stone >= building.getStoneCost();
    }

    public void build(Building building) {
        if (canBuild(building)) {
            wood -= building.getWoodCost();
            stone -= building.getStoneCost();
            System.out.println("Ai construit: " + building.getName());
            building.applyEffect(this);
        } else {
            System.out.println("Nu ai suficiente resurse pentru a construi " + building.getName());
        }
    }




}
