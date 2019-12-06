package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    boolean isFisrtInput = true; // 입력 값이 처음 입력되는가를 체크
    int resultNumber = 0; // 계산된 결과값을 저장하는 변수
    char operator = '+'; // 입력된 연산자를 저장하는 변수

    TextView result_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
