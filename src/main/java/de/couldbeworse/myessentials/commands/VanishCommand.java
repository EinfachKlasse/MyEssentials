package de.couldbeworse.myessentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static de.couldbeworse.myessentials.util.Strings.*;
import static org.bukkit.ChatColor.BLUE;
import static org.bukkit.ChatColor.GRAY;

public class VanishCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {

        if (!(sender instanceof Player player)) {
            sender.sendMessage(NO_CONSOLE);
            return true;
        }

        if (!(player.hasPermission("myessentials.command.vanish"))) {
            player.sendMessage(NO_PERMISSION);
            return true;
        }

        switch (args.length) {
            case (0) -> {

                if (player.isInvisible()) {
                    player.setInvisible(false);
                    player.sendMessage(PREFIX + "You're not longer invisible.");
                    return true;
                }

                player.setInvisible(true);
                player.sendMessage(PREFIX + "You're now invisible,");
            }
            case (1) -> {

                Player vanishTarget = Bukkit.getPlayer(args[0]);

                if (vanishTarget == null) {
                    player.sendMessage(PREFIX + "Couldn't find a player named " + BLUE + vanishTarget.getName() + GRAY + ".");
                    return true;
                }

                if (vanishTarget.isInvisible()) {
                    vanishTarget.setInvisible(false);
                    vanishTarget.sendMessage(PREFIX + "You're not longer invisible.");

                    if (vanishTarget == player) {
                        return true;
                    }

                    player.sendMessage(PREFIX + vanishTarget.getName() + " is not longer invisible.");

                    return true;
                }

                vanishTarget.setInvisible(true);
                vanishTarget.sendMessage(PREFIX + "You're now invisible.");

                if (vanishTarget == player) {
                    return true;
                }

                player.sendMessage(PREFIX + vanishTarget.getName() + " is now invisible.");
            }
            default -> player.sendMessage(USAGE + "/vanish <player>");
        }
        return true;
    }
}
