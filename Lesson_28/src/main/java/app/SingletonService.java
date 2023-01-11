package app;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SingletonService {

    private Map<Integer, Car> cars = new ConcurrentHashMap<>();

    private static SingletonService service;

    private SingletonService() {
    }

    public static SingletonService getInstance() {
        if (service == null)
            synchronized (SingletonService.class) {
                if (service == null) {
                    service = new SingletonService();
                }
            }
        return service;
    }

    public Map<Integer, Car> getAllCars() {
        return cars;
    }

}
