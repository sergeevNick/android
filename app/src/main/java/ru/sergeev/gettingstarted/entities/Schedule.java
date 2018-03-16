package ru.sergeev.gettingstarted.entities;


import java.util.Set;

public class Schedule {

    private Integer scheduleId;

    private Class scheduleClass;

    private Day day;

    private Set<ScheduleRow> rows;

    public Set<ScheduleRow> getRows() {
        return rows;
    }

    public void setRows(Set<ScheduleRow> rows) {
        this.rows = rows;
    }

    public void setScheduleClass(Class scheduleClass) {
        this.scheduleClass = scheduleClass;
    }

    public Day getDay() {

        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public Schedule() {
    }

    public Integer getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Integer scheduleId) {
        this.scheduleId = scheduleId;
    }
}
