package ro.teamnet.zerotohero.oop.graphicsshape;

import ro.teamnet.zerotohero.oop.graphicsshape.Shape;

/**
 * Created by Iordan.Serdin on 7/4/2017.
 */
public class Square extends Shape {
    private int side;

    public Square(int side) {
        this.side = side;
    }
    public double area(){
        return this.side*this.side;
    }
    public String toString(){
        String rez;
        rez="side="+side;
        return rez;
    }
}
