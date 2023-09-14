package dev.ng5m.skillgrinds.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import static dev.ng5m.skillgrinds.util.Shared.*;

public class PlayerChatEvent implements Listener {
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent e) {
        if (cfg.getBoolean(e.getPlayer().getUniqueId() + ".typingName")) {
            e.setCancelled(true);

            cfg.set(e.getPlayer().getUniqueId() + ".tempName", fix(e.getMessage()));

            cfg.set(e.getPlayer().getUniqueId() + ".typingMessage", false);

            e.getPlayer().sendMessage(fix("&aSet name to " + fix(e.getMessage())));

            plugin.saveConfig();
        } else if (cfg.getBoolean(e.getPlayer().getUniqueId() + ".typingMessage")) {
            e.setCancelled(true);

            cfg.set(e.getPlayer().getUniqueId() + ".tempMessage", fix(e.getMessage()));

            cfg.set(e.getPlayer().getUniqueId() + ".typingName", false);

            e.getPlayer().sendMessage(fix("&aSet saying to " + fix(e.getMessage())));

            plugin.saveConfig();
        }
    }
}
