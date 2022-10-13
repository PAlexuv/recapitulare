package ScoalaIt.Java.Curs5InheritPolymorphExtends.TemaAcasaCurs5;

public class Author {
    private String authName;
    private String email;

    public Author(String authName, String email){
        this.authName = authName;
        this.email = email;
    }

    public String getAuthName() {
        return authName;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "" +
                " " + authName +
                ", email='" + email + '\'' +
                '}';
    }
}
