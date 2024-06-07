package de.couldbeworse.myessentials.commands.workshops;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

import static de.couldbeworse.myessentials.util.Strings.*;

public class GrindstoneCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {

        if (!(sender instanceof Player player)) {
            sender.sendMessage(NO_CONSOLE);
            return true;
        }

        if (!(player.hasPermission("myessentials.command.workshops.grindstone"))) {
            player.sendMessage(NO_PERMISSION);
            return true;
        }

        if (args.length !=0) {
            player.sendMessage(USAGE + "/grindstone");
            return false;
        }

        Inventory grindstone = player.getOpenInventory().getTopInventory();

        if (grindstone.getType() != InventoryType.GRINDSTONE) {
            grindstone = Bukkit.createInventory(player , InventoryType.GRINDSTONE);
            player.openInventory(grindstone);
        }


        return true;
    }
}