package CatalogInformatica.Model;

import java.util.Comparator;

public class Materie {
    private String numeMaterie;
    private Integer semestru;

    public Materie(String numeMaterie, Integer semestru) {
        this.numeMaterie = numeMaterie;
        this.semestru = semestru;
    }

    public String getNumeMaterie() {
        return numeMaterie;
    }

    public void setNumeMaterie(String numeMaterie) {
        this.numeMaterie = numeMaterie;
    }

    public Integer getSemestru() {
        return semestru;
    }

    public void setSemestru(Integer semestru) {
        this.semestru = semestru;
    }

    @Override
    public String toString() {
        return "Materie{" +
                "numeMaterie='" + numeMaterie + '\'' +
                ", semestru=" + semestru +
                '}';
    }

    public static Comparator<Materie> compSem = new Comparator<Materie>() {
        @Override
        public int compare(Materie o1, Materie o2) {
            if(o1.semestru != o2.semestru)
                return o1.semestru - o2.semestru;
            else
                return o1.numeMaterie.compareTo(o2.numeMaterie);
        }

//        public int compareTo(Materie compare) {
//            int compareage = ((Materie) compare).getSemestru();
//            /* For Ascending order*/
//            return this.semestru - compareage;
//
//            /* For Descending order do like this */
//            //return compareage-this.studentage;
//        }
    };
}
