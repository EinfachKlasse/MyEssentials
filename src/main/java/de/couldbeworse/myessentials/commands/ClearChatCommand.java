package de.couldbeworse.myessentials.commands;

import de.couldbeworse.myessentials.util.Strings;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static de.couldbeworse.myessentials.util.Strings.*;
import static org.bukkit.ChatColor.*;

public class ClearChatCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {

        if (!(sender instanceof Player player)) {
            sender.sendMessage(NO_CONSOLE);
            return true;
        }

        if (args.length !=0) {
            player.sendMessage(USAGE + "/clearchat");
            return true;
        }

        if (!(player.hasPermission("myessentials.command.clearchat"))) {
            player.sendMessage(NO_PERMISSION);
            return true;
        }

        int clearChat = 100;

        while (clearChat > 0) {
            player.getServer().broadcastMessage(" ");
            clearChat--;
        }

        Bukkit.getServer().broadcastMessage(GRAY + "The Chat was cleared by " + BLUE + player.getName());
        Bukkit.getServer().broadcastMessage(RED + "   → Issued due to a chat abuse.");

        return false;
    }
}

