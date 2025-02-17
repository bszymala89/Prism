package com.example.prism.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CalculateSquareVolumeController {
    @FXML
    private TextField sideField;
    @FXML
    private Label volumeLabel, baseAreaLabel, totalPrismAreaLabel;

    private double height;

    public CalculateSquareVolumeController(double height) {
        this.height = height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @FXML
    protected void Calculate() {
        if (sideField.getText().isEmpty() || Double.parseDouble(sideField.getText().replace(",", ".")) <= 0) {
            System.out.println("Invalid side value. must be greater than 0");
            return;
        }

        double side = Double.parseDouble(sideField.getText().replace(",", "."));
        double baseArea = side * side;
        double sideArea = side * height * 4;
        double totalPrismArea = baseArea * 2 + sideArea;
        double volume = baseArea * height;

        String volumeToDisplay = String.format("%.2f", volume);
        String baseAreaToDisplay = String.format("%.2f", baseArea);
        String totalPrismAreaToDisplay = String.format("%.2f", totalPrismArea);

        baseAreaLabel.setText("Base Area = " + side + " * " + side + " = " + baseAreaToDisplay + " cm² ");
        totalPrismAreaLabel.setText("Total Prism Area = " + side + " * " + side + " * 2 + " + side + " * " + height + " * 4 = " + totalPrismAreaToDisplay + " cm²");
        volumeLabel.setText("Volume = " + side + " * " + side + " * " + height + " = " + volumeToDisplay + " cm³");

        baseAreaLabel.setVisible(true);
        totalPrismAreaLabel.setVisible(true);
        volumeLabel.setVisible(true);
    }
}
