package de.couldbeworse.myessentials;

import de.couldbeworse.myessentials.manager.registry.CommandRegistry;
import de.couldbeworse.myessentials.manager.registry.ListenerRegistry;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public final class MyEssentials extends JavaPlugin {

    /////////////////////////////////////////////////////////////////////////////////////////////////

    public static MyEssentials instance;

    private final CommandRegistry commandRegistry = new CommandRegistry();
    private final ListenerRegistry listenerRegistry = new ListenerRegistry();

    private final List<UUID> playerFlyList = new ArrayList<>();

    /////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void onLoad() {
        instance = this;
        Bukkit.getConsoleSender().sendMessage("Instance Initialized");
    }

    @Override
    public void onEnable() {
        instance = this;

        PluginManager pluginManager = Bukkit.getPluginManager();

        commandRegistry.setup();

    }

    @Override
    public void onDisable() {
    }

    public static MyEssentials getInstance() {
        return instance;
    }

    public List<UUID> getPlayerFlyList() {
        return playerFlyList;
    }
}
