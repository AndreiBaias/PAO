package CatalogInformatica.Model;

public class AnUniversitar {
    protected Integer an;
    private Integer nrSerii;

    public AnUniversitar(Integer an, Integer nrSerii) {
        this.an = an;
        this.nrSerii = nrSerii;
    }

    public Integer getAn() {
        return an;
    }

    public void setAn(Integer an) {
        this.an = an;
    }

    public Integer getNrSerii() {
        return nrSerii;
    }

    public void setNrSerii(Integer nrSerii) {
        this.nrSerii = nrSerii;
    }

    @Override
    public String toString() {
        return "Anul " + an + " are " + nrSerii + " serii.";
    }
}
