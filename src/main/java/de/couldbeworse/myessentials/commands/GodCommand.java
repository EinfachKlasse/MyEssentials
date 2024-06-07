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

public class GodCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {

        if (!(sender instanceof Player player)) {
            sender.sendMessage(NO_CONSOLE);
            return true;
        }

        if (!(player.hasPermission("myessentials.command.god"))) {
            player.sendMessage(NO_PERMISSION);
            return true;
        }

        switch (args.length) {
            case (0) -> {

                if (player.isInvulnerable()) {

                    player.setInvulnerable(false);
                    player.setGlowing(false);
                    player.sendMessage(PREFIX + "You're not longer invulnerable.");

                } else {

                    player.setInvulnerable(true);
                    player.setGlowing(true);
                    player.getMaxHealth();
                    player.setHealth(20);
                    player.sendMessage(PREFIX + "You're now invulnerable.");
                }
            }

            case (1) -> {

                Player target = Bukkit.getPlayer(args[0]);

                if (target == null) {
                    player.sendMessage(PREFIX + "Couldn't find a player named " + BLUE + target.getName() + GRAY + ".");
                    return true;
                }

                if (target.isInvulnerable()) {
                    target.setGlowing(false);
                    target.setInvulnerable(false);
                    target.sendMessage(PREFIX + "You're not longer invulnerable.");

                    if (target == player) {
                        return true;
                    }

                    player.sendMessage(PREFIX + target.getName() + " is now invulnerable.");

                } else {

                    target.setInvulnerable(true);
                    target.setGlowing(true);
                    target.getMaxHealth();
                    target.setHealth(20);
                    target.sendMessage(PREFIX + "You're now invulnerable.");

                    if (target == player) {
                        return true;
                    }

                    player.sendMessage(PREFIX + target.getName() + " is not longer invulnerable.");
                }
            }
            default -> player.sendMessage(USAGE + "/god <player>");
        }

        return true;
    }
}
