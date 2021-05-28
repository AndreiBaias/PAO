package CatalogInformatica.Service;

import CatalogInformatica.Model.AnUniversitar;
import CatalogInformatica.Model.Examen;
import CatalogInformatica.Model.Materie;
import CatalogInformatica.Model.Semestru;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ReportGeneratorService {

    private static final String MateriiPath = "C:\\Users\\Jamaica\\Desktop\\Facultate\\An 2\\Sem 2\\PAO\\ProiectCatalogScolar\\src\\reports\\Materii";
    private static final String AniPath = "C:\\Users\\Jamaica\\Desktop\\Facultate\\An 2\\Sem 2\\PAO\\ProiectCatalogScolar\\src\\reports\\Ani";
    private static final String SemestrePath = "C:\\Users\\Jamaica\\Desktop\\Facultate\\An 2\\Sem 2\\PAO\\ProiectCatalogScolar\\src\\reports\\Semestre";
    private static final String ExamenePath = "C:\\Users\\Jamaica\\Desktop\\Facultate\\An 2\\Sem 2\\PAO\\ProiectCatalogScolar\\src\\reports\\Examene";
    private ReportGeneratorService(){}

    private static class  SINGLETON_HOLDER{
        private static final ReportGeneratorService INSTANCE = new ReportGeneratorService();
    }

    public static ReportGeneratorService getInstance() {
        return SINGLETON_HOLDER.INSTANCE;
    }

    /**
     * generating CarsOrderedByNameReport
     */

    public static void generateMateriiReport(List<Materie> materieList){
        StringBuilder reportContent = new StringBuilder();

        //build header report
        reportContent.append("Nume Materie");
        reportContent.append(",");
        reportContent.append("Semestru");
//        reportContent.append(",");
//        reportContent.append("ENGINE_CAPACITY");
//        reportContent.append(",");
//        reportContent.append("ENGINE_TYPE");
        reportContent.append("\n");

        materieList.forEach(materie -> {
            reportContent.append(materie.getNumeMaterie());
            reportContent.append(",");
            reportContent.append(materie.getSemestru());
//            reportContent.append(",");
//            reportContent.append(car.getEngine().getCapacity());
//            reportContent.append(",");
//            reportContent.append(car.getEngine().getEngineType());
            reportContent.append("\n");
        });

        String fileExtension = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String filePath = MateriiPath + fileExtension + ".csv";

        try {
            Files.createFile(Paths.get(filePath));
            Files.write(Paths.get(filePath), reportContent.toString().getBytes());
            System.out.println("Report was generated to : " + filePath);
        } catch (IOException exception) {
            exception.printStackTrace();
        }

    }

    public static void generateAniReport(List<AnUniversitar> anList){
        StringBuilder reportContent = new StringBuilder();

        //build header report
        reportContent.append("An");
        reportContent.append(",");
        reportContent.append("Numar serii");
//        reportContent.append(",");
//        reportContent.append("ENGINE_CAPACITY");
//        reportContent.append(",");
//        reportContent.append("ENGINE_TYPE");
        reportContent.append("\n");

        anList.forEach(an -> {
            reportContent.append(an.getAn());
            reportContent.append(",");
            reportContent.append(an.getNrSerii());
//            reportContent.append(",");
//            reportContent.append(car.getEngine().getCapacity());
//            reportContent.append(",");
//            reportContent.append(car.getEngine().getEngineType());
            reportContent.append("\n");
        });

        String fileExtension = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String filePath = AniPath + fileExtension + ".csv";

        try {
            Files.createFile(Paths.get(filePath));
            Files.write(Paths.get(filePath), reportContent.toString().getBytes());
            System.out.println("Report was generated to : " + filePath);
        } catch (IOException exception) {
            exception.printStackTrace();
        }

    }

    public static void generateSemestreReport(List<Semestru> semestruList){
        StringBuilder reportContent = new StringBuilder();

        //build header report
        reportContent.append("Numar semestru");
        reportContent.append(",");
        reportContent.append("Numar an");
//        reportContent.append(",");
//        reportContent.append("ENGINE_CAPACITY");
//        reportContent.append(",");
//        reportContent.append("ENGINE_TYPE");
        reportContent.append("\n");

        semestruList.forEach(sem -> {
            reportContent.append(sem.getNr());
            reportContent.append(",");
            reportContent.append(sem.getAn());
//            reportContent.append(",");
//            reportContent.append(car.getEngine().getCapacity());
//            reportContent.append(",");
//            reportContent.append(car.getEngine().getEngineType());
            reportContent.append("\n");
        });

        String fileExtension = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String filePath = SemestrePath + fileExtension + ".csv";

        try {
            Files.createFile(Paths.get(filePath));
            Files.write(Paths.get(filePath), reportContent.toString().getBytes());
            System.out.println("Report was generated to : " + filePath);
        } catch (IOException exception) {
            exception.printStackTrace();
        }

    }


    public static void generateExameneReport(List<Examen> examenList){
        StringBuilder reportContent = new StringBuilder();

        //build header report
        reportContent.append("Nume materie");
        reportContent.append(",");
        reportContent.append("Numar restantieri");
        reportContent.append(",");
        reportContent.append("Data examen");
//        reportContent.append(",");
//        reportContent.append("ENGINE_TYPE");
        reportContent.append("\n");

        examenList.forEach(exam -> {
            reportContent.append(exam.getNumeMaterie());
            reportContent.append(",");
            reportContent.append(exam.getRestantieri());
            reportContent.append(",");
            reportContent.append(exam.getData());
//            reportContent.append(",");
//            reportContent.append(exam.getSemestru());
            reportContent.append("\n");
        });

        String fileExtension = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String filePath = ExamenePath + fileExtension + ".csv";

        try {
            Files.createFile(Paths.get(filePath));
            Files.write(Paths.get(filePath), reportContent.toString().getBytes());
            System.out.println("Report was generated to : " + filePath);
        } catch (IOException exception) {
            exception.printStackTrace();
        }

    }

    public static FileWriter logWriter;


    public static void logAction(String actionName) throws IOException {

        File file = new File("C:\\Users\\Jamaica\\Desktop\\Facultate\\An 2\\Sem 2\\PAO\\ProiectCatalogScolar\\src\\reports\\actionLogCSV.csv");
        logWriter = new FileWriter(file,true);
        Date timestamp = new Date();
        String line = actionName+ "," + timestamp + "\n";
        try {
            logWriter.append(line);
            logWriter.flush();
        } catch (IOException e) {
            System.err.print("Unable to write to log file");
            e.printStackTrace();
        }
    }
}
