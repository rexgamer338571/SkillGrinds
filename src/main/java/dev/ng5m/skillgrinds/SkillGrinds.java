package dev.ng5m.skillgrinds;

import dev.ng5m.skillgrinds.spigui.SpiGUI;
import dev.ng5m.skillgrinds.util.Shared;
import org.bukkit.plugin.java.JavaPlugin;

public final class SkillGrinds extends JavaPlugin {
    private static SkillGrinds instance;
    public static SpiGUI spiGUI;

    @Override
    public void onEnable() {
        instance = this;
        spiGUI = new SpiGUI(this);

        Shared.registerListeners(this);

        if (!getConfig().isSet("villagers.resetOnReload"))
            getConfig().set("villagers.resetOnReload", false);
        else {
            if (getConfig().getBoolean("villagers.resetOnReload"))
                getConfig().set("villagers.guideVillager.name", Shared.fix("&aGuide"));
        }

        saveConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static SkillGrinds getInstance() {
        return instance;
    }
}
