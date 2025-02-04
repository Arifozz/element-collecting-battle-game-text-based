public class Armor {
    private int id;
    private String name;
    private int hp;
    private int price;
    public Armor(int id, String name, int hp, int price) {
        this.id = id;
        this.name = name;
        this.hp = hp;
        this.price = price;
    }


    public static Armor[] armor() {
        Armor[] armorList = new Armor[3];
        armorList[0] = new Armor(1, "Light Armor", 4, 4);
        armorList[1] = new Armor(2, "Medium Armor", 6, 7);
        armorList[2] = new Armor(3, "Heavy Armor", 10, 10);
        return armorList;
    }

    public static Armor getArmorById(int id) {
        for (Armor a : armor()) {
            if (a.getId() == id) {
                return a;
            }
        }
        return null;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
