package ScoalaIt.Java.Curs5InheritPolymorphExtends.desters;

public class Author {
    private String name;
    private String email;

    public Author(String name, String email){
        this.email = email;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
