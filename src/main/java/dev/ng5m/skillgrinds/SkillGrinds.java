package dev.ng5m.skillgrinds;

import dev.ng5m.skillgrinds.util.Shared;
import org.bukkit.plugin.java.JavaPlugin;

public final class SkillGrinds extends JavaPlugin {
    private static SkillGrinds instance;

    @Override
    public void onEnable() {
        instance = this;

        Shared.registerListeners(this);

        getConfig().set("villagers.guideVillager.name", Shared.fix("&aGuide"));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static SkillGrinds getInstance() {
        return instance;
    }
}
