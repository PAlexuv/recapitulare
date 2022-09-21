package ScoalaIt.curs5InheritPolymorph;

import java.awt.*;

public class Shape {
    private Color color;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void draw(){
        System.out.println("Draw a shape...");
    }

    protected void erase(){
        System.out.println("Erase shape...");
    }
}
