package com.project.one1.carinventory;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ListingController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}