package CatalogInformatica.Model;

public class Examen extends Materie{
    private String data;
    private Integer restantieri;
    private Materie materie;


    public Examen(String numeMaterie, Integer semestru, String data, Integer restantieri) {
        super(numeMaterie, semestru);
        this.data = data;
        this.restantieri = restantieri;
        this.materie = new Materie(numeMaterie , semestru);
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Integer getRestantieri() {
        return restantieri;
    }

    public void setRestantieri(Integer restantieri) {
        this.restantieri = restantieri;
    }

    public Materie getMaterie() {
        return materie;
    }

    public void setMaterie(Materie materie) {
        this.materie = materie;
    }

    @Override
    public String toString() {
        return "Examen la materia " +
                materie.getNumeMaterie() +
                " pe data de " + data +
                ", numarul de restantieri inscrisi fiind " + restantieri;
    }
}
