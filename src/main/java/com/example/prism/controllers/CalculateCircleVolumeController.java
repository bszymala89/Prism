package com.example.prism.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CalculateCircleVolumeController {
    @FXML
    private TextField radiusField;
    @FXML
    protected Label volumeLabel, baseAreaLabel;

    private double height;

    public CalculateCircleVolumeController(double height) {
        this.height = height;
    }

    @FXML
    protected void Calculate() {
        if (radiusField.getText().isEmpty() || Integer.parseInt(radiusField.getText()) <= 0) {
            System.out.println("Invalid side value. must be greater than 0");
            return;
        }

        double radius = Integer.parseInt(radiusField.getText());
        double baseArea = 3.14 * radius * 2;
        double volume = baseArea * height;
        String volumeToDisplay = String.format("%.2f", volume);
        String baseAreaToDisplay = String.format("%.2f", baseArea);

        baseAreaLabel.setText("Base Area = 3.14 * " + radius + "² = " + baseAreaToDisplay + "cm²");
        volumeLabel.setText("Volume = 3.14 * " + radius + "² = " + volumeToDisplay + " cm³");
        volumeLabel.setVisible(true);
        baseAreaLabel.setVisible(true);
    }
}
