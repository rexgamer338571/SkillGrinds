package dev.ng5m.skillgrinds.gui.util;

import dev.ng5m.skillgrinds.util.Shared;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class HelperItems extends Shared {
    public static ItemStack getOutlineItem() {
        ItemStack outlineItem = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
        ItemMeta  meta = outlineItem.getItemMeta();

        assert meta != null;
        meta.setDisplayName(fix("&0 "));

        outlineItem.setItemMeta(meta);

        return outlineItem;
    }

    public static ItemStack getAir() {
        return new ItemStack(Material.AIR);
    }
}
