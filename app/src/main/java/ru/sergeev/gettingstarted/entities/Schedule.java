package ru.sergeev.gettingstarted.entities;


import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Schedule extends RealmObject {

    @PrimaryKey
    private Integer scheduleId;

    private Day day;

 //   private Grade grade;

    private RealmList<ScheduleRow> rows;

    public RealmList<ScheduleRow> getRows() {
        return rows;
    }

    public void setRows(RealmList<ScheduleRow> rows) {
        this.rows = rows;
    }

    /*public void setGrade(Grade grade) {
        this.grade = grade;
    }*/

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
