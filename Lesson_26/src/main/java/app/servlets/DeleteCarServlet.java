package app.servlets;

import app.model.CarsList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteCar")
public class DeleteCarServlet extends HttpServlet {

    private final CarsList carsList = new CarsList();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("id"));
        carsList.deleteCar(id);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("mainPage.jsp");
        requestDispatcher.forward(req, resp);
    }
}
