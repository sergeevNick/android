package ru.sergeev.gettingstarted.entities;


import java.util.Set;

public class Teacher {
    //done

    private Integer teacherId;

    private Name name;

    private OtherInfo otherInfo;

    private Set<ScheduleRow> rows;

    public void setRows(Set<ScheduleRow> rows) {
        this.rows = rows;
    }

    public Teacher(Name name, OtherInfo otherInfo) {
        this.name = name;
        this.otherInfo = otherInfo;
    }

    public Teacher() {
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

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }
}
