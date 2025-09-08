package dev.tudou.mossad.impl.features.gui.screens.ClickGui.setting;

import dev.tudou.mossad.impl.features.gui.screens.ClickGui.ModuleButton;
import dev.tudou.mossad.impl.features.settings.Setting;
import net.minecraft.client.gui.DrawContext;

public class Component {

    public Setting setting;
    public ModuleButton parent;
    public int offset;


    public Component(Setting setting, ModuleButton parent, int offset) {
        this.setting = setting;
        this.parent = parent;
        this.offset = offset;
    }

    public void render(DrawContext context, int mouseX, int mouseY, float delta) {

    }

    public void mouseClicked(double mouseX, double mouseY, int button) {

    }

    public void mouseReleased(double mouseX, double mouseY, int button) {

    }

    public boolean isHovered(double mouseX, double mouseY) {
        return mouseX > parent.parent.x && mouseX < parent.parent.x + parent.parent.width && mouseY > parent.parent.y + parent.offset + offset && mouseY < parent.parent.y + parent.offset + offset + parent.parent.height;
    }
}