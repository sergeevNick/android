package ru.sergeev.gettingstarted.entities;

import io.realm.RealmObject;
import io.realm.RealmResults;
import io.realm.annotations.LinkingObjects;
import io.realm.annotations.PrimaryKey;

public class Subject extends RealmObject {
    @PrimaryKey
    private Integer subjectId;
    private String name;
    private Integer room;

    @LinkingObjects("subject")
    private final RealmResults<Mark> marks = null;

    public Subject() {
    }

    public Subject(Integer subjectId, String name, Integer room) {
        this.subjectId = subjectId;
        this.name = name;
        this.room = room;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRoom() {
        return room;
    }

    public void setRoom(Integer room) {
        this.room = room;
    }
}
