package copper.items.items.copper.Items;

import org.bukkit.plugin.java.JavaPlugin;

public final class CopperItems extends JavaPlugin {
    public static CopperItems PLUGIN;

    public static CopperItems getPlugin() {
        return PLUGIN;
    }

    @Override
    public void onEnable() {
        PLUGIN = this;
        Items.init();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
