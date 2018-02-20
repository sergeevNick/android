package ru.sergeev.gettingstarted.classes;

import java.sql.Time;

/**
 * Created by serge on 16.02.2018.
 */

public class ScheduleRow {
    private int lessonNumber;
    private String subjectName;
    private String room;
    private String teacherName;
    private String startTime;
    private String endTime;

    public ScheduleRow() {
    }

    public ScheduleRow(int lessonNumber, String subjectName, String room, String teacherName, String startTime, String endTime) {
        this.lessonNumber = lessonNumber;
        this.subjectName = subjectName;
        this.room = room;
        this.teacherName = teacherName;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getLessonNumber() {
        return lessonNumber;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public String getRoom() {
        return room;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setLessonNumber(int lessonNumber) {
        this.lessonNumber = lessonNumber;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
