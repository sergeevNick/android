package ru.sergeev.gettingstarted.entities;

import java.util.Date;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by serge on 14.04.2018.
 */

public class User extends RealmObject {

    @PrimaryKey
    private Integer userId;
    private String login;
    private String role;
    private String hash;
    private String firstName;
    private String secondName;
    private String lastName;
    private String email;
    private String address;
    private Date birthDate;
    //  private Grade grade;


    public User() {
    }

    public User(Integer userId, String login, String role, String hash, String firstName, String secondName, String lastName, String email, String address, Date birthDate) {
        this.userId = userId;
        this.login = login;
        this.role = role;
        this.hash = hash;
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.birthDate = birthDate;
    }

    public Integer getUserId() {
        return userId;
    }

   /* public void setGrade(Grade grade) {
        this.grade = grade;
    }*/

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
}
