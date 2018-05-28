import java.awt.*;

public class WhiteTiger extends Critter {
    private boolean effectCitter;

    public WhiteTiger(){
        effectCitter = false;
    }

    public Action getMove(CritterInfo info) {
        if (info.getFront() == Neighbor.OTHER) {
            effectCitter = true;
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
        return Color.WHITE;
    }

    public String toString() {
        if (!(effectCitter))
            return "tgr";
        else
            return "TGR";
    }
}
