import java.awt.*;

public class Giant extends Critter {
    private int moves;
    private static String[] walk = {"fee", "fie", "foe", "fum"};
    private int i = 0;
    String s;

    public Action getMove(CritterInfo info) {
        moves++;
        moves %= 6;
        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        } else if (info.getFront() == Neighbor.EMPTY){
            return Action.HOP;
        } else {
            return Action.RIGHT;
        }
    }

    public Color getColor() {
        return Color.GRAY;
    }

    public String toString() {
        if (moves == 0){
            s = walk[i];
            i++;
            if (i == 3)
                i = 0;
        }
        return s;
    }
}
