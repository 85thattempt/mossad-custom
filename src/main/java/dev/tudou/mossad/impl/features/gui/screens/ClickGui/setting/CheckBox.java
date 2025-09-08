package dev.tudou.mossad.impl.features.gui.screens.ClickGui.setting;

import dev.tudou.mossad.impl.features.gui.screens.ClickGui.ModuleButton;
import dev.tudou.mossad.impl.features.settings.BooleanSetting;
import dev.tudou.mossad.impl.features.settings.Setting;
import net.minecraft.client.gui.DrawContext;

public class CheckBox extends Component {

    private BooleanSetting boolSet = (BooleanSetting) setting;

    public CheckBox(Setting setting, ModuleButton parent, int offset) {
        super(setting, parent, offset);
        this.boolSet = (BooleanSetting) setting;
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);
    }

    @Override
    public void mouseClicked(double mouseX, double mouseY, int button) {
        super.mouseClicked(mouseX, mouseY, button);
    }


}
