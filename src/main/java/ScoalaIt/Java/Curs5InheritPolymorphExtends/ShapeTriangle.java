package ScoalaIt.Java.Curs5InheritPolymorphExtends;

import java.awt.*;

public class ShapeTriangle extends Shape{

    public ShapeTriangle (Color color) {
        super(color);
        this.SHAPE_NAME = "Triangle";
    }

    @Override
    public void draw(){
        System.out.println("Overrided triangle from draw a shape to draw a triangle");
    }

    public void flipVertical(){
        System.out.println("Flip Vertical");
    }

    public void flipHorizontal(){
        System.out.println("Flip Horizontal");
    }

    @Override
    protected void erase(){
        System.out.println("Erase from Shapetriangle");
    }

    @Override
    public String toString() {
        return "ShapeTriangle{" +
                "SHAPE_NAME='" + SHAPE_NAME + '\'' +
                '}';
    }
}
