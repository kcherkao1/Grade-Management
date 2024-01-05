package com.example.miniprojgl.controller;

import com.example.miniprojgl.model.Module;
import com.example.miniprojgl.service.ModuleService;
import com.example.miniprojgl.service.ModuleServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ModuleController", urlPatterns = {"/modules"})
public class ModuleController extends HttpServlet {

    private ModuleService moduleService = new ModuleServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "editForm":
                    showEditForm(request, response);
                    break;
                case "delete":
                    deleteModule(request, response);
                    break;
                default:
                    listModules(request, response);
                    break;
            }
        } else {
            listModules(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "add":
                    addModule(request, response);
                    break;
                case "edit":
                    updateModule(request, response);
                    break;
                // Implement other cases if needed
            }
        }
    }

    private void listModules(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Module> modules = moduleService.getAllModules();
        request.setAttribute("modules", modules);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/module-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Module existingModule = moduleService.getModuleById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/module-edit.jsp");
        request.setAttribute("module", existingModule);
        dispatcher.forward(request, response);
    }

    private void addModule(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String name = request.getParameter("name");
        int semester = Integer.parseInt(request.getParameter("semester"));
        Module newModule = new Module(name, semester);
        moduleService.addModule(newModule);
        response.sendRedirect("modules");
    }

    private void updateModule(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int semester = Integer.parseInt(request.getParameter("semester"));
        Module module = new Module(id, name, semester);
        moduleService.updateModule(module);
        response.sendRedirect("modules");
    }

    private void deleteModule(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        moduleService.deleteModule(id);
        response.sendRedirect("modules");
    }
}
