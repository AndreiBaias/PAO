package CatalogInformatica.Service;

import CatalogInformatica.Model.*;

import java.util.*;

import static CatalogInformatica.Model.Materie.compSem;

public class MainService {

    public List<AnUniversitar> Ani = new ArrayList<AnUniversitar>();
    public List<Semestru> Semestre = new ArrayList<>();
    public List<Materie> Materii = new ArrayList<Materie>();
    public List<Examen> Examene = new ArrayList<>();
    public List<Student> Studenti = new ArrayList<Student>();
    public List<Profesor> Profesori = new ArrayList<Profesor>();
    public List<Materie> MateriiProfesor = new ArrayList<Materie>();



    public void afisareAn (int i)
    {
        System.out.println(Ani.get(i-1).toString());
    }

    public void afisareSemestru(int i)
    {
        for(Semestru sem : Semestre)
            if(sem.getNr() == i)
            {
                System.out.println(sem.toString());
                return;
            }
        System.out.println("Facultatea noastra nu are atatea semestre!");
    }

    public void afisareExamen(String materie)
    {
        for(Examen i : Examene)
        {
            if(i.getNumeMaterie().equals(materie))
            {
                System.out.println(i.toString());
                return;
            }
        }
        System.out.println("Examenul la aceasta materie inca nu a fost setat!");

    }
    public void adaugaStudent(Student student)
    {
        Nota[] note = new Nota[36];
        for(int i = 0; i < 36; i++)
        {
            Nota nota = new Nota(0 , Materii.get(i));
            note[i] = nota;
        }
        student.setNote(note);
        Studenti.add(student);
    }

    public void arataStudent(int i)
    {
        System.out.println(Studenti.get(i-1));
    }

    public void arataNoteStudent ( int i)
    {
        Student temp = Studenti.get(i-1);
        System.out.println(temp.toStringNote());
    }

    public void modificaStudent(int i, String nume, String adresa, String tel)
    {
        Studenti.get(i-1).setNume(nume);
        Studenti.get(i-1).setAdresa(adresa);
        Studenti.get(i-1).setTelefon(tel);

    }

    public void modificaAnStudent(int i, int an)
    {
        Studenti.get(i-1).setAn(an);
    }

    public void adaugaProfesor(Profesor profesor)
    {
        Profesori.add(profesor);
    }

    public void modificaProfesor(int i, String nume, String adresa, String tel)
    {
        Profesori.get(i-1).setNume(nume);
        Profesori.get(i-1).setAdresa(adresa);
        Profesori.get(i-1).setTelefon(tel);
    }

    public void arataProfesor(int i)
    {
        System.out.println(Profesori.get(i-1));
    }

    public void adaugaMateriiProfesor(String materie)
    {
        if(verificaMaterie(materie) != null)
            MateriiProfesor.add(verificaMaterie(materie));
    }


    public Materie verificaMaterie(String ver)
    {
        for(Materie i : Materii)
        {
            if(i.getNumeMaterie().equals(ver))
                return i;
        }
        return null;

    }

    public void modificaNumeMaterie(String materie, String nou)
    {
        verificaMaterie(materie).setNumeMaterie(nou);
    }

    public void modificaSemestruMaterie(String materie, int sem)
    {
        verificaMaterie(materie).setSemestru(sem);
    }

    //initializari

    public void initializareAni()
    {
        AnUniversitar an1 = new AnUniversitar(1 , 3);
        Ani.add(an1);
        AnUniversitar an2 = new AnUniversitar(2 , 2);
        Ani.add(an2);
        AnUniversitar an3 = new AnUniversitar(3 , 2);
        Ani.add(an3);
//        for(AnUniversitar a : Ani)
//        {
//            System.out.println(a);
//        }

    }

    public void intializareSemestre()
    {
        Semestru s1 = new Semestru(1, 3, 1);
        Semestre.add(s1);
        Semestru s2 = new Semestru(1, 3, 2);
        Semestre.add(s2);
        Semestru s3 = new Semestru(2, 2, 3);
        Semestre.add(s3);
        Semestru s4 = new Semestru(2, 2, 4);
        Semestre.add(s4);
        Semestru s5 = new Semestru(3, 2, 5);
        Semestre.add(s5);
        Semestru s6 = new Semestru(3, 2, 6);
        Semestre.add(s6);
    }



    public void initializareMaterii()
    {
        int i = 0;
        Materie materie1 = new Materie( "SAI", i/6 + 1);
        Materii.add(materie1);
        i++;
        Materie materie2 = new Materie("CDI" , i/6 + 1);
        Materii.add(materie2);
        i++;
        Materie materie3 = new Materie("LMC" , i/6 + 1);
        Materii.add(materie3);
        i++;
        Materie materie4 = new Materie( "PA", i/6 + 1);
        Materii.add(materie4);
        i++;
        Materie materie5 = new Materie( "ASC", i/6 + 1);
        Materii.add(materie5);
        i++;
        Materie materie6 = new Materie( "GCEA", i/6 + 1);
        Materii.add(materie6);
        i++;
        Materie materie7 = new Materie( "GAL", i/6 + 1);
        Materii.add(materie7);
        i++;
        Materie materie8 = new Materie( "BD", i/6 + 1);
        Materii.add(materie8);
        i++;
        Materie materie9 = new Materie( "SD", i/6 + 1);
        Materii.add(materie9);
        i++;
        Materie materie10 = new Materie( "LFA", i/6 + 1);
        Materii.add(materie10);
        i++;
        Materie materie11 = new Materie( "POO", i/6 + 1);
        Materii.add(materie11);
        i++;
        Materie materie12 = new Materie( "TW", i/6 + 1);
        Materii.add(materie12);
        i++;
        Materie materie13 = new Materie( "PS", i/6 + 1);
        Materii.add(materie13);
        i++;
        Materie materie14 = new Materie("AF" , i/6 + 1);
        Materii.add(materie14);
        i++;
        Materie materie15 = new Materie( "SGBD", i/6 + 1);
        Materii.add(materie15);
        i++;
        Materie materie16 = new Materie( "PF", i/6 + 1);
        Materii.add(materie16);
        i++;
        Materie materie17 = new Materie("SO" , i/6 + 1);
        Materii.add(materie17);
        i++;
        Materie materie18 = new Materie( "DAW", i/6 + 1);
        Materii.add(materie18);
        i++;
        Materie materie19 = new Materie( "IA", i/6 + 1);
        Materii.add(materie19);
        i++;
        Materie materie20 = new Materie( "PAO", i/6 + 1);
        Materii.add(materie20);
        i++;
        Materie materie21 = new Materie( "AA", i/6 + 1);
        Materii.add(materie21);
        i++;
        Materie materie22 = new Materie( "FLP", i/6 + 1);
        Materii.add(materie22);
        i++;
        Materie materie23 = new Materie( "MDS", i/6 + 1);
        Materii.add(materie23);
        i++;
        Materie materie24 = new Materie( "RC", i/6 + 1);
        Materii.add(materie24);
        i++;
        Materie materie25 = new Materie( "CC", i/6 + 1);
        Materii.add(materie25);
        i++;
        Materie materie26 = new Materie( "SSI", i/6 + 1);
        Materii.add(materie26);
        i++;
        Materie materie27 = new Materie( "IS", i/6 + 1);
        Materii.add(materie27);
        i++;
        Materie materie28 = new Materie( "AMI", i/6 + 1);
        Materii.add(materie28);
        i++;
        Materie materie29 = new Materie( "CS", i/6 + 1);
        Materii.add(materie29);
        i++;
        Materie materie30 = new Materie( "GV", i/6 + 1);
        Materii.add(materie30);
        i++;
        Materie materie31 = new Materie( "SDS", i/6 + 1);
        Materii.add(materie31);
        i++;
        Materie materie32 = new Materie( "IS", i/6 + 1);
        Materii.add(materie32);
        i++;
        Materie materie33 = new Materie( "PD", i/6 + 1);
        Materii.add(materie33);
        i++;
        Materie materie34 = new Materie( "IA", i/6 + 1);
        Materii.add(materie34);
        i++;
        Materie materie35 = new Materie( "LICENTA", i/6 + 1);
        Materii.add(materie35);
        i++;
        Materie materie36 = new Materie( "PRACTICA", i/6 + 1);
        Materii.add(materie36);
        i++;
        Collections.sort(Materii , compSem);
    }


}
