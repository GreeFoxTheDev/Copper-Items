package copper.items.items.copper.Items;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.attribute.AttributeModifier.Operation;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
        if (config.getBoolean("copper-items.copper-sword.enable")) {
            createCopperSword();
        }
        if (config.getBoolean("copper-items.copper-axe.enable")) {
            createCopperAxe();
        }
        if (config.getBoolean("copper-items.copper-pickaxe.enable")) {
            createCopperPickaxe();
        }
        if (config.getBoolean("copper-items.copper-shovel.enable")) {
            createCopperShovel();
        }
        if (config.getBoolean("copper-items.copper-hoe.enable")) {
            createCopperHoe();
        }
        if (config.getBoolean("copper-armor.copper-helmet.enable")) {
            createCopperHelmet();
        }
        if (config.getBoolean("copper-armor.copper-chestplate.enable")) {
            createCopperChestplate();
        }
        if (config.getBoolean("copper-armor.copper-leggings.enable")) {
            createCopperLeggings();
        }
        if (config.getBoolean("copper-armor.copper-boots.enable")) {
            createCopperBoots();
        }
    }

    private static void createCopperSword() {
        ItemStack item = new ItemStack(Material.IRON_SWORD, 1);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName(ChatColor.WHITE + CopperItems.getCurrentLang().getString("items.sword"));
        im.setLocalizedName("copper_sword");
        im.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add(ChatColor.GRAY + CopperItems.getCurrentLang().getString("item_description.in_main_hand"));
        String attackDamage = String.valueOf(config.getDouble("copper-items.copper-sword.attack-damage"));
        String attackSpeed = String.valueOf(config.getDouble("copper-items.copper-sword.attack-speed"));
        lore.add(ChatColor.DARK_GREEN + " " + attackDamage + CopperItems.getCurrentLang().getString("item_description.att_damage"));
        lore.add(ChatColor.DARK_GREEN + " " + attackSpeed + CopperItems.getCurrentLang().getString("item_description.att_speed"));
        im.setLore(lore);
        AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", config.getDouble("copper-items.copper-sword.attack-damage"), Operation.ADD_NUMBER, EquipmentSlot.HAND);
        im.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4.0 + config.getDouble("copper-items.copper-sword.attack-speed"), Operation.ADD_NUMBER, EquipmentSlot.HAND);
        im.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);
        im.setCustomModelData(1);
        item.setItemMeta(im);
        copperSword = item;

        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("copper_sword"), item);
        sr.shape(" X ", " X ", " Y ");
        sr.setIngredient('X', Material.COPPER_INGOT);
        sr.setIngredient('Y', Material.STICK);

        ShapedRecipe sr2 = new ShapedRecipe(NamespacedKey.minecraft("copper_sword2"), item);
        sr2.shape("X  ", "X  ", "Y  ");
        sr2.setIngredient('X', Material.COPPER_INGOT);
        sr2.setIngredient('Y', Material.STICK);

        ShapedRecipe sr3 = new ShapedRecipe(NamespacedKey.minecraft("copper_sword3"), item);
        sr3.shape("  X", "  X", "  Y");
        sr3.setIngredient('X', Material.COPPER_INGOT);
        sr3.setIngredient('Y', Material.STICK);

        ShapelessRecipe sr4 = new ShapelessRecipe(NamespacedKey.minecraft("copper_sword4"), item);
        sr4.addIngredient(new RecipeChoice.ExactChoice(Items.copperSword));
        sr4.addIngredient(new RecipeChoice.ExactChoice(Items.copperSword));

        Bukkit.getServer().addRecipe(sr);
        Bukkit.getServer().addRecipe(sr2);
        Bukkit.getServer().addRecipe(sr3);
        Bukkit.getServer().addRecipe(sr4);
    }

    private static void createCopperAxe() {
        ItemStack item = new ItemStack(Material.IRON_AXE);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName(ChatColor.WHITE + CopperItems.getCurrentLang().getString("items.axe"));
        im.setLocalizedName("copper_axe");
        im.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add(ChatColor.GRAY + CopperItems.getCurrentLang().getString("item_description.in_main_hand"));
        String attackDamage = String.valueOf(config.getDouble("copper-items.copper-axe.attack-damage"));
        String attackSpeed = String.valueOf(config.getDouble("copper-items.copper-axe.attack-speed"));
        lore.add(ChatColor.DARK_GREEN + " " + attackDamage + CopperItems.getCurrentLang().getString("item_description.att_damage"));
        lore.add(ChatColor.DARK_GREEN + " " + attackSpeed + CopperItems.getCurrentLang().getString("item_description.att_speed"));
        im.setLore(lore);

        AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", config.getDouble("copper-items.copper-axe.attack-damage"), Operation.ADD_NUMBER, EquipmentSlot.HAND);
        im.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4.0 + config.getDouble("copper-items.copper-axe.attack-speed"), Operation.ADD_NUMBER, EquipmentSlot.HAND);
        im.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);

        im.setCustomModelData(1);
        item.setItemMeta(im);
        copperAxe = item;

        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("copper_axe"), item);
        sr.shape("XX ", "XY ", " Y ");
        sr.setIngredient('X', Material.COPPER_INGOT);
        sr.setIngredient('Y', Material.STICK);
        ShapedRecipe sr2 = new ShapedRecipe(NamespacedKey.minecraft("copper_axe2"), item);
        sr2.shape(" XX", " YX", " Y ");
        sr2.setIngredient('X', Material.COPPER_INGOT);
        sr2.setIngredient('Y', Material.STICK);

        ShapedRecipe sr3 = new ShapedRecipe(NamespacedKey.minecraft("copper_axe3"), item);
        sr3.shape(" XX", " XY", "  Y");
        sr3.setIngredient('X', Material.COPPER_INGOT);
        sr3.setIngredient('Y', Material.STICK);

        ShapedRecipe sr4 = new ShapedRecipe(NamespacedKey.minecraft("copper_axe4"), item);
        sr4.shape("XX ", "YX ", "Y  ");
        sr4.setIngredient('X', Material.COPPER_INGOT);
        sr4.setIngredient('Y', Material.STICK);

        ShapelessRecipe sr5 = new ShapelessRecipe(NamespacedKey.minecraft("copper_axe5"), item);
        sr5.addIngredient(new RecipeChoice.ExactChoice(Items.copperAxe));
        sr5.addIngredient(new RecipeChoice.ExactChoice(Items.copperAxe));

        Bukkit.getServer().addRecipe(sr);
        Bukkit.getServer().addRecipe(sr2);
        Bukkit.getServer().addRecipe(sr3);
        Bukkit.getServer().addRecipe(sr4);
        Bukkit.getServer().addRecipe(sr5);

    }

    private static void createCopperPickaxe() {
        ItemStack item = new ItemStack(Material.STONE_PICKAXE, 1);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName(ChatColor.WHITE + CopperItems.getCurrentLang().getString("items.pickaxe"));
        im.setLocalizedName("copper_pickaxe");
        im.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add(ChatColor.GRAY + CopperItems.getCurrentLang().getString("item_description.in_main_hand"));
        int a = 3;
        String attDam = String.valueOf(a);
        int b = (int) 1.2;
        String attSpd = String.valueOf(b);
        lore.add(ChatColor.DARK_GREEN + " " + attDam + ChatColor.DARK_GREEN + CopperItems.getCurrentLang().getString("item_description.att_damage"));
        lore.add(ChatColor.DARK_GREEN + " " + attSpd + ChatColor.DARK_GREEN + CopperItems.getCurrentLang().getString("item_description.att_speed"));
        im.setLore(lore);
        item.setDurability((short) 450);
        im.setCustomModelData(1);
        item.setItemMeta(im);
        copperPickaxe = item;
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("copper_pickaxe"), item);
        sr.shape("XXX", " Y ", " Y ");
        sr.setIngredient('X', Material.COPPER_INGOT);
        sr.setIngredient('Y', Material.STICK);

        ShapelessRecipe sr2 = new ShapelessRecipe(NamespacedKey.minecraft("copper_pickaxe2"), item);
        sr2.addIngredient(new RecipeChoice.ExactChoice(Items.copperPickaxe));
        sr2.addIngredient(new RecipeChoice.ExactChoice(Items.copperPickaxe));

        Bukkit.getServer().addRecipe(sr);
    }

    private static void createCopperShovel() {
        ItemStack item = new ItemStack(Material.IRON_SHOVEL, 1);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName(ChatColor.WHITE + CopperItems.getCurrentLang().getString("items.shovel"));
        im.setLocalizedName("copper_shovel");
        im.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add(ChatColor.GRAY + CopperItems.getCurrentLang().getString("item_description.in_main_hand"));
        double a = 4.5;
        String attDam = String.valueOf(a);
        double b = 1;
        String attSpd = String.valueOf(b);
        lore.add(ChatColor.DARK_GREEN + " " + attDam + ChatColor.DARK_GREEN + CopperItems.getCurrentLang().getString("item_description.att_damage"));
        lore.add(ChatColor.DARK_GREEN + " " + attSpd + ChatColor.DARK_GREEN + CopperItems.getCurrentLang().getString("item_description.att_speed"));
        im.setLore(lore);
        im.setCustomModelData(1);
        item.setItemMeta(im);

        copperShovel = item;
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("copper_shovel"), item);
        sr.shape(" X ", " Y ", " Y ");
        sr.setIngredient('X', Material.COPPER_INGOT);
        sr.setIngredient('Y', Material.STICK);

        ShapedRecipe sr2 = new ShapedRecipe(NamespacedKey.minecraft("copper_shovel2"), item);
        sr2.shape("X  ", "Y  ", "Y  ");
        sr2.setIngredient('X', Material.COPPER_INGOT);
        sr2.setIngredient('Y', Material.STICK);

        ShapedRecipe sr3 = new ShapedRecipe(NamespacedKey.minecraft("copper_shovel3"), item);
        sr3.shape("  X", "  Y", "  Y");
        sr3.setIngredient('X', Material.COPPER_INGOT);
        sr3.setIngredient('Y', Material.STICK);

        ShapelessRecipe sr4 = new ShapelessRecipe(NamespacedKey.minecraft("copper_shovel4"), item);
        sr4.addIngredient(new RecipeChoice.ExactChoice(Items.copperShovel));
        sr4.addIngredient(new RecipeChoice.ExactChoice(Items.copperShovel));

        Bukkit.getServer().addRecipe(sr);
        Bukkit.getServer().addRecipe(sr2);
        Bukkit.getServer().addRecipe(sr3);
        Bukkit.getServer().addRecipe(sr4);
    }

    private static void createCopperHoe() {
        ItemStack item = new ItemStack(Material.STONE_HOE, 1);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName(ChatColor.WHITE + CopperItems.getCurrentLang().getString("items.hoe"));
        im.setLocalizedName("copper_hoe");
        im.setCustomModelData(1);
        im.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add(ChatColor.GRAY + CopperItems.getCurrentLang().getString("item_description.in_main_hand"));
        double a = 1;
        String attDam = String.valueOf(a);
        double b = 2;
        String attSpd = String.valueOf(b);
        lore.add(ChatColor.DARK_GREEN + " " + attDam + ChatColor.DARK_GREEN + CopperItems.getCurrentLang().getString("item_description.att_damage"));
        lore.add(ChatColor.DARK_GREEN + " " + attSpd + ChatColor.DARK_GREEN + CopperItems.getCurrentLang().getString("item_description.att_speed"));
        im.setLore(lore);
        item.setItemMeta(im);
        copperHoe = item;
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("copper_hoe"), item);
        sr.shape(" XX", " Y ", " Y ");
        sr.setIngredient('X', Material.COPPER_INGOT);
        sr.setIngredient('Y', Material.STICK);

        ShapedRecipe sr2 = new ShapedRecipe(NamespacedKey.minecraft("copper_hoe2"), item);
        sr2.shape("XX ", " Y ", " Y ");
        sr2.setIngredient('X', Material.COPPER_INGOT);
        sr2.setIngredient('Y', Material.STICK);

        ShapedRecipe sr3 = new ShapedRecipe(NamespacedKey.minecraft("copper_hoe3"), item);
        sr3.shape(" XX", "  Y", "  Y");
        sr3.setIngredient('X', Material.COPPER_INGOT);
        sr3.setIngredient('Y', Material.STICK);

        ShapedRecipe sr4 = new ShapedRecipe(NamespacedKey.minecraft("copper_hoe4"), item);
        sr4.shape("XX ", "Y  ", "Y  ");
        sr4.setIngredient('X', Material.COPPER_INGOT);
        sr4.setIngredient('Y', Material.STICK);

        ShapelessRecipe sr5 = new ShapelessRecipe(NamespacedKey.minecraft("copper_hoe5"), item);
        sr5.addIngredient(new RecipeChoice.ExactChoice(Items.copperHoe));
        sr5.addIngredient(new RecipeChoice.ExactChoice(Items.copperHoe));

        Bukkit.getServer().addRecipe(sr);
        Bukkit.getServer().addRecipe(sr2);
        Bukkit.getServer().addRecipe(sr3);
        Bukkit.getServer().addRecipe(sr4);
        Bukkit.getServer().addRecipe(sr5);

    }

    private static void createCopperHelmet() {
        ItemStack item = new ItemStack(Material.IRON_HELMET, 1);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName(ChatColor.WHITE + CopperItems.getCurrentLang().getString("armor.helmet"));
        im.setLocalizedName("copper_helmet");
        item.setDurability((short) 150);
        im.setCustomModelData(1);
        AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "generic.armor", config.getDouble("copper-armor.copper-helmet.armor"), Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        im.addAttributeModifier(Attribute.GENERIC_ARMOR, modifier);
        item.setItemMeta(im);
        copperHelmet = item;
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("copper_helmet"), item);
        sr.shape("XXX", "X X", "   ");
        sr.setIngredient('X', Material.COPPER_INGOT);

        ShapedRecipe sr2 = new ShapedRecipe(NamespacedKey.minecraft("copper_helmet2"), item);
        sr2.shape("   ", "XXX", "X X");
        sr2.setIngredient('X', Material.COPPER_INGOT);

        ShapelessRecipe sr3 = new ShapelessRecipe(NamespacedKey.minecraft("copper_helmet3"), item);
        sr3.addIngredient(new RecipeChoice.ExactChoice(Items.copperHelmet));
        sr3.addIngredient(new RecipeChoice.ExactChoice(Items.copperHelmet));

        Bukkit.getServer().addRecipe(sr);
        Bukkit.getServer().addRecipe(sr2);
        Bukkit.getServer().addRecipe(sr3);
    }

    private static void createCopperChestplate() {
        ItemStack item = new ItemStack(Material.IRON_CHESTPLATE, 1);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName(ChatColor.WHITE + CopperItems.getCurrentLang().getString("armor.chestplate"));
        im.setLocalizedName("copper_chestplate");
        im.setCustomModelData(1);
        item.setItemMeta(im);
        AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "generic.armor", config.getDouble("copper-armor.copper-chestplate.armor"), Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        im.addAttributeModifier(Attribute.GENERIC_ARMOR, modifier);
        copperChestplate = item;
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("copper_chestplate"), item);
        sr.shape("X X", "XXX", "XXX");
        sr.setIngredient('X', Material.COPPER_INGOT);

        ShapelessRecipe sr2 = new ShapelessRecipe(NamespacedKey.minecraft("copper_chestplate2"), item);
        sr2.addIngredient(new RecipeChoice.ExactChoice(Items.copperChestplate));
        sr2.addIngredient(new RecipeChoice.ExactChoice(Items.copperChestplate));

        Bukkit.getServer().addRecipe(sr);
        Bukkit.getServer().addRecipe(sr2);
    }

    private static void createCopperLeggings() {
        ItemStack item = new ItemStack(Material.IRON_LEGGINGS, 1);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName(ChatColor.WHITE + CopperItems.getCurrentLang().getString("armor.leggings"));
        im.setLocalizedName("copper_leggings");
        im.setCustomModelData(1);
        AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "generic.armor", config.getDouble("copper-armor.copper-leggings.armor"), Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        im.addAttributeModifier(Attribute.GENERIC_ARMOR, modifier);
        item.setItemMeta(im);
        copperLeggings = item;
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("copper_leggings"), item);
        sr.shape("XXX", "X X", "X X");
        sr.setIngredient('X', Material.COPPER_INGOT);

        ShapelessRecipe sr2 = new ShapelessRecipe(NamespacedKey.minecraft("copper_leggings2"), item);
        sr2.addIngredient(new RecipeChoice.ExactChoice(Items.copperLeggings));
        sr2.addIngredient(new RecipeChoice.ExactChoice(Items.copperLeggings));

        Bukkit.getServer().addRecipe(sr);
        Bukkit.getServer().addRecipe(sr2);
    }

    private static void createCopperBoots() {
        ItemStack item = new ItemStack(Material.IRON_BOOTS, 1);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName(ChatColor.WHITE + CopperItems.getCurrentLang().getString("armor.boots"));
        im.setLocalizedName("copper_boots");
        im.setCustomModelData(1);
        AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "generic.armor", config.getDouble("copper-armor.copper-boots.armor"), Operation.ADD_NUMBER, EquipmentSlot.FEET);
        im.addAttributeModifier(Attribute.GENERIC_ARMOR, modifier);
        item.setItemMeta(im);
        copperBoots = item;
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("copper_boots"), item);
        sr.shape("   ", "X X", "X X");
        sr.setIngredient('X', Material.COPPER_INGOT);
        ShapedRecipe sr2 = new ShapedRecipe(NamespacedKey.minecraft("copper_boots2"), item);
        sr2.shape("X X", "X X", "   ");
        sr2.setIngredient('X', Material.COPPER_INGOT);

        ShapelessRecipe sr3 = new ShapelessRecipe(NamespacedKey.minecraft("copper_boots2"), item);
        sr3.addIngredient(new RecipeChoice.ExactChoice(Items.copperBoots));
        sr3.addIngredient(new RecipeChoice.ExactChoice(Items.copperBoots));

        Bukkit.getServer().addRecipe(sr);
        Bukkit.getServer().addRecipe(sr2);
    }

}