import java.util.Scanner;

public abstract class Location {
    private Player player;
    private String name;
    Element element;
    protected Scanner scanner = new Scanner(System.in);


    public Location(String name, Player player) {
        this.name = name;
        this.player = player;
        this.element = null;
    }

    public abstract boolean onLocation();

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Element getElement() {
        return element;
    }

    public void setElement(Element element) {
        this.element = element;
    }
}
