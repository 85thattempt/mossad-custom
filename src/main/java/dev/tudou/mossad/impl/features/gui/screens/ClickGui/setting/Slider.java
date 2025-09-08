package dev.tudou.mossad.impl.features.gui.screens.ClickGui.setting;

import dev.tudou.mossad.impl.features.gui.screens.ClickGui.ModuleButton;
import dev.tudou.mossad.impl.features.settings.NumberSetting;
import dev.tudou.mossad.impl.features.settings.Setting;
import net.minecraft.client.gui.DrawContext;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Slider extends Component{

    public NumberSetting numSet = (NumberSetting) setting;

    public Slider(Setting setting, ModuleButton parent, int offset) {
        super(setting, parent, offset);
        this.numSet = (NumberSetting) setting;
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);
    }

    @Override
    public void mouseClicked(double mouseX, double mouseY, int button) {
        super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public void mouseReleased(double mouseX, double mouseY, int button) {
        super.mouseReleased(mouseX, mouseY, button);
    }

    private double roundToPlace(double value, int place) {
        if (place < 0) {
            return value;
        }

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(place, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

}
