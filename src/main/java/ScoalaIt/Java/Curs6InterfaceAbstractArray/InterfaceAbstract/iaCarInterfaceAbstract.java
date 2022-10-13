package ScoalaIt.Java.Curs6InterfaceAbstractArray.InterfaceAbstract;

abstract class iaCarInterfaceAbstract implements iCar, iCar2  {
    //clasa Abstracta nu are nevoie de nimic in body
    //daca pun public class trebuie sa implementez metodele din iCar

    public void horn(){
        System.out.println("iaCarInterfaceAbstract horn override Bus horn");
    }
}
