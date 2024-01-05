// src/main/java/com/example/miniprojgl/controller/TestServlet.java
package com.example.miniprojgl.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "TestServlet", urlPatterns = {"/test"})
public class TestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Set response content type to text/html
        response.setContentType("text/html");

        // Actual logic goes here
        PrintWriter out = response.getWriter();
        out.println("<h1>This is a test servlet</h1>");
    }
}
