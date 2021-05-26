package CatalogInformatica.Service;
import CatalogInformatica.Utils.Actions;
import CatalogInformatica.Utils.Actions.*;
import CatalogInformatica.Model.Nota;
import CatalogInformatica.Model.Profesor;
import CatalogInformatica.Model.Student;

import static CatalogInformatica.Service.MainService.Profesori;
import static CatalogInformatica.Service.MainService.Studenti;

public class PersoaneService {

    private static class SINGLETON_HOLDER{
        private static final PersoaneService INSTANCE = new PersoaneService();
    }

    public static PersoaneService getInstance() {
        return SINGLETON_HOLDER.INSTANCE;
    }

    public static void adaugaStudent(Student student)
    {
        Nota[] note = new Nota[36];
        for(int i = 0; i < 36; i++)
        {
            Nota nota = new Nota(0 , MainService.Materii.get(i));
            note[i] = nota;
        }
        student.setNote(note);
//        Studenti.add(student);
        Actions.adaugaStudent(student);
//        Student stud = Actions.retrieveStudent().get(Actions.retrieveStudent().size()-1);

    }

    public static void arataStudent(int i)
    {
        System.out.println(Studenti.get(i-1));
    }

    public static void arataNoteStudent(int i)
    {
        Student temp = Studenti.get(i-1);
        System.out.println(temp.toStringNote());
    }

    public static void modificaStudent(int i, String nume, String adresa, String tel)
    {
        Studenti.get(i-1).setNume(nume);
        Studenti.get(i-1).setAdresa(adresa);
        Studenti.get(i-1).setTelefon(tel);

    }

    public static void modificaAnStudent(int i, int an)
    {
        Studenti.get(i-1).setAn(an);
    }

    public static void adaugaProfesor(Profesor profesor)
    {
        Profesori.add(profesor);
    }

    public static void modificaProfesor(int i, String nume, String adresa, String tel)
    {
        Profesori.get(i-1).setNume(nume);
        Profesori.get(i-1).setAdresa(adresa);
        Profesori.get(i-1).setTelefon(tel);
    }

    public static void arataProfesor(int i)
    {
        System.out.println(Profesori.get(i-1));
    }

    public static void adaugaMateriiProfesor(String materie)
    {
        if(StructuraService.verificaMaterie(materie) != null)
            MainService.MateriiProfesor.add(StructuraService.verificaMaterie(materie));
    }




}
