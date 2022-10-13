package ScoalaIt.Java.Curs7;

import ScoalaIt.Java.Curs6InterfaceAbstractArray.TemaCurs6.Author;
import ScoalaIt.Java.Curs6InterfaceAbstractArray.TemaCurs6.Books;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class hashMapRecapCurs6 {
    private List<Books> myBooks = new ArrayList<>();
    private List<Author> myAut = new ArrayList<>();

    public hashMapRecapCurs6(List<Books> myBooks, List<Author> myAut) {
        for (Books myBook : myBooks)
            this.myBooks.add(myBook);
        for (Author myAuth : myAut)
            this.myAut.add(myAuth);
    }

    public hashMapRecapCurs6() {
    }

    //-----------------Methods to add Author and Books---------------
    //to be able to add a book and an author we need to create methods to do so:
    public boolean addAuthor(Author author) {
        return myAut.add(author);
    }

    public boolean addBook(Books book) {
        return myBooks.add(book);
    }
    //---------------- After creating the methods go to main class and:  add books and authors to hashMap class (hashMap)---------

    //-----------------Create A hashMap and display key and Value---------------
    //create a method with a
    // hashList (autBooksList) wich contain List<Author>(key) and List<Books>(value)
    // PUT - fill the hashList with (myAut) and (myBooks) lists defined as private lists before constructor
    // create a for() List<Author> .keySet applied to the hashList(HashMap) to display the key(author)
    // create a for() List<Books> .value applied to the hashList(HashMap) to display the value(books)
    public void showHashBooks() {
        HashMap<List<Author>, List<Books>> autBooksList = new HashMap<>();
        autBooksList.put(myAut, myBooks);

        for (List<Author> autKey : autBooksList.keySet()) {
            System.out.println("Authors: " + autKey);
        }
        for (List<Books> booksVal : autBooksList.values()) {
            System.out.println("Books : " + booksVal);
        }

    }


        //------------FilterByAuthor wich has more Books
        public void filterAuthor(Author author){
        //Create a list to add the author with his books ; use for.size()
            List<Books>authorsBooksList  =new ArrayList<>();
            //(FOR) assign to authorBooks variable all the books from myBooks
            //if authorsBooks is equal to (author from class Author) (use GetAuthor to get it's name) when going through authorBooks variable
            // (wich contains myBooks - wich has author as a parameter)
            //display the authorsBooks and // the list with authors books to show how many books he has.size()

            for (Books authorsBooks : myBooks){
                if(authorsBooks.getAuthor().equals(author)){
                    authorsBooksList.add(authorsBooks);
                    System.out.println(authorsBooks);
                }
            }
            System.out.println(authorsBooksList.size());
        }

}
