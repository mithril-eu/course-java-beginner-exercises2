package eu.mithril.java.edu9;

public class Grade {

    private String studentName;
    private String subject;
    private int score;

    public Grade(String studentName, String subject, int score) {
        this.studentName = studentName;
        this.subject = subject;
        this.score = score;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getSubject() {
        return subject;
    }

    public int getScore() {
        return score;
    }
}
