package com.example.loggingcalculator;

import java.util.ArrayList;
import java.util.List;

public class CalculatorSystem {
    private String currentExpression = "";
    private String num1 = "";
    private String operator = "";
    private String num2 = "";

    static List<String> logOfEvaluations = new ArrayList<>();

    public CalculatorSystem() {
    }

    public String getDisplayNumber() {
        System.out.println(this);
        if (num2.length() == 0) {
            return num1;
        } else {
            return num2;
        }
    }

    public void addIntegerInput(String intValue) {
        if (operator.length() == 0) {
            num1 += intValue;
        } else {
            num2 += intValue;
        }
        currentExpression += intValue;
    }

    public void addOperatorInput(String op) {
        if (num1.length() == 0)
            return;
        if (operator.length() != 0) {
            this.evaluate();
        }
        operator = op;
        currentExpression += op;
    }

    private boolean evaluate() {
        if (num1.length() == 0 || operator.length() == 0 || num2.length() == 0)
            return false;
        Double dub1 = Double.parseDouble(num1);
        Double dub2 = Double.parseDouble(num2);
        Double result;
        switch (operator) {
            case "+":
                result = dub1 + dub2;
                break;
            case "-":
                result = dub1 - dub2;
                break;
            case "*":
                result = dub1 * dub2;
                break;
            case "/":
                result = dub1 / dub2;
                break;
            default:
                result = dub1;
        }
        if (result % 1 != 0) {
            num1 = String.valueOf(result);
        } else {
            num1 = String.valueOf(result.intValue());
        }
        operator = "";
        num2 = "";
        return true;
    }

    public void reset() {
        currentExpression = "";
        operator = "";
        num1 = "";
        num2 = "";
    }

    public void undo() {
        System.out.println(this);
        currentExpression = currentExpression.substring(0,currentExpression.length()-2);
        System.out.println(this);
    }

    public String finalEvaluation() {
        currentExpression += "=";
        if (!evaluate())
            return null;
        String result = num1;
        logOfEvaluations.add(currentExpression + num1);
        this.reset();
        return result;
    }

    @Override
    public String toString() {
        return "CalculatorSystem{" +
                "currentExpression='" + currentExpression + '\'' +
                ", num1='" + num1 + '\'' +
                ", operator='" + operator + '\'' +
                ", num2='" + num2 + '\'' +
                '}';
    }
}
