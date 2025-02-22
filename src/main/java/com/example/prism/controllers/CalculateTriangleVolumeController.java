package com.example.prism.controllers;

import com.example.prism.Utils.Alert;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CalculateTriangleVolumeController {
    @FXML
    private TextField sideField;
    @FXML
    private TextField baseHeightField;
    @FXML
    private Label volumeLabel, baseAreaLabel, totalPrismAreaLabel, triangleArmLabel;

    private double height;

    public CalculateTriangleVolumeController(double height) {
        this.height = height;
    }

    @FXML
    protected void Calculate() {
        if (sideField.getText().isEmpty() || Double.parseDouble(sideField.getText().replace(",", ".")) <= 0) {
            Alert.showAlert(javafx.scene.control.Alert.AlertType.WARNING, "Invalid side value. must be greater than 0");
            System.out.println("Invalid side value. must be greater than 0");
            return;
        }
        if (baseHeightField.getText().isEmpty() || Double.parseDouble(baseHeightField.getText().replace(",", ".")) <= 0) {
            Alert.showAlert(javafx.scene.control.Alert.AlertType.WARNING, "Invalid height value. must be greater than 0");
            System.out.println("Invalid height value. must be greater than 0");
            return;
        }

        double side = Double.parseDouble(sideField.getText().replace(",", "."));
        double baseHeight = Double.parseDouble(baseHeightField.getText().replace(",", "."));
        double baseArea = side * baseHeight / 2;

        double halfBase = side / 2;
        double triangleArm = Math.sqrt(Math.pow(halfBase, 2) + Math.pow(baseHeight, 2));
        double sideArea = side * height + triangleArm * height * 2;

        double totalPrismArea = baseArea * 2 + sideArea;

        double volume = baseArea * height;

        String volumeToDisplay = String.format("%.2f", volume);
        String baseAreaToDisplay = String.format("%.2f", baseArea);
        String totalPrismAreaToDisplay = String.format("%.2f", totalPrismArea);
        String triangleArmToDisplay = String.format("%.2f", triangleArm);

        baseAreaLabel.setText("Base Area = " + side + " * " + baseHeight + " / 2 = " + baseAreaToDisplay + " cm² ");
        totalPrismAreaLabel.setText("Total Prism Area = (" + side + " * " + baseHeight + " / 2) * 2 + " +
                triangleArmToDisplay + " * " + height + " * 2 + " + side + " * " + height + " = " + totalPrismAreaToDisplay + " cm²");
        volumeLabel.setText("Volume = " + side + " * " + baseHeight + " / 2 * " + height + " = " + volumeToDisplay + " cm³");
        triangleArmLabel.setText("Triangle Arm = √((" + side + "/ 2)² + " + baseHeight + "²) =" + triangleArmToDisplay + " cm");

        volumeLabel.setVisible(true);
        totalPrismAreaLabel.setVisible(true);
        baseAreaLabel.setVisible(true);
        triangleArmLabel.setVisible(true);
    }
}
