package de.couldbeworse.myessentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static de.couldbeworse.myessentials.util.Strings.*;

public class FeedCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {

        if (!(sender instanceof Player player)) {
            sender.sendMessage(NO_CONSOLE);
            return true;
        }

        if (!(player.hasPermission("myessentials.command.feed"))) {
            player.sendMessage(NO_PERMISSION);
            return true;
        }

        switch (args.length) {
            case (0) -> {
                player.getSaturation();
                player.setSaturation(20);
                player.sendMessage(PREFIX + "You're saturation is filled up.");
            }

            case (1) -> {
                Player target = Bukkit.getPlayer(args[0]);
                    target.getSaturation();
                    target.setSaturation(20);
                    target.sendMessage(PREFIX + "You're saturation is filled up.");

                    if (target == player) {
                        return true;
                    }

                    player.sendMessage(PREFIX + "You filled " + target.getName() + "'s saturation up.");
            }
            default -> player.sendMessage(USAGE + "/feed <player>");
        }

        return true;
    }
}
