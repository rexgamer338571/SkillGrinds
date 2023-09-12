package dev.ng5m.skillgrinds.listener;

import dev.ng5m.skillgrinds.gui.guis.guide.GuideGUI;
import dev.ng5m.skillgrinds.util.Shared;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import java.util.Objects;

public class VillagerInteractEvent extends Shared implements Listener {
    @EventHandler
    public void onPlayerInteract(PlayerInteractEntityEvent e) {
        Player p = e.getPlayer();
        Entity entity = e.getRightClicked();

        if (entity instanceof Villager) {
            if (Objects.equals(entity.getName(), cfg.getString("villagers.guideVillager.name"))
                    || Objects.equals(entity.getCustomName(), cfg.getString("villagers.guideVillager.name"))) {

                p.openInventory(GuideGUI.getInv().getInventory());
            }
        }
    }

}
