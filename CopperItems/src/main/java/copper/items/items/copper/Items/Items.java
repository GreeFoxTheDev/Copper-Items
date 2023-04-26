package copper.items.items.copper.Items;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.attribute.AttributeModifier.Operation;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Items extends JavaPlugin {

    public static void init() {
        createCopperSword();
        createCopperAxe();
        createCopperPickaxe();
        createCopperShovel();
        createCopperHoe();

        createCopperHelmet();
        createCopperChestplate();
        createCopperLeggings();
        createCopperBoots();
    }
    public static ItemStack copperSword;
    private static void createCopperSword(){
        ItemStack item = new ItemStack(Material.IRON_SWORD, 1);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§fCopper Sword");
        im.setLocalizedName("copper_sword");
        im.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add(ChatColor.GRAY + "When in Main Hand:");
        lore.add(ChatColor.DARK_GREEN + " 6.5 Attack Damage");
        lore.add(ChatColor.DARK_GREEN + " 1.5 Attack Speed");
        im.setLore(lore);
        AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed",
                6.5, Operation.ADD_NUMBER, EquipmentSlot.HAND);
        im.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(),
                "generic.attackSpeed", -2.3, Operation.ADD_NUMBER, EquipmentSlot.HAND);
        im.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);
        item.setDurability((short) 450);
        im.setCustomModelData(1);
        item.setItemMeta(im);
        copperSword = item;

        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("copper_sword"), item);
        sr.shape(" X ",
                " X ",
                " Y ");
        sr.setIngredient('X', Material.COPPER_INGOT);
        sr.setIngredient('Y', Material.STICK);

        ShapedRecipe sr2 = new ShapedRecipe(NamespacedKey.minecraft("copper_sword2"), item);
        sr2.shape("X  ",
                "X  ",
                "Y  ");
        sr2.setIngredient('X', Material.COPPER_INGOT);
        sr2.setIngredient('Y', Material.STICK);

        ShapedRecipe sr3 = new ShapedRecipe(NamespacedKey.minecraft("copper_sword3"), item);
        sr3.shape("  X",
                "  X",
                "  Y");
        sr3.setIngredient('X', Material.COPPER_INGOT);
        sr3.setIngredient('Y', Material.STICK);
        Bukkit.getServer().addRecipe(sr);
        Bukkit.getServer().addRecipe(sr2);
        Bukkit.getServer().addRecipe(sr3);
    }
    public static ItemStack copperAxe;
    private  static void createCopperAxe(){
        ItemStack item = new ItemStack(Material.IRON_AXE);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§fCopper Axe");
        im.setLocalizedName("copper_axe");
        im.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add(ChatColor.GRAY + "When in Main Hand:");
        lore.add(ChatColor.DARK_GREEN + " 9.5 Attack Damage");
        lore.add(ChatColor.DARK_GREEN + " 0.9 Attack Speed");
        im.setLore(lore);
        AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage",
                9.5, Operation.ADD_NUMBER, EquipmentSlot.HAND);
        im.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(),
                "generic.attackSpeed", -3.0, Operation.ADD_NUMBER, EquipmentSlot.HAND);
        im.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);
        item.setDurability((short) 450);
        im.setCustomModelData(1);
        item.setItemMeta(im);
        copperAxe = item;

        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("copper_axe"), item);
        sr.shape("XX ",
                 "XY ",
                 " Y ");
        sr.setIngredient('X', Material.COPPER_INGOT);
        sr.setIngredient('Y', Material.STICK);
        ShapedRecipe sr2 = new ShapedRecipe(NamespacedKey.minecraft("copper_axe2"), item);
        sr2.shape(" XX",
                  " YX",
                  " Y ");
        sr2.setIngredient('X', Material.COPPER_INGOT);
        sr2.setIngredient('Y', Material.STICK);

        ShapedRecipe sr3 = new ShapedRecipe(NamespacedKey.minecraft("copper_axe3"), item);
        sr3.shape(" XX",
                  " XY",
                  "  Y");
        sr3.setIngredient('X', Material.COPPER_INGOT);
        sr3.setIngredient('Y', Material.STICK);

        ShapedRecipe sr4 = new ShapedRecipe(NamespacedKey.minecraft("copper_axe4"), item);
        sr4.shape("XX ",
                  "YX ",
                  "Y  ");
        sr4.setIngredient('X', Material.COPPER_INGOT);
        sr4.setIngredient('Y', Material.STICK);
        Bukkit.getServer().addRecipe(sr);
        Bukkit.getServer().addRecipe(sr2);
        Bukkit.getServer().addRecipe(sr3);
        Bukkit.getServer().addRecipe(sr4);

    }
    public static ItemStack copperPickaxe;
    private static void createCopperPickaxe(){
        ItemStack item = new ItemStack(Material.STONE_PICKAXE, 1);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§fCopper Pickaxe");
        item.setDurability((short) 450);
        im.setCustomModelData(1);
        item.setItemMeta(im);
        copperPickaxe = item;
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("copper_pickaxe"), item);
        sr.shape("XXX",
                " Y ",
                " Y ");
        sr.setIngredient('X', Material.COPPER_INGOT);
        sr.setIngredient('Y', Material.STICK);
        Bukkit.getServer().addRecipe(sr);
    }
    public static ItemStack copperHelmet;
    private static void createCopperHelmet(){
        ItemStack item = new ItemStack(Material.IRON_HELMET, 1);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§fCopper Helmet");
        item.setDurability((short) 150);
        im.setCustomModelData(1);
        item.setItemMeta(im);
        copperHelmet = item;
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("copper_helmet"), item);
        sr.shape("XXX",
                "X X",
                "   ");
        sr.setIngredient('X', Material.COPPER_INGOT);
        ShapedRecipe sr2 = new ShapedRecipe(NamespacedKey.minecraft("copper_helmet2"), item);
        sr2.shape("   ",
                "XXX",
                "X X");
        sr2.setIngredient('X', Material.COPPER_INGOT);
        Bukkit.getServer().addRecipe(sr);
        Bukkit.getServer().addRecipe(sr2);
    }
    public static ItemStack copperChestplate;
    private static void createCopperChestplate(){
        ItemStack item = new ItemStack(Material.IRON_CHESTPLATE, 1);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§fCopper Chestplate");
        im.setCustomModelData(1);
        item.setItemMeta(im);
        AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "generic.armor",
                5, Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        im.addAttributeModifier(Attribute.GENERIC_ARMOR, modifier);
        copperChestplate = item;
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("copper_chestplate"), item);
        sr.shape("X X",
                "XXX",
                "XXX");
        sr.setIngredient('X', Material.COPPER_INGOT);
        Bukkit.getServer().addRecipe(sr);
    }
    public static ItemStack copperLeggings;
    private static void createCopperLeggings(){
        ItemStack item = new ItemStack(Material.IRON_LEGGINGS, 1);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§fCopper Leggings");
        im.setCustomModelData(1);
        AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "generic.armor",
                4, Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        im.addAttributeModifier(Attribute.GENERIC_ARMOR, modifier);
        item.setItemMeta(im);
        copperLeggings = item;
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("copper_leggings"), item);
        sr.shape("XXX",
                "X X",
                "X X");
        sr.setIngredient('X', Material.COPPER_INGOT);
        Bukkit.getServer().addRecipe(sr);
    }
    public static ItemStack copperBoots;
    private static void createCopperBoots(){
        ItemStack item = new ItemStack(Material.IRON_BOOTS, 1);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§fCopper Boots");
        im.setCustomModelData(1);
        item.setItemMeta(im);
        copperBoots = item;
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("copper_boots"), item);
        sr.shape("   ",
                "X X",
                "X X");
        sr.setIngredient('X', Material.COPPER_INGOT);
        ShapedRecipe sr2 = new ShapedRecipe(NamespacedKey.minecraft("copper_boots2"), item);
        sr2.shape("X X",
                "X X",
                "   ");
        sr2.setIngredient('X', Material.COPPER_INGOT);
        Bukkit.getServer().addRecipe(sr);
        Bukkit.getServer().addRecipe(sr2);
    }
    public static ItemStack copperShovel;
    private static void createCopperShovel(){
        ItemStack item = new ItemStack(Material.IRON_SHOVEL, 1);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§fCopper Shovel");
        im.setCustomModelData(1);
        item.setItemMeta(im);
        copperBoots = item;
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("copper_shovel"), item);
        sr.shape(" X ",
                " Y ",
                " Y ");
        sr.setIngredient('X', Material.COPPER_INGOT);
        sr.setIngredient('Y', Material.STICK);

        ShapedRecipe sr2 = new ShapedRecipe(NamespacedKey.minecraft("copper_shovel2"), item);
        sr2.shape("X  ",
                "Y  ",
                "Y  ");
        sr2.setIngredient('X', Material.COPPER_INGOT);
        sr2.setIngredient('Y', Material.STICK);

        ShapedRecipe sr3 = new ShapedRecipe(NamespacedKey.minecraft("copper_shovel3"), item);
        sr3.shape("  X",
                "  Y",
                "  Y");
        sr3.setIngredient('X', Material.COPPER_INGOT);
        sr3.setIngredient('Y', Material.STICK);
        Bukkit.getServer().addRecipe(sr);
        Bukkit.getServer().addRecipe(sr2);
        Bukkit.getServer().addRecipe(sr3);
    }
    public static ItemStack copperHoe;
    private static void createCopperHoe(){
        ItemStack item = new ItemStack(Material.STONE_HOE, 1);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§fCopper Hoe");
        im.setCustomModelData(1);
        item.setItemMeta(im);
        copperHoe = item;
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("copper_hoe"), item);
        sr.shape(" XX",
                " Y ",
                " Y ");
        sr.setIngredient('X', Material.COPPER_INGOT);
        sr.setIngredient('Y', Material.STICK);

        ShapedRecipe sr2 = new ShapedRecipe(NamespacedKey.minecraft("copper_hoe2"), item);
        sr2.shape("XX ",
                " Y ",
                " Y ");
        sr2.setIngredient('X', Material.COPPER_INGOT);
        sr2.setIngredient('Y', Material.STICK);

        ShapedRecipe sr3 = new ShapedRecipe(NamespacedKey.minecraft("copper_hoe3"), item);
        sr3.shape(" XX",
                "  Y",
                "  Y");
        sr3.setIngredient('X', Material.COPPER_INGOT);
        sr3.setIngredient('Y', Material.STICK);

        ShapedRecipe sr4 = new ShapedRecipe(NamespacedKey.minecraft("copper_hoe4"), item);
        sr4.shape("XX ",
                "Y  ",
                "Y  ");
        sr4.setIngredient('X', Material.COPPER_INGOT);
        sr4.setIngredient('Y', Material.STICK);
        Bukkit.getServer().addRecipe(sr);
        Bukkit.getServer().addRecipe(sr2);
        Bukkit.getServer().addRecipe(sr3);
        Bukkit.getServer().addRecipe(sr4);

    }
}