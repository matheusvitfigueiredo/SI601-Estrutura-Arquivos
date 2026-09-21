package Projeto;

public class CourseRegistration {
    private String courseId;
    private String studentId;
    private int creditHours;
    private double grade;

    public CourseRegistration(String courseId, String studentId, int creditHours, double grade) {
        this.courseId = courseId;
        this.studentId = studentId;
        this.creditHours = creditHours;
        this.grade = grade;
    }

    public String getCourseId() {
        return this.courseId;
    }
    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getStudentId() {
        return this.studentId;
    }
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public int getCreditHours() {
        return this.creditHours;
    }
    public void setCreditHours(int creditHours) {
        this.creditHours = creditHours;
    }

    public double getGrade() {
        return this.grade;
    }
    public void setGrade(double grade) {
        this.grade = grade;
    }
}
