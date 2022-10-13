package ScoalaIt.Java.Curs5InheritPolymorphExtends;

import java.awt.*;

public class ShapeSquare extends Shape{

    public ShapeSquare(Color color){
        super(color);
    }

    @Override
    public void draw(){
        //super.draw();//cu super. apelam in clasa ShapeSquare elemente din Shape = Draw a shape...
        System.out.println("Draw a square");
    }

    public void showParentAttributes(){
        System.out.println(super.SHAPE_NAME);//protected poate fi accesata prin clasa; private ramane doar in clasa unde e private
    }

}
