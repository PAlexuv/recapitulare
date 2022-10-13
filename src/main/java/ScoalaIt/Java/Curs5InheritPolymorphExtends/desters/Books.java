package ScoalaIt.Java.Curs5InheritPolymorphExtends.desters;

public class Books {
    private String namebook;
    private int year;
    private Author author;
    private double price;
    private int stoc;

    public Books(String namebook, int year, Author author, double price, int stoc) {
        this.author = author;
        this.namebook = namebook;
        this.year = year;
        this.price = price;
        this.stoc = stoc;
    }

    public String getNamebook() {
        return namebook;
    }

    public int getYear() {
        return year;
    }

    public Author getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public int getStoc() {
        return stoc;
    }

    @Override
    public String toString() {
        return "Books{" +
                "namebook='" + namebook + '\'' +
                ", year=" + year +
                ", author=" + author +
                ", price=" + price + "ron" +
                ", stoc=" + stoc +
                '}';
    }
}
