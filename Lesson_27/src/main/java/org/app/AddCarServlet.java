package org.app;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add")
public class AddCarServlet extends HttpServlet {

    CarService service = new CarServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Long id = Long.parseLong(req.getParameter("id"));
        String brand = req.getParameter("brand");
        String model = req.getParameter("model");
        Long cost = Long.parseLong(req.getParameter("cost"));

        Car car = new Car(id, brand, model, cost);

        service.save(car);
        resp.sendRedirect("/");
    }
}
