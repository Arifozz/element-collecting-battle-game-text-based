import javax.swing.*;

public class ToolStore extends NormalLocation{


    public ToolStore( Player player) {
        super("Tool Store", player);
    }


    public boolean  onLocation() {
        System.out.println("---- Tool Store ---");
        boolean flag = true;
       while (flag){
           System.out.println("-------------------");
           System.out.println("1-Weapons"
                   + "\n2-Armors"
                   + "\n3-Exit");
           int selection = scanner.nextInt();

           while (selection <1 || selection > 3) {
               System.out.println("Invalid selection");
               selection = scanner.nextInt();
           }
           switch(selection) {
               case 1:
                   printWeapons();
                   buyWeapon();
                   break;
               case 2:
                   printArmors();
                   buyArmor();
                   break;
               case 3:

               case 4:
                   System.out.println("Exit");
                   flag = false;
               default:
                   System.out.println("Invalid selection");
           }
       }
       return true;
    }


    public void printWeapons() {
        System.out.println("------------ WEAPONS -------------");
        for (Weapon weapon : Weapon.weapons()){
            System.out.println(weapon.getId()+"-"
                    +"Name: "+ weapon.getName()
                    +"\t| Damage: " + weapon.getDamage()
                    +"\t| Price: "+ weapon.getPrice());
        }
        System.out.println("0- Previous Menu");
        System.out.println("-----------------------------------------");
    }


    public void buyWeapon(){
        System.out.println("Select a Weapon");

        int selectWeaponID = scanner.nextInt();
        while (selectWeaponID < 0 || selectWeaponID > Weapon.weapons().length) {
            System.out.println("Invalid selection - Try again");
            selectWeaponID = scanner.nextInt();
        }

        if (selectWeaponID !=0){
            Weapon selectedWeapon = Weapon.getWeaponByID(selectWeaponID);

            if (selectedWeapon != null){
                if (selectedWeapon.getPrice() > this.getPlayer().getMoney()){
                    System.out.println("You don't have enough money");
                }else {
                    System.out.println("You took the " + selectedWeapon.getName());
                    int moneyBalance =this.getPlayer().getMoney() - selectedWeapon.getPrice();
                    this.getPlayer().setMoney(moneyBalance);
                    System.out.println("Remaining Money: " + moneyBalance);
                    System.out.println("Previous Weapon: " + this.getPlayer().getInventory().Weapon.getName());
                    this.getPlayer().getInventory().Weapon(selectedWeapon);
                }
            }
        }

    }
    public void printArmors() {
        System.out.println("------------ ARMORS -------------");
        for (Armor armor : Armor.armor()){
            System.out.println(armor.getId()+"-"
                    +"Name: "+ armor.getName()
                    +"\t| HP: " +armor.getHp()
                    +"\t| Price: "+ armor.getPrice());
        }
        System.out.println("0- Previous Menu");
        System.out.println("-----------------------------------------");

    }

    public void buyArmor(){
        System.out.println("Select a Armor");
        int selectArmorID = scanner.nextInt();
        while (selectArmorID < 0 || selectArmorID > Armor.armor().length) {
            System.out.println("Invalid selection - Try again");
            selectArmorID = scanner.nextInt();
        }

        if(selectArmorID !=0){
            Armor selectedArmor = Armor.getArmorById(selectArmorID);
            if (selectedArmor != null){
                if (selectedArmor.getPrice() > this.getPlayer().getMoney()){
                    System.out.println("You don't have enough money");
                }
                else {
                    System.out.println("You took the " + selectedArmor.getName());
                    int moneyBalance = this.getPlayer().getMoney() - selectedArmor.getPrice();
                    this.getPlayer().setMoney(moneyBalance);
                    System.out.println("Remaining Money: " + moneyBalance);
                    System.out.println("Previous Armor: " + this.getPlayer().getInventory().Armor.getName());
                    this.getPlayer().getInventory().Armor = selectedArmor;
                }
            }

        }

    }





















}
