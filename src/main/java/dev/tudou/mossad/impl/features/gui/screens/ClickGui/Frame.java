package dev.tudou.mossad.impl.features.gui.screens.ClickGui;

import dev.tudou.mossad.core.manager.ModuleManager;
import dev.tudou.mossad.impl.features.Module;
import dev.tudou.mossad.impl.features.Module.Category;
import dev.tudou.mossad.impl.features.gui.screens.ClickGui.setting.Component;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.Drawable;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Frame {

    public int x, y, width, height, dragX, dragY;
    public Category category;

    public boolean dragging, extended;

    private List<ModuleButton> buttons;

    protected MinecraftClient mc = MinecraftClient.getInstance();

    public Frame(Category category, int x, int y, int width, int height) {
        this.category = category;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.dragging = false;
        this.extended = false;

        buttons = new ArrayList<>();

        int offset = height;
        for (Module module : ModuleManager.INSTANCE.getModulesInCategory(category)) {
            buttons.add(new ModuleButton(module,this, offset ));
            offset += height;
        }
    }

    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        context.fill(this.x, this.y, x + width, y + height, Color.PINK.getRGB());
        context.drawTextWithShadow(mc.textRenderer, category.name, x + 2, y + 2, Color.WHITE.getRGB());

        if (extended) {
            for (ModuleButton button : buttons) {
                button.render(context, mouseX, mouseY, delta);
            }
        }
    }

    public void mouseClicked(double mouseX, double mouseY, int button) {
        if (isHovered(mouseX, mouseY)) {
            if (button == 0) {
                dragging = true;
                dragX = (int) mouseX - x;
                dragY = (int) mouseY - y;
            } else if (button == 1) {
                extended = !extended;
            }

        }

        if (extended) {
            for (ModuleButton mb : buttons) {
                mb.mouseClicked(mouseX, mouseY, button);
            }
        }

    }

    public void mouseReleased(double mouseX, double mouseY, int button) {
        if (button == 0 && dragging == true) dragging = false;
    }
    public boolean isHovered(double mouseX, double mouseY) {
        return mouseX > x && mouseX < x + width && mouseY > y && mouseY < y + height;
    }

    public void updatePosition(double mouseX, double mouseY) {
        if (dragging) {
            x = (int) (mouseX - dragX);
            y = (int) (mouseY - dragY);
        }
    }

    public void updateButtons() {
        int offset = height;

        for (ModuleButton button : buttons) {
            button.offset = offset;
            offset += height;

            if (button.extended) {
                for (Component component : button.components) {
                    if (component.setting.isVisible()) offset += height;
                }
            }
        }
    }
}
