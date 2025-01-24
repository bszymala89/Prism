package com.example.prism.controllers;

import javafx.scene.control.TextField;

public class CalculateRectangleVolumeController {
    private TextField sideAField;
    private TextField sideBField;
    private double height;

    public CalculateRectangleVolumeController(double height) {
        this.height = height;
    }
}
