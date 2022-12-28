package app.servlets;

import app.model.Car;
import app.model.CarsList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {

    private final CarsList carsList = new CarsList();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getParameter("id").isEmpty()) {

            List<Car> cars = carsList.getCarsList();
            req.setAttribute("cars", cars);

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("carsList.jsp");
            requestDispatcher.forward(req, resp);

        } else {

            String id = req.getParameter("id");
            Car car = carsList.getCar(Long.parseLong(id));

            if (!carsList.getCarsList().contains(car)) {
                resp.getOutputStream().println("<h1>Car not found!</h1>");
            } else {
                resp.getOutputStream().println("<h1>" + car.toString() + "</h1>");
            }

        }
    }
}
