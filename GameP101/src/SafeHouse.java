import java.util.Scanner;

public class SafeHouse extends NormalLocation{
    public SafeHouse( Player player) {
        super("Safe House", player);
    }

    @Override
    public boolean onLocation() {
        System.out.println("---------------------You are on SafeHouse--------------------- ");
        System.out.println("Your health: "+ this.getPlayer().getHealth());
        System.out.print("press any key to refresh your health");
        String waitCase = scanner.nextLine();
        this.getPlayer().setHealth(this.getPlayer().getInitalHealth());
        System.out.println("Health: " + this.getPlayer().getHealth());
        return true;
    }
}
