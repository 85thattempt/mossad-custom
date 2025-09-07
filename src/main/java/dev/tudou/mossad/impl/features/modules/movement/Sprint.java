package dev.tudou.mossad.impl.features.modules.movement;

import dev.tudou.mossad.impl.features.Module;
import org.lwjgl.glfw.GLFW;

public class Sprint extends Module {

    public Sprint() {
        super("Sprint", "makes the player sprint", Category.MOVEMENT);
        this.setKey(GLFW.GLFW_KEY_Y);
    }

    @Override
    public void onTick() {
        mc.player.setSprinting(true);
        super.onTick();
    }

    @Override
    public void onDisable() {
        mc.player.setSprinting(false);
        super.onDisable();
    }
}
