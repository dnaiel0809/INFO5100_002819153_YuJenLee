package com.example.exercises9;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private Label result;
    @FXML
    private Button time;
    @FXML
    private Button min;
    @FXML
    private Button divide;
    @FXML
    private Button plus;
    @FXML
    private TextField pre;
    @FXML
    private TextField fix;

    @FXML
    private Button clear;


    @FXML
    protected void onButtonDivide() {
        if (isNumeric(pre.getText()) && isNumeric(fix.getText()))
            result.setText(String.valueOf(Float.parseFloat(pre.getText())/Float.parseFloat(fix.getText())));
        else
            result.setText("Please input number");

    }
    @FXML
    protected void onButtonTime() {
        if (isNumeric(pre.getText()) && isNumeric(fix.getText()))
            result.setText(String.valueOf(Float.parseFloat(pre.getText())*Float.parseFloat(fix.getText())));
        else
            result.setText("Please input number");

    }

    @FXML
    protected void onButtonMin() {
        if (isNumeric(pre.getText()) && isNumeric(fix.getText()))
            result.setText(String.valueOf(Float.parseFloat(pre.getText())-Float.parseFloat(fix.getText())));
        else
            result.setText("Please input number");

    }

    @FXML
    protected void onButtonPlus() {
        if (isNumeric(pre.getText()) && isNumeric(fix.getText()))
            result.setText(String.valueOf(Float.parseFloat(pre.getText())+Float.parseFloat(fix.getText())));
        else
            result.setText("Please input number");

    }

    @FXML
    protected void onButtonClear() {
        result.setText("");
        pre.setText("");
        fix.setText("");

    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}