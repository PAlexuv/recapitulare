package TestingBioGama.DataBioG.Models;

public class BaseModelRegistrationBioG {

    private String nume;
    private String prenume;
    private String telefon;
    private String email;
    private String parola;
    private String parolaVerif;
    private boolean termreq;

    public boolean isTermreq(){
        return termreq;
    }
    public void setTermreq(boolean termreq) {
        this.termreq = termreq;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public String getParolaVerif() {
        return parolaVerif;
    }

    public void setParolaVerif(String parolaVerif) {
        this.parolaVerif = parolaVerif;
    }
}
