package ro.teamnet.zerotohero.oop.graphicsshape;


import ro.teamnet.zerotohero.oop.graphicsshape.Shape;

public class Circle extends Shape {
    int xpos;
    int ypos;
    int radius;

    public Circle() {
        this.xpos = 0;
        this.ypos=0;
        this.radius=0;
    }

    public Circle(int xpos) {
        this.xpos = xpos;
    }

    public Circle(int xpos, int ypos) {
        this.xpos = xpos;
        this.ypos = ypos;
    }

    public Circle(int xpos, int ypos, int radius) {
        this.xpos = xpos;
        this.ypos = ypos;
        this.radius = radius;
    }

    public double area(){
        return radius*radius*Math.PI;
    }
    public int fillColour(){
        return super.getColor();
    }
    public void fillColour(int parametru){
        System.out.println("Metoda fillColour() cu parametru int");
        System.out.println("The circle color is now 2");
        super.setColor(parametru);

    }
    public void fillColour(float parametru){
        System.out.println("Metoda fillColour() cu parametru float");
        super.setSaturation(parametru);
    }
    public String toString(){
        String rez="";
        rez="Center=("+xpos+","+ypos+") and radius="+radius;
        return rez;
    }
}
