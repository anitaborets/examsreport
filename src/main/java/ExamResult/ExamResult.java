package ExamResult;

import lombok.Builder;


import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapters;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;


@XmlRootElement
public class ExamResult implements Serializable {
    private static final long serialVersionUID = 1L;
    @XmlAttribute
    private String id;
    @XmlElement
    private String code;
    @XmlElement
    private String field;
    @XmlElement
    private int yearOfStudy;
    @XmlElement
    private String semester;
    @XmlElement
    private String academicYear;
    @XmlElement
    private String codeOfProgram;
    @XmlElement
    private String name;
    @XmlElement
    private String type;
    @XmlElement
    private String result;
    @XmlElement
    private LocalDate dateOfExam;
    @XmlElement
    private String teacher;
    @XmlElement
    private int grade;
    @XmlElement
    private int creditsReg;
    @XmlElement
    private int creditsObt;

    public ExamResult() {
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setField(String field) {
        this.field = field;
    }

    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public void setAcademicYear(String academicYear) {
        String regex = "^\\d{4}/\\d{4}$";
        if (academicYear.matches(regex))
            this.academicYear = academicYear;
        else {
            this.academicYear = null;
        }
    }

    public void setCodeOfProgram(String codeOfProgram) {
        this.codeOfProgram = codeOfProgram;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void setDateOfExam(LocalDate dateOfExam) {
        this.dateOfExam = dateOfExam;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void setCreditsReg(int creditsReg) {
        this.creditsReg = creditsReg;
    }

    public void setCreditsObt(int creditsObt) {
        this.creditsObt = creditsObt;
    }

    @Override
    public String toString() {
        return "ExamResult{" +
                "id='" + id + '\'' +
                ", code='" + code + '\'' +
                ", field='" + field + '\'' +
                ", yearOfStudy=" + yearOfStudy +
                ", semester='" + semester + '\'' +
                ", academicYear='" + academicYear + '\'' +
                ", codeOfProgram='" + codeOfProgram + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", result='" + result + '\'' +
                ", dateOfExam=" + dateOfExam +
                ", teacher='" + teacher + '\'' +
                ", grade=" + grade +
                ", creditsReg=" + creditsReg +
                ", creditsObt=" + creditsObt +
                '}';
    }
}
