import java.util.ArrayList;
import java.util.List;

public class Inventory {
    Weapon Weapon;
    Armor Armor;
    List<Element> elementList;


    public Inventory() {
        this.Weapon = new Weapon(-1,"Fist",1,0);
        this.Armor = new Armor(-2,"None",0,0);
        this.elementList = new ArrayList<Element>();
    }

    public boolean hasElementByName(String elementName) {
        for (Element element : this.elementList) {
            if (element.getName().equalsIgnoreCase(elementName)) {
                return true; // Eğer isim eşleşiyorsa, element zaten var.
            }
        }
        return false; // İsim eşleşmiyorsa, element yok.
    }


    public Weapon getDefaultWeapon() {
        return Weapon;
    }
    public void Weapon(Weapon weapon){
        this.Weapon = weapon;
    }

    public Armor Armor() {
        return Armor;
    }

    public void setDefaultArmor(Armor defaultArmor) {
        this.Armor = defaultArmor;
    }

    public Weapon getWeapon() {
        return Weapon;
    }

    public void setWeapon(Weapon weapon) {
        Weapon = weapon;
    }

    public Armor getArmor() {
        return Armor;
    }

    public void setArmor(Armor armor) {
        Armor = armor;
    }

    public List<Element> getElementList() {
        return elementList;
    }

    public void setElementList(List<Element> elementList) {
        this.elementList = elementList;
    }

}
