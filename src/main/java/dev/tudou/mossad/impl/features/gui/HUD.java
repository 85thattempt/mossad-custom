package dev.tudou.mossad.impl.features.gui;

import java.awt.Color;
import java.util.Comparator;
import java.util.List;

import dev.tudou.mossad.impl.features.Module;
import dev.tudou.mossad.core.manager.ModuleManager;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;


public class HUD {

    private static MinecraftClient mc = MinecraftClient.getInstance();

    public static void render(DrawContext context, RenderTickCounter tickDelta) {
        renderArrayList(context);

    }

    public static void renderArrayList(DrawContext context) {
        int index = 0;
        int sWidth = mc.getWindow().getScaledWidth();
        int sHeight = mc.getWindow().getScaledHeight();

        List<Module> enabled = ModuleManager.INSTANCE.getEnabledModules();

        enabled.sort(Comparator.comparingInt(m -> (int)mc.textRenderer.getWidth(((Module)m).getDisplayName())).reversed());

        for (Module module : enabled) {
            context.drawTextWithShadow(mc.textRenderer, module.getDisplayName(), (sWidth - 4) - mc.textRenderer.getWidth(module.getDisplayName()), 10 + (index * mc.textRenderer.fontHeight), Color.WHITE.getRGB());
            index++;

        }
    }
}