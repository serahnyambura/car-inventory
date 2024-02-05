package com.project.one1.carinventory;

import java.util.ArrayList;
import java.util.List;

public class DealershipInventory {
    private List<Car> inventory; // List to store car objects

    // Constructor to initialize the inventory as an empty list
    public DealershipInventory() {
        this.inventory = new ArrayList<Car>();
    }

    //method to add a car to the inventory
    public void addCar(Car car) {
        inventory.add(car);
    }

    //method to report the total number of items in the inventory
    public  int getTotalInventoryCount() {
        return inventory.size();
    }

    //method to retrieve the inventory
    public List<Car> getInventory() {
        return inventory;
    }
}
