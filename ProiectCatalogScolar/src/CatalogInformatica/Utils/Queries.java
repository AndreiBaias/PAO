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


    public static final String Sterge_Materie = "delete from materie where (MaterieNume = ?)";
    public static final String Sterge_Student = "delete from student where (StudentNrOrd = ?)";
    public static final String Sterge_Semestru = "delete from semestru where (SemestruNr = ?)";
    public static final String Sterge_An = "delete from anuniversitar where (AnNr = ?)";


    public static final String Actualizare_Materie = "update materie set MaterieSemestru=? where MaterieNume =? ";
    public static final String Actualizare_Student = "update student set StudentNume=?, StudentAdresa = ?, StudentTelefon = ?, StudentAn = ? where StudentNrOrd =? ";
    public static final String Actualizare_Nota = "update nota set NotaValoare=? where (NotaStudentId = ? and NotaMaterieNume =?) ";
    public static final String Actualizare_An = "update anuniversitar set AnNrSerii =? where AnNr =? ";
}