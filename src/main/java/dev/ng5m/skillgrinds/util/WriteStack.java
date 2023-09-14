package dev.ng5m.skillgrinds.util;

import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;
import java.util.Objects;

public class WriteStack {
    private final JavaPlugin plugin;
    private final String cfgPath;
    private final Material material;
    private final String name;
    private final List<String> lore;
    private final String id;

    public WriteStack(JavaPlugin plugin, String cfgPath, Material material, String name, List<String> lore, String id) {
        this.plugin = plugin;
        this.cfgPath = cfgPath;
        this.material = material;
        this.name = name;
        this.lore = lore;
        this.id = id;

        write();
    }

    public WriteStack(JavaPlugin plugin, String cfgPath, ItemStack itemStack, String id) {
        ItemMeta meta = Objects.requireNonNull(itemStack.getItemMeta());

        this.plugin = plugin;
        this.cfgPath = cfgPath;
        this.material = itemStack.getType();
        this.name = meta.getDisplayName();
        this.lore = meta.getLore();
        this.id = id;

        write();
    }

    private void write() {
        plugin.getConfig().set(cfgPath + "." + this.id + ".material", this.material);
        plugin.getConfig().set(cfgPath + "." + this.id + ".name", this.name);
        plugin.getConfig().set(cfgPath + "." + this.id + ".lore", this.lore);
    }
}
