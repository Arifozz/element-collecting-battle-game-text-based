import java.util.Scanner;

public class Player {
    private String name;
    private int damage;
    private int health;
    private int initalHealth;
    private int money;
    private Inventory inventory;
    private Location location;
    Scanner sc= new Scanner(System.in);

    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }


    public void selectCharacter(){
        GameCharacter[] charlist = {new Samurai(),new Archer(), new Knight()};
        System.out.println("These are the Characters:");
        System.out.println("''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''");
        //for (GameCharacter character : charlist) {}    //"for each kullanimi"
        for (int i = 0; i < charlist.length; i++) {
            System.out.println(
                            "\tID: "+ charlist[i].getId()
                            +"\tCharacter: " + charlist[i].getName()
                            +"\tDamage: "+ charlist[i].getDamage()
                            +"\tHealt: "+ charlist[i].getHealth()
                            +"\tMoney: "+ charlist[i].getMoney());
        }
        System.out.println("''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''");
        System.out.print("Select a character:");

        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());
                break;
        }
    }

    private void initPlayer(GameCharacter gameCharacter){
            this.setName(gameCharacter.getName());
            this.setDamage(gameCharacter.getDamage());
            this.setHealth(gameCharacter.getHealth());
            this.setInitalHealth(gameCharacter.getHealth());
            this.setMoney(gameCharacter.getMoney());
    }

    public void playerInfo(){
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(" (i) Your character is: " + this.getName() +
                "\t|Weapon: " + this.getInventory().Weapon.getName()+
                "\t|Armor: " + this.getInventory().Armor.getName()+
                "\t|Damage: " + this.getDamage() +
                "\t|Health: " + this.getHealth() +
                "\t|Money: " + this.getMoney() +
                "|| Looted Elements: "+this.getInventory().elementList);
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");
        System.out.println();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getInitalHealth() {
        return initalHealth;
    }

    public void setInitalHealth(int initalHealth) {
        this.initalHealth = initalHealth;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
