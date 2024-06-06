package de.couldbeworse.myessentials.manager.registry;

import de.couldbeworse.myessentials.MyEssentials;
import de.couldbeworse.myessentials.commands.*;
import org.bukkit.command.CommandExecutor;

public class CommandRegistry {

    public void setup() {

        register("clearchat" , new ClearChatCommand());
        register("help" , new HelpCommand());
        register("gm" , new GamemodeCommand());
        register("fly" , new FlyCommand());
        register("heal" , new HealCommand());
        register("ping" , new PingCommand());
        register("time" , new TimeCommand());
        register("weather" , new WeatherCommand());
        register("invsee" , new InvseeCommand());
        register("playerinfo" , new PlayerInfoCommand());
        register("god" , new GodCommand());
        register("feed" , new FeedCommand());
//        register("lightning" , new LightningCommand());

    }

    public void register(String command, CommandExecutor commandExecutor) {
        MyEssentials.getInstance().getCommand(command).setExecutor(commandExecutor);
    }
}
