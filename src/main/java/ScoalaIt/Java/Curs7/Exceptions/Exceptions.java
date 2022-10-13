package ScoalaIt.Java.Curs7.Exceptions;

public class Exceptions extends Exception {

    public Exceptions(String message) {
    }

    //********************
    public static double circleArea(double radius)  {
        if (radius<=0) {
            throw new IllegalArgumentException("*** Radius need to be positive and bigger than 0 ***");
        }
        return Math.PI*radius*radius;
    }
    //********************
    public static void closeBrowser() {
        System.out.println("Close the browser by finally from try/catch");
    }
    //********************
    public static double divide(double a, double b) throws Exception {
        if(b==0)
            throw new Exception("divide by 0 not supported");
        return a /b;
    }

}
