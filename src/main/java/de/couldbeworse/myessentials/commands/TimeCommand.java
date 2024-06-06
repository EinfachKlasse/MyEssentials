package de.couldbeworse.myessentials.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

import static de.couldbeworse.myessentials.util.Strings.*;
import static org.bukkit.ChatColor.*;

public class TimeCommand implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {

        if (!(sender instanceof Player player)) {
            sender.sendMessage(NO_CONSOLE);
            return true;
        }

        if (!(player.hasPermission("teamcore.commands.time"))) {
            player.sendMessage(NO_PERMISSION);
            return true;
        }

        switch (args.length) {
            case (1) -> {
                switch (args[0]) {
                    case ("day") -> {
                        player.getWorld().setTime(0);
                        player.sendMessage(PREFIX + "Time set to " + BLUE + "day" + GRAY + ".");
                    }

                    case ("night") -> {
                        player.getWorld().setTime(14000);
                        player.sendMessage(PREFIX + "Time set to " + BLUE + "night" + GRAY + ".");
                    }


                    default -> player.sendMessage(USAGE + "/time <day|night>");
                }
            }
            default -> player.sendMessage(USAGE + "/time <day|night>");
        }


        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (!(sender.hasPermission("myessentials.commands.time"))) return null;

        List<String> subcommands = new ArrayList<>();

        switch (args.length) {
            case (1) -> {
                subcommands.add("day");
                subcommands.add("night");
            }
            default -> {
                return null;
            }
        }

        return subcommands;
    }
}
