package de.couldbeworse.myessentials.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static de.couldbeworse.myessentials.util.Strings.*;

public class HelpCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {

        if (!(sender instanceof Player player)) {
            sender.sendMessage(NO_CONSOLE);
            return true;
        }

        if (!(player.hasPermission("myessentials.command.help"))) {
            player.sendMessage(NO_PERMISSION);
            return false;
        }

        switch (args.length) {
            case (1) -> {

                switch (args[0]) {
                    case ("myessentials") -> {

                        player.sendMessage(PREFIX + "List of all commands:");
                        player.sendMessage(PREFIX + "Help, Clearchat, Heal, Fly, Gamemode, God, Invsee, Ping, Playerinfo, Time, Weather, Vanish, Repair.");

                    }
                    default -> player.sendMessage(USAGE + "/help myessentials");
                }
            }
            default -> player.sendMessage(USAGE + "/help myessentials");
        }

        return true;
    }
}
