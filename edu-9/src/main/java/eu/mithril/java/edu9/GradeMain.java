package eu.mithril.java.edu9;

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

        // Expected functionality:
        // 1. Calculate and print overall average
        // 2. Calculate and print average by subject
        // 3. Find and print highest score
        // 4. Print all grades grouped by subject
        // 5. Print all grades grouped by student
    }
}
