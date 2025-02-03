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
    private Label resultLabel;

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
        double area = side * baseHeight / 2;
        double volume = area * height;
        String volumeToDisplay = String.format("%.2f", volume);

        resultLabel.setText(side + " * " + baseHeight + " * " + height + " = " + volumeToDisplay + " cm³");
        resultLabel.setVisible(true);
    }
}
