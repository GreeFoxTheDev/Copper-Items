package copper.items.items.copper.Items;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class CopperItems extends JavaPlugin {

    @Override
    public void onEnable() {
        Items.init();
        getServer().getPluginManager().registerEvents(new CopperItemsListener(this), this);
        getServer().getPluginManager().registerEvents(new ResourcepackChecker(this), this);
        ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
        console.sendMessage(ChatColor.AQUA + "***********************************");
        console.sendMessage(ChatColor.AQUA + "| Copper Items have been enabled! |");
        console.sendMessage(ChatColor.AQUA + "***********************************");
    }

    @Override
    public void onDisable() {
        ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
        console.sendMessage(ChatColor.DARK_RED + "************************************");
        console.sendMessage(ChatColor.DARK_RED + "| Copper Items have been disabled! |");
        console.sendMessage(ChatColor.DARK_RED + "************************************");
    }
}
