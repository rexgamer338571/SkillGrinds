package dev.ng5m.skillgrinds.util;

import dev.ng5m.skillgrinds.SkillGrinds;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Shared {
    public static SkillGrinds plugin = SkillGrinds.getInstance();
    public static FileConfiguration cfg = plugin.getConfig();
    public static List<Listener> listeners = new ArrayList<>();

    public static void registerListener(Listener listener) {
        listeners.add(listener);
    }

    public static void registerListeners(Plugin plugin) {
        for (Listener l : listeners)
            plugin.getServer().getPluginManager().registerEvents(l, plugin);
    }

    public static void registerConfigEntries(List<String> paths, List<Object> values) {
        for (int i = 0; i < paths.size(); i++) {
            cfg.set(paths.get(i), values.get(i));
        }

        plugin.saveConfig();
    }

    public static String fix(String str) {
        Pattern pattern = Pattern.compile("&(#[a-fA-F0-9]{6})");

        for (Matcher matcher = pattern.matcher(str); matcher.find(); matcher = pattern.matcher(str)) {
            String color = str.substring(matcher.start() + 1, matcher.end());
            str = str.replace("&" + color, "" + ChatColor.valueOf(color));
        }

        return ChatColor.translateAlternateColorCodes('&', str).replace(">>", "Â»").replace("<<", "Â«").replace("->", "â†�").replace("**", "â€˘");
    }

}
