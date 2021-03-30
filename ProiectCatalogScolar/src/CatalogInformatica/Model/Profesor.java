package CatalogInformatica.Model;

import java.util.Arrays;
import java.util.List;

public class Profesor{
    private Integer nrOrd;
    private String nume;
    private String adresa;
    private String telefon;
    private List<Materie> materii;

    public Profesor(Integer nrOrd, String nume, String adresa, String telefon) {
        this.nrOrd = nrOrd;
        this.nume = nume;
        this.adresa = adresa;
        this.telefon = telefon;
    }

    public Integer getNrOrd() {
        return nrOrd;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public List<Materie> getMaterii() {
        return materii;
    }

    public void setMaterii(List<Materie> materii) {
        this.materii = materii;
    }

    public void addMaterie(Materie materie)
    {
        this.materii.add(materie);
    }

    @Override
    public String toString() {
        return "Profesor selectat are datele: " +
                "Nr. Crt=" + nrOrd +
                ", nume= " + nume +
                ", adresa= " + adresa +
                ", telefon= " + telefon  +
                " si preda materiile " + materii +
                '.';
    }
}
