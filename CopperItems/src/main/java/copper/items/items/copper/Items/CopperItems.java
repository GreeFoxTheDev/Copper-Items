package copper.items.items.copper.Items;

import copper.items.items.copper.Items.Commands.Give;
import copper.items.items.copper.Items.Listeners.CopperItemsListener;
import copper.items.items.copper.Items.Listeners.ResourcepackChecker;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

import static copper.items.items.copper.Items.Items.config;

public final class CopperItems extends JavaPlugin {

    private File en_US_file;
    private static FileConfiguration en_US;
    public static FileConfiguration get_en_US(){
        return en_US;
    }

    private File UK_file;
    private static FileConfiguration UK;
    public static FileConfiguration getUK(){
        return UK;
    }
    private static CopperItems instance;

    public static CopperItems getInstance() {
        return instance;
    }
    public static FileConfiguration getCurrentLang() {
        FileConfiguration en_US = get_en_US();
        FileConfiguration UK = getUK();
        if (config.getString("language").equalsIgnoreCase("en_US")){
            return en_US;
        }
        if (config.getString("language").equalsIgnoreCase("UK")){
            return UK;
        } else return en_US;
    }
    private void create_en_US() {
        en_US_file = new File(getDataFolder(), "en_US.yml");
        if (!en_US_file.exists()) {
            en_US_file.getParentFile().mkdirs();
            saveResource("en_US.yml", false);
        }

        en_US = new YamlConfiguration();
        try {
            en_US.load(en_US_file);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    private void createUK() {
        UK_file = new File(getDataFolder(), "UK.yml");
        if (!UK_file.exists()) {
            UK_file.getParentFile().mkdirs();
            saveResource("UK.yml", false);
        }

        UK = new YamlConfiguration();
        try {
            UK.load(UK_file);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onEnable() {
        instance = this;
        reloadConfig();
        create_en_US();
        createUK();

        FileConfiguration config = this.getConfig();

        config.addDefault("language", "en_US");
        config.addDefault("copper-items.copper-axe.enable", true);
        config.addDefault("copper-items.copper-axe.attack-damage", 9.5);
        config.addDefault("copper-items.copper-axe.attack-speed", 0.8);
        config.addDefault("copper-items.copper-sword.enable", true);
        config.addDefault("copper-items.copper-sword.attack-damage", 6.5);
        config.addDefault("copper-items.copper-sword.attack-damage", 1.6);
        config.addDefault("copper-items.copper-pickaxe.enable", true);
        config.addDefault("copper-items.copper-shovel.enable", true);
        config.addDefault("copper-items.copper-hoe.enable", true);

        config.addDefault("copper-armor.copper-helmet.enable", true);
        config.addDefault("copper-armor.copper-chestplate.enable", true);
        config.addDefault("copper-armor.copper-leggings.enable", true);
        config.addDefault("copper-armor.copper-boots.enable", true);

        saveDefaultConfig();


        Objects.requireNonNull(this.getCommand("givecopperitem")).setExecutor(new Give(this));
        Objects.requireNonNull(this.getCommand("givecopperitem")).setTabCompleter(new Give(this));

        getServer().getPluginManager().registerEvents(new CopperItemsListener(this), this);
        getServer().getPluginManager().registerEvents(new ResourcepackChecker(this), this);

        Items.init();
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
