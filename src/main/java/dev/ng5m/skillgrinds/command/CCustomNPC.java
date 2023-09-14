package dev.ng5m.skillgrinds.command;

import dev.ng5m.skillgrinds.gui.guis.npcmaker.NPCCreatorGUI;
import org.bukkit.Bukkit;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

import static dev.ng5m.skillgrinds.util.Shared.*;

public class CCustomNPC implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(fix("&cThis command must be run by a player!"));
        } else {
            Player p = (Player) sender;

            p.openInventory(NPCCreatorGUI.getInv().getInventory());
        }

        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        List<String> result = new ArrayList<>();

        if (args.length == 0 || args.length == 1) {
            for (EntityType t : EntityType.values()) {
                result.add(t.toString());
            }
        }

        return result;
    }
}
