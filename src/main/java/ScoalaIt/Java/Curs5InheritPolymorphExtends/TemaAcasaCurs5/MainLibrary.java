package ScoalaIt.Java.Curs5InheritPolymorphExtends.TemaAcasaCurs5;

public class MainLibrary {


    public static void main(String[] args) {
        Author auth1 = new Author("Mihai Eminescu", "misu@misu.com");
        Author auth2 = new Author("creanga", "crea@nga.com");
        Author auth3 = new Author("rebre", "rebre@anu.com");
        System.out.println(auth1.toString());
        System.out.println(auth2.toString());
        System.out.println(auth3.toString());
        System.out.println();


        Book book1 = new Book(auth1, "LaSteaua", 1980, 35.5, 5);
        Book book2 = new Book(auth2, "amintiri", 1984, 4.52, 3);
        Book book3 = new Book(auth3, "john", 1990, 45, 0);
        System.out.println(book1.getAuthor().getAuthName());
        System.out.println(book1.toString());
        System.out.println(book2.toString());
        System.out.println(book3.toString());

    }
}
