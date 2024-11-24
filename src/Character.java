public abstract class Character {

    protected String name;
    protected int attack;
    protected int defense;
    protected int health;
    protected boolean alive;

    public Character(String name, int attack, int defense, int health)
    {
        this.name = name;
        this.attack = attack;
        this.defense = defense;
        this.health = health;
        this.alive = alive;
    }

    public abstract int damage();

    public abstract void takeDamage(int damage);

    public abstract  void die();

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAttack()
    {
        return attack;
    }

    public void setAttack(int attack)
    {
        this.attack = attack;
    }

    public int getDefense()
    {
        return defense;
    }

    public void setDefense(int defense)
    {
        this.defense = defense;
    }

    public int getHealth()
    {
        return health;
    }

    public void setHealth(int health)
    {
        this.health = health;
    }

    public boolean isAlive()
    {
        return alive;
    }

    public void setAlive(boolean alive)
    {
        this.alive = alive;
    }

    @Override
    public String toString()
    {
        return "Character{" +
                "name='" + name + '\'' +
                ", attack=" + attack +
                ", defense=" + defense +
                ", health=" + health +
                ", alive=" + alive +
                '}';
    }
}
