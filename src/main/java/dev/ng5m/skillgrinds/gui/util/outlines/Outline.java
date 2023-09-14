package dev.ng5m.skillgrinds.gui.util.outlines;

import dev.ng5m.skillgrinds.gui.util.HelperItems;
import dev.ng5m.skillgrinds.spigui.buttons.SGButton;
import dev.ng5m.skillgrinds.spigui.menu.SGMenu;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class Outline {
    static int[][] borders = {{0, 1, 2, 3, 4, 5, 6, 7, 8, 17, 26, 25, 23, 22, 21, 20, 19, 18, 9}
            , {0, 1, 2, 3, 4, 5, 6, 7, 8, 17, 26, 35, 34, 33, 32, 31, 30, 29, 28, 27, 18, 9}
            , {0, 1, 2, 3, 4, 5, 6, 7, 8, 17, 26, 35, 44, 43, 42, 41, 40, 39, 38, 37, 36, 27, 18, 9}
            , {0, 1, 2, 3, 4, 5, 6, 7, 8, 17, 26, 35, 44, 53, 52, 51, 50, 49, 48, 47, 46, 45, 36, 27, 18, 9}};

    static int[] border3 = {0,1,2,3,4,5,6,7,8,9,17,18,19,20,21,22,23,24,25,26};

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

    public static void border(SGMenu inv) {
        if ((inv.getPageSize() / 9) < 3) return;

        int[] border = borders[inv.getPageSize() / 9 - 3];
        for (int j : border) {
            inv.setButton(j, new SGButton(HelperItems.getOutlineItem()));
        }
    }

    public static void border3(SGMenu inv) {
        for (int i : border3)
            inv.setButton(i, new SGButton(HelperItems.getOutlineItem()));
    }
}
