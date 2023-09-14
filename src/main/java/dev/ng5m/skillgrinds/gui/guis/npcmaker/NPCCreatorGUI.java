package dev.ng5m.skillgrinds.gui.guis.npcmaker;

import dev.ng5m.skillgrinds.SkillGrinds;
import dev.ng5m.skillgrinds.gui.util.HelperItems;
import dev.ng5m.skillgrinds.gui.util.outlines.Outline;
import dev.ng5m.skillgrinds.spigui.buttons.SGButton;
import dev.ng5m.skillgrinds.spigui.item.ItemBuilder;
import dev.ng5m.skillgrinds.spigui.menu.SGMenu;
import dev.ng5m.skillgrinds.util.Shared;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;

public class NPCCreatorGUI extends Shared {
    public static SGMenu inv;
    public static SGMenu getInv() {
        inv = SkillGrinds.spiGUI.create(fix("&a&lNPC CREATOR"), 3);
        Outline.border3(inv);

        inv.setButton(12, new SGButton(new ItemBuilder(Material.PAPER).name(fix("&r&a&lSET NAME")).build()).withListener((InventoryClickEvent e) -> {
            cfg.set(e.getWhoClicked().getUniqueId() + ".typingName", true);
            e.getWhoClicked().closeInventory();
            e.getWhoClicked().sendMessage(fix("&aEnter your NPC's name: "));
        }));

        inv.setButton(14, new SGButton(new ItemBuilder(Material.PAPER).name(fix("&r&a&lSET MESSSAGE")).build()).withListener((InventoryClickEvent e) -> {
            cfg.set(e.getWhoClicked().getUniqueId() + ".typingMessage", true);
            e.getWhoClicked().closeInventory();
            e.getWhoClicked().sendMessage(fix("&aEnter your NPC's saying: "));
        }));

        return inv;
    }
}
