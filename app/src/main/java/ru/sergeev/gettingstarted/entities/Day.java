package ru.sergeev.gettingstarted.entities;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Day extends RealmObject {

    @PrimaryKey
    private Integer dayId;

    private String dayName;

    public Day() {

    }

    public Day(Integer dayId, String dayName) {
        this.dayId = dayId;
        this.dayName = dayName;
    }

    public Integer getDayId() {
        return dayId;
    }

    public void setDayId(Integer dayId) {
        this.dayId = dayId;
    }

    public String getDayName() {
        return dayName;
    }

    public void setDayName(String dayName) {
        this.dayName = dayName;
    }
}
