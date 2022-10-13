package ScoalaIt.Java.Curs5InheritPolymorphExtends;

import java.awt.*;

public class ShapeCircle extends Shape {
    float radius;
    static final float PI= 3.141492f;

    public ShapeCircle(Color color){
        super(color);
    }

    //SETTER
    public void setRadius(float radius){
        this.radius = radius;
    }

    public float diameter(){
        return radius*2;
    }

    public float getArea(){
        return PI*radius*radius;
    }
}
