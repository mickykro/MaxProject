package com.example.maxapp.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseBase<T> {

    @JsonProperty("DataObject")
    private DataListResponse mData;

    public ResponseBase() {
    }

    public DataListResponse getResponseData() {
        return mData;
    }

    public void setmData(DataListResponse mData) {
        this.mData = mData;
    }
}
