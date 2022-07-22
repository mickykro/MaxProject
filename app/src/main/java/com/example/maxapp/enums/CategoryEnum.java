package com.example.maxapp.enums;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CategoryEnum {

    public static final int Category1 = 1;
    public static final int Category2 = 2;
    public static final int Category3 = 3;
    public static final int Category4 = 4;
    public static final int Category5 = 5;

    public CategoryEnum() {
    }
    public static String getNameByValue(int category){
        switch (category){
            case Category1:
                return "קטגוריה 1";
            case Category2:
                return "קטגוריה 2";
            case Category3:
                return "קטגוריה 3";
            case Category4:
                return "קטגוריה 4";
            case Category5:
                return "קטגוריה 5";
            default:
                return "";
        }
    }

    @IntDef({Category1, Category2, Category3, Category4, Category5})
    @Retention(RetentionPolicy.SOURCE)
    public @interface enAppDepositType {
    }
}
