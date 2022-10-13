package ScoalaIt.Java.Curs6InterfaceAbstractArray.TemaCurs6;

import ScoalaIt.Java.Curs7.hashMapRecapCurs6;

public class MainTemaCurs6 {
    public static void main(String[] args) {

        //-----------------------------------define Properties----------------------------------------------------------
        LibraryPosition position1 = new LibraryPosition("1", "1");
        LibraryPosition position2 = new LibraryPosition("1", "2");
        LibraryPosition position3 = new LibraryPosition("1", "3");
        LibraryPosition position4 = new LibraryPosition("1", "4");
        LibraryPosition position5 = new LibraryPosition("1", "5");

        Author author1 = new Author("Ion Creanga", "ion@creanga.ro");
        Author author2 = new Author("Mihai Emin", "misu@emi.ro");
        Author author3 = new Author("Dan Crea", "dan@crea.ro");
        Author author4 = new Author("Dan Crea", "dan@crea.ro");

        Books book1 = new Books(author1, position1, "Amintiri", 1987, 55.5, 8);
        Books book2 = new Books(author2, position2, "Ciuleandra", 1988, 45, 1);
        Books book3 = new Books(author3, position3, "CarteNoua", 1989, 87.3, 15);
        Books book4 = new Books(author1, position4, "Amintiri2", 1986, 22.3, 10);
        Books book5 = new Books(author2, position5, "Ciuleandra2", 1985, 47.8, 2);
        Books book6 = new Books(author1, position1, "Amintiri", 1987, 55.5, 8);

//----------------------------------------------------------------------------------------------------------------------
        //---------------------initiate bookMethods----------------------------------------------------
//        BookMethods bookmethods = new BookMethods();
//        //we are able to access hashmaps (key - value) only after we add to our class bookmethods both types of list elements
//        //Use (add a book method) for Books List and (add a author) method for Author List
//        //---------------------add books and authors in bookmethods after initialization----------------------------------------------------
//        bookmethods.addBook(book1);
//        bookmethods.addBook(book2);
//        bookmethods.addBook(book3);
//        bookmethods.addBook(book4);
//        bookmethods.addBook(book5);
//
//        bookmethods.addAut(author1);
//        bookmethods.addAut(author2);
//        bookmethods.addAut(author3);

        //---------------------display books aut nu merge----------------------------------------------------
//        bookmethods.displayBooks();
//        System.out.println();
//
//        bookmethods.displayAut();
//        System.out.println();
///*
        //---------------------remove books----------------------------------------------------
//        bookmethods.removeBook(book2);
//        bookmethods.displayBooks();
//        System.out.println();

        //---------------------search a book----------------------------------------------------
/*
        bookmethods.showFoundBook("Amintsiri");
        System.out.println();
        bookmethods.showFoundBook("Ciuleandra");
        bookmethods.showFoundBook("Amintiri");
        bookmethods.showFoundBook("Ciuleandra2");
*/

//        bookmethods.searchBookName("Amintsiri");
//        System.out.println();
//        bookmethods.searchBookName("Ciuleandra");
//        bookmethods.searchBookName("Amintiri");
//        bookmethods.searchBookName("Ciuleandra2");

//        bookmethods.updateBookPosition(book2, position3);

//        bookmethods.filtAuthor();

//        bookmethods.hashMaps();
//        bookmethods.assignBooks(author1);

        //intantiate hashMap
          hashMapRecapCurs6 hashMap = new hashMapRecapCurs6();

        // add books
          hashMap.addBook(book1);
          hashMap.addBook(book2);
          hashMap.addBook(book3);
          hashMap.addBook(book4);
          hashMap.addBook(book5);
        // add auth
          hashMap.addAuthor(author1);
          hashMap.addAuthor(author2);
          hashMap.addAuthor(author3);
/*
          //display hashMap key and value
          hashMap.showHashBooks();
        System.out.println();
          //filter by author with more books
        hashMap.filterAuthor(author2);
*/
//-------------------compare 2 books and 2 authors-----------------
        System.out.println(book1.equals(book6));
        System.out.println(author3.equals(author4));



    }
}
