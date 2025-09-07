package dev.tudou.mossad.impl.features.gui.screens.ClickGui;

import net.minecraft.client.gui.DrawContext;

import java.awt.*;

public class ModuleButton {

    public Module module;
    public Frame parent;
    public int offset;

    public ModuleButton(Module module, Frame parent, int offset) {
        this.module = module;
        this.parent = parent;
        this.offset = offset;
    }

    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        context.fill(parent.x, parent.y, parent.y + offset, parent.x + parent.width, parent.y + offset + parent.height, new Color(0, 0, 0, 100).getRGB());
        context.drawTextWithShadow (context, module.getName(), parent.x + 2, parent.y + offset + 2,-1);

    }
    public void mouseClicked(double mouseX, double mouseY, int button) {
    }

    public boolean isHovered(double mouseX, double mouseY) {
        return mouseX > parent.x && mouseX < parent.x + parent.width && mouseY > parent.y && offset < parent.y + offset + parent.height;
    }
}
