import java.awt.*;


public class Bear extends Critter {
    private boolean polar;
    private String s = "/";

    public Bear(boolean polar){
        this.polar = polar;
    }

    public Action getMove(CritterInfo info) {
//always infect if an enemy is in front, otherwise hop if possible, otherwise turn left.
        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        } else if (info.getFront() == Neighbor.EMPTY){
            return Action.HOP;
        } else {
            return Action.LEFT;
        }
    }

    public Color getColor() {
        if (polar)
                return Color.WHITE;
        else
            return Color.BLACK;
    }

//    public void setPolar(boolean polar){
//
//    }

    public String toString() {
        if(s.equals("/")){
            s = "\\";
        } else {
            s = "/";
        }
        return s;
    }
}
