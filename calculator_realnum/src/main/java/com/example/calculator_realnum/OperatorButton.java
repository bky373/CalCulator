package com.example.calculator_realnum;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.appcompat.widget.AppCompatImageButton;

public class OperatorButton extends AppCompatImageButton {

    int operatorButtonDefalut = R.drawable.operator_button_default;
    int operatorButtonClick = R.drawable.operator_button_click;

    public OperatorButton(Context context) {
        super(context);
        init();
    }

    public OperatorButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public OperatorButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();

    }

    private void init() {
        setBackgroundResource(operatorButtonDefalut);
        setPadding(70,70,70,70);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                setBackgroundResource(operatorButtonClick);
                setPadding(80,80,70,70);
                break;
            case MotionEvent.ACTION_UP:
                init();
                break;
        }
        return true;
    }
}
