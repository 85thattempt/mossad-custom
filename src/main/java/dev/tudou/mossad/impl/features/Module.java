package dev.tudou.mossad.impl.features;

import dev.tudou.mossad.impl.features.settings.Setting;
import net.minecraft.client.MinecraftClient;

import java.util.ArrayList;
import java.util.List;

public class Module {

    private String name;
    private String displayName;
    private String description;
    private Category category;
    private int key;
    private boolean enabled;

    private List<Setting> settings = new ArrayList<>();

    protected MinecraftClient mc = MinecraftClient.getInstance();

    public Module(String name, String description, Category category) {
        this.name = name;
        this.displayName = name;
        this.description = description;
        this.category = category;
    }

    public List<Setting> getSettings() {
        return settings;
    }

    public void addSetting(Setting setting) {
    }

    public void addSettings(Setting... settings) {
        for (Setting setting : settings) addSetting(setting); {

        }
    }

    public void toggle() {
        this.enabled = !this.enabled;

        if (enabled) onEnable();
            else onDisable();

    }

    public void onEnable() {

    }

    public void onDisable() {

    }

    public void onTick() {

    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Category getCategory() {
        return category;
    }

    public String getName(String name) {
        return name;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;

        if (enabled) onEnable();
        else onDisable();
    }

    public enum Category {
        COMBAT("Combat"),
        MISC("Misc"),
        VISUALS("Visuals"),
        MOVEMENT("Movement"),
        EXPLOITS("Exploits"),
        CORE("Core");

        public String name;

        private Category(String name) {
            this.name = name;
        }
    }
}
