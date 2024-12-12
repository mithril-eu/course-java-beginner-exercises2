package eu.mithril.java.edu13;

import java.util.Arrays;
import java.util.List;

public class StreamMain {
    public static void main(String[] args) {

        List<Student> students = Arrays.asList(
                new Student("Ana", "Math", 4.5),
                new Student("Marko", "Math", 5.0),
                new Student("Ivan", "Physics", 4.8),
                new Student("Petra", "Math", 4.2),
                new Student("Luka", "Physics", 4.5),
                new Student("Mia", "Physics", 5.0)
        );

        StudentAnalyzer analyzer = new StudentAnalyzer(students);

        // Test your implementations here
        System.out.println("Average grade: " + String.format("%.2f", analyzer.getAverageGrade()));

        System.out.println("\nStudents above 4.5:");
        analyzer.getStudentsAboveGrade(4.5)
                .forEach(System.out::println);

        System.out.println("\nStudents by subject:");
        analyzer.groupBySubject()
                .forEach((subject, studentList) -> {
                    System.out.println(subject + ": " + studentList);
                });

        System.out.println("\nBest student: " + analyzer.getBestStudent());

        System.out.println("\nAverage grade by subject:");
        analyzer.getAverageGradeBySubject()
                .forEach((subject, average) ->
                        System.out.printf("%s: %.2f%n", subject, average));
    }
}

/*
 * Expected output:
 *
 * Average grade: 4.67
 *
 * Students above 4.5:
 * Marko: Math - 5.00
 * Ivan: Physics - 4.80
 * Mia: Physics - 5.00
 *
 * Students by subject:
 * Math: [Ana: Math - 4.50, Marko: Math - 5.00, Petra: Math - 4.20]
 * Physics: [Ivan: Physics - 4.80, Luka: Physics - 4.50, Mia: Physics - 5.00]
 *
 * Best student: Marko: Math - 5.00
 *
 * Average grade by subject:
 * Math: 4.57
 * Physics: 4.77
 */