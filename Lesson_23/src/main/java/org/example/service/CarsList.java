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

    public Car addNewCar(Car car) {
        carsList.add(car);
        return car;
    }

    public Car getCar(long id) {

        for (Car car : carsList) {
            if (car.getId() == id) {
                return car;
            }
        }
        return null;
    }

    public void deleteCar(long id) {
        Car car = getCar(id);
        carsList.remove(car);
    }

    public Car updateCar(Car car) {
        Car newCar = getCar(car.getId());

        newCar.setBrand(car.getBrand());
        newCar.setModel(car.getModel());
        return newCar;
    }

}
