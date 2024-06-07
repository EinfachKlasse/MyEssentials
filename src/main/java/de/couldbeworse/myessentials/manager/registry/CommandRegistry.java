package de.couldbeworse.myessentials.manager.registry;

import de.couldbeworse.myessentials.MyEssentials;
import de.couldbeworse.myessentials.commands.*;
import de.couldbeworse.myessentials.commands.workshops.*;
import org.bukkit.command.CommandExecutor;

public class CommandRegistry {

    public void setup() {

//        Player

        register("help" , new HelpCommand());
        register("fly" , new FlyCommand());
        register("heal" , new HealCommand());
        register("ping" , new PingCommand());
        register("repair" , new RepairCommand());

//      Workshop's

        register("anvil" , new AnvilCommand());
        register("enchantmenttable" , new EnchantmentTableCommand());
        register("cartography" , new CartographyCommand());
        register("loom" , new LoomCommand());
        register("stonecutter" , new StonecutterCommand());
        register("grindstone" , new GrindstoneCommand());
        register("workbench" , new WorkbenchCommand());
        register("smithingtable" , new SmithingtableCommand());

//        Moderation

        register("clearchat" , new ClearChatCommand());
        register("gm" , new GamemodeCommand());
        register("time" , new TimeCommand());
        register("weather" , new WeatherCommand());
        register("invsee" , new InvseeCommand());
        register("playerinfo" , new PlayerInfoCommand());
        register("god" , new GodCommand());
        register("vanish" , new VanishCommand());

    }

    public void register(String command, CommandExecutor commandExecutor) {
        MyEssentials.getInstance().getCommand(command).setExecutor(commandExecutor);
    }
}
