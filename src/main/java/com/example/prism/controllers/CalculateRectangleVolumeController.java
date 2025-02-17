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
    private Label volumeLabel, baseAreaLabel, totalPrismAreaLabel;

    private double height;

    public CalculateRectangleVolumeController(double height) {
        this.height = height;
    }

    @FXML
    protected void Calculate() {
        if (sideAField.getText().isEmpty() || Double.parseDouble(sideAField.getText().replace(",", ".")) <= 0) {
            System.out.println("Invalid side value. must be greater than 0");
            return;
        }
        if (sideBField.getText().isEmpty() || Double.parseDouble(sideBField.getText().replace(",", ".")) <= 0) {
            System.out.println("Invalid side value. must be greater than 0");
            return;
        }

        double sideA = Double.parseDouble(sideAField.getText().replace(",", "."));
        double sideB = Double.parseDouble(sideBField.getText().replace(",", "."));

        double baseArea = sideA * sideB;
        double sideArea = sideA * height * 2 + sideB * height * 2;
        double totalPrismArea = baseArea * 2 + sideArea;

        double volume = baseArea * height;

        String volumeToDisplay = String.format("%.2f", volume);
        String baseAreaToDisplay = String.format("%.2f", baseArea);
        String totalPrismAreaToDisplay = String.format("%.2f", totalPrismArea);

        baseAreaLabel.setText("Base Area = " + sideA + " * " + sideB + " = " + baseAreaToDisplay + " cm² ");
        totalPrismAreaLabel.setText("Total Prism Area = " + sideA + " * " + sideB + " * 2 + " + sideA + " * " + height +
                " * 2 +" + sideB + " * " + height + " * 2 = " + totalPrismAreaToDisplay + " cm²");
        volumeLabel.setText("Volume = " + sideA + " * " + sideB + " * " + height + " = " + volumeToDisplay + " cm³");

        baseAreaLabel.setVisible(true);
        totalPrismAreaLabel.setVisible(true);
        volumeLabel.setVisible(true);
    }
}
