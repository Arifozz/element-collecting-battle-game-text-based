import java.util.Scanner;

public class Game {
    private final Scanner sc = new Scanner(System.in);

    // Lokasyonları bir kez tanımlıyoruz
    private Location safeHouse;
    private Location toolStore;
    private BattleLocation cave; // Cave'i BattleLocation olarak tutuyoruz
    private BattleLocation forest;
    private BattleLocation riverSide;

    public void start() {
        System.out.println("Game Started");
        System.out.print("Enter a name:");
        String name = sc.nextLine();
        Player player = new Player(name);
        System.out.println("Welcome " + player.getName().toUpperCase());
        player.selectCharacter();
        // Lokasyonları oluşturuyoruz
        safeHouse = new SafeHouse(player);
        toolStore = new ToolStore(player);
        cave = new Cave(player);  // Cave'i bir kez oluşturuyoruz
        forest = new Forest(player);
        riverSide = new RiverSide(player);

        Location location = null;
        while (true) {
            player.playerInfo();
            System.out.println("************ LOCATIONS ************");
            System.out.println("---------------");
            System.out.println("1- Safe House");
            System.out.println("2- Tool Store");
            System.out.println("3- Cave");
            System.out.println("4- Forest");
            System.out.println("5- River Side");
            System.out.println("---------------");

            System.out.print("Enter a location:");
            int selection = sc.nextInt();
            switch (selection) {
                case 1:
                    location = safeHouse; // Tekrar aynı nesneyi kullanıyoruz
                    break;
                case 2:
                    location = toolStore;
                    break;
                case 3:
                    // Burada Cave'a girmeden önce, elementin toplanıp toplanmadığını kontrol ediyoruz
                    if (player.getInventory().hasElementByName("Food")) {  // Cave nesnesinin toplanıp toplanmadığını kontrol ediyoruz
                        System.out.println("You looted Food already --> You can move to the next location!!");
                        location = null;
                    } else {
                        location = cave; // Cave'e girmeye izin veriyoruz
                    }
                    break;
                case 4:
                    if (player.getInventory().hasElementByName("Firewood")) {
                        System.out.println("You looted Wood already --> You can move to the next location!!");
                        location=null;
                    }else {
                        location = forest;
                    }
                    break;
                case 5:
                    if (player.getInventory().hasElementByName("Water")) {
                        System.out.println("You looted Water already --> You can move to the next location!!");
                        location=null;
                    }else {
                        location = riverSide;
                    }
                    break;
                default:
                    System.out.println("Invalid selection");
            }

            if (player.getInventory().hasElementByName("Food")
                    && player.getInventory().hasElementByName("Firewood")
                    &&player.getInventory().hasElementByName("Water")) {
                System.out.println("You Win the Game By Looted All the Elements Successfully! ");
                System.out.println("Looted All the Elements!");
                break;

            }
            // Eğer geçerli bir location seçilmişse ve orada yapılacak bir işlem varsa
            if (location != null && !location.onLocation()) {
                System.out.println("Game Over");
                break;
            }
        }
    }
}
