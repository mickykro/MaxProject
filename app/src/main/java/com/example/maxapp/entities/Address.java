package com.example.maxapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Address {

    @JsonProperty("Addr")
    private String mAddr;

    @JsonProperty("Dad")
    private String mDad;

    @JsonIgnore
    public String getmAddr() {
        return mAddr;
    }

    @JsonIgnore
    public void setmAddr(String mAddr) {
        this.mAddr = mAddr;
    }

    @JsonIgnore
    public String getmDad() {
        return mDad;
    }

    @JsonIgnore
    public void setmDad(String mDad) {
        this.mDad = mDad;
    }
}
/**
 * {
 * "Addr": "רמת נפתלי",
 * "DAd": "מושב רמת נפתלי"
 * }
 */
