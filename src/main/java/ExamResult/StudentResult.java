package ExamResult;
import java.io.Serializable;

public class StudentResult implements Serializable {
    Student student;
    ExamResult examResult;

    public StudentResult() {
    }

    public StudentResult(Student student, ExamResult examResult) {
        this.student = student;
        this.examResult = examResult;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public ExamResult getExamResult() {
        return examResult;
    }

    public void setExamResult(ExamResult examResult) {
        this.examResult = examResult;
    }

    @Override
    public String toString() {
        return "StudentResult{" +
                "student=" + student +
                ", examResult=" + examResult +
                '}';
    }
}
