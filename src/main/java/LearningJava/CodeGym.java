package LearningJava;

import java.util.Scanner;

public class CodeGym {


    public static void main(String[] args) {

        for(int i=0; i<10; i++){
            for(int j=0; j<=i; j++)
                System.out.print("8");
            System.out.println();
        }

        /*
        int f = 1;
        for (int i = 1; i <= 10; i++)
            f = f * i;
        System.out.println(f);
*/
        /*
        Scanner console = new Scanner(System.in);
        int count = 0;
        for (int i = 0; i < 10; i++)
        {
            if (console.hasNextInt())
                count++;
            console.nextLine();
        }
        System.out.println(count);
*/
        //////////
        /*
        Scanner scanner = new Scanner(System.in);
        int start = scanner.nextInt();
        int end = scanner.nextInt();
        int multiple = scanner.nextInt();
        int sum = 0;

        for(int i=start; i<end; i++){
            if(i%multiple !=0){
                continue;
            }
            sum+=i;
        }
        System.out.println(sum);
*/
        //////////
//        int i = 1;
//        while (i <= 20)
//        {
//            if ( (i % 7) == 0) continue;
//            System.out.println(i);
//            i++;
//        }

//        for (int i = 1; i <= 20; i++)
//        {
//            if ( (i % 7) == 0) continue;
//            System.out.println(i);
//        }


//        int even=0;
//         for(int i=1; i<=15; i++){
//            if(i%2==0){
//                even=i;
//                System.out.println(even);
//                }
//            }



       // test();
       // operatiiMatematice();
        //verifyInterval();
//        System.out.println(isOnInterval(10));
//        System.out.println(isOnInterval(101));
//        System.out.println(sumOFNumbers(10, 11));

    }

    ////////////////////////
/*
    public static int sumOFNumbers(int a, int b){
        return a+b;
    }

    public static int isOnInterval(int x){
        if(x>=0 && x<=100){
            System.out.println("x is in 0-100");
            x+=10;
        }
        else
            System.out.println("x outside interval");
        return x;
    }

    public static void verifyInterval(){
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        if(x>=0 && x<=100)
            System.out.println(x + " is between 0 and 100");
        else
            System.out.println("outside interval");
    }

    public static void operatiiMatematice(){
        int a= 5;
        int b= 7;
        int prod = a*b;

        int catul = a/b;
        int restul = a%b;
        float rezultat = (float) a/b;

        System.out.println("prod: " + prod + " " + "catul: " + catul + " " + "restul: " + restul + " " + "rezultat: " + rezultat);
    }

    //cele cu public void sunt metode/actiuni
    public static void test(){
        System.out.println("Curs 3. Primul de java");
    }


    //asta e o proprietate
    int varsta;

    boolean istrue = true, isfalse = false;
    char c  = 'a';
    final double PI = 3.14;

*/
}
