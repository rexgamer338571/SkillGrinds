package dev.ng5m.skillgrinds.gui.util.outlines;

import dev.ng5m.skillgrinds.gui.util.HelperItems;
import dev.ng5m.skillgrinds.spigui.buttons.SGButton;
import dev.ng5m.skillgrinds.spigui.menu.SGMenu;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class Outline {
    public static List<ItemStack> line2, line3, line4, line5 = new ArrayList<>();

    public static void air(SGMenu menu, int air) {
        for (int i=0;i<air;i++) { menu.addButton(new SGButton(HelperItems.getAir())); }
    }

    public static void br(SGMenu menu) {
        menu.addButton(new SGButton(HelperItems.getOutlineItem()));
        menu.addButton(new SGButton(HelperItems.getOutlineItem()));
    }

    public static void br(SGMenu menu, int air) {
        menu.addButton(new SGButton(HelperItems.getOutlineItem()));
        menu.addButton(new SGButton(HelperItems.getOutlineItem()));

        air(menu, air);
    }

    public static void start(SGMenu menu) {
        for (int i=0; i < 10; i++) {
            menu.addButton(new SGButton(HelperItems.getOutlineItem()));
        }
    }

    public static void end(SGMenu menu) {
        for (int i=0; i < 10; i++) {
            menu.addButton(new SGButton(HelperItems.getOutlineItem()));
        }
    }

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
