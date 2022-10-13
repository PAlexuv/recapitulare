package ScoalaIt.Java.Curs5InheritPolymorphExtends;

import java.awt.*;

public class Shape {
    private Color color;
    protected String SHAPE_NAME = "Shape";

    //avem 2 constructori in Shape dar e necesar doar 1 constructor din parent pentru a functiona
    public Shape(Color color){
        this.color = color;
    }

    public Shape(String SHAPE_NAME){
        this.SHAPE_NAME = SHAPE_NAME;
    }

    public void draw(){
        System.out.println("Draw a shape...");
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    protected void erase(){
        System.out.println("Erase shape...");
    }
}
