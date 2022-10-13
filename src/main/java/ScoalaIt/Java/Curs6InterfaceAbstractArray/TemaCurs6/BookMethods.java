package ScoalaIt.Java.Curs6InterfaceAbstractArray.TemaCurs6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class BookMethods {

    private List<Books> myBooks = new ArrayList<>();
    private List<Author> myAut = new ArrayList<>();

    //constructor
    public BookMethods(List<Books> myBooks, List<Author> myAut) {
        //BAD practice: obiectele se definesc prin for nu prin this. ; primitivele se definesc prin this.
//        this.myBooks = myBooks;
//        this.myAut = myAut;
        for (Books myBook : myBooks)
            this.myBooks.add(myBook);

        for (Author myAuth : myAut)
            this.myAut.add(myAuth);
    }

    public BookMethods() {
    }


    //----------- addBook (book):boolean - will add a new Book to the list -----------
    public boolean addBook(Books book) {
        return myBooks.add(book);
    }

    public boolean addAut(Author author) {
        return myAut.add(author);
    }

    //----------------- create a hashMap list display key author value books-----------------
    public void hashMaps() {
        HashMap<List<Author>, List<Books>> authorBooksHash = new HashMap<>();
        authorBooksHash.put(myAut, myBooks);
        for (List<Author> authors : authorBooksHash.keySet()) {
            System.out.println("Authors: " + authors);
        }
        System.out.println();
        for (List<Books> books : authorBooksHash.values()) {
            System.out.println("Books : " + books);
        }
    }

    public void assignBooks(Author author) {
//        List<Books> authorBooksList = new ArrayList<>();
        for (Books allHisBooks : myBooks) {
            if (allHisBooks.getAuthor().equals(author))
                System.out.println(allHisBooks);
        }
    }


//if(allHisBooks.getBookName().equals(myAut)){
//        authorBooksList.add(allHisBooks);
//    public HashMap<List<Author>, List<Books>> filtAuthor() {
//
//        HashMap<List<Author>, List<Books>> authorBooks = new HashMap<>();
//
//        authorBooks.put(myAut,myBooks);
//
////        System.out.println(authorBooks);
//
//        for (List<Author> authors : authorBooks.keySet()){
//            System.out.println(authors);
//        }
//        for (List<Books> bookss : authorBooks.values()){
//            System.out.println(bookss);
//        }
//        return authorBooks;
//    }


    //----------- searchBook(name): List<Book> - return list of books if found else return null -----------

    //create a Method - type List<Books> - with attribute theBook as String
    //inside the method create a list of found books to add to this list the books we find
    //make a loop to go through myBooks list
    //if book has the same name - from book.getBookName() -  with the bookName - .equals(theBook)
    //the found book name we add it to foundBook list
    //must return a list of found boooks(requirements)
    public List<Books> searchBookName(String bookName) {
        List<Books> foundBookList = new ArrayList<>();
        for (Books foundIt : myBooks) {
            if (foundIt.getBookName().equals(bookName)) {
                foundBookList.add(foundIt);
                System.out.println("book found: " + bookName);
            }
        }
        if (foundBookList.isEmpty()) {
            System.out.println("no book");
            return null;
        }
        for (Books foundList : foundBookList) {
            System.out.println(foundList);
        }
        return foundBookList;
    }


    //----------- removeBook(book): boolean - will remove Book from list -----------
    public boolean removeBook(Books book) {
        return myBooks.remove(book);
    }

//----------- updateBookPosition -----------

    public boolean updateBookPosition(Books books, LibraryPosition libraryPosition) {

        if (books.getLibraryPosition().equals(libraryPosition)) {
            System.out.println("same position");
            return true;
        }
        books.setLibraryPosition(libraryPosition);
        System.out.println("new position: " + libraryPosition);
        return false;
    }
// ------------------------- de  inteles -------------------------
    //    public HashMap<String, ArrayList<Books>> filterByAuthor(Author author) {
//
//        HashMap<String, ArrayList<Books>> books = new HashMap<>();
//        ArrayList<Books> authorBooks = new ArrayList<>();
//
//        for (Books book : myBooks) {
//            if (book.getAuthor().equals(author)) {
//                authorBooks.add(book);
//                System.out.println(authorBooks);
//            }
//        }
//        books.put(author.getName(), authorBooks);
//        return books;
//    }

    //----------- displayBooks() - will dispaly all books available on Library -----------
    public void displayBooks() {
        for (Books allBooks : myBooks) {
            System.out.println(allBooks);
        }
    }

    public void displayAut() {
        for (Author allAut : myAut) {
            System.out.println(allAut);
        }
    }
}

//cate carti sunt adaugate
//        int nrBooks=0;
//        for (Author autBooks : authorBooks.keySet() ){
//            nrBooks+=authorBooks.get(autBooks).size();
//            System.out.println(nrBooks);
//        }

////        for (Books autBooks : myBooks) {
////            if (autBooks.getAuthor().equals(author)) {
////                autBookList.add(autBooks);
////                System.out.println(author);
////            }
//        }
//        if (autBookList.isEmpty()) {
//            System.out.println("no aut");
//            return null;
//        }

/*
   public List<Books> showFoundBook(String theBook) {
        List<Books> foundBooks = new ArrayList<>();

        for (Books foundIt : myBooks) {
            if (foundIt.getBookName().equals(theBook)) {
                foundBooks.add(foundIt);
                System.out.println("book found: " + theBook);
            }
        }
        if (foundBooks.isEmpty()) {
            System.out.println("no book");
            return null;
        }
        for (Books foundBookslist : foundBooks) {
            System.out.println(foundBookslist);
//        System.out.println(foundBooks);
        }
        return foundBooks;
    }

  public List<Author> searchAutName(Author autName){
        List<Author> foundAutList = new ArrayList<>();
        for(Author foundItAut: myAut) {
            if (foundItAut.getautName().equals(autName)) {
                foundAutList.add(foundItAut);
                System.out.println("aut found: " + autName);
            }
        }
//        if(foundAutList.isEmpty()){
//            System.out.println("no aut");
//            return null;
//        }
//        for (Author foundAutLis: foundAutList){
//            System.out.println(foundAutLis);
//        }
        return foundAutList;
    }
 */
//-----------------eroare:
//    public List<Books> searchBook (String bookName){
//        List<Books> foundBooks = new ArrayList<>();
//        for(Books book: myBooks){
//            if(book.getBookName().equals(bookName)) {
//                foundBooks.add(book);
//                System.out.println("The book matches: " + bookName);
//                for(Books books: foundBooks) {
//                    System.out.println("found books: " + books);
//                }
//            }
//            else return null;
//        }
//        return foundBooks;
//    }

//    public List<Books> showFoundBook(String theBook) {
////        List<Books> myBooks = new ArrayList<Books>();
//        List<Books> foundBooks = new ArrayList<>();
//        for (Books foundIt : myBooks) {
//            if (foundIt.getBookName().equals(theBook)) {
//                foundBooks.add(foundIt);
//                System.out.println("book found: " + theBook);
//            }
////            System.out.println(foundBooks);
//            for (Books foundBookslist : foundBooks) {
//                System.out.println(foundBookslist);
//                break;
//            }
//            if(foundBooks.isEmpty()){
//                System.out.println("no book");
//                return null;
//            }
//        }
//        return foundBooks;
//    }
//--------------------------