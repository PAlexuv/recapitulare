package ScoalaIt.Java.Curs6InterfaceAbstractArray.InterfaceAbstract;

public class iTruck implements iCar, iCar2{

    @Override
    public void start() {
        System.out.println("start truck");
    }

    @Override
    public void stop() {
        System.out.println("stop truck");
    }

    @Override
    public void horn() {
        System.out.println("Truck Horn");
    }

    public void lights(){
        System.out.println("Lights On");
    }

}
