public class Element {
    String name;


    public Element( String name) {
        this.name = name;
    }


  /* public static Element[] elements(){
        Element[] elements = new Element[3];
        elements[0] = new Element("Food");
        elements[1] = new Element("FireWood");
        elements[2] = new Element( "Water");
       return elements;
   }*/

    @Override
    public String toString() {
        return name; // Elementin adını döndür
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
