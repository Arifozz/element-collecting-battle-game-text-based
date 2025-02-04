public class Cave extends BattleLocation{
    public Cave( Player player) {
        super("Cave", player, new Wolf(), "Food ",4,new Element("Food"));
    }

}
