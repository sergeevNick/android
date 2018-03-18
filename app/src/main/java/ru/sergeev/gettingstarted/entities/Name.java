package ru.sergeev.gettingstarted.entities;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Name extends RealmObject {
    @PrimaryKey
    private Integer nameId;

    private String firstName;

    private String secondName;

    private String lastName;


    public Name(String firstName, String secondName, String lastName) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
    }


    public Integer getNameId() {
        return nameId;
    }

    public void setNameId(Integer nameId) {
        this.nameId = nameId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Name() {

    }
}
