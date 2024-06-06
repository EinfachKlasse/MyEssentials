package de.couldbeworse.myessentials.commands;

import de.couldbeworse.myessentials.MyEssentials;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static de.couldbeworse.myessentials.util.Strings.*;

public class FlyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage(NO_CONSOLE);
            return true;
        }

        if (args.length != 0) {
            player.sendMessage(USAGE + "/fly");
            return true;
        }

        if (!(player.hasPermission("teamcore.commands.fly"))) {
            player.sendMessage(NO_PERMISSION);
            return true;
        }

        if (!(MyEssentials.getInstance().getPlayerFlyList().contains(player.getUniqueId()))) {

            player.setAllowFlight(true);
            MyEssentials.getInstance().getPlayerFlyList().add(player.getUniqueId());
            player.sendMessage(PREFIX + "Fly enabled.");
        } else {

            player.setAllowFlight(false);
            MyEssentials.getInstance().getPlayerFlyList().remove(player.getUniqueId());
            player.sendMessage(PREFIX + "Fly disabled.");
        }
        return true;
    }
}
