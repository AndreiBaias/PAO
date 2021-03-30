package CatalogInformatica.Model;

public class Nota{
    private Integer nota;
    private Materie materie;

    public Nota(Integer nota, Materie materie) {
        this.nota = nota;
        this.materie = materie;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public void setMaterie(Materie materie) {
        this.materie = materie;
    }

    public Materie getMaterie() {
        return materie;
    }

    @Override
    public String toString() {
        return "La materia " + materie.getNumeMaterie() +
                " studentul are nota " + nota +
                '.';
    }
}
