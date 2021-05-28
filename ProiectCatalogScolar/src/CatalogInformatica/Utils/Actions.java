package CatalogInformatica.Utils;

import CatalogInformatica.Model.*;
import CatalogInformatica.Service.MainService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static CatalogInformatica.Utils.Queries.*;

public class Actions {
    private static DbConnection dbConnection = DbConnection.getInstance();
    public static String adaugaMaterie(Materie materie) {

        ResultSet resultSet;
        try{
            PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(Adauga_Materie, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, materie.getNumeMaterie());
            preparedStatement.setInt(2, materie.getSemestru());
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            if(resultSet.next()) {
                return resultSet.getString(1);
            }
            else
                return "a";
//            return Integer.parseInt(resultSet.getString(1));
        }catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Some problem ocurred during adding materie");
        }
    }

    public static int adaugaAn(AnUniversitar anUniversitar) {

        ResultSet resultSet;
        try{
            PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(Adauga_An, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, anUniversitar.getAn());
            preparedStatement.setInt(2, anUniversitar.getNrSerii());
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            if(resultSet.next()) {
                return Integer.parseInt(resultSet.getString(1));
            }
            else
                return 0;
//            return Integer.parseInt(resultSet.getString(1));
        }catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Some problem ocurred during adding an");
        }
    }
    public static int adaugaSemestru(Semestru semestru) {

        ResultSet resultSet;
        try{
            PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(Adauga_Semestru, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, semestru.getNr());
            preparedStatement.setInt(2, semestru.getAn());
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            if(resultSet.next()) {
                return Integer.parseInt(resultSet.getString(1));
            }
            else
                return 0;
//            return Integer.parseInt(resultSet.getString(1));
        }catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Some problem ocurred during adding semestru");
        }
    }

    public static int adaugaStudent(Student student) {

        ResultSet resultSet;
        try{
            PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(Adauga_Student, Statement.RETURN_GENERATED_KEYS);
            if(retrieveStudent().isEmpty())
                preparedStatement.setInt(1, 1);
            else
                preparedStatement.setInt(1, retrieveStudent().get(retrieveStudent().size()-1).getNrOrd()+1);
            preparedStatement.setString(2, student.getNume());
            preparedStatement.setString(3, student.getAdresa());
            preparedStatement.setString(4, student.getTelefon());
            preparedStatement.setInt(5, student.getAn());
            preparedStatement.executeUpdate();
            student = retrieveStudent().get(retrieveStudent().size()-1);
//            System.out.println(student);
            Nota[] note = new Nota[36];
            for(int i = 0; i < 36; i++)
            {
                Nota nota = new Nota(0 , MainService.Materii.get(i));
                note[i] = nota;
            }
            student.setNote(note);
            for(Nota i:student.getNote()) {
                Materie m = i.getMaterie();
                adaugaNota(student, m, i);
            }
            resultSet = preparedStatement.getGeneratedKeys();
            if(resultSet.next()) {
                return Integer.parseInt(resultSet.getString(1));
            }
            else
                return 0;
//            return Integer.parseInt(resultSet.getString(1));
        }catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Some problem ocurred during adding student");
        }
    }

    public static int adaugaNota(Student student, Materie materie, Nota nota) {

        ResultSet resultSet;
        try{
            PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(Adauga_Nota, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, student.getNrOrd());
            preparedStatement.setString(2, materie.getNumeMaterie());
            preparedStatement.setInt(3, nota.getNota());
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            if(resultSet.next()) {
                return Integer.parseInt(resultSet.getString(1));
            }
            else
                return 0;
//            return Integer.parseInt(resultSet.getString(1));
        }catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Some problem ocurred during adding nota");
        }
    }


    public static List<AnUniversitar> retrieveAni() {
        List<AnUniversitar> ani = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(Retrieve_An);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                AnUniversitar An = new AnUniversitar(resultSet.getInt(1), resultSet.getInt(2));
                ani.add(An);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return ani;
    }

    public static List<Semestru> retrieveSemestru() {
        List<Semestru> sem = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(Retrieve_Semestru);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int a = resultSet.getInt(1);
                int b = resultSet.getInt(2);
                int c = 0;
                for(AnUniversitar i:retrieveAni())
                    if(i.getAn() == b)
                        c=i.getNrSerii();
                Semestru Sem = new Semestru(b, c, a);
                sem.add(Sem);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return sem;
    }

    public static List<Student> retrieveStudent() {
        List<Student> stud = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(Retrieve_Student);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Student student = new Student(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4));
                stud.add(student);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return stud;
    }

    public static int retrieveNota(int s, String m) {
        int nota=0;
        try {
            PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(Retrieve_Nota);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                if(resultSet.getInt(1) == s && resultSet.getString(2) == m)
                {
                    nota = resultSet.getInt(3);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nota;
    }

    public static void stergeMaterie(String numeMaterie){


        try{
            PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(Sterge_Materie, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, numeMaterie);

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public static void stergeStudent(int id){


        try{
            PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(Sterge_Student, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }


    public static void stergeSemestru(int nr){


        try{
            PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(Sterge_Semestru, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, nr);

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public static void stergeAn(int nr){


        try{
            PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(Sterge_An, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, nr);

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }


    public static void actualizareMaterie(Materie materie, String MaterieNume) throws SQLException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = dbConnection.getDBConnection().prepareStatement(Actualizare_Materie, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(2, MaterieNume);
            preparedStatement.setInt(1, materie.getSemestru());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public static void actualizareStudent(int id, String StudentNume, String StudentAdresa, String StudentTelefon, int StudentAn) throws SQLException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = dbConnection.getDBConnection().prepareStatement(Actualizare_Student, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(5, id);
            preparedStatement.setString(1, StudentNume);
            preparedStatement.setString(2, StudentAdresa);
            preparedStatement.setString(3, StudentTelefon);
            preparedStatement.setInt(4, StudentAn);

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public static void actualizareNota(int idStudent, String NumeMaterie, int ValoareNota) throws SQLException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = dbConnection.getDBConnection().prepareStatement(Actualizare_Nota, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(2, idStudent);
            preparedStatement.setInt(1, ValoareNota);
            preparedStatement.setString(3, NumeMaterie);

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public static void actualizareAn(int An, int Serii) throws SQLException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = dbConnection.getDBConnection().prepareStatement(Actualizare_An, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(2, An);
            preparedStatement.setInt(1, Serii);

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
