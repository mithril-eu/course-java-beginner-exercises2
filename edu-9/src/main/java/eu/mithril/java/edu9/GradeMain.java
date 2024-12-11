package eu.mithril.java.edu9;

import java.util.List;
import java.util.Map;

public class GradeMain {
    public static void main(String[] args) {
        GradeAnalyzer analyzer = new GradeAnalyzer();

        // Add test data
        analyzer.getGrades().add(new Grade("Ana", "Matematika", 85));
        analyzer.getGrades().add(new Grade("Ana", "Fizika", 92));
        analyzer.getGrades().add(new Grade("Marko", "Matematika", 77));
        analyzer.getGrades().add(new Grade("Marko", "Fizika", 82));
        analyzer.getGrades().add(new Grade("Ivan", "Matematika", 95));
        analyzer.getGrades().add(new Grade("Ivan", "Fizika", 88));


        // Overall statistics
        System.out.println("Overall Statistics:");
        System.out.printf("Average Score: %.1f%n", analyzer.calculateAverageScore());
        System.out.printf("Highest Score: %d%n", analyzer.findHighestScore());

        // Average by subject
        System.out.println("\nAverage by Subject:");
        Map<String, Double> subjectAverages = analyzer.calculateAverageBySubject();
        for (String subject : subjectAverages.keySet()) {
            double average = subjectAverages.get(subject);
            System.out.printf("%s: %.1f%n", subject, average);
        }

        // Grades by subject
        System.out.println("\nGrades by Subject:");
        Map<String, List<Grade>> bySubject = analyzer.groupBySubject();
        for (String subject : bySubject.keySet()) {
            System.out.println(subject + ":");
            List<Grade> subjectGrades = bySubject.get(subject);
            for (Grade grade : subjectGrades) {
                System.out.printf("- %s: %d%n",
                        grade.getStudentName(), grade.getScore());
            }
            System.out.println();
        }

        // Grades by student
        System.out.println("Grades by Student:");
        Map<String, List<Grade>> byStudent = analyzer.groupByStudent();
        for (String student : byStudent.keySet()) {
            System.out.println(student + ":");
            List<Grade> studentGrades = byStudent.get(student);
            for (Grade grade : studentGrades) {
                System.out.printf("- %s: %d%n",
                        grade.getSubject(), grade.getScore());
            }
            System.out.println();
        }
    }
}
