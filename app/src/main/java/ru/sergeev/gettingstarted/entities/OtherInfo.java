package ru.sergeev.gettingstarted.entities;

import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class OtherInfo extends RealmObject {

    @PrimaryKey
    private Integer infoId;

    private String email;

    private String address;

    private Date birthDate;

    public OtherInfo(String email, String address, Date birthDate) {
        this.email = email;
        this.address = address;
        this.birthDate = birthDate;
    }

    public Integer getInfoId() {
        return infoId;
    }

    public void setInfoId(Integer infoId) {
        this.infoId = infoId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public OtherInfo() {

    }
}
