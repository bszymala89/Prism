package com.example.prism.controllers;

import javafx.scene.control.TextField;

public class CalculateTriangleVolumeController {
    private TextField sideField;
    private TextField baseHeightField;
    private double height;

    public CalculateTriangleVolumeController(double height) {
        this.height = height;
    }
}
