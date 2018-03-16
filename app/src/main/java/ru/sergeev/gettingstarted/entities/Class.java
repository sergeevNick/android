package ru.sergeev.gettingstarted.entities;

import java.util.Set;

public class Class {

    private Integer classId;


    private String number;

    private Set<Student> students;


    private Set<Schedule> schedules;


    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public Set<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(Set<Schedule> schedules) {
        this.schedules = schedules;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getClassId() {

        return classId;
    }

    public String getNumber() {
        return number;
    }

    public Class() {    }

    public Class(String number) {
        this.number = number;
    }
}
