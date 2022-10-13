package ScoalaIt.Java.Curs5InheritPolymorphExtends.TemaClasaCurs5;

public class Person {

    private String nume;
    private String cnp;
    private String gen;
    private int varsta;

    public Person(String nume, String gen, String cnp, int varsta){
        this.nume=nume;
        this.gen = gen;
        this.varsta = varsta;
        this.cnp = cnp;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public String getGen() {
        return gen;
    }

    public void setGen(String gen) {
        this.gen = gen;
    }

    public int getVarsta() {
        return varsta;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    @Override
    public String toString() {
        return "Person: " +
                "nume='" + nume + '\'' +
                ", gen='" + gen + '\'' +
                ", cnp=" + cnp +
                ", varsta=" + varsta;
    }
}
