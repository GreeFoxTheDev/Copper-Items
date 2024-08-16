package copper.items.items.copper.Items.Commands;

import copper.items.items.copper.Items.CopperItems;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CopperItemsCommand implements CommandExecutor {
    CopperItems plugin;
    public CopperItemsCommand(CopperItems plugin) {
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, String label, String[] args){
        if (label.equalsIgnoreCase("copperitems")){
            if (args.length == 0){
                if (sender instanceof Player){
                    sender.sendMessage(ChatColor.GREEN + "CopperItems by Greefox");
                    sender.sendMessage(ChatColor.WHITE + "   Version: " +  ChatColor.GREEN + "2.0");
                    sender.sendMessage(ChatColor.WHITE + "   Give Command: " + ChatColor.GREEN + "/givecopperitem");
                    sender.sendMessage(ChatColor.BLUE + "   Visit my discord server for more!");
                }
            }
        }
    return true; }

}
