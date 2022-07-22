package com.example.maxapp.responses;

import com.example.maxapp.entities.DataCategory;
import com.example.maxapp.entities.DataObject;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class DataListResponse {

    @JsonProperty("DataListObject")
    private ArrayList<DataObject> mDataListObject;

    @JsonProperty("DataListCat")
    private ArrayList<DataCategory> mDataListCategory;

    public ArrayList<DataObject> getmDataListObject() {
        return mDataListObject;
    }

    public void setmDataListObject(ArrayList<DataObject> mDataListObject) {
        this.mDataListObject = mDataListObject;
    }

    public ArrayList<DataCategory> getmDataListCategory() {
        return mDataListCategory;
    }

    public void setmDataListCategory(ArrayList<DataCategory> mDataListCategory) {
        this.mDataListCategory = mDataListCategory;
    }
}
/**
 *{
 *   "DataObject": {
 *     "DataListObject": [
 *       {
 *         "CatId": 1,
 *         "Title": "טרקטורוני היער והגולן",
 *         "STitle": "הנחות ליחיד",
 *         "Imag": "https://mobile.leumi-card.co.il/ImgHandler/GetImage.ashx?origpath=/he-il/Benefits/BenefitsPlus/Atractions/PublishingImages/arnak/TractoroniHayaar/טרקטרוני_הגולן_big.jpg&format=webp&type=b",
 *         "Id": 101069,
 *         "DataListAddr": [
 *           {
 *             "Addr": "רמת נפתלי",
 *             "DAd": "מושב רמת נפתלי"
 *           }
 *         ]
 *       },
 *
 *     ]
 *
 *     ,"DataListCat": [
 *       {"CatId":1 ,"CTitle":"קטגוריה 1"},
 *       {"CatId":2 ,"CTitle":"קטגוריה 2"},
 *       {"CatId":3 ,"CTitle":"קטגוריה 3"},
 *       {"CatId":4 ,"CTitle":"קטגוריה 4"},
 *       {"CatId":5 ,"CTitle":"קטגוריה 5"}
 *     ]
 *   }
 * }
 */

