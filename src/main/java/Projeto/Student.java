package Projeto;

import java.time.LocalDate;

public class Student {
    private String id;
    private String name;
    private String address;
    private LocalDate enrollmentDate;
    private int creditHours;

    public Student(String id, String name, String address, LocalDate enrollmentDate, int creditHours) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.enrollmentDate = enrollmentDate;
        this.creditHours = creditHours;
    }

    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return this.address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getEnrollmentDate() {
        return this.enrollmentDate;
    }
    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public int getCreditHours() {
        return this.creditHours;
    }
    public void setCreditHours(int creditHours) {
        this.creditHours = creditHours;
    }

    public void increaseCreditHours(int creditHours) {
        this.creditHours += creditHours;
    }
}
