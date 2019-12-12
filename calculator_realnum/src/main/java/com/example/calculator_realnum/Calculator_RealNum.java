package com.example.calculator_realnum;

import java.text.DecimalFormat;

public class Calculator_RealNum {

    private final String CLEAR_INPUT_TEXT = "0";
    private double resultNumber = 0;
    private double lastInputNumber = 0;

    private String operator = "+";
    private String expressionString = "";

    private DecimalFormat decimalFormat = new DecimalFormat("###,###.#####");

    String getDecimalString(String changeString) {
        String setChangeString = changeString.replace(",", "");
        return decimalFormat.format(Double.parseDouble(setChangeString));
    }

    private String getDecimalString(double changeNumber) {
        return decimalFormat.format(changeNumber);
    }

    String getExpressionString() {
        return expressionString;
    }

    String getClearInputText() {
        return CLEAR_INPUT_TEXT;
    }

    void setAllClear() {
        resultNumber = 0;
        lastInputNumber = 0;
        operator = "+";
        expressionString = "";
    }

    private double calculate(double result, double lastNumber, String operator) {
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

    String getResult(boolean isFirstInput, String getResultString, String lastOperator) {
        if (isFirstInput) {
            if (lastOperator.equals("=")) {
                resultNumber = calculate(resultNumber, lastInputNumber, operator);
                expressionString = "";
            } else {
                operator = lastOperator;
                if (expressionString.equals("")) {
                    expressionString = getResultString + " " + lastOperator;
                } else {
                    expressionString = expressionString.substring(0, expressionString.length() - 1);
                    expressionString = expressionString + lastOperator;
                }
            }
        } else {
            lastInputNumber = Double.parseDouble(getResultString.replace(",", ""));
            resultNumber = calculate(resultNumber, lastInputNumber, operator);
            if (lastOperator.equals("=")) {
                expressionString = "";
            } else {
                expressionString = expressionString + " " + getResultString + " " + lastOperator;
                operator = lastOperator;
            }
        }
        return getDecimalString(resultNumber);
    }
}
