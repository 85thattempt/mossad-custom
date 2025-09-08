package dev.tudou.mossad.impl.features.modules.core;

import dev.tudou.mossad.impl.features.Module;
import dev.tudou.mossad.impl.features.settings.BooleanSetting;
import dev.tudou.mossad.impl.features.settings.ModeSetting;
import dev.tudou.mossad.impl.features.settings.NumberSetting;

public class TestModule extends Module {

    public NumberSetting test = new NumberSetting("Test", 10, 0, 100, 1);
    public BooleanSetting testBool = new BooleanSetting("check", true);
    public ModeSetting testMode = new ModeSetting("mode", "test", "test", "test2");

    public TestModule() {
        super("TestModule", "testing", Category.CORE);
        addSettings(test, testBool, testMode);

    }
}
