package de.couldbeworse.myessentials.commands;

import de.couldbeworse.myessentials.util.Strings;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static de.couldbeworse.myessentials.util.Strings.*;

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
                    player.sendMessage(PREFIX + "You're not longer invulnerable.");

                } else {

                    player.setInvulnerable(true);
                    player.getMaxHealth();
                    player.setHealth(20);
                    player.sendMessage(PREFIX + "You're now invulnerable.");
                }
            }

            case (1) -> {

                Player target = Bukkit.getPlayer(args[0]);

                if (target.isInvulnerable()) {
                    target.setInvulnerable(false);
                    target.sendMessage(PREFIX + "You're not longer invulnerable.");

                    if (target == player) {
                        return true;
                    }

                    player.sendMessage(PREFIX + target.getName() + " is now invulnerable.");

                } else {

                    target.setInvulnerable(true);
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
