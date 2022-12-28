package app.servlets;

import app.model.Car;
import app.model.CarsList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/")
public class ListServlet extends HttpServlet {

    private final CarsList carsList = new CarsList();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Car> cars = carsList.getCarsList();
        req.setAttribute("cars", cars);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("mainPage.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String idLong = req.getParameter("id");
        String brand = req.getParameter("brand");
        String model = req.getParameter("model");
        String costInt = req.getParameter("cost");

        long id = Long.parseLong(idLong);
        int cost = Integer.parseInt(costInt);

        carsList.addNewCar(new Car(id, brand, model, cost));

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("mainPage.jsp");
        requestDispatcher.forward(req, resp);

    }

}
