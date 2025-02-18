package com.example.prism.controllers;

import com.example.prism.Utils.Alert;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CalculateCircleVolumeController {
    @FXML
    private TextField radiusField;
    @FXML
    protected Label volumeLabel, baseAreaLabel, totalPrismAreaLabel;

    private double height;

    public CalculateCircleVolumeController(double height) {
        this.height = height;
    }

    @FXML
    protected void Calculate() {
        if (radiusField.getText().isEmpty() || Double.parseDouble(radiusField.getText().replace(",", ".")) <= 0) {
            Alert.showAlert(javafx.scene.control.Alert.AlertType.WARNING, "Invalid radius value. must be greater than 0");
            return;
        }


        double radius = Double.parseDouble(radiusField.getText().replace(",", "."));

        double baseArea = 3.14 * radius * radius;
        double sideArea = 3.14 * radius * 2;
        double totalPrismArea = sideArea * height;

        double volume = baseArea * height;

        String volumeToDisplay = String.format("%.2f", volume);
        String baseAreaToDisplay = String.format("%.2f", baseArea);
        String totalPrismAreaToDisplay = String.format("%.2f", totalPrismArea);

        baseAreaLabel.setText("Base Area = 3.14 * " + radius + "² = " + baseAreaToDisplay + " cm²");
        volumeLabel.setText("Volume = 3.14 * " + radius + "² * " + height + " = " + volumeToDisplay + " cm³");
        totalPrismAreaLabel.setText("Total Prism Area = 3.14 * " + radius + " * 2 *" + height + " = " + totalPrismAreaToDisplay + " cm²");

        baseAreaLabel.setVisible(true);
        totalPrismAreaLabel.setVisible(true);
        volumeLabel.setVisible(true);
    }
}
