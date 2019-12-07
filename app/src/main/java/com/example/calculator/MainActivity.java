package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final String CLEAR_INPUT_TEXT = "0";

    boolean isFisrtInput = true; // 입력 값이 처음 입력되는가를 체크
    int resultNumber = 0; // 계산된 결과값을 저장하는 변수
    char operator = '+'; // 입력된 연산자를 저장하는 변수

    TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultText = findViewById(R.id.result_text);
    }

    // AC, CE, BS, . 을 클릭했을 때 실행되는 메소드
    public void buttonClick(View view) {
        switch (view.getId()) {
            case R.id.all_clear_button:
                resultNumber = 0;
                operator = '+';
                setClearText(CLEAR_INPUT_TEXT);
                break;
            case R.id.clear_entry_button:
                setClearText(CLEAR_INPUT_TEXT);
                break;

            case R.id.backspace_button:
                if (resultText.getText().toString().length() > 1) {
                    String getResultText = resultText.getText().toString();
                    String subString = getResultText.substring(0, getResultText.length() - 1);
                    resultText.setText(subString);
                } else {
                    setClearText(CLEAR_INPUT_TEXT);
                }
                break;

            case R.id.decimal_button:
                Log.e("buttonClick", "decimal_button 버튼이 클릭되었습니다.");

                break;
        }
    }

    // 입력된 숫자를 클리어해주는 메소드
    public void setClearText(String clearText) {
        isFisrtInput = true;
        resultText.setTextColor(0xFF666666);
        resultText.setText(clearText);
    }

    // 0 ~ 9 버튼 클릭했을 때 클릭되는 메소드
    public void numButtonClick(View view) {
        Button getButton = findViewById(view.getId());

        if (isFisrtInput) {
            resultText.setTextColor(0xFF000000);
            resultText.setText(getButton.getText().toString());
            isFisrtInput = false;
        } else {
            if (resultText.getText().toString().equals("0")) {
                Toast.makeText(getApplicationContext(), "0으로 시작하는 정수는 없습니다.", Toast.LENGTH_SHORT).show();
                setClearText(CLEAR_INPUT_TEXT);
                return;
            }
            resultText.append(getButton.getText().toString());
        }
    }

    // 연산자를 클릭했을 때 실행되는 메소드
    public void operatorClick(View view) {
        Button getButton = findViewById(view.getId());
        int lastNum = Integer.parseInt(resultText.getText().toString());

        if (view.getId() == R.id.result_button) {
            if (isFisrtInput) {
                resultNumber = 0;
                operator = '+';
                setClearText(CLEAR_INPUT_TEXT);
                // TODO: 2019.12.07 다음에 실수형 계산기 만들 때 윈도우 계산기처럼 =을 두 번 이상 누를 때 실행 방법과 같이 구현할 것!
            } else {
                resultNumber = intCal(resultNumber, lastNum, operator);
                resultText.setText(String.valueOf(resultNumber));
                isFisrtInput = true;
            }
        } else {
            if (isFisrtInput) {
                operator = getButton.getText().toString().charAt(0);
            } else {
                resultNumber = intCal(resultNumber, lastNum, operator);
                operator = getButton.getText().toString().charAt(0);
                resultText.setText(String.valueOf(resultNumber));
                isFisrtInput = true;
            }
        }

    }

    // 사칙연산을 이용해 값을 반환해주는 메소드
    public int intCal(int result, int lastNum, char operator) {
        if (operator == '+') {
            result += lastNum;
        } else if (operator == '-') {
            result -= lastNum;
        } else if (operator == '*') {
            result *= lastNum;
        } else if (operator == '/') {
            result /= lastNum;
        }
        return result;
    }
}
