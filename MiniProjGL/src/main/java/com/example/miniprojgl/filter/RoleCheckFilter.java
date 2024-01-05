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
public class RoleCheckFilter implements Filter {

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession(false);

        User user = (session != null) ? (User) session.getAttribute("user") : null;
        String loginURI = request.getContextPath() + "/login";

        boolean loggedIn = user != null;
        boolean loginRequest = request.getRequestURI().equals(loginURI);
        boolean resourceRequest = request.getRequestURI().startsWith(request.getContextPath() + "/resources");

        if (loggedIn || loginRequest || resourceRequest) {
            if (isAuthorized(user, request)) {
                chain.doFilter(request, response);
            } else {
                response.sendRedirect("accessDenied.jsp"); // Redirect to an access denied page
            }
        } else {
            response.sendRedirect(loginURI);
        }



    }

    private boolean isAuthorized(User user, HttpServletRequest request) {
        // Implement logic to check if the user's role allows access to the requested resource
        // Example:
        if (request.getRequestURI().contains("/admin")) {
            return user != null && "admin".equalsIgnoreCase(user.getRole());
        }
        // Add more checks as needed
        return true;
    }

    // implement init() and destroy() methods
}
