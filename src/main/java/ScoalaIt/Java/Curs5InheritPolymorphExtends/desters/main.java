package ScoalaIt.Java.Curs5InheritPolymorphExtends.desters;

public class main {
    public static void main(String[] args) {
        Author a1 = new Author("Liviu", "li@li.ro");
        Author a2 = new Author("Alex", "lalex@li.ro");
        Author a3 = new Author("bogdan", "bogdan@li.ro");
        System.out.println(a1.getEmail());
        System.out.println(a1.getName());
        System.out.println(a1.toString());

        System.out.println();

        Books b1 = new Books("carte1", 1234, a1, 54.6, 6);
        Books b2 = new Books("carte2", 1432, a2, 65, 3);
        Books b3 = new Books("carte3", 14832, a2, 658, 83);
        System.out.println(b1.getAuthor());
        System.out.println(b1.getNamebook());
        System.out.println(b1.getStoc());
        System.out.println(b1.toString());

    }
}
