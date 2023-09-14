package dev.ng5m.skillgrinds.command;

import dev.ng5m.skillgrinds.gui.guis.guide.GuideTipsGUI;
import dev.ng5m.skillgrinds.util.WriteStack;
import org.bukkit.command.Command;
import org.bukkit.command.CommandException;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;

import static dev.ng5m.skillgrinds.util.Shared.*;

public class CSkillGrindsManager implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;

            if (args.length == 3) {

                if (args[0].equalsIgnoreCase("tips")) {
                    if (args[1].equalsIgnoreCase("add")) {
                        new WriteStack(plugin, "villagers.guideVillager.tipsList", p.getInventory().getItemInMainHand(), args[2]);
                    }
                }

            }
        } else {
            sender.sendMessage(fix("&cThis command must be ran by a player!"));
        }

        return true;
    }
}
