package ru.sergeev.gettingstarted.classes;

/**
 * Created by serge on 18.02.2018.
 */

public class Mark {
    private int value;
    private String date;

    public Mark(int value, String date) {
        this.value = value;
        this.date = date;
    }

    public Mark() {
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getValue() {
        return value;
    }

    public String getDate() {
        return date;
    }
}
