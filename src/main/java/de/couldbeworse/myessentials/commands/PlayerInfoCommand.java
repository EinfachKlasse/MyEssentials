package de.couldbeworse.myessentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static de.couldbeworse.myessentials.util.Strings.*;
import static org.bukkit.ChatColor.*;

public class PlayerInfoCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {

        if (!(sender instanceof Player player)) {
            sender.sendMessage(NO_CONSOLE);
            return true;
        }

        if (!(player.hasPermission("myessentials.command.playerinfo"))) {
            player.sendMessage(NO_PERMISSION);
            return true;
        }

        switch (args.length) {
            case (1) -> {

                Player target = Bukkit.getPlayer(args[0]);

                player.sendMessage(" ");
                player.sendMessage(PREFIX + BLUE + target.getName().toLowerCase() + WHITE + " Username");
                player.sendMessage(PREFIX + BLUE + target.getAddress().toString().toLowerCase() + WHITE + " Address");
                player.sendMessage(PREFIX + BLUE + target.getClientBrandName().toLowerCase() + WHITE + " Client");
                player.sendMessage(PREFIX + BLUE + target.getPing() + WHITE + " Ping");
                player.sendMessage(PREFIX + BLUE + target.getWorld().getName() + WHITE + " World");
                player.sendMessage(" ");
            }
            default -> player.sendMessage(USAGE + "/playerinfo <player>");
        }
        return true;
    }
}