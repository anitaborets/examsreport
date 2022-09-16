package ExamResult.htmlConvert;

import ExamResult.Student;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "record")
public class ResultForHtml {
    @XmlElement
    Student student;
    @XmlElement
    Exams exams;

    public ResultForHtml(Student student, Exams exams) {
        this.student = student;
        this.exams = exams;
    }

    public ResultForHtml() {
    }
}
