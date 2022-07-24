package com.example.maxapp.customViews;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class TabTextView extends androidx.appcompat.widget.AppCompatTextView {

    public TabTextView(Context context,String text){
        super(context);
        initTV(text);

    }

    public TabTextView(Context context) {
        super(context);
    }

    public TabTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TabTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void setTypeface(@Nullable Typeface tf) {
        super.setTypeface(tf);
    }

    private void initTV(String text){
        setTextSize(TypedValue.COMPLEX_UNIT_SP,10);
        setText(text);
    }
}
