package org.app;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet(value = "/init", loadOnStartup = 1)
public class StartUpServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {

        try {
            Class.forName("org.postgresql.Driver");
            getConnection().createStatement().execute("drop table if exists cars");
            getConnection().createStatement().execute("create table cars" +
                    "(" +
                    " id int primary key, " +
                    " brand varchar, " +
                    " model varchar, " +
                    " cost int" +
                    ")"
            );
        } catch (Exception exc) {
            throw new RuntimeException();
        }
    }

    public Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/cars", "postgres", "admin");
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
}
