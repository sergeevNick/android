package ru.sergeev.gettingstarted.classes;

import java.util.ArrayList;

/**
 * Created by serge on 16.02.2018.
 */

public class DayCard {

    private String dayName;
    private ArrayList<ScheduleRow> subjects;

    public DayCard() {
    }

    public DayCard(String dayName, ArrayList<ScheduleRow> subjects) {
        this.dayName = dayName;
        this.subjects = subjects;
    }

    public String getDayName() {
        return dayName;
    }

    public ArrayList<ScheduleRow> getSubjects() {
        return subjects;
    }

    public void setDayName(String dayName) {
        this.dayName = dayName;
    }

    public void setSubjects(ArrayList<ScheduleRow> subjects) {
        this.subjects = subjects;
    }
}
