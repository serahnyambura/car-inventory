package com.project.one1.carinventory;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Objects;

public class Listing extends Application {

    public static void main(String[] args) {
        launch();
    }

    private DealershipInventory dealershipInventory = new DealershipInventory();

    @Override
    public void start(Stage primaryStage) {
        // Creating sample cars and adding them to the inventory
        Car car1 = new Car(2024, "Toyota", "Camry", "ABC123", 5000, 25000, true, "/files/car1.jpeg");
        Car car2 = new Car(2021, "Honda", "Accord", "DEF456", 7000, 27000, false, "/files/car2.jpeg");
        Car car3 = new Car(2023, "Ford", "Mustang", "GHI789", 3000, 35000, true, "/files/car3.jpeg");
        Car car4 = new Car(2020, "Chevrolet", "Cruze", "JKL012", 8000, 20000, false, "/files/car4.jpeg");

        dealershipInventory.addCar(car1);
        dealershipInventory.addCar(car2);
        dealershipInventory.addCar(car3);
        dealershipInventory.addCar(car4);

        //JavaFX GUI Components
        ComboBox<Car> carComboBox = new ComboBox<>(FXCollections.observableArrayList(dealershipInventory.getInventory()));

        Label inventryLabel = new Label("Current inventory count: " + dealershipInventory.getTotalInventoryCount());

        Button viewDetailsButton = new Button("View Details");

        //Event Handler for "View Details" button
        viewDetailsButton.setOnAction(event -> {
            Car selectedCar = carComboBox.getValue();
            if (selectedCar != null) {
                displayCarDetails(selectedCar);
            }
        });

        // Layout for the main window
        VBox root = new VBox(10);
        root.setPadding(new Insets(10));
        root.getChildren().addAll(carComboBox, inventryLabel, viewDetailsButton);

        //Scene setup
        Scene scene = new Scene(root,600, 500);
        primaryStage.setTitle("Car Listing System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Method to display detailed information about the selected car
    private void displayCarDetails(Car car) {
        // Create a new window for displaying details
        Stage detailsStage = new Stage();
        detailsStage.setTitle("Car Details");

        // Labels for displaying car details
        Label yearLabel = new Label("Year: " + car.getYear());
        Label makeLabel = new Label("Make: " + car.getMake());
        Label modelLabel = new Label("Model: " + car.getModel());
        Label vinLabel = new Label("VIN: " + car.getVin());
        Label mileageLabel = new Label("Mileage: " + car.getMileage());
        Label costLabel = new Label("Cost: " + car.getCost());
        Label cleanRecordLabel = new Label("Clean Record: " + (car.isCleanRecord() ? "Yes" : "No"));

        // Create an ImageView for displaying the car image
//        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(imageUrl)));
//        ImageView imageView = new ImageView(image);
        ImageView imageView = new ImageView();
        imageView.setFitWidth(200);
        imageView.setPreserveRatio(true);

        // Load the image from the URL or path
        try {
            Image image = new Image(Objects.requireNonNull(getClass().getResource(car.getImageUrl())).toExternalForm());
            imageView.setImage(image);
        } catch (Exception e) {
            // Handle image loading error (display a placeholder image or show a message)
//            e.printStackTrace();
            System.out.println("Error loading car image: " + e.getMessage());
        }

        // Layout for the details window including the image
        VBox detailsLayout = new VBox(10);
        detailsLayout.setPadding(new Insets(10));
        detailsLayout.getChildren().addAll(imageView, yearLabel, makeLabel, modelLabel, vinLabel, mileageLabel, costLabel, cleanRecordLabel);

        // Set scene and show the details window
        Scene detailsScene = new Scene(detailsLayout, 800, 700);
        detailsStage.setScene(detailsScene);
        detailsStage.show();
    }

}