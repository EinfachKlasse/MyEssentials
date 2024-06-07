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

public class EnchantmentTableCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {

        if (!(sender instanceof Player player)) {
            sender.sendMessage(NO_CONSOLE);
            return true;
        }

        if (!(player.hasPermission("myessentials.command.workshops.enchantmenttable"))) {
            player.sendMessage(NO_PERMISSION);
            return true;
        }

        if (args.length !=0) {
            player.sendMessage(USAGE + "/enchantmenttable");
            return false;
        }

        Inventory enchanting = player.getOpenInventory().getTopInventory();

        if (enchanting.getType() != InventoryType.ENCHANTING) {
            enchanting = Bukkit.createInventory(player , InventoryType.ENCHANTING);
            player.openInventory(enchanting);
        }


        return true;
    }
}
