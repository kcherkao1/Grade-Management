package com.example.miniprojgl.filter;

import com.example.miniprojgl.model.User;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class AuthFilter implements Filter {

    public void init(FilterConfig fConfig) throws ServletException {
        // Filter initialization code can go here
    }

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession(false);

        String loginURI = request.getContextPath() + "/login";
        String registerURI = request.getContextPath() + "/register";
        String registerPage = request.getContextPath() + "/register.jsp";

        boolean loggedIn = session != null && session.getAttribute("user") != null;
        boolean loginRequest = request.getRequestURI().equals(loginURI);
        boolean registerRequest = request.getRequestURI().equals(registerURI) || request.getRequestURI().equals(registerPage);

        // Add logging to see what URLs are coming through and which conditions are being met
        System.out.println("Request URI: " + request.getRequestURI());
        System.out.println("loggedIn: " + loggedIn);
        System.out.println("loginRequest: " + loginRequest);
        System.out.println("registerRequest: " + registerRequest);

        if (loggedIn || loginRequest || registerRequest) {
            chain.doFilter(request, response); // Allow these requests to proceed
        } else {
            System.out.println("Redirecting to login.");
            response.sendRedirect(loginURI); // Redirect all other requests to the login page
        }
    }

    private boolean isAuthorized(User user, HttpServletRequest request) {
        String requestURI = request.getRequestURI();

        if (user == null) return false;

        if (requestURI.contains("/admin")) {
            return "admin".equalsIgnoreCase(user.getRole());
        } else if (requestURI.contains("/user")) {
            return "user".equalsIgnoreCase(user.getRole());
        }

        // Allow access to common resources or non-protected pages
        return true;
    }

    public void destroy() {
        // Close resources if any
    }
}
