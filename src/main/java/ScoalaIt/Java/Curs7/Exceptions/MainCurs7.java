package ScoalaIt.Java.Curs7.Exceptions;

public class MainCurs7 {


    public static void main(String[] args) {


        //==========Exceptions=================
//introducem valori pentru radius direct din   pentru asta facem vairiabila radius parsedouble de args[0] practic prima pozitie din String[]

        try {
            double radius = Double.parseDouble(args[0]);
//            Exceptions.circleArea(radius);
            System.out.println("Aria este: " + Exceptions.circleArea(radius));
//            Exceptions.circleArea(-1);
//            System.out.println(Exceptions.divide(radius, 0)); //impartirea la 0 intoarce o exceptie

            MyCustomException.testMyExc("x", 5);

        }catch (NumberFormatException | ArithmeticException e){         //multiline Catch
            System.out.println("incorrect argument, only numbers: " + e.getMessage());

        }catch (IllegalArgumentException e) {
            System.out.println("incorrect argument: " +e.getMessage());

        }catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Index out of Bound, pls add param value from edit");

        }catch (MyCustomException e){
            System.out.println(e.getMessage());

        }catch (Exception e){
            System.out.println("Other exceptions!");


        }finally {
           Exceptions.closeBrowser();
        }

        System.out.println("programul continua mai departe chiar daca intervine o eroare pe parcurs");

    }


}
