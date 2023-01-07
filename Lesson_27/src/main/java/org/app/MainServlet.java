package org.app;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/cars")
public class MainServlet extends HttpServlet {

    CarService service = new CarServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        req.setAttribute("title", "hello from JSTL");
//
////        --------------------------------------------------------------
//
//        String role = req.getParameter("role");
//        if ("admin".equals(role)) {
//            req.setAttribute("isAdmin", true);
//        } else {
//            req.setAttribute("isAdmin", false);
//        }
//
////        --------------------------------------------------------------
//
//        String brand = req.getParameter("brand");
//
//        if (brand == null) {
//            req.setAttribute("brand", 0);
//        } else {
//            req.setAttribute("brand", Long.parseLong(brand));
//        }
//
////        --------------------------------------------------------------
//
//        String red = req.getParameter("red");
//
//        if (red == null || !red.equals("true")) {
//            req.setAttribute("red", false);
//        } else {
//            req.setAttribute("red", true);
//        }
//
////        --------------------------------------------------------------
//

        List<Car> cars = service.getAll();
        req.setAttribute("cars", cars);

        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
