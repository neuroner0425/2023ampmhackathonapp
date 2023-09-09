package com.test.2023ampmhackathon;

import android.text.format.Time;

public class CurfewMateInfo {
    private String time;
    private String dormname;

    // 생성자
    public CurfewMateInfo() {
    }

    public CurfewMateInfo(String time, String dormName) {
        this.time = time;
        this.dormname = dormName;
    }

    public String getTime() {
        return time;
    }

    public String getDormname() {
        return dormname;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setDormName(String dormName) {
        this.dormname = dormName;
    }
}
