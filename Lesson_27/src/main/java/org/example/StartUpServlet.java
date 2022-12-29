package org.example;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet("/init")
public class StartUpServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {

        try {
            Class.forName("org.postgresql.Driver");
        } catch (Exception exc) {
            System.out.println(exc);
            throw new RuntimeException();
        }
    }

    public Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/cars");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
