package de.couldbeworse.myessentials.commands;

import de.couldbeworse.myessentials.util.Strings;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
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

public class GamemodeCommand implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {

        if (!(sender instanceof Player player)) {
            sender.sendMessage(NO_CONSOLE);
            return true;
        }

        switch (args.length) {
            case (1) -> {
                switch (args[0]) {
                    case ("0"), ("survival") -> {

                        if (player.hasPermission("myessentials.command.gamemode.survival")) {
                            player.sendMessage(NO_PERMISSION);
                        }

                        player.setGameMode(GameMode.SURVIVAL);
                        player.sendMessage(PREFIX + "You're now in the " + BLUE + "Survival" + GRAY + " mode!");
                    }

                    case ("1"), ("creative") -> {

                        if (player.hasPermission("myessentials.command.gamemode.creative")) {
                         player.sendMessage(NO_PERMISSION);
                        }

                        player.setGameMode(GameMode.CREATIVE);
                        player.sendMessage(PREFIX + "You're now in the " + BLUE + "Creative" + GRAY + " mode!");
                    }

                    case ("2"), ("adventure") -> {

                        if (player.hasPermission("myessentials.command.gamemode.adventure")) {
                            player.sendMessage(NO_PERMISSION);
                        }

                        player.setGameMode(GameMode.ADVENTURE);
                        player.sendMessage(PREFIX + "You're now in the " + BLUE + "Adventure" + GRAY + " mode!");
                    }

                    case ("3"), ("spectator") -> {

                        if (player.hasPermission("myessentials.command.gamemode.spectator")) {
                            player.sendMessage(NO_PERMISSION);
                        }

                        player.setGameMode(GameMode.SPECTATOR);
                        player.sendMessage(PREFIX + "You're now in the " + BLUE + "Spectator" + GRAY + " mode!");
                    }

                    default -> player.sendMessage(USAGE + "Use /gm <0|1|2|3>");
                }
            }
            default -> player.sendMessage(USAGE + "Use /gm <0|1|2|3>");
        }
        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (!(sender.hasPermission("myessentials.command.gamemode"))) return null;

        List<String> subcommands = new ArrayList<>();

        switch (args.length) {
            case (1) -> {
                subcommands.add("0");
                subcommands.add("survival");
                subcommands.add("1");
                subcommands.add("creative");
                subcommands.add("2");
                subcommands.add("adventure");
                subcommands.add("3");
                subcommands.add("spectator");
            }
            default -> {
                return null;
            }
        }

        return subcommands;
    }
}