package ru.sergeev.gettingstarted.entities;


import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Day extends RealmObject {

    @PrimaryKey
    private Integer dayId;

    private String dayName;

    public void setDayId(Integer dayId) {
        this.dayId = dayId;
    }

    public void setDayName(String dayName) {
        this.dayName = dayName;
    }

    public Integer getDayId() {
        return dayId;
    }

    public String getDayName() {
        return dayName;
    }

    public Day() {

    }
}
