package org.example;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/cars")
public class CarsServlet extends HttpServlet {

    private static final Map<String, String> cars = new HashMap<>();

    @Override
    public void init(ServletConfig config) {
        System.out.println("---DO INIT---");
        cars.put("1", "brand: BMW" + ", model: E34");
        cars.put("2", "brand: Audi" + ", model: A6");
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("---DO SERVICE---");
        super.service(req, res);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        String id = req.getParameter("id");

        User user = new User("Danila", "123");
        req.setAttribute("register", user.login + " " + user.password);
        req.getRequestDispatcher("car.jsp");

        if (id == null) {
            resp.getOutputStream().println("CARS INFO");
            for (String car : cars.keySet()) {
                resp.getOutputStream().println("Car " + car + ": " + cars.get(car));
            }
            resp.getOutputStream().println("_________________________________");
            resp.getOutputStream().println("Cars: " + cars.size());
        } else {
            if (cars.containsKey(id)) {
                resp.getOutputStream().println("CARS INFO");
                resp.reset();
                resp.getOutputStream().println(cars.get(id));
            } else {
                req.getRequestDispatcher("/car.jsp").forward(req, resp);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("---DO POST CARS LIST---");

        PrintWriter writer = resp.getWriter();

        String id = req.getParameter("id");
        String brand = req.getParameter("brand");
        String model = req.getParameter("model");

        writer.println("Car " + id + ": brand: " + brand + ", model: " + model);

        cars.put(id, "brand: " + brand + ", model: " + model);


    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("id");

        cars.remove(id);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");
        String newBrand = req.getParameter("newBrand");
        String newModel = req.getParameter("newModel");

        PrintWriter writer = resp.getWriter();

        writer.println("Car " + id + ": brand: " + newBrand + ", model: " + newModel);

        cars.put(id, "brand: " + newBrand + ", model: " + newModel);
    }
}
