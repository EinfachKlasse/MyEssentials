package de.couldbeworse.myessentials.commands.workshops;

import de.couldbeworse.myessentials.util.Strings;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

import static de.couldbeworse.myessentials.util.Strings.*;

public class WorkbenchCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {

        if (!(sender instanceof Player player)) {
            sender.sendMessage(NO_CONSOLE);
            return true;
        }

        if (!(player.hasPermission("myessentials.command.workshops.workbench"))) {
            player.sendMessage(NO_PERMISSION);
            return true;
        }

        if (args.length !=0) {
            player.sendMessage(USAGE + "/workbench");
            return false;
        }

        Inventory workbench = player.getOpenInventory().getTopInventory();

        if (workbench.getType() != InventoryType.WORKBENCH) {
            workbench = Bukkit.createInventory(player , InventoryType.WORKBENCH);
            player.openInventory(workbench);
        }


        return true;
    }
}
