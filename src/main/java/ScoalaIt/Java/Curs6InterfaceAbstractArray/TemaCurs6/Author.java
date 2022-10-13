package ScoalaIt.Java.Curs6InterfaceAbstractArray.TemaCurs6;

import java.util.Objects;

public class Author {
    private String autName;
    private String email;

    public Author(String autName, String email) {
        this.autName = autName;
        this.email = email;
    }

    public String getautName() {
        return autName;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return autName + " " +
                "- ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return autName.equals(author.autName) && email.equals(author.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(autName, email);
    }
}
