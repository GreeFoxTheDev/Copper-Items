package copper.items.items.copper.Items.Listeners;

import copper.items.items.copper.Items.CopperItems;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class ResourcepackChecker implements Listener {
    CopperItems plugin;

    public ResourcepackChecker(CopperItems plugin) {
        this.plugin = plugin;
    }
    static FileConfiguration config = CopperItems.getInstance().getConfig();

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {

        if (config.getBoolean("enable-resource-pack") == true) {
            if (!(Bukkit.getServer().getPluginManager().isPluginEnabled("EpicWeapons"))) {
                event.getPlayer().setResourcePack("https://cdn-raw.modrinth.com/data/TQ5na7TX/versions/tRLkpZCx/EpicWepons-BETA-0.11.zip");
            }
        }
    }


}
