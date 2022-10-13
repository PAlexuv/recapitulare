package ScoalaIt.Java.Curs6InterfaceAbstractArray.InterfaceAbstract;

public class iaTrain extends iaCarInterfaceAbstract {

    @Override
    public void start() {
        System.out.println("start() method: iBus override start method from iCar wich is empty so we get: ");
        System.out.println("iaTrain override Icar");
    }

    @Override
    public void stop() {

    }

    @Override
    public void horn() {
        super.horn();
        System.out.println("horn() method: iaTrain horn override iaCarInterfaceAbstract horn");
    }
}
