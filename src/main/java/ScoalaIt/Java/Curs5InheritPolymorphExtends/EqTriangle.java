package ScoalaIt.Java.Curs5InheritPolymorphExtends;

import java.awt.*;

public class EqTriangle extends ShapeTriangle {

    public EqTriangle(Color color) {
        super(color);
    }

    public void draw(Color color, int n) {
        System.out.println("Draw triangle with color:" + color.toString()+"number of times:" + n);
    }
}
