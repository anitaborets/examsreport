package ExamResult;

import ExamResult.htmlConvert.Exams;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class ResultToMap {

    public static HashMap<Student, Exams> convertToMap(List<StudentResult> studentResultList) {
        HashMap<Student, Exams> resultMap = new HashMap();
        for (StudentResult studentResult : studentResultList) {
            if (!resultMap.containsKey(studentResult.getStudent())) {
                Exams list = new Exams();
                list.add(studentResult.getExamResult());
                resultMap.put(studentResult.getStudent(), list);
            } else {
                resultMap.forEach((key, value) -> value.add(studentResult.getExamResult()));
            }
        }
        return resultMap;
    }

    public static HashSet<Student> getStudents(List<StudentResult> studentResultList) {
        HashSet listOfStudents = new HashSet();
        for (StudentResult studentResult : studentResultList) {
            listOfStudents.add(studentResult.getStudent());
        }
        return listOfStudents;
    }
}
