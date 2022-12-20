package org.example;
import org.example.service.CarsList;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
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
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        SimpleDateFormat simpleDataFormat = new SimpleDateFormat("HH.mm");
        resp.addCookie(new Cookie("Time", simpleDataFormat.format(new Date())));
        super.service(req, resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        System.out.println("мда");
        String id = req.getParameter("id");

        if (id == null) {
            resp.getOutputStream().println(carsList.getCarsList().toString());
        }



//        User user = new User("Danila", "123");
//        req.setAttribute("register", user.login + " " + user.password);
//        req.getRequestDispatcher("car.jsp");



//        if (id == null) {
//            resp.getOutputStream().println("CARS INFO");
//            for (String car : cars.keySet()) {
//                resp.getOutputStream().println("Car " + car + ": " + cars.get(car));
//            }
//            resp.getOutputStream().println("_________________________________");
//            resp.getOutputStream().println("Cars: " + cars.size());
//        } else {
//            if (cars.containsKey(id)) {
//                resp.getOutputStream().println("CARS INFO");
//                resp.reset();
//                resp.getOutputStream().println(cars.get(id));
//            } else {
//                req.getRequestDispatcher("/car.jsp").forward(req, resp);
//            }
//        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("---DO POST CARS LIST---");

        PrintWriter writer = resp.getWriter();

        String id = req.getParameter("id");
        String brand = req.getParameter("brand");
        String model = req.getParameter("org/example/model");

        writer.println("Car " + id + ": brand: " + brand + ", model: " + model);

//        cars.put(id, "brand: " + brand + ", model: " + model);


    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("id");

//        cars.remove(id);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");
        String newBrand = req.getParameter("newBrand");
        String newModel = req.getParameter("newModel");

        PrintWriter writer = resp.getWriter();

        writer.println("Car " + id + ": brand: " + newBrand + ", model: " + newModel);

//        cars.put(id, "brand: " + newBrand + ", model: " + newModel);
    }
}
