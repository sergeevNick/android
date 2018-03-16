package ru.sergeev.gettingstarted.entities;


import java.util.Set;

public class Student {


    private Integer studentId;

    private Name name;


    private OtherInfo otherInfo;

    private Set<Mark> marks;

    private Class studentClass;

    public void setStudentClass(Class studentClass) {
        this.studentClass = studentClass;
    }

    public Set<Mark> getMarks() {
        return marks;
    }

    public void setMarks(Set<Mark> marks) {
        this.marks = marks;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public OtherInfo getOtherInfo() {
        return otherInfo;
    }

    public void setOtherInfo(OtherInfo otherInfo) {
        this.otherInfo = otherInfo;
    }

    public Student() {
    }

    public Student(Name name, OtherInfo otherInfo) {
        this.name = name;
        this.otherInfo = otherInfo;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }
}
