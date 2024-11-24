public class Enemy extends Character
{

    private Item droppedItem;

    public Enemy(String name, int attack, int defense, int health, Item droppedItem)
    {
        super(name, attack, defense, health);
        this.droppedItem = droppedItem;
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

    @Override
    public void die() {
        alive = false;
        System.out.println(name + " a murit si a dropat un obiect.");
    }
    public int getHealth() {
        return health;
    }

    public Item getDroppedItem()
    {
        return droppedItem;
    }

    @Override
    public String toString() {
        return "Enemy{" +
                "name='" + name + '\'' +
                ", attack=" + attack +
                ", defense=" + defense +
                ", health=" + health +
                ", alive=" + alive +
                droppedItem + '\'' +
                '}';
    }
}
