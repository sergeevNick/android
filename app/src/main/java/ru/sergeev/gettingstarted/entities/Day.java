package ru.sergeev.gettingstarted.entities;

import java.util.Set;

public class Day {


    private Integer dayId;

    private String dayName;

    private Set<Schedule> schedules;

    public void setSchedules(Set<Schedule> schedules) {
        this.schedules = schedules;
    }

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
