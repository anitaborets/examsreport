package ExamResult.csvParser;

import ExamResult.Student;
import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class ParseInputCSV {

    public static List<Student> parseInput(String filePath) throws IOException {
        CsvToBean csv = new CsvToBean();
        CSVReader reader = new CSVReader(new FileReader(filePath));
        List<String[]> strings = reader.readAll();
        List list = csv.parse(setColumMapping(), reader);
        return list;
}
    private static ColumnPositionMappingStrategy setColumMapping(){
        ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
        strategy.setType(Student.class);
        String[] columns = new String[] {"id", "name", "surname"};
        strategy.setColumnMapping(columns);
        return strategy;
    }
}
