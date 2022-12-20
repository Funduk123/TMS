package org.example.service;

import org.example.model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarsList {

    private final static List<Car> carsList = new ArrayList<>();

    static {
        carsList.add(new Car(1L, "BMW", "X5"));
        carsList.add(new Car(2L, "Audi", "A6"));
    }

    public List<Car> getCarsList() {
        return carsList;
    }

    public void addNewCar(long id, String brand, String model) {
        Car car = new Car(id, brand, model);
        carsList.add(car);
    }

    public Car getCar(long id) {

        for (Car car : carsList) {
            if (car.getId() == id) {
                return car;
            }
        }
        return null;
    }

}
