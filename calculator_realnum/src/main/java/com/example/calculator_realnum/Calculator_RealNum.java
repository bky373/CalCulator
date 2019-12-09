package com.example.calculator_realnum;

import java.text.DecimalFormat;

public class Calculator_RealNum {

    DecimalFormat decimalFormat = new DecimalFormat("###,###.#####");

    public String getDecimalFormat(String changeString) {
        String setChangeString = changeString.replace(",", "");
        return decimalFormat.format(Double.parseDouble(setChangeString));
    }
}
