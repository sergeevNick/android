package ru.sergeev.gettingstarted.entities;


import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Schedule extends RealmObject {

    @PrimaryKey
    private Integer scheduleId;

    private Class scheduleClass;

    private Day day;

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
