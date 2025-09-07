package dev.tudou.mossad.core.manager;

import dev.tudou.mossad.impl.features.Module;
import dev.tudou.mossad.impl.features.modules.movement.*;

import java.util.ArrayList;
import java.util.List;

public class ModuleManager {

    public static final ModuleManager INSTANCE = new ModuleManager();
    private List<Module> modules = new ArrayList<>();

    public ModuleManager() {
        addModules();

    }

    public List<Module> getModules() {
        return modules;
    }

    public List<Module> getEnabledModules() {
        List<Module> enabled = new ArrayList<>();
        for (Module module : modules) {
            if (module.isEnabled()) enabled.add(module);

            }
            return enabled;
        }


    private void addModules() {
        modules.add(new Sprint());

    }


}
