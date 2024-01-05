package com.example.miniprojgl.service;

import com.example.miniprojgl.model.Module;
import java.util.List;

public interface ModuleService {
    List<Module> getAllModules();
    Module getModuleById(int id);
    boolean addModule(Module module);
    boolean updateModule(Module module);
    boolean deleteModule(int id);
}
