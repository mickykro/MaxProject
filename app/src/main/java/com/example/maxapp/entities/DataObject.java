package com.example.maxapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class DataObject {

    @JsonProperty("CatId")
    private Integer mCatId;

    @JsonProperty("Title")
    private String mTitle;

    @JsonProperty("STitle")
    private String mSTitle;

    @JsonProperty("Imag")
    private String mImage;

    @JsonProperty("Id")
    private Integer mId;


    @JsonProperty("DataListAddr")
    private ArrayList<Address> mDataListAddr;

    @JsonIgnore
    public Integer getmCatId() {
        return mCatId;
    }

    @JsonIgnore
    public void setmCatId(Integer mCatId) {
        this.mCatId = mCatId;
    }

    @JsonIgnore
    public String getmTitle() {
        return mTitle;
    }

    @JsonIgnore
    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    @JsonIgnore
    public String getmSTitle() {
        return mSTitle;
    }

    @JsonIgnore
    public void setmSTitle(String mSTitle) {
        this.mSTitle = mSTitle;
    }

    @JsonIgnore
    public String getmImage() {
        return mImage;
    }

    @JsonIgnore
    public void setmImage(String mImage) {
        this.mImage = mImage;
    }

    @JsonIgnore
    public Integer getmId() {
        return mId;
    }

    @JsonIgnore
    public void setmId(Integer mId) {
        this.mId = mId;
    }

    @JsonIgnore
    public ArrayList<Address> getmDataListAddr() {
        return mDataListAddr;
    }

    @JsonIgnore
    public void setmDataListAddr(ArrayList<Address> mDataListAddr) {
        this.mDataListAddr = mDataListAddr;
    }
}
/**
 * {
 * "CatId": 1,
 * "Title": "טרקטורוני היער והגולן",
 * "STitle": "הנחות ליחיד",
 * "Imag": "https://mobile.leumi-card.co.il/ImgHandler/GetImage.ashx?origpath=/he-il/Benefits/BenefitsPlus/Atractions/PublishingImages/arnak/TractoroniHayaar/טרקטרוני_הגולן_big.jpg&format=webp&type=b",
 * "Id": 101069,
 * "DataListAddr": [
 * {
 * "Addr": "רמת נפתלי",
 * "DAd": "מושב רמת נפתלי"
 * }
 * ]
 * }
 */
