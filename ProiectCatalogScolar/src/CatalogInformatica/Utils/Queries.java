package CatalogInformatica.Utils;

public class Queries {
    public static final String Adauga_Materie = "insert into materie(MaterieNume, MaterieSemestru) values(?,?)";
    public static final String Adauga_An = "insert into anuniversitar(AnNr, AnNrSerii) values(?,?)";
    public static final String Adauga_Semestru = "insert into semestru(SemestruNr, SemestruAn) values(?,?)";
    public static final String Adauga_Student = "insert into student(StudentNrOrd, StudentNume, StudentAdresa,StudentTelefon,StudentAn) values(?, ?, ?, ?,?)";
    public static final String Adauga_Nota = "insert into nota(NotaStudentId, NotaMaterieNume, NotaValoare) values(?, ?, ?)";
    public static final String Retrieve_An = "select AnNr,AnNrSerii from anuniversitar";
    public static final String Retrieve_Semestru = "select SemestruNr,SemestruAn from semestru";
    public static final String Retrieve_Student = "select StudentNrOrd, StudentNume, StudentAdresa,StudentTelefon,StudentAn from student";
    public static final String Retrieve_Nota = "select NotaStudentId, NotaMaterieNume, NotaValoare from nota";
}