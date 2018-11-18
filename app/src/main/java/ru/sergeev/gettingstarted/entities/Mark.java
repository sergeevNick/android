package ru.sergeev.gettingstarted.entities;

import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Mark extends RealmObject {

    @PrimaryKey
    private Integer markId;
    private Integer value;
    private Date date;
    private Subject subject;
    private User student;

    public void setMarkId(Integer markId) {
        this.markId = markId;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getMarkId() {

        return markId;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public void setStudent(User student) {
        this.student = student;
    }

    public Integer getValue() {
        return value;
    }

    public Date getDate() {
        return date;
    }

    public Subject getSubject() {
        return subject;
    }

    public User getStudent() {
        return student;
    }

    public Mark() {
    }

    public Mark(Integer value) {
        this.value = value;
    }

    public Mark(Integer value, Date date) {
        this.value = value;
        this.date = date;
    }
}
