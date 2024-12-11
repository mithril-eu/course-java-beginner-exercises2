package eu.mithril.java.edu9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GradeAnalyzer {

    private ArrayList<Grade> grades;

    public GradeAnalyzer() {
        grades = new ArrayList<>();
    }


    public ArrayList<Grade> getGrades() {
        return grades;
    }

    public void addGrade(Grade grade) {
        grades.add(grade);
    }

    public double calculateAverageScore() {
        if (grades.isEmpty()) {
            return 0.0;
        }

        int sum = 0;
        for (Grade grade : grades) {
            sum += grade.getScore();
        }
        return (double) sum / grades.size();
    }

    public Map<String, Double> calculateAverageBySubject() {
        Map<String, Double> sumBySubject = new HashMap<>();
        Map<String, Integer> countBySubject = new HashMap<>();

        // Calculate sum and count for each subject
        for (Grade grade : grades) {
            String subject = grade.getSubject();

            // Update sum
            double currentSum = sumBySubject.getOrDefault(subject, 0.0);
            sumBySubject.put(subject, currentSum + grade.getScore());

            // Update count
            int currentCount = countBySubject.getOrDefault(subject, 0);
            countBySubject.put(subject, currentCount + 1);
        }

        // Calculate averages
        Map<String, Double> averages = new HashMap<>();
        for (String subject : sumBySubject.keySet()) {
            double sum = sumBySubject.get(subject);
            int count = countBySubject.get(subject);
            averages.put(subject, sum / count);
        }

        return averages;
    }

    public int findHighestScore() {
        if (grades.isEmpty()) {
            return 0;
        }


        int highest = grades.get(0).getScore();
        for (Grade grade : grades) {
            if (grade.getScore() > highest) {
                highest = grade.getScore();
            }
        }
        return highest;
    }

    public Map<String, List<Grade>> groupBySubject() {
        Map<String, List<Grade>> grouped = new HashMap<>();

        for (Grade grade : grades) {
            String subject = grade.getSubject();

            // Initialize list if not present
            if (!grouped.containsKey(subject)) {
                grouped.put(subject, new ArrayList<>());
            }

            // Add grade to the list
            grouped.get(subject).add(grade);
        }

        return grouped;
    }

    public Map<String, List<Grade>> groupByStudent() {
        Map<String, List<Grade>> grouped = new HashMap<>();

        for (Grade grade : grades) {
            String student = grade.getStudentName();

            // Initialize list if not present
            if (!grouped.containsKey(student)) {
                grouped.put(student, new ArrayList<>());
            }

            // Add grade to the list
            grouped.get(student).add(grade);
        }

        return grouped;
    }
}