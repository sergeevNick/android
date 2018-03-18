package ru.sergeev.gettingstarted.entities;


import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Student extends RealmObject {

    @PrimaryKey
    private Integer studentId;

    private Name name;


    private OtherInfo otherInfo;

    private Class studentClass;

    public void setStudentClass(Class studentClass) {
        this.studentClass = studentClass;
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
