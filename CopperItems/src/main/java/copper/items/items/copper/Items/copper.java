package copper.items.items.copper.Items;

import org.bukkit.plugin.java.JavaPlugin;

public final class copper extends JavaPlugin {

    @Override
    public void onEnable() {
        spigot.items.spigot.items.Spigot.Items.init();
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
