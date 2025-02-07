package com.example.prism.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CalculateTriangleVolumeController {
    @FXML
    private TextField sideField;
    @FXML
    private TextField baseHeightField;
    @FXML
    private Label volumeLabel, baseAreaLabel;

    private double height;

    public CalculateTriangleVolumeController(double height) {
        this.height = height;
    }

    @FXML
    protected void Calculate() {
        if (sideField.getText().isEmpty() || Integer.parseInt(sideField.getText()) <= 0) {
            System.out.println("Invalid side value. must be greater than 0");
            return;
        }
        if (baseHeightField.getText().isEmpty() || Integer.parseInt(baseHeightField.getText()) <= 0) {
            System.out.println("Invalid height value. must be greater than 0");
            return;
        }

        double side = Integer.parseInt(sideField.getText());
        double baseHeight = Integer.parseInt(baseHeightField.getText());
        double baseArea = side * baseHeight / 2;
        double volume = baseArea * height;
        String volumeToDisplay = String.format("%.2f", volume);
        String baseAreaToDisplay = String.format("%.2f", baseArea);

        baseAreaLabel.setText("Base Area = " + side + " * " + baseHeight + " / 2 = " + baseAreaToDisplay + "cm² ");
        volumeLabel.setText("Volume = " + side + " * " + baseHeight + " / 2 * " + height + " = " + volumeToDisplay + " cm³");
        volumeLabel.setVisible(true);
        baseAreaLabel.setVisible(true);
    }
}
