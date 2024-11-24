public class Building
{

    private String name;
    private int woodCost;
    private int stoneCost;
    private String effect;

    public Building(String name, int woodCost, int stoneCost, String effect)
    {
        this.name = name;
        this.woodCost = woodCost;
        this.stoneCost = stoneCost;
        this.effect = effect;
    }

    public void applyEffect(Player player)
    {
        if(effect.equals("Restore health"))
        {
            player.setHealth(100);

            if(!player.isAlive())
            {
                player.setAlive(true);
                System.out.println("Ai hp-ul plin. Bravo :D");
            }
        }
        else if (effect.equals("Boost attack"))
        {
            player.setAttack(player.getAttack()+10);
            System.out.println(player.getName() + " a primit un attack boost de +10!");
        }
        else if (effect.equals("Boost defense"))
        {
            player.setDefense(player.getDefense()+4);
            System.out.println(player.getName()+ "si-a crescut apararea cu +4.");
        }
        else
        {
            System.out.println("Efect necunoscut pentru cladire? :(");
        }
    }

    public String getName()
    {
        return name;
    }

    public int getWoodCost()
    {
        return woodCost;
    }

    public int getStoneCost()
    {
        return stoneCost;
    }

    public String getEffect()
    {
        return effect;
    }



    @Override
    public String toString() {
        return "Building{" +
                "name='" + name + '\'' +
                ", woodCost=" + woodCost +
                ", stoneCost=" + stoneCost +
                ", effect='" + effect + '\'' +
                '}';
    }
}
