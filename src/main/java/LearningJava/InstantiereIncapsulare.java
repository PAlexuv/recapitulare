package LearningJava;

public class InstantiereIncapsulare {
    int dogs;
    int cats;
    int[] intarray3;

////////////////////
    public int populateArray3(){
//        int[] intarray3 = new int[30]; sau direct in main
        for (int i=0; i < intarray3.length; i++){
            intarray3[i]=i+1;
            System.out.println(i);
        }
        return intarray3.length;
    }
    public void showHowManyNumbersInArray3(){
        System.out.println(populateArray3());
    }

    public int getTotalAnimals(){
        return dogs+cats;
    }
    public void displayAnimalNumers() {
        System.out.println("number of animals:" + getTotalAnimals());
    }

    //MAIN
    public static void main(String[] args) {
        InstantiereIncapsulare vr1 = new InstantiereIncapsulare();
        InstantiereIncapsulare vr2 = new InstantiereIncapsulare();

        InstantiereIncapsulare arr3 = new InstantiereIncapsulare();
        arr3.intarray3=new int[10];
        arr3.showHowManyNumbersInArray3();
  /*
//vr1
        vr1.cats = 99;
        vr1.dogs = 199;

        vr1.displayNumers();

        System.out.println(vr1.getTotalAnimals());
// vr2
        vr2.dogs = 2;
        vr2.cats = 2;

        vr1.displayAnimalNumers();
        vr2.displayAnimalNumers();

        System.out.println("The first class method says there are " + vr1.getTotalAnimals() + " animals");
        System.out.println("The second class method says there are " + vr2.getTotalAnimals() + " animals");

   */
    }
}
