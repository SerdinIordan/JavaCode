package ro.teamnet.zerotohero.oop.graphicsshape;

/**
 * Created by Iordan.Serdin on 7/4/2017.
 */
public class Point {
    int xPos;
    int yPos;

    public Point(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }
    public Point(){

    }
    public boolean equals(Object other){
        if (other==null){
            return false;
        }
        if (other instanceof Point){
            Point anotherPoint=(Point)other;
            if( (this.xPos == anotherPoint.xPos) && (this.yPos == anotherPoint.yPos) )
                return true;

        }
        return false;
    }





}
