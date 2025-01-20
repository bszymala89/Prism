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

    public void selectShape() {
        System.out.println("chosen figure.");
    }

    @FXML
    protected void onNextBtnClick() throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
}
