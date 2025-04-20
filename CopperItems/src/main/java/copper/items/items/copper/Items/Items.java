package copper.items.items.copper.Items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.EquipmentSlotGroup;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;

public class Items extends JavaPlugin {
    public static ItemStack copperSword;
    public static ItemStack copperAxe;
    public static ItemStack copperPickaxe;
    public static ItemStack copperHelmet;
    public static ItemStack copperChestplate;
    public static ItemStack copperLeggings;
    public static ItemStack copperBoots;
    public static ItemStack copperShovel;
    public static ItemStack copperHoe;


    static FileConfiguration config = CopperItems.getInstance().getConfig();


    public static void init() {
        if (config.getBoolean("items.sword.enable")) {
            createSword();
        }
        if (config.getBoolean("items.axe.enable")) {
            createAxe();
        }
        if (config.getBoolean("items.pickaxe.enable")) {
            createPickaxe();
        }
        if (config.getBoolean("items.shovel.enable")) {
            createShovel();
        }
        if (config.getBoolean("items.hoe.enable")) {
            createHoe();
        }
        if (config.getBoolean("armor.helmet.enable")) {
            createHelmet();
        }
        if (config.getBoolean("armor.chestplate.enable")) {
            createChestplate();
        }
        if (config.getBoolean("armor.leggings.enable")) {
            createLeggings();
        }
        if (config.getBoolean("armor.boots.enable")) {
            createBoots();
        }
    }

    private static void createSword() {
        CustomItemBuilder builder = new CustomItemBuilder(Material.IRON_SWORD, ChatColor.WHITE + "Copper Sword", "copper_sword", 1);
        builder.addAttributes(config.getDouble("items.sword.attack-damage"), config.getDouble("items.sword.attack-speed"), 0, 0, 0);
        builder.addLoreLine("");
        builder.addLoreLine(ChatColor.GRAY + CopperItems.getCurrentLang().getString("item_description.in_main_hand"));

        builder.addLoreLine(ChatColor.DARK_GREEN + " " + config.getDouble("items.sword.attack-damage") + CopperItems.getCurrentLang().getString("item_description.att_damage"));
        builder.addLoreLine(ChatColor.DARK_GREEN + " " + config.getDouble("items.sword.attack-speed") + CopperItems.getCurrentLang().getString("item_description.att_speed"));

        Map<Character, Material> ingredients = new HashMap<>();
        ingredients.put('X', Material.COPPER_INGOT);
        ingredients.put('Y', Material.STICK);

        builder.addRecipe2(new String[]{" X ", " X ", " Y "}, ingredients);
        builder.addRecipe2(new String[]{"X  ", "X  ", "Y  "}, ingredients);
        builder.addRecipe2(new String[]{"  X", "  X", "  Y"}, ingredients);

        copperSword = builder.build();
    }

    private static void createAxe() {
        CustomItemBuilder builder = new CustomItemBuilder(Material.IRON_AXE, ChatColor.WHITE + "Copper Axe", "copper_axe", 1);
        builder.addAttributes((config.getDouble("items.axe.attack-damage")), config.getDouble("items.axe.attack-speed"), -0.2, 0, 0);
        builder.addLoreLine("");
        builder.addLoreLine(ChatColor.GRAY + CopperItems.getCurrentLang().getString("item_description.in_main_hand"));

        builder.addLoreLine(ChatColor.DARK_GREEN + " " + config.getDouble("items.axe.attack-damage") + CopperItems.getCurrentLang().getString("item_description.att_damage"));
        builder.addLoreLine(ChatColor.DARK_GREEN + " " + config.getDouble("items.axe.attack-speed") + CopperItems.getCurrentLang().getString("item_description.att_speed"));

        Map<Character, Material> ingredients = new HashMap<>();
        ingredients.put('X', Material.COPPER_INGOT);
        ingredients.put('Y', Material.STICK);

        builder.addRecipe2(new String[]{" XX", " YX", " Y "}, ingredients);
        builder.addRecipe2(new String[]{"XX ", "XY ", " Y "}, ingredients);


        copperAxe = builder.build();
    }

    private static void createPickaxe() {
        CustomItemBuilder builder = new CustomItemBuilder(Material.STONE_PICKAXE, ChatColor.WHITE + "Copper Pickaxe", "copper_pickaxe", 1);
        builder.addAttributes(4, 1.2, 0.3, 0, 0);
        builder.addLoreLine("");
        builder.addLoreLine(ChatColor.GRAY + CopperItems.getCurrentLang().getString("item_description.in_main_hand"));

        builder.addLoreLine(ChatColor.DARK_GREEN + " " + 3.5 + CopperItems.getCurrentLang().getString("item_description.att_damage"));
        builder.addLoreLine(ChatColor.DARK_GREEN + " " + 1.2 + CopperItems.getCurrentLang().getString("item_description.att_speed"));

        Map<Character, Material> ingredients = new HashMap<>();
        ingredients.put('X', Material.COPPER_INGOT);
        ingredients.put('Y', Material.STICK);

        builder.addRecipe(new String[]{"XXX", " Y ", " Y "}, ingredients);

        copperPickaxe = builder.build();
    }

    private static void createShovel() {
        CustomItemBuilder builder = new CustomItemBuilder(Material.IRON_SHOVEL, ChatColor.WHITE + "Copper Shovel", "copper_shovel", 1);
        builder.addAttributes(4, 1, -0.2, 0, 0);
        builder.addLoreLine("");
        builder.addLoreLine(ChatColor.GRAY + CopperItems.getCurrentLang().getString("item_description.in_main_hand"));

        builder.addLoreLine(ChatColor.DARK_GREEN + " " + 4 + CopperItems.getCurrentLang().getString("item_description.att_damage"));
        builder.addLoreLine(ChatColor.DARK_GREEN + " " + 1 + CopperItems.getCurrentLang().getString("item_description.att_speed"));

        Map<Character, Material> ingredients = new HashMap<>();
        ingredients.put('X', Material.COPPER_INGOT);
        ingredients.put('Y', Material.STICK);

        builder.addRecipe2(new String[]{" X ", " Y ", " Y "}, ingredients);
        builder.addRecipe2(new String[]{"X  ", "Y  ", "Y  "}, ingredients);
        builder.addRecipe2(new String[]{"  X", "  Y", "  Y"}, ingredients);

        copperShovel = builder.build();
    }

    private static void createHoe() {
        CustomItemBuilder builder = new CustomItemBuilder(Material.STONE_HOE, ChatColor.WHITE + "Copper Hoe", "copper_hoe", 1);
        builder.addAttributes(1, 2.5, 0, 0, 0);
        builder.addLoreLine("");
        builder.addLoreLine(ChatColor.GRAY + CopperItems.getCurrentLang().getString("item_description.in_main_hand"));

        builder.addLoreLine(ChatColor.DARK_GREEN + " " + 1 + CopperItems.getCurrentLang().getString("item_description.att_damage"));
        builder.addLoreLine(ChatColor.DARK_GREEN + " " + 2.5 + CopperItems.getCurrentLang().getString("item_description.att_speed"));

        Map<Character, Material> ingredients = new HashMap<>();
        ingredients.put('X', Material.COPPER_INGOT);
        ingredients.put('Y', Material.STICK);

        builder.addRecipe2(new String[]{"XX ", " Y ", " Y "}, ingredients);
        builder.addRecipe2(new String[]{"XX ", "Y  ", "Y  "}, ingredients);
        builder.addRecipe2(new String[]{" XX", "  Y", "  Y"}, ingredients);
        builder.addRecipe2(new String[]{" XX", " Y ", " Y "}, ingredients);

        copperHoe = builder.build();
    }

    private static void createHelmet() {
        CustomArmorBuilder builder = new CustomArmorBuilder(Material.IRON_HELMET, ChatColor.WHITE + "Copper Helmet", "copper_helmet", 1);
        builder.addAttributes(config.getDouble("armor.helmet.armor"), 0, EquipmentSlotGroup.HEAD);

        Map<Character, Material> ingredients = new HashMap<>();
        ingredients.put('X', Material.COPPER_INGOT);

        builder.addRecipe2(new String[]{"XXX", "X X", "   "}, ingredients);
        builder.addRecipe2(new String[]{"   ", "XXX", "X X"}, ingredients);

        copperHelmet = builder.build();
    }

    private static void createChestplate() {
        CustomArmorBuilder builder = new CustomArmorBuilder(Material.IRON_CHESTPLATE, ChatColor.WHITE + CopperItems.getCurrentLang().getString("armor.chestplate"), "copper_chestplate", 1);
        builder.addAttributes(config.getDouble("armor.chestplate.armor"), 0, EquipmentSlotGroup.CHEST);

        Map<Character, Material> ingredients = new HashMap<>();
        ingredients.put('X', Material.COPPER_INGOT);

        builder.addRecipe2(new String[]{"X X", "XXX", "XXX"}, ingredients);

        copperChestplate = builder.build();
    }

    private static void createLeggings() {
        CustomArmorBuilder builder = new CustomArmorBuilder(Material.IRON_LEGGINGS, ChatColor.WHITE + CopperItems.getCurrentLang().getString("armor.leggings"), "copper_leggings", 1);
        builder.addAttributes(config.getDouble("armor.leggings.armor"), 0, EquipmentSlotGroup.LEGS);

        Map<Character, Material> ingredients = new HashMap<>();
        ingredients.put('X', Material.COPPER_INGOT);

        builder.addRecipe2(new String[]{"XXX", "X X", "X X"}, ingredients);

        copperLeggings = builder.build();
    }

    private static void createBoots() {
        CustomArmorBuilder builder = new CustomArmorBuilder(Material.IRON_BOOTS, ChatColor.WHITE + CopperItems.getCurrentLang().getString("armor.boots"), "copper_boots", 1);
        builder.addAttributes(config.getDouble("armor.boots.armor"), 0, EquipmentSlotGroup.FEET);

        Map<Character, Material> ingredients = new HashMap<>();
        ingredients.put('X', Material.COPPER_INGOT);

        builder.addRecipe2(new String[]{"X X", "X X", "   "}, ingredients);
        builder.addRecipe2(new String[]{"   ", "X X", "X X"}, ingredients);

        copperBoots = builder.build();
    }
}