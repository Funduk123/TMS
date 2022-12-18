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
        String header = ((HttpServletRequest) request).getHeader("Parameter");

        if ("GET".equalsIgnoreCase(method)) {
            chain.doFilter(request, response);
        }

        if (header == null) {
            throw new ServletException("Enter parameter");
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
