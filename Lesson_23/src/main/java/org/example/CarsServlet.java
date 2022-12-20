package org.example;

import org.example.model.Car;
import org.example.service.CarsList;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/cars")
public class CarsServlet extends HttpServlet {

    private CarsList carsList;

    @Override
    public void init(ServletConfig config) {
        carsList = new CarsList();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SimpleDateFormat simpleDataFormat = new SimpleDateFormat("HH.mm");
        resp.addCookie(new Cookie("Time", simpleDataFormat.format(new Date())));
        super.service(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String id = req.getParameter("id");

        if (id == null) {
            resp.getOutputStream().println(carsList.getCarsList().toString());
        } else {
            Car car = carsList.getCar(Long.parseLong(id));
            resp.getOutputStream().println(car.toString());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("id"));
        String brand = req.getParameter("brand");
        String model = req.getParameter("model");
        Car car = new Car(id, brand, model);
        car = carsList.addNewCar(car);
        resp.getOutputStream().println(car.toString());
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        long id = Long.parseLong(req.getParameter("id"));
        carsList.deleteCar(id);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        long id = Long.parseLong(req.getParameter("id"));
        String brand = req.getParameter("brand");
        String model = req.getParameter("model");

        Car car = new Car(id, brand, model);
        car = carsList.updateCar(car);
        resp.getOutputStream().println(car.toString());
    }
}
