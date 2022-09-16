package ExamResult.csvParser;

import ExamResult.ExamResult;
import ExamResult.Student;
import ExamResult.StudentResult;
import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static ExamResult.Main.filePath;

public class ParseInputCSVtoArray {

    public static List<StudentResult> parseInput() throws IOException, ParseException {
        List<StudentResult> listOfStudentResults = new ArrayList();

        CSVReader reader = new CSVReader(new FileReader(filePath), ';');
        List<String[]> strings = reader.readAll();

        for (int i = 1; i < strings.size(); i++) {
            String[] array = strings.get(i);
            Student student = new Student();
            student.setId(array[0]);
            student.setName(array[1]);
            student.setSurname(array[2]);

            ExamResult examResult = new ExamResult();
            examResult.setId(array[3]);
            examResult.setCode(array[4]);
            examResult.setField(array[5]);
            examResult.setYearOfStudy(Integer.parseInt(array[6]));
            examResult.setSemester(array[7]);
            examResult.setAcademicYear(array[8]);
            examResult.setCodeOfProgram(array[9]);
            examResult.setName(array[10]);
            examResult.setType(array[11]);
            examResult.setResult(array[12]);
            examResult.setDateOfExam(LocalDate.parse(array[13], DateTimeFormatter.ofPattern("dd.MM.yyyy")));
            examResult.setTeacher(array[14]);

            StudentResult studentResult = new StudentResult(student, examResult);
            listOfStudentResults.add(studentResult);
        }

        return listOfStudentResults;
    }
}
