public abstract class Beast {
    int id;
    String name;
    int damage;
    int health;
    int bounty;
    int initialHealth;

    public Beast(int id, String name, int damage, int health, int bounty) {
        this.id = id;
        this.name = name;
        this.damage = damage;
        this.initialHealth = health;
        this.health = health;
        this.bounty = bounty;
    }

    public void BeastInfo(){
        System.out.println(" (i) Beat is: " + this.getName() +
                "\t|Damage: " + this.getDamage() +
                "\t|Health: " + this.getHealth()+
                "\t|Bounty: " + this.getBounty());

        System.out.println("--------------------------------------------------------------------------------------------");

    }

    public void BeastInfo(int num){
        System.out.println(num +"." + this.getName() + "->"+
                "|Damage: " + this.getDamage() +
                "\t|Health: " + this.getHealth() +
                "\t|Bounty: " + this.getBounty());
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

    public int getBounty() {
        return bounty;
    }

    public void setBounty(int bounty) {
        this.bounty = bounty;
    }

    public int getInitialHealth() {
        return initialHealth;
    }

    public void setInitialHealth(int initialHealth) {
        this.initialHealth = initialHealth;
    }
}
