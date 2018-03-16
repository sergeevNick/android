package ru.sergeev.gettingstarted.entities;

import java.sql.Date;

public class OtherInfo {

    private Integer infoId;

    private String email;

    private String address;

    private Date birthDate;

    private Student student;

    private Teacher teacher;

    public OtherInfo(String email, String address, Date birthDate) {
        this.email = email;
        this.address = address;
        this.birthDate = birthDate;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Integer getInfoId() {
        return infoId;
    }

    public void setInfoId(Integer infoId) {
        this.infoId = infoId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public OtherInfo() {

    }
}
