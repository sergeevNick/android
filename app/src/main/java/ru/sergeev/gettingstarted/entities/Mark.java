package ru.sergeev.gettingstarted.entities;

import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Mark extends RealmObject {

    @PrimaryKey
    private Integer markId;
    private Integer value;
    private Date date;

    public void setMarkId(Integer markId) {
        this.markId = markId;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getMarkId() {

        return markId;
    }

    public Integer getValue() {
        return value;
    }

    public Date getDate() {
        return date;
    }

    public Mark() {

    }

    public Mark(Integer value) {
        this.value = value;
    }

    public Mark(Integer value, Date date) {
        this.value = value;
        this.date = date;
    }
}
