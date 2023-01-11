package app;

import java.util.Map;

public class MainApp2 {
    public static void main(String[] args) {
        SingletonService service = SingletonService.getInstance();
        Map<Integer, Car> allCars = service.getAllCars();
    }
}
