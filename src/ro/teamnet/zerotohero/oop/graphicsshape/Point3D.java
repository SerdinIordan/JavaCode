package ro.teamnet.zerotohero.oop.graphicsshape;

/**
 * Created by Iordan.Serdin on 7/4/2017.
 */
public class Point3D extends Point {
    int zPos;

    public Point3D(int xPos, int yPos, int zPos) {
        super(xPos, yPos);
        this.zPos = zPos;
    }

    public Point3D(int zPos) {
        this.zPos = zPos;
    }
}
