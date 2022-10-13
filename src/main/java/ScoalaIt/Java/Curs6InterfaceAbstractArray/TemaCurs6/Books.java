package ScoalaIt.Java.Curs6InterfaceAbstractArray.TemaCurs6;

import java.util.Objects;

public class Books {
    private Author author;
    private LibraryPosition libraryPosition;
    private String bookName;
    private int year;
    private double price;
    private int stoc;

    public Books(Author author, LibraryPosition libraryPosition, String bookName, int year, double price, int stoc) {
        this.author = author;
        this.libraryPosition = libraryPosition;
        this.bookName = bookName;
        this.year = year;
        this.price = price;
        this.stoc = stoc;
    }

    public Author getAuthor() {
        return author;
    }

    public LibraryPosition getLibraryPosition() {
        return libraryPosition;
    }

    public String getBookName() {
        return bookName;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    public int getStoc() {
        return stoc;
    }


    public void setLibraryPosition(LibraryPosition libraryPosition) {
        this.libraryPosition = libraryPosition;
    }

    @Override
    public String toString() {
        return author +
                "bookName= " + bookName + '\'' +
                ", year=" + year +
                ", price=" + price +
                ", stoc=" + stoc +
                ", libraryPosition=" + libraryPosition + " *** ";
                };

    //compare 2 books with the same name year etc... not working just to compare book1 with book2 as they get separate memory allocation
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Books books = (Books) o;
        return year == books.year && Double.compare(books.price, price) == 0 && stoc == books.stoc && author.equals(books.author) && libraryPosition.equals(books.libraryPosition) && bookName.equals(books.bookName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, libraryPosition, bookName, year, price, stoc);
    }
}
