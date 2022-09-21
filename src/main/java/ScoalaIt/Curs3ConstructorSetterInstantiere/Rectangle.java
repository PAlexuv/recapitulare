package ScoalaIt.Curs3ConstructorSetterInstantiere;

//
public class Rectangle {
    private double length, width;

    //Constructor intotdeauna inaintea metodelor, sunt primii in cod
// un constructor e default format din NUMELE CLASEI FARA PARAMETRI
    public Rectangle(){
    }
    //OVERLOADING - metode cu acelasi nume DAR difera PARAMETRI: numarul param, tipul, ordinea
    public Rectangle(double length, double width){
        this.width = width;
        this.length = length;
    }
    public Rectangle(double length){
        this.width = length;
        this.length = length;
    }


/////////

    public static int numeMetoda(int x, int y){
        return x+y;
    }

    public double getArea(){
        return length*width;
    }

    public double getPerimeter(){
        return 2*(length + width);
    }

    public double getDiagonal(){
        return Math.sqrt(Math.pow(width,2) + Math.pow(length,2)) ;
    }

    //Setter nu este nevoie de el ca facem constructor dar necesar pentru invatare
    public void setLength(double length) {
        this.length = length;
    }

    public void setWidth(double width) {
        this.width = width;
    }
    ///////////////////

    public void displayRequirements(){
        System.out.println("area is: " + getArea());
        System.out.println("perimeter is: " + getPerimeter());
        System.out.println("diagonal is: " + getDiagonal());
    }

}
