package dev.tudou.mossad.impl.features.gui.screens.ClickGui;

import dev.tudou.mossad.impl.features.Module;
import dev.tudou.mossad.impl.features.gui.screens.ClickGui.setting.CheckBox;
import dev.tudou.mossad.impl.features.gui.screens.ClickGui.setting.Component;
import dev.tudou.mossad.impl.features.gui.screens.ClickGui.setting.ModeBox;
import dev.tudou.mossad.impl.features.gui.screens.ClickGui.setting.Slider;
import dev.tudou.mossad.impl.features.settings.BooleanSetting;
import dev.tudou.mossad.impl.features.settings.ModeSetting;
import dev.tudou.mossad.impl.features.settings.NumberSetting;
import dev.tudou.mossad.impl.features.settings.Setting;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ModuleButton {

    public Module module;
    public Frame parent;
    public int offset;
    public List<Component> components;
    public boolean extended;

    protected MinecraftClient mc = MinecraftClient.getInstance();


    public ModuleButton(Module module, Frame parent, int offset) {
        this.module = module;
        this.parent = parent;
        this.offset = offset;
        this.extended = false;
        this.components = new ArrayList<>();

        int setOffset = offset;
        for (Setting setting : module.getSettings()) {
            if (setting instanceof BooleanSetting) {
                components.add(new CheckBox(setting, this, setOffset));
            } else  if (setting instanceof ModeSetting) {
                components.add(new ModeBox(setting, this, setOffset));
            } else  if (setting instanceof NumberSetting) {
                components.add(new Slider(setting, this, setOffset));
            }
        }
    }

    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        context.fill(parent.x, parent.y + offset, parent.x + parent.width, parent.y + offset + 12, new Color(0, 0, 0, 100).getRGB());
        if (isHovered(mouseX, mouseY)) context.fill(parent.x, parent.y + offset, parent.x + parent.width, parent.y + offset + 12, new Color(0, 0, 0, 100).getRGB());
        context.drawTextWithShadow(mc.textRenderer, module.getName(), parent.x + 2, parent.y + offset + 2,module.isEnabled() ? Color.PINK.getRGB() : -1);


        for (Component component : components) {
            component.render(context, mouseX, mouseY, delta);
        }
    }
    public void mouseClicked(double mouseX, double mouseY, int button) {
        if (isHovered(mouseX, mouseY)) {
            if (button == 0) {
                module.toggle();
            } else if (button == 1) {
                extended = !extended;
                parent.updateButtons();
            }
        }

        for (Component component : components) {
            component.mouseClicked(mouseX, mouseY, button);
        }
    }

    public void mouseReleased(double mouseX, double mouseY, int button) {
        for (Component component : components) {
            component.mouseReleased(mouseX, mouseY, button);
        }
    }

    public boolean isHovered(double mouseX, double mouseY) {
        return mouseX > parent.x && mouseX < parent.x + parent.width && mouseY > parent.y + offset && mouseY < parent.y + offset + 12;
    }
}