package ScoalaIt.Java.Curs6InterfaceAbstractArray.ListsArraySets;

public class ArrayCollectionsBasicArray {

    public void arrays(){

        int [] numbers = {1,2,3,4,5};
        //show list elements best practice:
        for(int numere: numbers){
            System.out.println(numere);
        }
        System.out.println();

        String [] nume = {"Ion", "Vasile", "Maria"};
        //show list elements best practice:
        for(String el: nume){
            System.out.println(el);
        }
        System.out.println();

        //define second element with another name
        nume[nume.length-2] = "vasi";
        System.out.println("first numbers: " + numbers[0]);
        System.out.println("last name in the list: " + nume[ nume.length-3]); // nume[2] era corect dar pentru GENERAL VALABIL facem (array.size -1) - folosim (array.length -1)
        System.out.println(nume[nume.length-2]);

        System.out.println();

    }

// metode care fac acelasi lucru ca ce e in main
    public void newarray(){
        double [] array = {2.3, 3.5, 4.2};
        for(int i=0; i<array.length; i++) {
            System.out.println(array[i]);
        }
        //best practice cum e jos: dam unei variabile double tot arrayul de [i] si apelam variabila
        for(double numar: array){
            System.out.println(numar);
        }
    }




}
