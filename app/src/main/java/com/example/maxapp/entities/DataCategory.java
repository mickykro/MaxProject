package com.example.maxapp.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DataCategory {
    @JsonProperty("CatId")
    private Integer mCatId;

    @JsonProperty("CTitle")
    private String mCTitle;

    public Integer getmCatId() {
        return mCatId;
    }

    public void setmCatId(Integer mCatId) {
        this.mCatId = mCatId;
    }

    public String getmCTitle() {
        return mCTitle;
    }

    public void setmCTitle(String mCTitle) {
        this.mCTitle = mCTitle;
    }
}
/**
 * "CatId":1 ,"CTitle":"קטגוריה 1"
 */
