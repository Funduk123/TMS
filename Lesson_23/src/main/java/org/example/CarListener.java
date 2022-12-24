package org.example;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.io.PrintWriter;

@WebListener
public class CarListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("Session created!!!");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
    }
}
