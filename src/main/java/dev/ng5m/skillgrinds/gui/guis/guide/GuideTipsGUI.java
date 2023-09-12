package dev.ng5m.skillgrinds.gui.guis.guide;

import dev.ng5m.skillgrinds.SkillGrinds;
import dev.ng5m.skillgrinds.gui.util.outlines.OutlineDoubleChest;
import dev.ng5m.skillgrinds.spigui.buttons.SGButton;
import dev.ng5m.skillgrinds.spigui.menu.SGMenu;
import dev.ng5m.skillgrinds.util.Shared;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

import static dev.ng5m.skillgrinds.gui.util.outlines.Outline.air;

public class GuideTipsGUI extends Shared {
    public static SGMenu inv;
    public static SGMenu getInv() {
        inv = SkillGrinds.spiGUI.create(fix("&aTips"), 6);

        OutlineDoubleChest.start(inv);

        air(inv, 7);
        for (int b=0;b<3;b++) { OutlineDoubleChest.br(inv, 7); }

        OutlineDoubleChest.end(inv);

        return inv;
    }
}
