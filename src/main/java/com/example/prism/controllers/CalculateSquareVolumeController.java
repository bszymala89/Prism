package com.example.prism.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CalculateSquareVolumeController {
    @FXML
    private TextField sideField;
    @FXML
    private Label volumeLabel, baseAreaLabel;

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
        double baseArea = side * side;
        double volume = baseArea * height;
        String volumeToDisplay = String.format("%.2f", volume);
        String baseAreaToDisplay = String.format("%.2f", baseArea);

        baseAreaLabel.setText("Base Area = " + side + " * " + side + " = " + baseAreaToDisplay + "cm² ");
        volumeLabel.setText("Volume = " + side + " * " + side + " * " + height + " = " + volumeToDisplay + " cm³");
        volumeLabel.setVisible(true);
        baseAreaLabel.setVisible(true);
    }
}
