package com.example.calculator_realnum;

import java.text.DecimalFormat;

public class Calculator_RealNum {

    final String CLEAR_INPUT_TEXT = "0";
    double resultNumber = 0;
    double lastInputNumber = 0;

    DecimalFormat decimalFormat = new DecimalFormat("###,###.#####");

    public String getDecimalString(String changeString) {
        String setChangeString = changeString.replace(",", "");
        return decimalFormat.format(Double.parseDouble(setChangeString));
    }

    public String getClearInputText(){
        return CLEAR_INPUT_TEXT;
    }
}
