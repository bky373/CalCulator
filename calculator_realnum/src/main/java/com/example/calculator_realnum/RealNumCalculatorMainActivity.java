package com.example.calculator_realnum;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;

public class RealNumCalculatorMainActivity extends AppCompatActivity {

    ScrollView scrollView;
    TextView resultOperatorTextView;
    TextView resultTextView;

    ImageButton allClearButton;
    ImageButton clearEntryButton;
    ImageButton backspaceButton;
    ImageButton decimalButton;

    Button[] numberButton = new Button[10];
    ImageButton[] operatorButton = new ImageButton[4];



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_real_num_calculator_main);
        scrollView = findViewById(R.id.scroll_view);
        resultOperatorTextView = findViewById(R.id.result_operator_text_view);
        resultTextView = findViewById(R.id.result_text_view);

        allClearButton = findViewById(R.id.all_clear_button);
        clearEntryButton = findViewById(R.id.clear_entry_button);
        backspaceButton = findViewById(R.id.backspace_button);
        decimalButton = findViewById(R.id.decimal_button);

        for (int i = 0; i < 10; i++) {
            numberButton[i] = findViewById(R.id.num_button_0 + i);
        }
    }
}
