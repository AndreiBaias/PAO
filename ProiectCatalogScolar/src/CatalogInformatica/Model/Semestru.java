package CatalogInformatica.Model;

public class Semestru  extends AnUniversitar{
    private Integer nr;

    public Semestru(Integer an, Integer nrSerii, Integer nr) {
        super(an, nrSerii);
        this.nr = nr;
    }

    public Integer getNr() {
        return nr;
    }

    public void setNr(Integer nr) {
        this.nr = nr;
    }


    @Override
    public String toString() {
        return "Semestrul " +
                nr +
                " face parte din anul " + an +
                '.';
    }
}
