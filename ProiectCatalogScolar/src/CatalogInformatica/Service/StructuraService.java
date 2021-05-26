package CatalogInformatica.Service;

import CatalogInformatica.Model.Examen;
import CatalogInformatica.Model.Materie;
import CatalogInformatica.Model.Semestru;

public class StructuraService {

    private static class SINGLETON_HOLDER{
        private static final StructuraService INSTANCE = new StructuraService();
    }

    public static StructuraService getInstance() {
        return SINGLETON_HOLDER.INSTANCE;
    }

    public static void afisareAn(int i)
    {
        System.out.println(MainService.Ani.get(i-1).toString());
    }

    public static void afisareSemestru(int i)
    {
        for(Semestru sem : MainService.Semestre)
            if(sem.getNr() == i)
            {
                System.out.println(sem.toString());
                return;
            }
        System.out.println("Facultatea noastra nu are atatea semestre!");
    }

    public static void afisareExamen(String materie)
    {
        for(Examen i : MainService.Examene)
        {
            if(i.getNumeMaterie().equals(materie))
            {
                System.out.println(i.toString());
                return;
            }
        }
        System.out.println("Examenul la aceasta materie inca nu a fost setat!");

    }




    public static Materie verificaMaterie(String ver)
    {
        for(Materie i : MainService.Materii)
        {
            if(i.getNumeMaterie().equals(ver))
                return i;
        }
        return null;

    }

    public static void modificaNumeMaterie(String materie, String nou)
    {
        verificaMaterie(materie).setNumeMaterie(nou);
    }

    public static void modificaSemestruMaterie(String materie, int sem)
    {
        verificaMaterie(materie).setSemestru(sem);
    }




}
