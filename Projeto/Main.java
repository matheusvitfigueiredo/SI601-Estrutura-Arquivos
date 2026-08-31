package Projeto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();

        studentList.add(new Student("194774", "Matheus Figueiredo", "Rua A, 123", LocalDate.of(2006, 2, 23), 30));
        studentList.add(new Student("266864", "Maria Clara", "Rua B, 123", LocalDate.of(2005, 5, 27), 60));
        studentList.add(new Student("196220", "Nelson Neto", "Rua C, 123", LocalDate.of(2006, 7, 10), 15));

        List<CourseRegistration> courseList = new ArrayList<>();
        courseList.add(new CourseRegistration("ST601", "194774", 4, 8.5));
        courseList.add(new CourseRegistration("ST765", "194774", 6, 7.0));

        courseList.add(new CourseRegistration("ST601", "266864", 4, 9.2));
        courseList.add(new CourseRegistration("ST201", "266864", 4, 6.5));

        courseList.add(new CourseRegistration("ST601", "196220", 4, 10.0));
        courseList.add(new CourseRegistration("ST201", "196220", 4, 8.0));
    }
}
