package de.couldbeworse.myessentials.commands;

import de.couldbeworse.myessentials.util.IntegerUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.checkerframework.checker.units.qual.Prefix;
import org.jetbrains.annotations.NotNull;

import static de.couldbeworse.myessentials.util.Strings.*;
import static org.bukkit.ChatColor.*;

public class SetLevelCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {

        if (!(sender instanceof Player player)) {
            sender.sendMessage(NO_CONSOLE);
            return true;
        }

        if (!(player.hasPermission("myessentials.command.setlevel"))) {
            player.sendMessage(NO_PERMISSION);
            return true;
        }

        switch (args.length) {
            case (1) -> {
                int targetLevel = Integer.parseInt(args[0]);

                player.setLevel(targetLevel);
                player.sendMessage(PREFIX + "Your level is now set to " + BLUE + targetLevel + GRAY + ".");
            }
            case (2) -> {
                int targetLevel = Integer.parseInt(args[0]);
                Player target = Bukkit.getPlayer(args[1]);

                if (target == null) {
                    player.sendMessage(PREFIX + "Couldn't find a player named " + BLUE + args[1] + GRAY + ".");
                    return true;
                }

                target.setLevel(targetLevel);

                if (target == player) {
                    player.sendMessage(PREFIX + "Your level is now set to " + BLUE + targetLevel + GRAY + ".");
                    return true;
                }
                target.sendMessage(PREFIX + "Your level is now set to " + BLUE + targetLevel + GRAY + ".");
                player.sendMessage(PREFIX + BLUE + target.getName() + "'s" + GRAY + "level is now set to " + BLUE + targetLevel + GRAY + ".");
            }
            default -> player.sendMessage(USAGE + "/setlevel <level> <player>");
        }
        return true;
    }
}
