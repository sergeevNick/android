package ru.sergeev.gettingstarted.entities;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;


public class Grade extends RealmObject {

    @PrimaryKey
    private Integer gradeId;
    private String number;

    public void setGradeId(Integer gradeId) {
        this.gradeId = gradeId;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getGradeId() {

        return gradeId;
    }

    public String getNumber() {
        return number;
    }

    public Grade() {
    }

    public Grade(Integer gradeId, String number) {
        this.gradeId = gradeId;
        this.number = number;
    }

    public Grade(String number) {
        this.number = number;
    }
}
