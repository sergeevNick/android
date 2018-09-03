package ru.sergeev.gettingstarted.entities;


import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class ScheduleRow extends RealmObject {

    @PrimaryKey
    private Integer scheduleRowId;
    private Lesson lesson;
    private User teacher;
    private Subject subject;

    //private Schedule schedule;


    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public User getTeacher() {
        return teacher;
    }

    public void setTeacher(User teacher) {
        this.teacher = teacher;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }


    public ScheduleRow() {
    }

    public ScheduleRow(Integer scheduleRowId, Lesson lesson, User teacher, Subject subject) {
        this.scheduleRowId = scheduleRowId;
        this.lesson = lesson;
        this.teacher = teacher;
        this.subject = subject;
    }

    public Integer getScheduleRowId() {
        return scheduleRowId;
    }

    public void setScheduleRowId(Integer scheduleRowId) {
        this.scheduleRowId = scheduleRowId;
    }
}
