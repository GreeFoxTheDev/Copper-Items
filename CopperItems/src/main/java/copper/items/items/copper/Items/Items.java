package copper.items.items.copper.Items;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.attribute.AttributeModifier.Operation;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.UUID;

public class Items extends JavaPlugin {

    public static void init() {
        createCopperSword();
        createCopperAxe();
        createCopperPickaxe();
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
        AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed",
                6.5, Operation.ADD_NUMBER, EquipmentSlot.HAND);
        im.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(),
                "generic.attackSpeed", 1.7, Operation.ADD_NUMBER, EquipmentSlot.HAND);
        im.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);
        item.setDurability((short) 450);
        item.setItemMeta(im);
        copperSword = item;

        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("copper_sword"), item);
        sr.shape(" X ",
                " X ",
                " Y ");
        sr.setIngredient('X', Material.COPPER_INGOT);
        sr.setIngredient('Y', Material.STICK);
        Bukkit.getServer().addRecipe(sr);
    }
    public static ItemStack copperAxe;
    private  static void createCopperAxe(){
        ItemStack item = new ItemStack(Material.IRON_AXE);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§fCopper Axe");
        AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed",
                9.5, Operation.ADD_NUMBER, EquipmentSlot.HAND);
        im.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(),
                "generic.attackSpeed", 0.9, Operation.ADD_NUMBER, EquipmentSlot.HAND);
        im.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speed);
        item.setDurability((short) 450);
        item.setItemMeta(im);
        copperAxe = item;

        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("copper_sword"), item);
        sr.shape("XX ",
                "XY ",
                " Y ");
        sr.setIngredient('X', Material.COPPER_INGOT);
        sr.setIngredient('Y', Material.STICK);
        Bukkit.getServer().addRecipe(sr);
    }
    public static ItemStack copperPickaxe;
    private static void createCopperPickaxe(){
        ItemStack item = new ItemStack(Material.IRON_PICKAXE, 1);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("Copper Pickaxe");
        item.setDurability((short) 450);
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
        im.setDisplayName("Copper Helmet");
        item.setDurability((short) 150);
        item.setItemMeta(im);
        copperHelmet = item;
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("copper_helmet"), item);
        sr.shape("XXX",
                "X X",
                "   ");
        sr.setIngredient('X', Material.COPPER_INGOT);
        Bukkit.getServer().addRecipe(sr);
    }
    public static ItemStack copperChestplate;
    private static void createCopperChestplate(){
        ItemStack item = new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("Copper Chestplate");
        item.setItemMeta(im);
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
        ItemStack item = new ItemStack(Material.CHAINMAIL_LEGGINGS);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("Copper Leggings");
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
        im.setDisplayName("Copper Boots");
        item.setDurability((short) 150);
        copperBoots = item;
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("copper_boots"), item);
        sr.shape("   ",
                "X X",
                "X X");
        sr.setIngredient('X', Material.COPPER_INGOT);
        Bukkit.getServer().addRecipe(sr);
    }
    //public static PotionEffect copperPotion;
    //private static void createCopperPotion(){
    //    PotionEffect potionEffect = new PotionEffect(PotionEffectType.WITHER, 10, 2, true, true, true)
    //}

}
