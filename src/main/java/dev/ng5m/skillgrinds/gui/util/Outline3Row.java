package dev.ng5m.skillgrinds.gui.util;

import dev.ng5m.skillgrinds.SkillGrinds;
import dev.ng5m.skillgrinds.spigui.buttons.SGButton;
import dev.ng5m.skillgrinds.spigui.item.ItemBuilder;
import dev.ng5m.skillgrinds.spigui.menu.SGMenu;
import dev.ng5m.skillgrinds.util.Shared;
import org.bukkit.Material;

public class Outline3Row extends Shared {
    public static void start(SGMenu menu, int guiItems) {
        for (int i=0; i < 10; i++) {
            menu.addButton(new SGButton(HelperItems.getOutlineItem()));
        }

        int airCount = 0;

        switch (guiItems) {
            case 1:
                airCount = 3;
                break;
            case 2:
                airCount = 2;
                break;
            case 3:
                airCount = 1;
                break;
        }

        for (int i = 0; i < airCount; i++) {
            menu.addButton(new SGButton(HelperItems.getAir()));
        }
    }

    public static void end(SGMenu menu, int guiItems) {
        int airCount = 0;

        switch (guiItems) {
            case 1:
                airCount = 3;
                break;
            case 2:
                airCount = 2;
                break;
            case 3:
                airCount = 1;
                break;
        }

        for (int i = 0; i < airCount; i++) {
            menu.addButton(new SGButton(HelperItems.getAir()));
        }

        for (int i=0; i < 10; i++) {
            menu.addButton(new SGButton(HelperItems.getOutlineItem()));
        }
    }
}
