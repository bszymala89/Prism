package com.example.prism.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CalculateCircleVolumeController {
    @FXML
    private TextField radiusField;
    @FXML
    protected Label resultLabel;

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
        double area = 3.14 * radius * 2;
        double volume = area * height;
        String volumeToDisplay = String.format("%.2f", volume);

        resultLabel.setText("3.14 * " + radius + " * 2 = " + volumeToDisplay + " cm³");
        resultLabel.setVisible(true);
    }
}
