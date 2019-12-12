package com.example.calculator_realnum;

import java.text.DecimalFormat;

public class Calculator_RealNum {

    final String CLEAR_INPUT_TEXT = "0";
    double resultNumber = 0;
    double lastInputNumber = 0;
    String operator = "+";
    String expressionString = "";

    DecimalFormat decimalFormat = new DecimalFormat("###,###.#####");

    public String getDecimalString(String changeString) {
        String setChangeString = changeString.replace(",", "");
        return decimalFormat.format(Double.parseDouble(setChangeString));
    }

    public String getDecimalString(double changeNumber) {
        return decimalFormat.format(changeNumber);
    }

    public String getExpressionString() {
        return expressionString;
    }

    public String getClearInputText() {
        return CLEAR_INPUT_TEXT;
    }

    public void setAllClear() {
        resultNumber = 0;
        lastInputNumber = 0;
        operator = "+";
        expressionString = "";
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

    public String getResult(boolean isFirstInput, String getResultString, String lastOperator) {
        if (isFirstInput) {
            if (lastOperator.equals("=")) {
                resultNumber = calculate(resultNumber, lastInputNumber, operator);
                expressionString = "";
            } else {
                operator = lastOperator;
                if (expressionString.equals("")) {
                    expressionString = getResultString + " " + lastOperator;
                } else {
                    expressionString = expressionString.substring(0,expressionString.length()-1);
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
