package copper.items.items.copper.Items;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ItemBuilder {
    private Material material;
    private String displayName;
    private String localName;
    private boolean hideAttributes;
    private int customModelData;
    private double attackDamage;
    private double attackSpeed;
    private List<String> lore;
    private int amount;
    private boolean glowing;
    private Enchantment enchantment;
    private int enchantmentLevel;
    private String[] recipeShape;
    private String[] ingredients;

    public ItemBuilder(Material material) {
        this.material = material;
        this.displayName = "";
        this.localName = "";
        this.hideAttributes = true;
        this.customModelData = -1;
        this.lore = new ArrayList<>();
        this.amount = 1;
        this.glowing = false;
        this.enchantment = null;
        this.enchantmentLevel = 0;
        this.recipeShape = null;
        this.ingredients = null;
    }

    public ItemBuilder setDisName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    public ItemBuilder setLocName(String localName) {
        this.localName = localName;
        return this;
    }

    public ItemBuilder hideAttributes(boolean hideAttributes) {
        this.hideAttributes = hideAttributes;
        return this;
    }

    public ItemBuilder setAttackDamage(double attackDamage) {
        this.attackDamage = attackDamage;
        return this;
    }

    public ItemBuilder setAttackSpeed(double attackSpeed) {
        this.attackSpeed = attackSpeed;
        return this;
    }

    public ItemBuilder setCustomModelData(int customModelData) {
        this.customModelData = customModelData;
        return this;
    }

    public ItemBuilder addLore(String lore) {
        this.lore.add(lore);
        return this;
    }

    public ItemBuilder setAmount(int amount) {
        this.amount = amount;
        return this;
    }

    public ItemBuilder setGlowing(boolean glowing) {
        this.glowing = glowing;
        return this;
    }

    public ItemBuilder setEnchantment(Enchantment enchantment, int level) {
        this.enchantment = enchantment;
        this.enchantmentLevel = level;
        return this;
    }
    public ItemBuilder setRecipe(String[] recipeShape, String[] ingredients) {
        this.recipeShape = recipeShape;
        this.ingredients = ingredients;
        return this;
    }

    public ItemStack build() {
        ItemStack itemStack = new ItemStack(material, amount);
        ItemMeta meta = itemStack.getItemMeta();
        meta.setDisplayName(ChatColor.WHITE + displayName);
        meta.setLocalizedName(localName);
        //lore.add("");
        lore.add(ChatColor.GRAY + CopperItems.getCurrentLang().getString("item_description.in_main_hand"));
        String damage = String.valueOf(attackDamage);
        String speed = String.valueOf(attackSpeed);
        lore.add(ChatColor.DARK_GREEN + " " + damage + CopperItems.getCurrentLang().getString("item_description.att_damage"));
        lore.add(ChatColor.DARK_GREEN + " " + speed + CopperItems.getCurrentLang().getString("item_description.att_speed"));
        meta.setLore(lore);
        meta.setCustomModelData(customModelData);
        AttributeModifier damageMod = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", attackDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damageMod);
        AttributeModifier speedMod = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", -4.0 + attackSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, speedMod);
        if (hideAttributes) {
            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        }
        if (glowing) {
            // Example enchantment for glowing effect
            meta.addEnchant(Enchantment.LUCK, 1, true);
        }
        if (enchantment != null) {
            meta.addEnchant(enchantment, enchantmentLevel, true);
        }
        itemStack.setItemMeta(meta);

        if (recipeShape != null && ingredients != null) {
            ShapedRecipe recipe = new ShapedRecipe(NamespacedKey.minecraft(localName), itemStack);
            recipe.shape(recipeShape);
            for (int i = 0; i < recipeShape.length; i++) {
                for (int j = 0; j < recipeShape[i].length(); j++) {
                    char ingredientChar = recipeShape[i].charAt(j);
                    if (ingredientChar != ' ') {
                        recipe.setIngredient(ingredientChar, Material.matchMaterial(ingredients[i * recipeShape[i].length() + j]));
                    }
                }
            }
            Bukkit.getServer().addRecipe(recipe);
        }


        return itemStack;
    }
}