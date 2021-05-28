package CatalogInformatica.Service;

import CatalogInformatica.Model.*;

import CatalogInformatica.Service.ReportGeneratorService;

import CatalogInformatica.Utils.Actions;

import java.sql.SQLException;
import java.util.*;


import CatalogInformatica.Utils.*;

import static CatalogInformatica.Model.Materie.compSem;

public class MainService {

    public static List<AnUniversitar> Ani = new ArrayList<AnUniversitar>();
    public static List<Semestru> Semestre = new ArrayList<>();
    public static List<Materie> Materii = new ArrayList<Materie>();
    public static List<Examen> Examene = new ArrayList<>();
    public static List<Student> Studenti = new ArrayList<Student>();
    public static List<Profesor> Profesori = new ArrayList<Profesor>();
    public static List<Materie> MateriiProfesor = new ArrayList<Materie>();




    //initializari

    public void initializareAni()
    {
        Ani = Actions.retrieveAni();
        ReportGeneratorService.generateAniReport(Ani);
//        for(AnUniversitar a : Ani)
//        {
//            System.out.println(a);
//        }

    }

    public void intializareSemestre()
    {
        Semestre = Actions.retrieveSemestru();
        ReportGeneratorService.generateSemestreReport(Semestre);
    }

    public void test()
    {
//        for(Materie A:Materii) {
//            Actions.adaugaMaterie(A);
//        }
    }

    public void adaugaMaterieTest(Materie M)
    {
        Actions.adaugaMaterie(M);
    }

    public void stergeMaterieTest(String M)
    {
        Actions.stergeMaterie(M);
    }

    public void stergeStudentTest(int id)
    {
        Actions.stergeStudent(id);
//        System.out.println("STERS!!!!");
    }

    public void stergeSemestruTest(int id)
    {
        Actions.stergeSemestru(id);
//        System.out.println("STERS!!!!");
    }

    public void stergeAnTest(int id)
    {
        Actions.stergeAn(id);
//        System.out.println("STERS!!!!");
    }

    public void testAfisareNota()
    {
        System.out.println(Actions.retrieveNota(1, "PAO"));
    }

    public void actualizareMaterieTest(Materie M, String nume) throws SQLException {
        Actions.actualizareMaterie(M, nume);
    }

    public void actualizareStudentTest(int id, String StudentNume, String StudentAdresa, String StudentTelefon, int StudentAn) throws SQLException {
        Actions.actualizareStudent(id, StudentNume, StudentAdresa, StudentTelefon, StudentAn);
    }

    public void actualizareNotaTest(int id, String numeMaterie, int valoareNota) throws SQLException {
        Actions.actualizareNota(id, numeMaterie, valoareNota);
    }

    public void actualizareAnTest(int an, int serii) throws SQLException {
        Actions.actualizareAn(an, serii);
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
        Materie materie32 = new Materie( "ISOpt", i/6 + 1);
        Materii.add(materie32);
        i++;
        Materie materie33 = new Materie( "PD", i/6 + 1);
        Materii.add(materie33);
        i++;
        Materie materie34 = new Materie( "IAOpt", i/6 + 1);
        Materii.add(materie34);
        i++;
        Materie materie35 = new Materie( "LICENTA", i/6 + 1);
        Materii.add(materie35);
        i++;
        Materie materie36 = new Materie( "PRACTICA", i/6 + 1);
        Materii.add(materie36);
        i++;
        ReportGeneratorService.generateMateriiReport(Materii);
        Collections.sort(Materii , compSem);
    }


}
