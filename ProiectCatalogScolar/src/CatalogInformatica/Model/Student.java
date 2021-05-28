package CatalogInformatica.Model;

import java.util.Arrays;

public class Student{
    private Integer nrOrd;
    private String nume;
    private String adresa;
    private String telefon;
    private Integer an;
    private Nota[] note;

    //constructor pentru un student nou inscris in anul 1


    public Student(Integer nrOrd, String nume, String adresa, String telefon) {
        this.nrOrd = nrOrd;
        this.nume = nume;
        this.adresa = adresa;
        this.telefon = telefon;
        this.an = 1;
    }

    public Student(Integer nrOrd, String nume, String adresa, String telefon, int an) {
        this.nrOrd = nrOrd;
        this.nume = nume;
        this.adresa = adresa;
        this.telefon = telefon;
        this.an = an;
    }

    public void setNrOrd(Integer nrOrd) {
        this.nrOrd = nrOrd;
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

    public Integer getAn() {
        return an;
    }

    public void setAn(Integer an) {
        this.an = an;
    }

    public Nota[] getNote() {
        return note;
    }

    public void setNote(Nota[] note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Studentul are urmatoarele date: " +
                "Nr. crt.=" + nrOrd +
                ", Nume= " + nume +
                ", Adresa= " + adresa +
                ", Nr. telefon= " + telefon +
                ", an universitar= " + an +
                '.';
    }

    public String toStringNote()
    {
        return Arrays.toString(note);
    }
}
