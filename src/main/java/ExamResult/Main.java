package ExamResult;

import ExamResult.csvParser.ParseInputCSVtoArray;
import ExamResult.htmlConvert.Exams;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;

import static ExamResult.ResultToMap.convertToMap;
import static ExamResult.htmlConvert.HtmlConvert.saveToHtmlFile;
import static ExamResult.zipConverter.saveToZIP;

public class Main {
    public static String filePath = "src/input.csv";
    public static String schemaPath = "src/record.xsd";
    public static String zipPath = "src/record.zip";

    public static void main(String[] args) throws IOException, ParseException, JAXBException, SAXException {
        //ParseInputCSV.parseInput(filePath);
        List<StudentResult> studentResultList = ParseInputCSVtoArray.parseInput();
        HashMap<Student, Exams> map = convertToMap(studentResultList);
        List<String> pathesHtmlFiles = saveToHtmlFile(map);
        saveToZIP(pathesHtmlFiles);
    }
}

