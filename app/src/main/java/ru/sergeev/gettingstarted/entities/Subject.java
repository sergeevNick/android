package ru.sergeev.gettingstarted.entities;


import java.util.Set;

public class Subject {
    //done?

    private Integer subjectId;

    private String name;

    private Integer room;

    private Set<Mark> marks;

    private Set<ScheduleRow> rows;

    public void setRows(Set<ScheduleRow> rows) {
        this.rows = rows;
    }

    public Set<Mark> getMarks() {
        return marks;
    }

    public void setMarks(Set<Mark> marks) {
        this.marks = marks;
    }

    public Subject() {
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRoom() {
        return room;
    }

    public void setRoom(Integer room) {
        this.room = room;
    }
}
