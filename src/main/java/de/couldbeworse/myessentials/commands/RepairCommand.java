package de.couldbeworse.myessentials.commands;

import de.couldbeworse.myessentials.util.Strings;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import static de.couldbeworse.myessentials.util.Strings.*;

public class RepairCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {


        if (!(sender instanceof Player player)) {
            sender.sendMessage(NO_CONSOLE);
            return true;
        }

        if (!(player.hasPermission("myessentials.command.repair"))) {
            player.sendMessage(NO_PERMISSION);
            return true;
        }

        if (args.length !=0) {
            player.sendMessage(USAGE + "/repair");
            return true;
        }

        ItemStack itemToRepair = player.getInventory().getItemInMainHand();

        if (itemToRepair.getDurability() > 0) {

            itemToRepair.setDurability((short) 0);
            player.sendMessage(PREFIX + "Item repaired.");
        }
        return true;
    }
}
