package ScoalaIt.Java.Curs5InheritPolymorphExtends;

import ScoalaIt.Java.Curs5InheritPolymorphExtends.TemaClasaCurs5.Person;
import ScoalaIt.Java.Curs5InheritPolymorphExtends.TemaClasaCurs5.Student;
import ScoalaIt.Java.Curs5InheritPolymorphExtends.TemaClasaCurs5.Teacher;

public class MainCurs5 {

    public static void main(String[] args) {

        //Tema in clasa profesor student

        Person person = new Person("Persoana", "M", "132", 25);
        Student student1 = new Student("Elevu","M", "122", 24, 5, "4", "mate" );
        Teacher teacher1 = new Teacher("Profu","M", "122", 25, 4, "mate" );

        System.out.println(person.toString());
        System.out.println(student1.toString());
        System.out.println(teacher1.toString());

        /*

        // ------------------------------------------------Inheritance------------------------------------------------

        Shape shape = new Shape(Color.BLUE);
        System.out.println("This is the main shape");
        shape.draw();

        System.out.println();

        ShapeCircle shapeCircle = new ShapeCircle(Color.CYAN);
        System.out.println("This is a circle shape");
        shapeCircle.draw();

        System.out.println();

        ShapeTriangle shapeTriangle = new ShapeTriangle(Color.black);
        System.out.println("This is a triangle");
        shapeTriangle.draw();

        System.out.println();

        ShapeSquare shapeSquare = new ShapeSquare(Color.BLUE);
        System.out.println("This is a square");
        shapeSquare.draw();

        System.out.println();

        //-------------------Polimorfism----------------
        Shape shape1 = new ShapeCircle(Color.BLUE);
        Shape shape2 = new ShapeSquare(Color.black);
        Shape shape3 = new EqTriangle(Color.CYAN);
        shape1.draw();
        shape2.draw();
        shape3.erase();
*/

    }
}
