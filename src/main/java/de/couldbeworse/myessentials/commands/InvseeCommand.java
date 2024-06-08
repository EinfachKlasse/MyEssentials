package de.couldbeworse.myessentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

import static de.couldbeworse.myessentials.util.Strings.*;
import static org.bukkit.ChatColor.*;

public class InvseeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {

        if (!(sender instanceof Player player)) {
            sender.sendMessage(NO_CONSOLE);
            return true;
        }

        if (!(player.hasPermission("myessentials.command.invsee"))) {
            player.sendMessage(NO_PERMISSION);
            return true;
        }

        switch (args.length) {
            case (1) -> {
                Player targetPlayer = Bukkit.getPlayer(args[0]);

                if (targetPlayer == null) {
                    player.sendMessage(PREFIX + "Couldn't find a player named " + BLUE + args[0] + GRAY + ".");
                    return true;
                }

                if (targetPlayer == player) {
                    player.sendMessage(PREFIX + "Press E to open your inventory.");
                    return true;
                }

                Inventory targetInventory = targetPlayer.getInventory();

                player.openInventory(targetInventory);
                player.playSound(player.getLocation() , Sound.ENTITY_CHICKEN_EGG, 0.2F,1);
            }
            default -> player.sendMessage(USAGE + "/invsee <player>");
        }

        return true;
    }
}