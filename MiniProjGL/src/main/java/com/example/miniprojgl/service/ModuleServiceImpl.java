package com.example.miniprojgl.service;

import com.example.miniprojgl.dao.ModuleDAO;
import com.example.miniprojgl.dao.ModuleDAOImpl;
import com.example.miniprojgl.model.Module;

import java.util.List;

public class ModuleServiceImpl implements ModuleService {

    private ModuleDAO moduleDAO;

    public ModuleServiceImpl() {
        this.moduleDAO = new ModuleDAOImpl(); // Initialize the DAO implementation
    }

    @Override
    public List<Module> getAllModules() {
        return moduleDAO.getAllModules(); // Call the DAO for the operation
    }

    @Override
    public Module getModuleById(int id) {
        return moduleDAO.getModuleById(id); // Call the DAO for the operation
    }

    @Override
    public boolean addModule(Module module) {
        return moduleDAO.addModule(module); // Call the DAO for the operation
    }

    @Override
    public boolean updateModule(Module module) {
        return moduleDAO.updateModule(module); // Call the DAO for the operation
    }

    @Override
    public boolean deleteModule(int id) {
        return moduleDAO.deleteModule(id); // Call the DAO for the operation
    }
}
