package LearningJava;

public class Curs1 {

    /*
    public static void adunamParImpar() {
//        int sumpar = 0;
//        int sumimpar = 0;
//        int list[]={1, 34, 65, 78, 99};
//        for(int i=0; i<= list.length -1; i++) {
//            if (list[i] % 2 == 0) {
//                System.out.println("Numar par: " + list[i]);
//                sumpar = sumpar + list[i];
//            }
//            else {
//                System.out.println("numar impar: "+ list[i]);
//            sumimpar = sumimpar + list[i];
//            }
//        }
//        System.out.println("Suma pare: " + sumpar);
//        System.out.println("Suma impare: " + sumimpar);
//    }

//        int sum = 0;
//        int list[] = {1, 4, 7, 45, 76, 87, 98};
//
//        for (int i = 0; i <= list.length - 1; i++) {
//            if (list[i] % 2 == 0) {
//                System.out.println("numere pare: " + list[i]);
//                sum = sum + list[i];
//            } else
//                System.out.println("numere impare: " + list[i]);
//        }
//        System.out.println("Suma nr pare: " +  sum);
//    }

//////////////////////////////
*/

//    public static int max(int a, int b){
//        if(a>b)
//            return a;
//        else
//            return b;
//    }

//////////////////////////////
//    public static boolean par(int x) {
//            if (x % 2 == 0)
//                return true;
//            else
//                return false;
//        }
//    public static void showOddNumbers(int x, int y){
//        for(int i=x; i<=y; i++ ){
//            if(par(i)){
//                System.out.println(i);
//            }
//        }
//    }

////////////////////////////////
//    public static void SumOfNumbers() {
//        int x;
//        int sum = 0;
//        for (x = 0; x <= 100; x++) {
//            sum = sum + x;
//        }
//        System.out.println(sum);
//    }

/////////////////////////
//    public static boolean PrimeNumbers(int x) {
//        if (x % 2 != 0) {
//            return true;
//        } else
//            return false;
//    }
//    public static void showPrime(int x, int y) {
//        for (int i = x; i <= y; i++) {
//            if (PrimeNumbers(i)) {
//                System.out.println("prime numbers: " + i);
//            }
//        }
//    }

    ////////////////////////////
//    public static void February() {
//        Scanner scanner = new Scanner(System.in);
//        int year = scanner.nextInt();
//        int february = 0;
//        if (year < 1900 || year > 2016) {
//            System.out.println("just between 1900 - 2016");
//        } else if ((year % 4 == 0) || (year % 400 == 0) && year % 100 != 0) {
//            february = february + 28;
//        } else {
//            february = february + 29;
//        }
//        System.out.println(february);
//    }

//////////////////////
//    public static boolean leapYear(int year) {
//        if (year % 4 == 0) {
//            return false;
//        } else if (year % 100 != 0) {
//            return true;
//        } else if (year % 400 != 0) {
//            return false;
//        } else {
//            return true;
//        }
//    }
//    public static void February() {
//        Scanner scanner = new Scanner(System.in);
//        int year = scanner.nextInt();
//        int february = 0;
//        if (year < 1900 || year > 2016) {
//            System.out.println("just between 1900 - 2016");
//        } else if (leapYear(year)) {
//            february = february + 28;
//        } else {
//            february = february + 29;
//        }
//        System.out.println(february);
//    }
///////////////////////

    public static void main(String[] args) {

//        February();

//        int x= Integer.parseInt(args[0]);
//        int y= Integer.parseInt(args[1]);
//        showPrime(x, y);

//        SumOfNumbers();

//            int x= Integer.parseInt(args[0]);
//            int y= Integer.parseInt(args[1]);
//            showOddNumbers(x, y);

        //parImpar()
//            System.out.println("5 par: " + parImpar(5));
//            System.out.println("8 par: " + parImpar(8));
//            System.out.println("7 par: " + parImpar(7));
//            System.out.println("4 par: " + parImpar(4));

        // adunamParImpar();

        //max()
//            System.out.println(max(1, 100));
//            System.out.println(max(8, 8));
//            System.out.println(max(3, 2));


    }
}

