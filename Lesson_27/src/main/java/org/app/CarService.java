package org.app;

import java.util.List;

public interface CarService {

    void save(Car car);

    void delete(Long id);

    void update(Long id);

    List<Car> getAll();

    List<Car> getById(Long id);


}
