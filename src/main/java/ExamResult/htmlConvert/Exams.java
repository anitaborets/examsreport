package ExamResult.htmlConvert;

import ExamResult.ExamResult;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "record")
public class Exams {
    List<ExamResult> results;

    public List<ExamResult> getResults() {
        return results;
    }

    @XmlElement(name = "study")
    public void setResults(List<ExamResult> results) {
        this.results = results;
    }

    public void add(ExamResult result) {
        if (this.results == null) {
            this.results = new ArrayList<ExamResult>();
        }
        this.results.add(result);
    }
}
