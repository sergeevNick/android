package ru.sergeev.gettingstarted.entities;

import java.util.Set;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;


public class Class extends RealmObject{

    @PrimaryKey
    private Integer classId;


    private String number;

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getClassId() {

        return classId;
    }

    public String getNumber() {
        return number;
    }

    public Class() {    }

    public Class(String number) {
        this.number = number;
    }
}
