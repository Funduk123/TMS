package org.example;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/cars")
public class CarFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        String method = ((HttpServletRequest) request).getMethod();
        String header = ((HttpServletRequest) request).getHeader("headerParam");

        if (method.equalsIgnoreCase("GET")) {
            chain.doFilter(request, response);
        }

        if (header == null) {
            throw new ServletException("Enter headerParam");
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
    }
}
