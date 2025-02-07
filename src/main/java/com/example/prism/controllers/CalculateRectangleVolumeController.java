package com.example.prism.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CalculateRectangleVolumeController {
    @FXML
    private TextField sideAField;
    @FXML
    private TextField sideBField;
    @FXML
    private Label volumeLabel, baseAreaLabel;

    private double height;

    public CalculateRectangleVolumeController(double height) {
        this.height = height;
    }

    @FXML
    protected void Calculate() {
        if (sideAField.getText().isEmpty() || Integer.parseInt(sideAField.getText()) <= 0) {
            System.out.println("Invalid side value. must be greater than 0");
            return;
        }
        if (sideBField.getText().isEmpty() || Integer.parseInt(sideBField.getText()) <= 0) {
            System.out.println("Invalid side value. must be greater than 0");
            return;
        }

        double sideA = Integer.parseInt(sideAField.getText());
        double sideB = Integer.parseInt(sideBField.getText());
        double baseArea = sideA * sideB;
        double volume = baseArea * height;
        String volumeToDisplay = String.format("%.2f", volume);
        String baseAreaToDisplay = String.format("%.2f", baseArea);

        baseAreaLabel.setText("Base Area = " + sideA + " * " + sideB + " = " + baseAreaToDisplay + "cm² ");
        volumeLabel.setText("Volume = " + sideA + " * " + sideB + " * " + height + " = " + volumeToDisplay + " cm³");
        volumeLabel.setVisible(true);
        baseAreaLabel.setVisible(true);
    }
}
