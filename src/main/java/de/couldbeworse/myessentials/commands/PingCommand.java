package de.couldbeworse.myessentials.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static de.couldbeworse.myessentials.util.Strings.*;
import static org.bukkit.ChatColor.*;

public class PingCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {

        if (!(sender instanceof Player player)) {
            sender.sendMessage(NO_CONSOLE);
            return true;
        }

        if (args.length !=0) {
            player.sendMessage(USAGE + "/ping");
            return true;
        }

        if (!(player.hasPermission("myessentials.command.ping"))) {
            player.sendMessage(NO_PERMISSION);
            return true;
        }

        player.sendMessage(PREFIX + "Ping: " + BLUE + player.getPing());

        return true;
    }
}
