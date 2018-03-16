package ru.sergeev.gettingstarted.entities;

import java.sql.Time;
import java.util.Set;

public class Lesson {



    private Integer lessonId;

    private Time startTime;

    private Time endTime;

    private Set<ScheduleRow> rows;

    public void setRows(Set<ScheduleRow> rows) {
        this.rows = rows;
    }

    public Lesson() {
    }

    public void setLessonId(Integer lessonId) {
        this.lessonId = lessonId;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public Integer getLessonId() {

        return lessonId;
    }

    public Time getStartTime() {
        return startTime;
    }

    public Time getEndTime() {
        return endTime;
    }
}
