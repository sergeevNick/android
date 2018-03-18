package ru.sergeev.gettingstarted.entities;



import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Teacher extends RealmObject {

    @PrimaryKey
    private Integer teacherId;

    private Name name;

    private OtherInfo otherInfo;

    public Teacher(Name name, OtherInfo otherInfo) {
        this.name = name;
        this.otherInfo = otherInfo;
    }

    public Teacher() {
    }

    public Name getName() {
        return name;
    }

    public OtherInfo getOtherInfo() {
        return otherInfo;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }
}
