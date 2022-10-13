package ScoalaIt.Java.Curs6InterfaceAbstractArray.InterfaceAbstract;

public class aTir extends AbstractCar {

    @Override
    public void turnLeft() {
        System.out.println("turn left");
    }

    @Override
    public void turnRight() {
        System.out.println("turn right");
    }

    @Override
    protected void reverse() {
        super.reverse();
        System.out.println("tir override Car reverse!!");
    }
}
