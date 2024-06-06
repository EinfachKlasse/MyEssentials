package de.couldbeworse.myessentials.commands;

import org.bukkit.*;
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

public class WeatherCommand implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {

        if (!(sender instanceof Player player)) {
            sender.sendMessage(NO_CONSOLE);
            return true;
        }

        if (args.length !=1) {
            player.sendMessage(USAGE + "/weather <sun|rain|thunder>");
            return true;
        }

        if (!(player.hasPermission("myessentials.command.weather"))) {
            player.sendMessage(NO_PERMISSION);
        }

        World world = Bukkit.getWorld(player.getWorld().getName());

        switch (args[0]) {
            case ("sun") -> {
                world.setStorm(true);
                world.setClearWeatherDuration(900);
                player.playSound(player.getLocation() , Sound.ENTITY_PLAYER_LEVELUP, 0.2F,1);
                player.sendMessage(PREFIX + WHITE + "Weather is changing to " + BLUE + "sunny");
                return true;
            }

            case ("rain") -> {
                world.setStorm(false);
                world.setWeatherDuration(600);
                player.playSound(player.getLocation() , Sound.ENTITY_PLAYER_LEVELUP, 0.2F,1);
                player.sendMessage(PREFIX + WHITE + "Weather is changing to " + BLUE + "rainy");
                return true;
            }

            case ("thunder") -> {
                world.setThundering(true);
                world.setThunderDuration(600);
                player.playSound(player.getLocation() , Sound.ENTITY_PLAYER_LEVELUP, 0.2F,1);
                player.sendMessage(PREFIX + WHITE + "Weather is changing to " + BLUE + "thunder");
                return true;
            }
        }
        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (!(sender.hasPermission("myessentials.command.weather"))) return null;

        List<String> subcommands = new ArrayList<>();

        switch (args.length) {
            case (1) -> {
                subcommands.add("sun");
                subcommands.add("rain");
                subcommands.add("thunder");
            }
            default -> {
                return null;
            }
        }

        return subcommands;
    }
}