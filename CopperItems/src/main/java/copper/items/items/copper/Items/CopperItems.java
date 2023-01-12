package copper.items.items.copper.Items;

import org.bukkit.plugin.java.JavaPlugin;

public final class CopperItems extends JavaPlugin {

    @Override
    public void onEnable() {
        Items.init();
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
