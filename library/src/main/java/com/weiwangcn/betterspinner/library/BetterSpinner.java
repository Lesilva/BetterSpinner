package com.weiwangcn.betterspinner.library;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;

import java.util.Calendar;

/**
 * Created by Wei on 2015/3/23.
 */
public class BetterSpinner extends AutoCompleteTextView {

    private static final int MAX_CLICK_DURATION = 200;
    private long startClickTime;

    public BetterSpinner(Context context) {
        super(context);
    }

    public BetterSpinner(Context arg0, AttributeSet arg1) {
        super(arg0, arg1);
    }

    public BetterSpinner(Context arg0, AttributeSet arg1, int arg2) {
        super(arg0, arg1, arg2);
    }

    @Override
    public boolean enoughToFilter() {
        return true;
    }

    @Override
    protected void onFocusChanged(boolean focused, int direction,
                                  Rect previouslyFocusedRect) {
        super.onFocusChanged(focused, direction, previouslyFocusedRect);
        if (focused) {
            InputMethodManager imm = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getWindowToken(), 0);
            setKeyListener(null);
        }
    }

    @Override
    public void setOnClickListener(OnClickListener listener) {
        super.setOnClickListener(listener);
        performFiltering("", 0); //show everything in the list
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                startClickTime = Calendar.getInstance().getTimeInMillis();
                break;
            }
            case MotionEvent.ACTION_UP: {
                long clickDuration = Calendar.getInstance().getTimeInMillis() - startClickTime;
                if (clickDuration < MAX_CLICK_DURATION) {
                    requestFocus();
                    showDropDown();
                }
            }
        }

        return super.onTouchEvent(event);
    }

}
