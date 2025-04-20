package copper.items.items.copper.Items;

import copper.items.items.copper.Items.Commands.Give;
import copper.items.items.copper.Items.Listeners.CopperItemsListener;
import copper.items.items.copper.Items.Listeners.Oxidize;
import copper.items.items.copper.Items.Listeners.ResourcepackChecker;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

import static copper.items.items.copper.Items.Items.config;

public final class CopperItems extends JavaPlugin {


    private static FileConfiguration en_US;
    private static FileConfiguration UK;
    private static FileConfiguration GE;
    private static FileConfiguration ES;
    private static CopperItems instance;
    private File en_US_file;
    private File UK_file;
    private File GE_file;
    private File ES_file;

    public static FileConfiguration get_en_US() {
        return en_US;
    }

    public static FileConfiguration getUK() {
        return UK;
    }

    public static FileConfiguration get_GE() {
        return GE;
    }

    public static FileConfiguration getES() {
        return ES;
    }

    public static FileConfiguration getCurrentLang() {
        FileConfiguration en_US = get_en_US();
        FileConfiguration UK = getUK();
        FileConfiguration GE = get_GE();
        FileConfiguration ES = getES();
        if (config.getString("language").equalsIgnoreCase("en_US")) {
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


        // Replace "world" with the name of your target world if different.
        World world = Bukkit.getWorld(config.getString("nerd-stuff.world-name"));
        if (world != null) {
            File datapacksDir = new File(world.getWorldFolder(), "datapacks");

            // Create the datapacks directory if it doesn't exist
            if (!datapacksDir.exists()) {
                boolean created = datapacksDir.mkdirs();
                if (created) {
                    getLogger().info("Datapacks folder created successfully!");
                } else {
                    getLogger().warning("Failed to create datapacks folder.");
                }
            } else {
                getLogger().info("Datapacks folder already exists.");
            }

            // Optionally, download a file and place it in the datapacks folder
            try {
                URL fileUrl = new URL("https://cdn.modrinth.com/data/gbnXN4Fr/versions/lylo6Gtk/CopperItemsDP.zip");
                File targetFile = new File(datapacksDir, "CopperItemsDP.zip");

                if (!targetFile.exists()) {
                    // Download and copy the file
                    Files.copy(fileUrl.openStream(), targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                    getLogger().info("Datapack downloaded and saved successfully!");
                    getLogger().info("");
                    getLogger().info("The server will restart, please wait!");
                    getLogger().info("");
                    //Bukkit.getScheduler().runTaskLater(this, this::restartServer, 20 * 6);
                    executeCommand("restart");
                } else getLogger().info("Datapack is downloaded already!");
            } catch (IOException e) {
                getLogger().severe("Failed to download datapack: " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            getLogger().warning("World not found.");
        }


        reloadConfig();
        create_en_US();
        createUK();
        create_GE();
        createES();

        saveDefaultConfig();

        Items.init();


        Objects.requireNonNull(this.getCommand("givecopperitem")).setExecutor(new Give(this));
        Objects.requireNonNull(this.getCommand("givecopperitem")).setTabCompleter(new Give(this));

        getServer().getPluginManager().registerEvents(new CopperItemsListener(this), this);
        getServer().getPluginManager().registerEvents(new ResourcepackChecker(this), this);

        Bukkit.getServer().getPluginManager().registerEvents(new Oxidize(this), this);
        ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
        console.sendMessage(ChatColor.AQUA + "***********************************");
        console.sendMessage(ChatColor.AQUA + "| Copper Items have been enabled! |");
        console.sendMessage(ChatColor.AQUA + "***********************************");
    }
    public static CopperItems getInstance() {
        return instance;
    }


    @Override
    public void onDisable() {
        ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
        console.sendMessage(ChatColor.DARK_RED + "************************************");
        console.sendMessage(ChatColor.DARK_RED + "| Copper Items have been disabled! |");
        console.sendMessage(ChatColor.DARK_RED + "************************************");
    }

    private void executeCommand(String command) {
        CommandSender console = Bukkit.getConsoleSender();
        Bukkit.dispatchCommand(console, command);
    }
}