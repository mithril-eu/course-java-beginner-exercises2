package eu.mithril.java.edu13;

import java.util.List;
import java.util.Map;

public class StudentAnalyzer {

    private final List<Student> students;

    public StudentAnalyzer(List<Student> students) {
        this.students = students;
    }

    // TODO: Calculate average grade for all students
    public double getAverageGrade() {
        return 0.0;
    }

    // TODO: Find students with grade above threshold
    public List<Student> getStudentsAboveGrade(double threshold) {
        return null;
    }

    // TODO: Group students by subject
    public Map<String, List<Student>> groupBySubject() {
        return null;
    }

    // TODO: Find student with highest grade
    public Student getBestStudent() {
        return null;
    }

    // TODO: Get average grade by subject
    public Map<String, Double> getAverageGradeBySubject() {
        return null;
    }
}