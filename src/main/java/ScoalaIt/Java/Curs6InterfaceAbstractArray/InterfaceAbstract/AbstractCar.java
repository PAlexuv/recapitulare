package ScoalaIt.Java.Curs6InterfaceAbstractArray.InterfaceAbstract;

import java.awt.*;

abstract public class AbstractCar {
    public Color color;

    abstract public void turnLeft();
    abstract public void turnRight();

    protected void reverse(){
        System.out.println("Car reverse!!");
    }
}
