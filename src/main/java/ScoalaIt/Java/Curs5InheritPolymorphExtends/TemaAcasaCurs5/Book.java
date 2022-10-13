package ScoalaIt.Java.Curs5InheritPolymorphExtends.TemaAcasaCurs5;

public class Book{

    private String name;
    private int year;
    private double price;
    private int stoc;
    private Author author;


    public Book(Author author, String name, int year, double price, int stoc) {
        this.author = author;
        this.name = name;
        this.year = year;
        this.price = price;
        this.stoc = stoc;

    }

    public String getName() {
        return name;
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

    public Author getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Book " +
                "name='" + name + '\'' +
                ", year=" + year +
                ", price=" + price + " ron" +
                ", stoc=" + stoc +
                ", author=" + author +
                '}';
    }
}
