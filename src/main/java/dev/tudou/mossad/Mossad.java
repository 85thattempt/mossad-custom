package dev.tudou.mossad;

import dev.tudou.mossad.impl.features.Module;
import dev.tudou.mossad.core.manager.ModuleManager;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.MinecraftClient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.glfw.GLFW;

public class Mossad implements ClientModInitializer {

    public static final Mossad INSTANCE = new Mossad();
    public static final String MOD_ID = "mossad";
    public static final String MOD_NAME = "Mossad";
    public static final String VERSION = "1.0.0";

    public Logger logger = LogManager.getLogger(MOD_NAME);

    private MinecraftClient mc = MinecraftClient.getInstance();

    @Override
    public void onInitializeClient() {
        logger.info("Mossad Client Initialized");
    }

    public void onKeyPressed(int key, int action) {
        if (action == GLFW.GLFW_PRESS) {
            for (Module module : ModuleManager.INSTANCE.getModules()) {
                if (key == module.getKey()) module.toggle();

            }
        }




    }
    public void onTick() {
        if (mc.player != null) {
            for (Module module : ModuleManager.INSTANCE.getEnabledModules()) {
                module.onTick();
            }
        }

    }
}
