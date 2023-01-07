package org.app;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/all")
public class ListServlet extends HttpServlet {

    CarService service = new CarServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");

        if (id.isEmpty()) {
            populateCars(req);
            req.getRequestDispatcher("/add.jsp").forward(req, resp);
        } else {
            List<Car> byId = service.getById(Long.parseLong(id));
            if (byId == null) {
                resp.getOutputStream().println("<h1>Car not found!</h1>");
            } else {
                req.setAttribute("cars", byId);
                req.getRequestDispatcher("/add.jsp").forward(req, resp);
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String search = req.getParameter("search");
        if (search == null) {
            populateCars(req);
        } else {
            List<Car> byId = service.getById(Long.parseLong(search));
            req.setAttribute("cars", byId);
        }

        req.getRequestDispatcher("/add.jsp").forward(req, resp);
    }

    private void populateCars(HttpServletRequest request) {
        request.setAttribute("cars", service.getAll());
    }
}
