package dev.ng5m.skillgrinds;

import dev.ng5m.skillgrinds.command.CCustomNPC;
import dev.ng5m.skillgrinds.command.CCustomVillager;
import dev.ng5m.skillgrinds.command.CSkillGrindsManager;
import dev.ng5m.skillgrinds.command.CUpdate;
import dev.ng5m.skillgrinds.spigui.SpiGUI;
import dev.ng5m.skillgrinds.util.Shared;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Objects;

public final class SkillGrinds extends JavaPlugin {
    private static SkillGrinds instance;
    public static SpiGUI spiGUI;

    @Override
    public void onEnable() {
        instance = this;
        spiGUI = new SpiGUI(this);

        Shared.registerListeners(this);

        Objects.requireNonNull(getCommand("customvillager")).setExecutor(new CCustomVillager());
//        Objects.requireNonNull(getCommand("skillgrindsmanager")).setExecutor(new CSkillGrindsManager());
        Objects.requireNonNull(getCommand("customnpc")).setExecutor(new CCustomNPC());

        if (!getConfig().isSet("villagers.resetOnReload"))
            getConfig().set("villagers.resetOnReload", false);
        else {
            if (getConfig().getBoolean("villagers.resetOnReload")) {
                getConfig().set("villagers.guideVillager.name", Shared.fix("&aGuide"));

                getConfig().set("villagers.guideVillager.tipsList", "");
            }
        }

        saveConfig();

        CUpdate.update();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static SkillGrinds getInstance() {
        return instance;
    }
}
