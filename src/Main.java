import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        GameMap gameMap = new GameMap(5, 5);
        Player player = new Player("Hero", 10, 5, 100);


        Map<String, Enemy> enemies = new HashMap<>();


        Enemy goblin = new Enemy("Goblin", 10, 3, 30, new Item("Sword", 5, 0, 0));
        enemies.put("1,3", goblin);
        gameMap.placeEnemy(1, 3);


        gameMap.placePlayer(2, 2);
        gameMap.placeTree(1, 1, new Tree(3, Gatherable.Quality.RARE));
        gameMap.placeRock(3, 3, new Rock(2, Gatherable.Quality.COMMON));
        gameMap.placeFood(0, 4, new Food(5, Gatherable.Quality.EPIC));



        Scanner scanner = new Scanner(System.in);

        while (true) {
            gameMap.printMap();
            System.out.println("Introdu o comanda (W/A/S/D pentru miscare, B pentru a construi o cladire sau Q pentru iesire):");
            String command = scanner.nextLine();


            if (command.equalsIgnoreCase("Q")) {
                System.out.println("Joc terminat!");
                break;
            }
            if (command.equalsIgnoreCase("B")) {
                System.out.println("Ce cladire doresti sa construiesti? (1 - Fantana Vietii, 2 - Monumentul Sabiei, 3 - Fortareata)");
                String choice = scanner.nextLine();
                Building building = null;

                switch (choice) {
                    case "1":
                        building = new Building("Fantana Vietii", 2, 0, "Restore health");
                        break;
                    case "2":
                        building = new Building("Monumentul Sabiei", 0, 2, "Boost attack");
                        break;
                    case "3":
                        building = new Building("Fortareata", 1, 1, "Boost defense");
                        break;
                    default:
                        System.out.println("Optiune invalida!");
                        continue;
                }


                gameMap.buildStructure(player, building, gameMap.getPlayerX(), gameMap.getPlayerY());
                continue;
            }

            gameMap.processCommand(command, player, enemies);


            System.out.println("Resurse colectate: Lemn = " + player.getWood() + ", Piatra = " + player.getStone() + ", Hrana = " + player.getFood());
            System.out.println("Statistici jucator: " + player);


            if (!player.isAlive()) {
                System.out.println("Jocul s-a terminat! Jucatorul a murit.");
                break;
            }
        }

        scanner.close();
    }
}
