public class Weapon {
    String name;
    int id;
    int damage;
    int price;

    public Weapon(int id, String name, int damage, int price) {
        this.name = name;
        this.id = id;
        this.damage = damage;
        this.price = price;
    }

    public static Weapon[] weapons(){
        Weapon[] weaponList = new Weapon[3];
        weaponList[0] = new Weapon(1,"Axe",3,15);
        weaponList[1] = new Weapon(2,"Gun",5,20);
        weaponList[2] = new Weapon(3,"ShotGun",7,35);
        return weaponList;
    }

    public static Weapon getWeaponByID(int id){
        for (int i = 0; i < weapons().length; i++){
            if (weapons()[i].getId() == id){
                return weapons()[i];
            }
        }
        return null;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
