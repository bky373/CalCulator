package com.example.calculator_realnum;

import java.text.DecimalFormat;

public class Calculator_RealNum {

    final String CLEAR_INPUT_TEXT = "0";
    double resultNumber = 0;
    double lastInputNumber = 0;
    String operator = "+";

    DecimalFormat decimalFormat = new DecimalFormat("###,###.#####");

    public String getDecimalString(String changeString) {
        String setChangeString = changeString.replace(",", "");
        return decimalFormat.format(Double.parseDouble(setChangeString));
    }

    public String getClearInputText() {
        return CLEAR_INPUT_TEXT;
    }

    public void setAllClear() {
        resultNumber = 0;
        lastInputNumber = 0;
        operator = "+";
    }

    public double calculate(double result, double lastNumber, String operator) {
        switch (operator) {
            case "+":
                result += lastNumber;
                break;
            case "-":
                result -= lastNumber;
                break;
            case "*":
                result *= lastNumber;
                break;
            case "/":
                result /= lastNumber;
                break;
        }
        return result;
    }
}
