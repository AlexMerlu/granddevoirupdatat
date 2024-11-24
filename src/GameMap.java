import java.util.Map;
import java.util.HashMap;

public class GameMap {
    private char[][] map;
    private int playerX;
    private int playerY;
    private Map<String, Gatherable> gatherables = new HashMap<>();

    public GameMap(int randuri,int coloane)
    {
        map= new char[randuri][coloane];
        for(int i=0;i<randuri;i++)
        {
            for(int j=0;j<coloane;j++)
            {
                map[i][j]='.';
            }
        }
    }

    public void placeTree(int x, int y, Tree tree) {
        gatherables.put(x + "," + y, tree);
        map[x][y] = 'W';
    }

    public void placeRock(int x, int y, Rock rock) {
        gatherables.put(x + "," + y, rock);
        map[x][y] = 'R';
    }

    public void placeFood(int x, int y, Food food) {
        gatherables.put(x + "," + y, food);
        map[x][y] = 'F';
    }


    public void placePlayer(int x,int y)
    {
        playerX=x;
        playerY=y;
        map[x][y]='P';
    }

    public void printMap()
    {

        for(int i=0;i< map.length;i++)
        {
            for (int j = 0; j < map[i].length; j++)
            {
                System.out.print(map[i][j]+ " ");
            }
            System.out.println();
        }
    }

    public int getPlayerX()
    {
        return playerX;
    }

    public int getPlayerY()
    {
        return playerY;
    }

    public int getRanduri()
    {
        return map.length;
    }
    public int getColoane()
    {
        return map[0].length;
    }

    public void movePlayer(int newX, int newY, Player player, Map<String, Enemy> enemies) {
        char current = map[newX][newY];
        String key = newX + "," + newY;
        switch (current) {
            case 'W': // Lemn
                Tree tree = (Tree) gatherables.get(key);
                if (tree != null) {
                    int woodCollected = tree.getQualityMultiplier() * tree.getQuantity();
                    System.out.println("Ai colectat " + woodCollected + " unitati de lemn.");
                    player.collectWood(woodCollected);
                    gatherables.remove(key); // Eliminam obiectul colectat
                    map[newX][newY] = '.'; // Golim locul
                }
                break;

            case 'R': // Piatra
                key = newX + "," + newY;
                Rock rock = (Rock) gatherables.get(key);
                if (rock != null) {
                    int stoneCollected = rock.getQualityMultiplier() * rock.getQuantity();
                    System.out.println("Ai colectat " + stoneCollected + " unitati de piatra.");
                    player.collectStone(stoneCollected);
                    gatherables.remove(key);
                    map[newX][newY] = '.';
                }
                break;

            case 'F': // Hrană
                key = newX + "," + newY;
                Food food = (Food) gatherables.get(key);
                if (food != null) {
                    int foodCollected = food.getQualityMultiplier() * food.getQuantity();
                    System.out.println("Ai colectat " + foodCollected + " unitati de hrana.");
                    player.collectFood(foodCollected);
                    gatherables.remove(key);
                    map[newX][newY] = '.';
                }
                break;


            case 'E':
                Enemy enemy = enemies.get(key);
                System.out.println("Te-ai intalnit cu un inamic: " + enemy.getName());
                while (player.isAlive() && enemy.isAlive()) {
                    enemy.takeDamage(player.damage());
                    if (enemy.isAlive()) {
                        player.takeDamage(enemy.damage());
                    }

                    System.out.println(player.getName() + " are " + player.getHealth() + " HP.");
                    System.out.println(enemy.getName() + " are " + enemy.getHealth() + " HP.");
                }

                if (!enemy.isAlive()) {
                    System.out.println("Ai invins inamicul si acesta a dropat un obiect: " + enemy.getDroppedItem().getName());
                    player.collectItem(enemy.getDroppedItem());
                    map[newX][newY] = '.'; // Golim locul
                    enemies.remove(key);  // Eliminam inamicul din harta
                } else {
                    player.die();
                }
                return; // Oprim executia pentru lupta
            default:
                break;
        }

        // Mutam jucatorul
        map[playerX][playerY] = '.'; // Golim pozitia anterioara
        playerX = newX;
        playerY = newY;
        map[playerX][playerY] = 'P'; // Actualizam pozitia jucatorului
    }


    public void processCommand(String command, Player player, Map<String, Enemy> enemies) {
        int newX = playerX;
        int newY = playerY;

        if (command.equalsIgnoreCase("W")) {
            newX = playerX - 1;
        } else if (command.equalsIgnoreCase("A")) {
            newY = playerY - 1;
        } else if (command.equalsIgnoreCase("S")) {
            newX = playerX + 1;
        } else if (command.equalsIgnoreCase("D")) {
            newY = playerY + 1;
        } else {
            System.out.println("Comanda invalida!");
            return;
        }

        if (newX >= 0 && newX < map.length && newY >= 0 && newY < map[0].length) {
            movePlayer(newX, newY, player, enemies); // Trecem harta de inamici
        } else {
            System.out.println("Nu poti iesi din harta!");
        }
    }



    public void placeEnemy(int x,int y)
        {
            map[x][y] = 'E';
        }

        public void placeBuilding(int x,int y)
        {
            map[x][y] = 'B';
        }

        public void placeWood(int x,int y)
        {
            map[x][y]='W';
        }
        public void placeRock(int x,int y)
        {
            map[x][y]='R';
        }
        public void placeFood(int x,int y)
        {
            map[x][y]='F';
        }
    public void buildStructure(Player player, Building building, int x, int y) {
        if (map[x][y] == '.' || map[x][y] == 'P') { // Permitem construirea pe pozitia jucatorului
            if (player.canBuild(building))
            {
                player.build(building);
                System.out.println("Cladirea " + building.getName() + " a fost construita la (" + x + ", " + y + ").");
                if (map[x][y] != 'P')
                { // Daca nu e pozitia jucatorului, actualizam simbolul
                    map[x][y] = 'B'; // Reprezentam cladirea cu 'B'
                }
            } else
            {
                System.out.println("Nu ai suficiente resurse pentru a construi cladirea!");
            }
        } else
        {
            System.out.println("Locul nu este gol!");
        }
    }





}
