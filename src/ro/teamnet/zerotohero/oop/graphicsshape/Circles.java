package ro.teamnet.zerotohero.oop.graphicsshape;

/**
 * Created by Iordan.Serdin on 7/4/2017.
 */
public class Circles {
    public double getAreaPub(){
        Circle c=new Circle(1,1,2);
        return c.area();

    }
    public void getAreaDef(){
        Circle c=new Circle();
        c.fillColour();
        c.fillColour(2);//parametrul culorii
        c.fillColour(3.2f);
    }

}
