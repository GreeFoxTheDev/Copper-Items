package copper.items.items.copper.Items.Listeners;

import copper.items.items.copper.Items.CopperItems;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class ResourcepackChecker implements Listener {
    static FileConfiguration config = CopperItems.getInstance().getConfig();
    CopperItems plugin;

    public ResourcepackChecker(CopperItems plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {

        if (config.getBoolean("enable-resource-pack") == true) {
            if (!(Bukkit.getServer().getPluginManager().isPluginEnabled("EpicWeapons"))) {
                event.getPlayer().setResourcePack("https://cdn.modrinth.com/data/TQ5na7TX/versions/11fGHd4H/MPR-2.2%5B1.21.5%5D.zipfgit ");
            }
        }
    }
}
