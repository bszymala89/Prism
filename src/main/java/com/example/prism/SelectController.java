package com.example.prism;

import com.example.prism.controllers.CalculateCircleVolumeController;
import com.example.prism.controllers.CalculateRectangleVolumeController;
import com.example.prism.controllers.CalculateSquareVolumeController;
import com.example.prism.controllers.CalculateTriangleVolumeController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class SelectController {
    public String chosenShape;
    public double height;
    private Button activeShapeButton = null;
    @FXML
    TextField heightField;
    @FXML
    Button squareBtn, triangleBtn, rectangleBtn, circleBtn;


    @FXML
    public void initialize() {
        squareBtn.setGraphic(createImageView("/com/example/prism/images/square.png"));
        triangleBtn.setGraphic(createImageView("/com/example/prism/images/triangle.png"));
        rectangleBtn.setGraphic(createImageView("/com/example/prism/images/rectangle.png"));
        circleBtn.setGraphic(createImageView("/com/example/prism/images/circle.png"));

        squareBtn.setOnAction(actionEvent -> selectShape("square", squareBtn));
        triangleBtn.setOnAction(actionEvent -> selectShape("triangle", triangleBtn));
        rectangleBtn.setOnAction(actionEvent -> selectShape("rectangle", rectangleBtn));
        circleBtn.setOnAction(actionEvent -> selectShape("circle", circleBtn));

        setButtonScaling(squareBtn);
    }

    private void setButtonScaling(Button button) {
        button.setMaxWidth(Double.MAX_VALUE);
        button.setMaxHeight(Double.MAX_VALUE);
    }

    private ImageView createImageView(String path) {
        try {
            Image image = new Image(getClass().getResourceAsStream(path));
            return new ImageView(image);
        } catch (NullPointerException e) {
            System.err.println("Error: Image not found " + path + " loading fallback image");
            return new ImageView(new Image(getClass().getResourceAsStream("/com/example/prism/images/fallback.png")));
        }
    }

    public void selectShape(String figure, Button selectedButton) {
        System.out.println("chosen figure = " + figure);
        chosenShape = figure;

        if (activeShapeButton != null) {
            resetButtonStyles(activeShapeButton);
        }

        activeShapeButton = selectedButton;

        selectedButton.setStyle("-fx-background-color: #00ff00");
    }

    private void resetButtonStyles(Button button) {
        button.setStyle("");
    }

    @FXML
    protected void onNextBtnClick() throws IOException {
        if (chosenShape.isEmpty()) {
            System.out.println("Shape not chosen");
            return;
        }

        if (heightField.getText().isEmpty() || Double.parseDouble(heightField.getText().replace(",", ".")) <= 0) {
            System.out.println("Invalid height. must be greater that 0");
            return;
        }

        height = Double.parseDouble(heightField.getText().replace(",", "."));
        String fxmlFile;

        Object controller;
        switch (chosenShape) {
            case "square":
                fxmlFile = "calculate-square-volume-view.fxml";
                controller = new CalculateSquareVolumeController(height);
                break;
            case "triangle":
                fxmlFile = "calculate-triangle-volume-view.fxml";
                controller = new CalculateTriangleVolumeController(height);
                break;
            case "rectangle":
                fxmlFile = "calculate-rectangle-volume-view.fxml";
                controller = new CalculateRectangleVolumeController(height);
                break;
            case "circle":
                fxmlFile = "calculate-circle-volume-view.fxml";
                controller = new CalculateCircleVolumeController(height);
                break;
            default:
                System.out.println("wrong shape");
                return;
        }

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlFile));
        fxmlLoader.setController(controller);
        Scene scene = new Scene(fxmlLoader.load(), 550, 450);

        Stage stage = new Stage();
        stage.setTitle("Hello!");
        stage.setScene(scene);

        stage.widthProperty().addListener((obs, oldValue, newValue) -> scene.getRoot().requestLayout());
        stage.heightProperty().addListener((obs, oldValue, newValue) -> scene.getRoot().requestLayout());

        stage.show();
    }
}
