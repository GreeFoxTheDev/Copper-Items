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
    private File GE_file;
    private static FileConfiguration GE;
    public static FileConfiguration get_GE(){
        return GE;
    }
    private File ES_file;
    private static FileConfiguration ES;
    public static FileConfiguration getES(){
        return ES;
    }
    private static CopperItems instance;

    public static CopperItems getInstance() {
        return instance;
    }
    public static FileConfiguration getCurrentLang() {
        FileConfiguration en_US = get_en_US();
        FileConfiguration UK = getUK();
        FileConfiguration GE = get_GE();
        FileConfiguration ES = getES();
        if (config.getString("language").equalsIgnoreCase("en_US")){
            return en_US;
        }
        if (config.getString("language").equalsIgnoreCase("UK")) {
            return UK;
        }
        if (config.getString("language").equalsIgnoreCase("GE")) {
            return GE;
        }
        if (config.getString("language").equalsIgnoreCase("ES")) {
            return ES;
        } else return en_US;
    }
    private void create_en_US() {
        en_US_file = new File(getDataFolder(), "languages/en_US.yml");
        if (!en_US_file.exists()) {
            en_US_file.getParentFile().mkdirs();
            saveResource("languages/en_US.yml", false);
        }

        en_US = new YamlConfiguration();
        try {
            en_US.load(en_US_file);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    private void createUK() {
        UK_file = new File(getDataFolder(), "languages/UK.yml");
        if (!UK_file.exists()) {
            UK_file.getParentFile().mkdirs();
            saveResource("languages/UK.yml", false);
        }

        UK = new YamlConfiguration();
        try {
            UK.load(UK_file);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }
    private void create_GE() {
        GE_file = new File(getDataFolder(), "languages/GE.yml");
        if (!GE_file.exists()) {
            GE_file.getParentFile().mkdirs();
            saveResource("languages/GE.yml", false);
        }

        GE = new YamlConfiguration();
        try {
            GE.load(GE_file);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }
    private void createES() {
        ES_file = new File(getDataFolder(), "languages/ES.yml");
        if (!ES_file.exists()) {
            ES_file.getParentFile().mkdirs();
            saveResource("languages/ES.yml", false);
        }

        ES = new YamlConfiguration();
        try {
            ES.load(ES_file);
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
        create_GE();
        createES();

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