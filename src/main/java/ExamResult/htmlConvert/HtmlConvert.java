package ExamResult.htmlConvert;

import ExamResult.Student;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.util.JAXBSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ExamResult.Main.schemaPath;

public interface HtmlConvert {
    static List<String> saveToHtmlFile(HashMap<Student, Exams> map) throws SAXException, JAXBException, FileNotFoundException {
        JAXBContext contextObj = JAXBContext.newInstance(ResultForHtml.class);
        Marshaller marshallerObj = contextObj.createMarshaller();
        marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        List<String> records = new ArrayList<>();

        for (Map.Entry<Student, Exams> entry : map.entrySet()) {
            ResultForHtml temp = new ResultForHtml(entry.getKey(), entry.getValue());
            if (validateXcdSchema(contextObj, temp)) {
                String fileName = entry.getKey().getId() + ".html";
                marshallerObj.marshal(temp, new FileOutputStream(fileName));
                records.add(fileName);
            } else {
                System.err.println("The result does not matches the pattern");
            }
        }
        return records;
    }

    public static boolean validateXcdSchema(JAXBContext contextObj, ResultForHtml temp) throws SAXException, JAXBException, FileNotFoundException {

        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = schemaFactory.newSchema(new File(schemaPath));
        Validator validator = schema.newValidator();
        validator.setErrorHandler(new MyErrorHandler());
        JAXBSource source = new JAXBSource(contextObj, temp);
        try {
            validator.validate(source);
            System.out.println("The result matches the pattern");
        } catch (SAXException | IOException e) {
            e.getMessage();
        }
        return true;
    }
}
