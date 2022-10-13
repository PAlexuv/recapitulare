package ScoalaIt.Java.BasicC1C2Instant;

import java.util.Scanner;

public class Curs2 {
    //return sum of even numbers from a to b
///////////////////////////
    public static boolean even(int even) {
        if (even % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void showSum(int a, int b) {
        int sum = 0;
        for (a = 0; a < b; a++) {
            if (even(a)) {
                sum = sum + a;
                System.out.println(a);
            }
        }
        System.out.println(sum);
    }

    ////////////////////
    public static boolean pare(int par) {
        return par % 2 == 0;
    }

    public static int suma(int a, int b) {
        return a + b;
    }

    public static int evensumOfRangeNumbers(int inceput, int sfarsit) {
        int summ = 0;
        for (int i = inceput; i <= sfarsit; i++) {
            if (pare(i))
                summ = suma(summ, i);
        }
        return summ;
    }
    ///////////////////////////////////

//    public static void line(int m) {
//        for (int i = 1; i <= m; i++) {
//            System.out.print("*");
//        }
//    }
//    public static void fullShape(int m, int n){
//        for(int i = 1; i<=n; i++){
//            line(m);
////            System.out.println();
//        }
//    }

    ////////////////// METHOD OVERLOADING : putem avea acelasi nume al metodei dar sa aibe parametri diferiti. putem accesa metoda prin metoda chiar daca are acelasi nume
    public static void drawRows(int m){
        for(int i=1; i<=m; i++){
            System.out.print("*");
        }
    }
    public static void drawShape(int m, int n) {
        for (int i = 1; i <= n; i++) {
            drawRows(m);
            System.out.println();
        }
    }

    ////////////////////////

    public static void drawShape(int n){
        drawShape(n, n);
    }
    //metoda in care schimbam din string in int
    public static void drawShape(String n){
        drawShape(Integer.parseInt(n), Integer.parseInt(n)) ;
    }

    public static void Solution() {
        Scanner console = new Scanner(System.in);
        int min = console.nextInt();
        int max= console.nextInt();
        if(max<min){
            int newMax = min;


            // min =4 : sec =2; sec =2<min =4  tmp=min =4; min :4=sec :2; sec: 2=tmp(min:4)
        }
    }



            public static void main(String[] args) {
//        showSum(0, 10);
//        System.out.println(evensumOfRangeNumbers(2, 4));
//        fullShape(3, 3);
//        drawLines(5);
        System.out.println("Two values; line and row entered");
        drawShape(5,3);
        System.out.println("square shape from int, we enter just 1 value : n*n");
        drawShape(9);
        System.out.println("square shape transformed from string to int with parseint");
        drawShape(4);
    }
}
