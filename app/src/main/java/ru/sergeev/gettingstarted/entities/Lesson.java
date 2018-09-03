package ru.sergeev.gettingstarted.entities;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Lesson extends RealmObject {

    @PrimaryKey
    private Integer lessonId;

    private String startTime;

    private String endTime;

    public Lesson() {
    }

    public Lesson(Integer lessonId, String startTime, String endTime) {
        this.lessonId = lessonId;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public void setLessonId(Integer lessonId) {
        this.lessonId = lessonId;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Integer getLessonId() {

        return lessonId;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }
}
