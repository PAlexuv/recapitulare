package ScoalaIt.Java.Curs7.Exceptions;

public class MyCustomException extends Exceptions {
    public MyCustomException(String message) {
        super("message: " + message);
    }
    public MyCustomException(String message, int errCode) {
        super(message + " " + errCode);
    }

    public static void testMyExc(String message, int err) throws MyCustomException  {
        throw new MyCustomException(message, err);
    }

}
