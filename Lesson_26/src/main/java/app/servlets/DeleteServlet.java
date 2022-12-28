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

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {

    private final CarsList carsList = new CarsList();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (!req.getParameter("id").isEmpty()) {
            long id = Long.parseLong(req.getParameter("id"));
            Car car = carsList.getCar(id);

            if (carsList.getCarsList().contains(car)) {
                carsList.deleteCar(id);

                RequestDispatcher requestDispatcher = req.getRequestDispatcher("delete.jsp");
                requestDispatcher.forward(req, resp);

            } else {
                resp.getOutputStream().println("<h1>Car not found!</h1>");
            }

        } else {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("mainPage.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}
