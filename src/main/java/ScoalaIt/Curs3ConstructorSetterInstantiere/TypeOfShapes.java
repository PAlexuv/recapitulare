package ScoalaIt.Curs3ConstructorSetterInstantiere;

public class TypeOfShapes {


    public static void main(String[] args) {

        //instantiem si: pentru ca am facut constructor putem da in paranteze radius-ul, sau
//        putem da radiusul prin setradius(..)
/*
        TCircle myTCircle = new TCircle();
        System.out.println("Circle area: " + myTCircle.getArea());

        myTCircle.setRadius(4);

        TCircle myTCircle2= new TCircle(2f);
        System.out.println("Circle2 area: " + myTCircle2.getArea());
        System.out.println("Circle2 diameter: " + myTCircle2.diameter());
*/
        //////////////////
/*

//        Square

//        Square mySquare  = new Square(5f);
        Square mySquare  = new Square(Integer.parseInt(args[0]));
        mySquare.setLatura(8);
        System.out.println("Perim is: " + mySquare.getPerim());
        System.out.println("Aria is: " + mySquare.getAria());
        mySquare.displayLatura();
        /////////////////////
   */
//        Rectangle
/*
        Rectangle rectangle = new Rectangle(5, 6);
//      System.out.println("perim is: " + rectangle.getPerimeter());
        System.out.println("first RECTANGLE:");
        rectangle.displayRequirements();
        ////////
        System.out.println("2nd RECTANGLE:");
        Rectangle rectangle1 = new Rectangle();
        rectangle1.setLength(4);
        rectangle1.setWidth(5);
        rectangle1.displayRequirements();
        /////////
        System.out.println("3rd RECTANGLE:");
        Rectangle rectangle2 = new Rectangle(3, 4);
        rectangle2.displayRequirements();
        //////
        System.out.println("SQUARE FROM RECTANGLE: input just length:");
        Rectangle squareRectangle = new Rectangle(5);
        squareRectangle.displayRequirements();
 */
        /*
        /////// drawCorners
        DrawShapeCorners draw = new DrawShapeCorners(5, 6);
        System.out.println(draw.drawShapeCorner());
        */
        PrimeNumbers prime = new PrimeNumbers(1, 100);
        prime.displayPrime();

    }
}
