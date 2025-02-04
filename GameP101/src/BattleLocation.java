import java.util.ArrayList;
import java.util.Random;

public class BattleLocation extends Location {
    private Beast beast;
    private String award;
    private int maxBeasts;
    Element element;
    private boolean isElementCollected;
    int defeatedBeast = 0; //Elemunated enemy

    public BattleLocation(String name , Player player, Beast beast, String award, int maxBeasts, Element element) {
        super(name, player);
        this.award = award;
        this.beast = beast;
        this.maxBeasts = maxBeasts;
        this.element = element;
        this.isElementCollected = false;
    }

    @Override
    public boolean onLocation() {
        int beastCount = randomBeastNum();
        System.out.println("\n-You are walking through " + this.getName() + " right now.");
        System.out.println("-Be careful " + beastCount  + " "+ this.getBeast().getName()+ " Living Here!!");
        System.out.println("\t\tPress <F> for Fight |||| <R> for Run Away");
        String battleCase = scanner.nextLine().toUpperCase();

        if (battleCase.equals("F")) {

            System.out.println("################ BATTLE ################");
            if (fight(beastCount)) {
                System.out.println("YOU WIN!");
                return true;

            }
            if (getPlayer().getHealth()<=0){
                System.out.println("YOU DIE --- YOU LOSE!");
                return false;
            }
        }
        else if (battleCase.equals("R")) {
            System.out.println("You ESCAPE !!!");
            return true;
        }
        return true;
    }

    private boolean fight(int beastCount){
        getPlayer().playerInfo();
        //getBeast().BeastInfo();
        for (int i=1; i<=beastCount; i++) {
            getBeast().BeastInfo(i);
            this.beast.setHealth(this.beast.getInitialHealth()); // Canavarın başlangıç sağlığına döndürüyor
            while (this.getPlayer().getHealth()> 0 && this.getBeast().getHealth()>0) {
                System.out.println("\nPress <H> for Hit the " + getBeast().getName() + " OR Press <R> for Run Away>");
                String fightOrFlight = scanner.nextLine().toUpperCase();
                if (fightOrFlight.equals("H")) {

                    if (attackPriority()==1){
                        System.out.println("Attack Priority 1! ---> Player Hit ");
                        System.out.print("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        playerHit();
                        afterHit();
                        if (this.beast.getHealth()>0){
                            beastHit();
                            afterHit();
                            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        }
                    }else {
                        System.out.println("Attack Priority 0! ---> Beast Hit ");
                        System.out.print("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        beastHit();
                        afterHit();

                        if (this.getPlayer().getHealth()>0){

                            playerHit();
                            afterHit();
                            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        }
                    }
                    //element kazanma işlemleri
                    if (this.getPlayer().getInventory().elementList == null) {
                        this.getPlayer().getInventory().elementList = new ArrayList<>();
                    }

                    if(defeatedBeast==beastCount){
                        this.getPlayer().getInventory().elementList.add(this.element);
                        this.setElementCollected(true);
                        System.out.println("\nYOU LOOT : " + toString(this.element));
                        //System.out.println("Inventory Elements: " + this.getPlayer().getInventory().elementList);
                    }

                    //element buraya kadar


                }else if (fightOrFlight.equals("R")) {
                    System.out.println("You ESCAPE !!");
                    return false;
                }
            }
            if (this.getPlayer().getHealth()>this.getBeast().getHealth()) {
                System.out.println("\n"+this.getBeast().getBounty() +"$ You earned");
                this.getPlayer().setMoney(this.getBeast().getBounty()+this.getPlayer().getMoney());
                System.out.println("You have "+ this.getPlayer().getMoney()+"$ in your pocket now");
            }else {
                return false;
            }
        }
        return false;
    }

    private void playerHit(){
        this.beast.setHealth(beast.health - getPlayer().getDamage()) ;
        System.out.println("\n"+getPlayer().getName()+ " Hits the "+ this.getBeast().getName());
        if(this.getBeast().getHealth()<=0){
            defeatedBeast++;
        }
    }

    private void beastHit(){
        System.out.println("\n"+this.getBeast().getName()+" Hits the "+ this.getPlayer().getName());
        if (this.getPlayer().getInventory().getArmor().getHp()>0){
            this.getPlayer().getInventory().getArmor().setHp
                    (this.getPlayer().getInventory().getArmor().getHp()-getBeast().getDamage());
            if (this.getPlayer().getInventory().getArmor().getHp()<0){
                this.getPlayer().setHealth(this.getPlayer().getHealth()-Math.abs(this.getPlayer().getInventory().getArmor().getHp()));
                System.out.println("!!! Your Armor Broken !!! ");
                this.getPlayer().getInventory().getArmor().setHp(0);
            }
        }else{
            this.getPlayer().setHealth(this.getPlayer().getHealth()-this.getBeast().getDamage());

        }
    }

    private String toString(Element element) {
        return this.element.name;
    }


    private void afterHit(){
        System.out.println(this.getPlayer().getName()+" Health: "+this.getPlayer().getHealth()+
                " | Armor HP: "+ getPlayer().getInventory().getArmor().getHp());
        System.out.println(this.getBeast().getName()+" Health: "+this.getBeast().getHealth());
    }

    private int attackPriority(){
        Random random = new Random();
        return random.nextInt(2);
    }

    public int randomBeastNum(){
        Random rand = new Random();
        return rand.nextInt(this.maxBeasts)+1;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public Beast getBeast() {
        return beast;
    }

    public void setBeast(Beast beast) {
        this.beast = beast;
    }
    public int getMaxBeasts() {
        return maxBeasts;
    }
    public void setMaxBeasts(int maxBeasts) {
        this.maxBeasts = maxBeasts;
    }

    public Element getElement() {
        return element;
    }

    public void setElement(Element element) {
        this.element = element;
    }

    public boolean isElementCollected() {
        return isElementCollected;
    }

    public void setElementCollected(boolean elementCollected) {
        isElementCollected = elementCollected;
    }
}
