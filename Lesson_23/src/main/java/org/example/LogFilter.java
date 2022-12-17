package org.example;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.logging.LogRecord;


@WebFilter("/cars")
public class LogFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String method = ((HttpServletRequest) request).getMethod();

        if (!"GET".equalsIgnoreCase(method)) {
            System.out.println(((HttpServletRequest) request).getRequestURI());
        }

        chain.doFilter(request, response);

    }

    @Override
    public void destroy() {

    }
}
