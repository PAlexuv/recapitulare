package ScoalaIt.Java.Curs6InterfaceAbstractArray.InterfaceAbstract;

public class iBus implements iCar, iCar2{
    @Override
    public void start() {
        System.out.println("start bus");
    }
    @Override
    public void stop() {
        System.out.println("stop bus");
    }

    @Override
    public void horn() {

    }

}
