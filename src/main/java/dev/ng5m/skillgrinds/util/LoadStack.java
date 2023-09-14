package dev.ng5m.skillgrinds.util;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;
import java.util.Objects;

public class LoadStack {
    private JavaPlugin plugin;
    private String cfgPath;
    private String id;

    private String material;
    private String name;
    private List<String> lore;

    public LoadStack(JavaPlugin plugin, String cfgPath, String id) {
        this.plugin = plugin;
        this.id = id;
        this.cfgPath = cfgPath;
    }

    public LoadStack(String material, String name, List<String> lore) {
        this.material = material;
        this.name = name;
        this.lore = lore;
    }

    public ItemStack toStack() {
        ItemStack f = new ItemStack(Material.valueOf(this.material));
        ItemMeta m = Objects.requireNonNull(f.getItemMeta());

        m.setDisplayName(Shared.fix(name));
        m.setLore(lore);

        f.setItemMeta(m);

        return f;
    }

    public String load() {
        return plugin.getConfig().getString(cfgPath + "." + id + ".material") + " | " + plugin.getConfig().getString(cfgPath + "." + id + ".name") + " | " + plugin.getConfig().getString(cfgPath + "." + id + ".lore");
    }
}
