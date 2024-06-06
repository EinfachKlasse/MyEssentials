//package de.couldbeworse.myessentials.commands;
//
//import org.bukkit.Bukkit;
//import org.bukkit.Location;
//import org.bukkit.command.Command;
//import org.bukkit.command.CommandExecutor;
//import org.bukkit.command.CommandSender;
//import org.bukkit.entity.Player;
//import org.jetbrains.annotations.NotNull;
//
//import static de.couldbeworse.myessentials.util.Strings.*;
//
//public class LightningCommand implements CommandExecutor {
//    @Override
//    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
//
//          /////////////////////////////////////////////////////////////////////////////////////////////////
//
//                                            STILL IN PROGRESS, NOT WORKING.
//
//          /////////////////////////////////////////////////////////////////////////////////////////////////
//
//        if (!(sender instanceof Player player)) {
//            sender.sendMessage(NO_CONSOLE);
//            return true;
//        }
//
//        if (!(player.hasPermission("myessentials.command.lightning"))) {
//            player.sendMessage(NO_PERMISSION);
//            return true;
//        }
//
//        switch (args.length) {
//            case (1) -> {
//                Player target = Bukkit.getPlayer(args[0]);
//
//                target.getLocation().getWorld().strikeLightning((Location) target);
//            }
//        }
//
//        return true;
//    }
//}
