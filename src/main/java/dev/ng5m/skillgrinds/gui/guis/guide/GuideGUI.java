package dev.ng5m.skillgrinds.gui.guis.guide;

import dev.ng5m.skillgrinds.SkillGrinds;
import dev.ng5m.skillgrinds.gui.util.outlines.Outline3Row;
import dev.ng5m.skillgrinds.spigui.buttons.SGButton;
import dev.ng5m.skillgrinds.spigui.item.ItemBuilder;
import dev.ng5m.skillgrinds.spigui.menu.SGMenu;
import dev.ng5m.skillgrinds.util.Shared;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;

public class GuideGUI extends Shared {
    public static SGMenu inv;
    public static SGMenu getInv() {
        inv = SkillGrinds.spiGUI.create(cfg.getString("villagers.guideVillager.name"), 3);

        Outline3Row.start(inv, 1);

        inv.addButton(new SGButton(new ItemBuilder(Material.PAPER).name(fix("&aTips")).build()).withListener((InventoryClickEvent e) -> {
            e.getWhoClicked().openInventory(GuideTipsGUI.getInv().getInventory());
        }));

        Outline3Row.end(inv, 1);

        return inv;
    }
}
