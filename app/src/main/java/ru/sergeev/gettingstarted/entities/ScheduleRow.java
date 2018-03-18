package ru.sergeev.gettingstarted.entities;


import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class ScheduleRow extends RealmObject {

    @PrimaryKey
    private Integer scheduleRowId;
    private Lesson lesson;
    private Teacher teacher;
    private Subject subject;
    private Schedule schedule;


    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
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

    public Integer getScheduleRowId() {
        return scheduleRowId;
    }

    public void setScheduleRowId(Integer scheduleRowId) {
        this.scheduleRowId = scheduleRowId;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
}
