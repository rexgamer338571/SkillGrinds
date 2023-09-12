package dev.ng5m.skillgrinds.command;

import dev.ng5m.skillgrinds.util.Shared;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;

public class CCustomVillager extends Shared implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(fix("&cThis command must be ran by a player!"));
        } else {
            Player p = (Player) sender;

            if (args.length >= 1) {
                String name = "";

                if (!(args.length == 1))
                    for (String arg : args) {
                        name += arg + " ";
                    }
                else
                    name = args[0];

                Villager entity = (Villager) p.getWorld().spawnEntity(p.getLocation(), EntityType.VILLAGER);
                AttributeInstance attribs = entity.getAttribute(Attribute.GENERIC_MAX_HEALTH);
                assert attribs != null;
                attribs.setBaseValue(200D);
                entity.setHealth(200);

                entity.setCustomNameVisible(true);
                entity.setInvulnerable(true);
                entity.setAI(false);
                entity.setCustomName(fix(name));

            } else {
                p.sendMessage(fix("&cInvalid arguments!"));
            }
        }

        return true;
    }
}
