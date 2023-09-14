package dev.ng5m.skillgrinds.gui.guis.guide;

import com.google.gson.JsonObject;
import dev.ng5m.skillgrinds.SkillGrinds;
import dev.ng5m.skillgrinds.spigui.buttons.SGButton;
import dev.ng5m.skillgrinds.spigui.menu.SGMenu;
import dev.ng5m.skillgrinds.util.LoadStack;
import dev.ng5m.skillgrinds.util.Shared;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import static dev.ng5m.skillgrinds.gui.util.outlines.Outline.*;

public class GuideTipsGUI extends Shared {
    public static List<ItemStack> tipItems = new ArrayList<>();

    public static SGMenu inv;
    public static SGMenu getInv() {
        inv = SkillGrinds.spiGUI.create(fix("&aTips"), 6);

        border(inv);

        for (String k : Objects.requireNonNull(cfg.getConfigurationSection("villagers.guideVillager.tipsList")).getKeys(false)) {
            tipItems.add(new LoadStack(cfg.getString(k + ".material"), cfg.getString(k + ".name"), cfg.getStringList(k + ".lore")).toStack());
        }

        for (int i = 0; i < tipItems.size(); i++) {
            inv.setButton(i + 10, new SGButton(tipItems.get(i)));
        }

        border(inv);

        return inv;
    }
}
