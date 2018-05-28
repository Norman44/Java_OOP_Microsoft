import java.awt.*;
import java.util.Random;

public class Tiger extends Critter {
    private int random;
    private int moves;
    private static Color[] COLORS = {Color.RED, Color.BLUE, Color.GREEN};
    private Color currColor;
    private Random rand;


    public Tiger(){
        rand = new Random();
    }

    public Action getMove(CritterInfo info) {
        moves++;
        moves %= 3;

        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        } else if (info.getFront() == Neighbor.WALL || info.getRight() == Neighbor.WALL){
            return Action.LEFT;
        } else if (info.getFront() == Neighbor.SAME){
            return Action.RIGHT;
        } else {
            return Action.HOP;
        }
    }

    public Color getColor() {
        if (moves == 0) currColor = COLORS[rand.nextInt(COLORS.length)];
        return currColor;
    }

    public String toString() {
        return "TGR";
    }

}
