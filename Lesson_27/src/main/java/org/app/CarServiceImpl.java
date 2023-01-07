package org.app;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarServiceImpl implements CarService {

    StartUpServlet servlet = new StartUpServlet();

    @Override
    public void save(Car car) {
        try {
            Connection connection = servlet.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into cars (id, brand, model, cost) values(?, ?, ?, ?)");
            preparedStatement.setLong(1, car.getId());
            preparedStatement.setString(2, car.getBrand());
            preparedStatement.setString(3, car.getModel());
            preparedStatement.setLong(4, car.getCost());

            preparedStatement.execute();
        } catch (Exception exc) {
            throw new RuntimeException("SQL ADD FAILED");
        }
    }

    @Override
    public void delete(Long id) {
        try {
            Connection connection = servlet.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from cars where id = ?");
            preparedStatement.setLong(1, id);

            preparedStatement.execute();
        } catch (Exception exc) {
            throw new RuntimeException("SQL DELETE FAILED");
        }
    }

    @Override
    public void update(Long id) {
        try {
            Connection connection = servlet.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("update cars set cost = cost + 1000 where id = ?");
            preparedStatement.setLong(1, id);

            preparedStatement.execute();
        } catch (Exception exc) {
            throw new RuntimeException("SQL UPDATE FAILED");
        }
    }

    @Override
    public List<Car> getAll() {
        try {
            Connection connection = servlet.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from cars order by id");
            return get(resultSet);
        } catch (Exception exc) {
            throw new RuntimeException("SQL EXCEPTION");
        }
    }

    @Override
    public List<Car> getById(Long id) {
        try {
            Connection connection = servlet.getConnection();
            PreparedStatement statement = connection.prepareStatement("select * from cars where id=?");
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (check(id)) {
                return get(resultSet);
            } else return null;

        } catch (Exception exc) {
            throw new RuntimeException("SQL EXCEPTION");
        }
    }

    private boolean check(long id) throws SQLException {
        Connection connection = servlet.getConnection();
        PreparedStatement statement = connection.prepareStatement("select * from cars where id=?");
        statement.setLong(1, id);
        for (Car car : getAll()) {
            if (car.getId() == id) {
                return true;
            }
        }
        return false;
    }

    private List<Car> get(ResultSet resultSet) {

        List<Car> cars = new ArrayList<>();
        try {
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String brand = resultSet.getString("brand");
                String model = resultSet.getString("model");
                long cost = resultSet.getLong("cost");
                Car car = new Car(id, brand, model, cost);
                cars.add(car);
            }
        } catch (Exception exc) {
            throw new RuntimeException("SQL EXCEPTION");
        }
        return cars;
    }
}
