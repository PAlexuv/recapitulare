package ScoalaIt.Java.Curs4VarMetStaticDin;

public class MainCurs4 {
    public static void main(String[] args) {

        // Variablia Statica: o apelam prin Clasa : "Car.nrOfCars" (Car = clasa; nrOfCars =Variabila Statica)
        Car Car1 = new Car(10f);
        System.out.println("Nr of Cars: " + Car.nrOfCars);
        System.out.println("My 1stCar: " + Car1);
        System.out.println();

        // Metoda Statica: o apelam prin Clasa: "Car.getNrOfCarsStatic()" (Car = clasa; getNrOfCarsStatic = Metoda Statica)
        Car Car2  = new Car(10f);
        System.out.println("Nr of Cars: " + Car.getNrOfCarsStatic());
        System.out.println("My 2ndCar: " + Car2);
        System.out.println();

        // Metoda Dinamica:  o apelam prin Obiect: instantiem Obiectul si dupa apelam Metoda Dinamica prin Obiectul Instantiat apeland de fapt o Variabila Statica:
        //                                                                 "Car3.getNrOfCars()" Car3 = Obiectul Instantiat; getNrOfCars= Metoda Dinamica )
        Car Car3  = new Car(10f);
        System.out.println("Nr of Cars: " + Car3.getNrOfCars());
        System.out.println("My 3rdCar: " + Car3.toString());            //toString is redundant it will show details from toString without calling

        System.out.println();
        Car.setNrOfCars(10);
        System.out.println("Nr of Cars after set: " + Car3.getNrOfCars()); //sau Car.getNrOfCarsStatic() sau Car.nrOfCars

//        SumOfNum sumOfNum = new SumOfNum();
//        sumOfNum.showSum();

        //SumOfNum.showSum();
//        SumOfNum.sumOfNumbers(1,3);

        /* ----------------- dim increase turn on turn off light - use delta - cu cat creste intesitatea
        /*
        Light light = new Light(1);
        light.turnON();
        light.dimLight(50);
        light.increaseLight(10);
        light.turnOFF();

//        light.dimLight();
//        light.dimLight();
        //in loc cele 2 de sus facem o metoda prin care dam de cate ori vrem sa diminueze
        //metoda are acelasi nume(overloading) dar are 1 parametru(de cate ori sa dim)

//        light.increaseLight();
//        light.increaseLight();
//        light.increaseLight();
        //in loc cele 3 de sus facem o metoda prin care dam de cate ori vrem sa creasca lumina
        //metoda are acelasi nume(overloading) dar are 1 parametru(de cate ori sa creasca)
*/
        //--------------------------------------/--------------------------------------/--------------------------------------

    }
}
