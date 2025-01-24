package com.example.prism.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CalculateSquareVolumeController {
    @FXML
    private TextField sideField;
    @FXML
    private Label resultLabel;

    private double height;

    public CalculateSquareVolumeController(double height) {
        this.height = height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @FXML
    protected void Calculate() {
        if (sideField.getText().isEmpty() || Integer.parseInt(sideField.getText()) <= 0) {
            System.out.println("Invalid side value. must be greater than 0");
            return;
        }

        double side = Integer.parseInt(sideField.getText());
        double area = side * side;
        double volume = area * height;

        resultLabel.setText(side + " * " + side + " * " + height + " = " + volume);
        resultLabel.setVisible(true);
    }
}
