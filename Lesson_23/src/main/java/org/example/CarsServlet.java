package org.example;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CarsServlet extends HttpServlet {

    private static Map<String, String> cars = new HashMap<>();

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        String action = req.getParameter("action");
//        req.setAttribute("car", car);


//        String id = req.getParameter("id");
//        resp.getOutputStream().print(cars.get(id));

//        resp.setStatus(400);

        req.setAttribute("name", "Car");
        req.getRequestDispatcher("/car.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        System.out.println("Выполняется doPost");
//
//        req.setCharacterEncoding("UTF-8");
//        String action = req.getParameter("action");
//
//        if ("submit".equals(action)) {
//            car.setId(Integer.parseInt(req.getParameter("id")));
//            car.setBrand(req.getParameter("brand"));
//            car.setModel(req.getParameter("model"));
//        }
//
//        req.setAttribute("car", car);
        req.getRequestDispatcher("/car.jsp").forward(req, resp);



//        String id = req.getParameter("id");
//        String title = req.getParameter("title");
//        cars.put(id, title);

        // Сохранение данных
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String id = req.getParameter("id");
//        cars.remove(id);
        // Удаление данных
    }

}
