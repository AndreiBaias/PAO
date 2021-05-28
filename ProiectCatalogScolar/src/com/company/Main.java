package com.company;
import CatalogInformatica.Model.*;
import CatalogInformatica.Service.*;
import CatalogInformatica.Service.MainService;
import CatalogInformatica.Service.PersoaneService;
import CatalogInformatica.Service.ReportGeneratorService;
import CatalogInformatica.Service.StructuraService;
import CatalogInformatica.Utils.Actions;

import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import static CatalogInformatica.Model.Materie.compSem;
import static CatalogInformatica.Service.MainService.Studenti;

public class Main {

    public static void main(String[] args) throws SQLException, IOException {


        MainService mainService = new MainService();
        mainService.initializareAni();
        mainService.initializareMaterii();
        mainService.intializareSemestre();
        mainService.testAfisareNota();
//        Materie materie1 = new Materie( "materieTest", 1);
//        Materie materie2 = new Materie( "materieUpdate", 6);
//        mainService.adaugaMaterieTest(materie1);
//        mainService.stergeMaterieTest("materieTest");
//        mainService.actualizareMaterieTest(materie2, "materieTest");
//        mainService.stergeStudentTest(3);
//        AnUniversitar anNouTest = new AnUniversitar(4, 7);
//        Actions.adaugaAn(anNouTest);
//        mainService.stergeAnTest(4);
//        Semestru semestruTest = new Semestru(4, 7, 7);
//        Actions.adaugaSemestru(semestruTest);
//        mainService.stergeSemestruTest(7);
//        mainService.actualizareStudentTest(2, "studentUpdate", "studentUpdate", "0798765432", 2);
//        mainService.actualizareNotaTest(2, "PAO", 10);
//        mainService.actualizareAnTest(4,12);
        Integer nrOrdStudenti = 1;
        Integer nrOrdProfesori = 1;
        boolean ok = false;
        System.out.println("Bun venit pe catalogul dumneavoastra digital!");
        while(true) {
            System.out.println("Va rugam sa alegeti o optiune prin introducere a numarului corespunzator:");
            System.out.println("1. Introducere student nou");
            System.out.println("2. Modificare date student");
            System.out.println("3. Afisare date student");
            System.out.println("4. Afisare note student");
            System.out.println("5. Introducere profesor nou");
            System.out.println("6. Modificare date profesor");
            System.out.println("7. Afisare date profesor");
            System.out.println("8. Afisare detalii materie");
            System.out.println("9. Modificare materie");
            System.out.println("10. Afisare detalii an universitar");
            System.out.println("11. Afisare detalii semestru");
            System.out.println("12. Programare examen");
            System.out.println("13. Afisare detalii examen");
//            System.out.println("14. Afisare detalii catedra");
//            System.out.println("15. Modificare nota student");
            System.out.println("Pentru finalizare introduceti orice numar care nu este atasat unei optiuni");

            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            int n = Integer.parseInt(input);

            switch(n)
            {
                case 1:
                    System.out.println("Introduceti pe rand numele complet, adresa completa si numarul de telefon ale studentului.");
                    System.out.println("Separati fiecare camp cu simbolul <<;>> si la final apasati enter. ");
                    String dateStudent = scanner.nextLine();
                    String[] fragments = dateStudent.split(";");
                    Student student = new Student(
                            nrOrdStudenti,
                            fragments[0],
                            fragments[1],
                            fragments[2]
                    );
                    nrOrdStudenti++;
                    student.setAn(1);
                    PersoaneService.adaugaStudent(student);
                    ReportGeneratorService.logAction("AddStudent");
//                    MainService.Studenti = Actions.retrieveStudent();
//                    System.out.println(Studenti);
//                    Student ultStud = Studenti.get(Studenti.size() - 1);
//                    for (Nota i:ultStud.getNote())
//                        Actions.adaugaNota(ultStud, i.getMaterie(), i);
                    break;
                case 2:
                    System.out.println("Introduceti numarul de ordine al studentului:");
                    String nrOrdStud = scanner.nextLine();
                    int nrOrd= Integer.parseInt(nrOrdStud);
                    System.out.println("Pentru modificarea datelor personale scrieti <<date>>");
                    System.out.println("Pentru modificarea anului universitar scrieti <<an>>");
                    System.out.println("Pentru modificarea unei note utilizati optiunea 14");
                    String mod = scanner.nextLine();
                    if(mod.equals("date"))
                    {
                        System.out.println("Reintroduceti datele studentului.");
                        System.out.println("Introduceti pe rand numele complet, adresa completa si numarul de telefon ale studentului.");
                        System.out.println("Separati fiecare camp cu simbolul <<;>> si la final apasati enter. ");
                        String dateStudentRe = scanner.nextLine();
                        String[] fragmentsRe = dateStudentRe.split(";");
                        PersoaneService.modificaStudent(nrOrd, fragmentsRe[0], fragmentsRe[1], fragmentsRe[2]);
                    }
                    else
                    if(mod.equals("an"))
                    {
                        System.out.println("In ce an este studentul?");
                        String an = scanner.nextLine();
                        int anNou = Integer.parseInt(an);
                        PersoaneService.modificaAnStudent(nrOrd, anNou);
                    }
                    ReportGeneratorService.logAction("ModificareStudent");
                    break;
                case 3:
                    System.out.println("Introduceti numarul de ordine al studentului:");
                    String nrOrdStud1 = scanner.nextLine();
                    int nrOrd1= Integer.parseInt(nrOrdStud1);
                    try {
                        PersoaneService.arataStudent(nrOrd1);
                    }
                    catch(IndexOutOfBoundsException e)
                    {
                        System.out.println("Studentul nu exista!!!");
                    }
                    ReportGeneratorService.logAction("AfisareDateStudent");
                    break;
                case 4:
                    System.out.println("Introduceti numarul de ordine al studentului cautat: ");
                    String nrOrdStud2 = scanner.nextLine();
                    int nrOrd2 = Integer.parseInt(nrOrdStud2);
                    PersoaneService.arataNoteStudent(nrOrd2);
                    ReportGeneratorService.logAction("AfisareNoteStudent");
                    break;
                case 5:
                    System.out.println("Introduceti pe rand numele complet, adresa completa si numarul de telefon ale profesorului.");
                    System.out.println("Separati fiecare camp cu simbolul <<;>> si la final apasati enter. ");
                    String dateProfesor = scanner.nextLine();
                    String[] prof = dateProfesor.split(";");
                    Profesor profesor = new Profesor(
                            nrOrdProfesori,
                            prof[0],
                            prof[1],
                            prof[2]
                    );
                    nrOrdProfesori++;
                    System.out.println("Introduceti pe rand numele abreviate ale materiilor predate de catre profesor, fara puncte.");
                    System.out.println("Separati fiecare camp cu simbolul <<;>> si la final apasati enter. ");
                    while(ok == false)
                    {
                        String materiiProfesor = scanner.nextLine();
                        String[] profM = materiiProfesor.split(";");
                        ok = true;
                        for(String i : profM)
                        {
                            if(StructuraService.verificaMaterie(i) == null)
                            {
                                ok = false;
                                System.out.println("Aceasta materie nu este predata la facultatea noastra!");
                                System.out.println("Va rugam reluati adaugarea materiilor, scriind cu majuscule abrevierea numelui materiei, fara puncte!");
                                break;
                            }
                        }
                        if(ok)
                        {
                            for(String i : profM)
                            {
                                PersoaneService.adaugaMateriiProfesor(i);
                            }
                        }
                        profesor.setMaterii(mainService.MateriiProfesor);
                        mainService.MateriiProfesor = new ArrayList<Materie>();
                    }
                    PersoaneService.adaugaProfesor(profesor);
                    ReportGeneratorService.logAction("AddProfesor");
                    break;
                case 6:
                    System.out.println("Introduceti numarul de ordine al profesorului:");
                    String nrOrdProf = scanner.nextLine();
                    int nrOrd3= Integer.parseInt(nrOrdProf);
                    System.out.println("Pentru modificarea datelor personale scrieti <<date>>");
                    System.out.println("Pentru adaugarea unei materii predate scrieti <<materie>>");
                    String mod1 = scanner.nextLine();
                    if(mod1.equals("date"))
                    {
                        System.out.println("Reintroduceti datele profesorului.");
                        System.out.println("Introduceti pe rand numele complet, adresa completa si numarul de telefon ale profesorului.");
                        System.out.println("Separati fiecare camp cu simbolul <<;>> si la final apasati enter. ");
                        String dateProfesorRe = scanner.nextLine();
                        String[] fragmentsRe = dateProfesorRe.split(";");
                        PersoaneService.modificaProfesor(nrOrd3, fragmentsRe[0], fragmentsRe[1], fragmentsRe[2]);
                    }
                    else
                    if(mod1.equals("materie"))
                    {
                        System.out.println("Ce materie doriti sa adaugati? Scrieti abrevierea fara puncte");
                        ok = false;
                        while(ok == false)
                        {
                            String materieProfesor = scanner.nextLine();
                            ok = true;
                            if(StructuraService.verificaMaterie(materieProfesor) == null)
                            {
                                ok = false;
                                System.out.println("Aceasta materie nu este predata la facultatea noastra!");
                                System.out.println("Va rugam reluati adaugarea materiei, scriind cu majuscule abrevierea numelui materiei!");
                                break;
                            }
                            if(ok)
                            {
                                if(mainService.Profesori.get(nrOrd3-1).getMaterii().contains(StructuraService.verificaMaterie(materieProfesor)))
                                    System.out.println("Profesorul este deja inregistrat in sistem cu aceasta materie!");
                                else
                                    mainService.Profesori.get(nrOrd3-1).addMaterie(StructuraService.verificaMaterie(materieProfesor));
                            }
                        }
                    }
                    else
                        System.out.println("Optiune invalida! Reluati procesul!");
                    ReportGeneratorService.logAction("ModificareProfesor");
                    break;

                case 7:
                    System.out.println("Introduceti numarul de ordine al profesorului:");
                    String nrOrdProf1 = scanner.nextLine();
                    int nrOrd4= Integer.parseInt(nrOrdProf1);
                    PersoaneService.arataProfesor(nrOrd4);
                    ReportGeneratorService.logAction("AfisareProfesor");
                    break;
                case 8:
                    System.out.println("Introduceti numele materiei despre care vreti detalii sub forma de abreviere fara puncte si fara semn final: ");
                    String numeMaterie = scanner.nextLine();
                    if(StructuraService.verificaMaterie(numeMaterie) == null)
                        System.out.println("Aceasta materie nu se preda in facultatea noastra!");
                    else
                        System.out.println("Materia " + numeMaterie + " este predata in semestrul " + StructuraService.verificaMaterie(numeMaterie).getSemestru());
                    ReportGeneratorService.logAction("DetaliiMaterie");
                    break;
                case 9:
                    System.out.println("Introduceti numele materiei pe care o modificati: ");
                    String numeMaterie1 = scanner.nextLine();
                    if(StructuraService.verificaMaterie(numeMaterie1) == null)
                    {
                        System.out.println("Aceasta materie nu exista la facultatea noastra!");
                        break;
                    }
                    System.out.println("Modificati numele materiei sau semestrul in care se preda?");
                    System.out.println("Pentru a modifica numele introduceti <<nume>> , iar pentru a modifica semestrul, <<semestru>>");
                    String optiune = scanner.nextLine();
                    if(optiune.equals("nume"))
                    {
                        System.out.println("Introduceti noul nume sub forma de abreviere fara puncte si fara simbol final: ");
                        String mod2 = scanner.nextLine();
                        StructuraService.modificaNumeMaterie(numeMaterie1 , mod2);
                        Collections.sort(mainService.Materii , compSem);
                        System.out.println("Materia dumneavoastra se numeste acum " + StructuraService.verificaMaterie(mod2).getNumeMaterie());

                    }
                    else
                    if(optiune.equals("semestru"))
                    {
                        System.out.println("Introduceti numarul corespunzator semestrului in care se va preda materia: ");
                        String mod3 = scanner.nextLine();
                        int semNou = Integer.parseInt(mod3);
                        StructuraService.modificaSemestruMaterie(numeMaterie1 , semNou);
                        Collections.sort(mainService.Materii , compSem);
                        System.out.println("Materia " + StructuraService.verificaMaterie(numeMaterie1).getNumeMaterie() + " se va preda de acum in semestrul " +  StructuraService.verificaMaterie(numeMaterie1).getSemestru());
                    }
                    else
                        System.out.println("Optiune invalida! Reluati procesul!");
                    ReportGeneratorService.logAction("ModificareMaterie");
                    break;
                case 10:
                    System.out.println("Introduceti anul despre care vreti detalii: ");
                    String anCautat = scanner.nextLine();
                    int an = Integer.parseInt(anCautat);
                    StructuraService.afisareAn(an);
                    ReportGeneratorService.logAction("AfisareAn");
                    break;
                case 11:
                    System.out.println("Introduceti numarul semestrului: ");
                    String semCautat = scanner.nextLine();
                    int sem = Integer.parseInt(semCautat);
                    StructuraService.afisareSemestru(sem);
                    ReportGeneratorService.logAction("AfisareSemestru");
                    break;
                case 12:
                    System.out.println("Introduceti numele materiei, semestrul in care se face, data examenului si numarul de restantieri inscrisi.");
                    System.out.println("Separati informatiile cu simbolul <<;>>");
                    String examenNou = scanner.nextLine();
                    String[] exam = examenNou.split(";");
                    Examen examen = new Examen(
                            exam[0],
                            Integer.parseInt(exam[1]),
                            exam[2],
                            Integer.parseInt(exam[3])
                    );
                    mainService.Examene.add(examen);
                    System.out.println(examen.toString());
                    ReportGeneratorService.logAction("ProgramareExamen");

                    break;
                case 13:
                    System.out.println("Introduceti numele materiei de care sunteti interesat: ");
                    String examenCautat = scanner.nextLine();
                    StructuraService.afisareExamen(examenCautat);
                    ReportGeneratorService.logAction("AfisareExamen");
                    break;
                default:
                    ReportGeneratorService.generateAniReport(mainService.Ani);
                    ReportGeneratorService.generateSemestreReport(mainService.Semestre);
                    ReportGeneratorService.generateMateriiReport(mainService.Materii);
                    ReportGeneratorService.generateExameneReport(mainService.Examene);
                    System.out.println("Va multumim ca ati folosit aplicatia noastra! La revedere!");
                    ReportGeneratorService.logAction("EXIT");
                    System.exit(0);


            }
        }






        // write your code here
    }
}
