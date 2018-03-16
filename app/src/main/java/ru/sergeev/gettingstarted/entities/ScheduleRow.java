package ru.sergeev.gettingstarted.entities;


public class ScheduleRow {


    private Integer scheduleRowId;

    private Schedule schedule;

    private Lesson lesson;

    private Teacher teacher;

    private Subject subject;

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

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public ScheduleRow() {
    }

    public Integer getScheduleRowId() {
        return scheduleRowId;
    }

    public void setScheduleRowId(Integer scheduleRowId) {
        this.scheduleRowId = scheduleRowId;
    }
}
