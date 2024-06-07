package de.couldbeworse.myessentials.commands;

import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import static de.couldbeworse.myessentials.util.Strings.*;
import static org.bukkit.ChatColor.*;


public class HealCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player player)) {
            sender.sendMessage(NO_CONSOLE);
            return false;
        }

        if (!(player.hasPermission("teamcore.command.heal"))) {
            player.sendMessage(NO_PERMISSION);
            return true;
        }

        switch (args.length) {
            case (0) -> {

                if (player.getGameMode().equals(GameMode.CREATIVE)) {
                    player.sendMessage(PREFIX + "You're in creative!");
                    return true;
                }

                for (PotionEffect effect : player.getActivePotionEffects()) {
                    player.removePotionEffect(effect.getType());
                }

                if (player.isConnected()) player.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 30, 0, true));
                if (player.isUnderWater()) player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 300, 0, true));
                if (player.isInLava()) player.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 300, 0, true));

                player.setMaxHealth(player.getMaxHealth());
                player.setHealth(20);
                player.setSaturation(20);

                player.getWorld().spawnParticle(Particle.TOTEM, player.getLocation(), 50);
                player.playSound(player.getLocation() , Sound.ENTITY_PLAYER_LEVELUP, 0.2F,1);

                player.sendMessage(PREFIX + GRAY + "You've been" + GREEN.toString() + BOLD + " Healed" + GRAY + ".");
            }

            case (1) -> {

                Player playerToHeal = Bukkit.getPlayer(args[0]);

                if (playerToHeal.getGameMode().equals(GameMode.CREATIVE)) {
                    player.sendMessage(PREFIX + "Player is in creative!");
                    return true;
                }

                if (playerToHeal == null) {
                    player.sendMessage(PREFIX + "Couldn't find a player named " + BLUE + playerToHeal.getName() + GRAY + ".");
                    return true;
                }

                for (PotionEffect effect : playerToHeal.getActivePotionEffects()) {
                    playerToHeal.removePotionEffect(effect.getType());
                }

                if (playerToHeal.isConnected()) player.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 30, 0, true));
                if (playerToHeal.isUnderWater()) playerToHeal.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 300, 1, true));
                if (playerToHeal.isInLava()) playerToHeal.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 300, 1, true));

                playerToHeal.setMaxHealth(playerToHeal.getMaxHealth());
                playerToHeal.setHealth(20);
                playerToHeal.setSaturation(20);

                playerToHeal.getWorld().spawnParticle(Particle.TOTEM, player.getLocation(), 50);

                playerToHeal.playSound(playerToHeal.getLocation() , Sound.ENTITY_PLAYER_LEVELUP, 0.2F,1);

                if (playerToHeal == player) {
                    player.sendMessage(PREFIX + GRAY + "You've been" + GREEN + BOLD + " Healed" + GRAY + ".");
                    return true;
                }

                player.sendMessage(PREFIX + GRAY + "You've " + BLUE + BOLD + "healed " + GRAY  + "the player " + AQUA + BOLD + playerToHeal.getName() + GRAY + ".");

                playerToHeal.sendMessage(PREFIX + GRAY + "You've been " + BLUE + BOLD + "healed " + GRAY + "by " + AQUA + BOLD + player.getName() + GRAY  + ".");
            }
            default -> player.sendMessage(USAGE + "/heal <player>");
        }
        return true;
    }
}