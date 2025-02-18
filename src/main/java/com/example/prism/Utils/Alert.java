package com.example.prism.Utils;

public class Alert {
    public static void showAlert(javafx.scene.control.Alert.AlertType alertType, String alertMessage) {
        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(alertType);
        alert.setContentText(alertMessage);
        alert.show();
    }
}
