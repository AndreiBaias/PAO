package CatalogInformatica.Model;

import java.util.Arrays;

public class Catedra{
    private String domeniu;
    private Profesor[] profesori;

    public Catedra(String domeniu, Profesor[] profesori) {
        this.domeniu = domeniu;
        this.profesori = profesori;
    }

    public String getDomeniu() {
        return domeniu;
    }

    public void setDomeniu(String domeniu) {
        this.domeniu = domeniu;
    }

    public Profesor[] getProfesori() {
        return profesori;
    }

    public void setProfesori(Profesor[] profesori) {
        this.profesori = profesori;
    }

    @Override
    public String toString() {
        return "Catedra de " +
                domeniu + '{' +
                "profesori=" + Arrays.toString(profesori) +
                '}';
    }
}
