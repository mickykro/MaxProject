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

    @IntDef({Category1, Category2, Category3, Category4, Category5})
    @Retention(RetentionPolicy.SOURCE)
    public @interface enAppDepositType {
    }
}
