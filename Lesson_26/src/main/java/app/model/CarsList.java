package app.model;

import java.util.ArrayList;
import java.util.List;

public class CarsList {

    private final static List<Car> carsList = new ArrayList<>();

    static {
        carsList.add(new Car(1L, "BMW", "X5", 30000));
        carsList.add(new Car(2L, "Audi", "A6", 35000));
    }

    public List<Car> getCarsList() {
        return carsList;
    }

    public void addNewCar(Car car) {
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

    public void deleteCar(long id) {
        Car car = getCar(id);
        carsList.remove(car);
    }


}
