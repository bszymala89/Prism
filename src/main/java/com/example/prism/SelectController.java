package com.example.prism;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class SelectController {
    public String chosenShape;
    @FXML
    TextField heightField;

    @FXML
    Button squareBtn;
    @FXML
    Button triangleBtn;
    @FXML
    Button rectangleBtn;
    @FXML
    Button circleBtn;


    @FXML
    public void initialize() {
        squareBtn.setGraphic(createImageView("/com/example/prism/images/square.png"));
        triangleBtn.setGraphic(createImageView("/com/example/prism/images/triangle.png"));
        rectangleBtn.setGraphic(createImageView("/com/example/prism/images/rectangle.png"));
        circleBtn.setGraphic(createImageView("/com/example/prism/images/circle.png"));

        squareBtn.setOnAction(actionEvent -> selectShape("square"));
        triangleBtn.setOnAction(actionEvent -> selectShape("triangle"));
        rectangleBtn.setOnAction(actionEvent -> selectShape("rectangle"));
        circleBtn.setOnAction(actionEvent -> selectShape("circle"));
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

    public void selectShape(String figure) {
        System.out.println("chosen figure = " + figure);
        chosenShape = figure;
    }

    @FXML
    protected void onNextBtnClick() throws IOException {
        if (chosenShape.isEmpty()) {
            System.out.println("Shape not chosen");
            return;
        }

        String fxmlFile;

        switch (chosenShape) {
            case "square":
                fxmlFile = "calculate-square-volume-view.fxml";
                break;
            case "triangle":
                fxmlFile = "calculate-triangle-volume-view.fxml";
                break;
            case "rectangle":
                fxmlFile = "calculate-rectangle-volume-view.fxml";
                break;
            case "circle":
                fxmlFile = "calculate-circle-volume-view.fxml";
                break;
            default:
                System.out.println("wrong shape");
                return;
        }


        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxmlFile));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        Stage stage = new Stage();
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
}
