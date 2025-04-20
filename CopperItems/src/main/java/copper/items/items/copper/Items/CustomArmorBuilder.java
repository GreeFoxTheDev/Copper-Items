package copper.items.items.copper.Items;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.EquipmentSlotGroup;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ArmorMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.components.CustomModelDataComponent;
import org.bukkit.inventory.meta.trim.ArmorTrim;
import org.bukkit.inventory.meta.trim.TrimMaterial;
import org.bukkit.inventory.meta.trim.TrimPattern;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class CustomArmorBuilder {

    private final ItemStack item;
    private final ItemMeta meta;
    private final List<String> lore = new ArrayList<>();
    private final NamespacedKey itemKey;
    private int recipeCount = 0;

    public CustomArmorBuilder(Material material, String displayName, String internalName, int modelData) {
        this.item = new ItemStack(material, 1);
        this.meta = item.getItemMeta();
        this.meta.setDisplayName(displayName);
        this.meta.setItemName(internalName);


        if (meta instanceof ArmorMeta am) {
            am.setTrim(new ArmorTrim(setCustomTrimMaterial(), setCustomTrimPattern()));
        }
        this.meta.addItemFlags(ItemFlag.HIDE_ARMOR_TRIM);
        //this.meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        CustomModelDataComponent cmdComponent = meta.getCustomModelDataComponent();
        cmdComponent.setFloats(Collections.singletonList((float) modelData));
        meta.setCustomModelDataComponent(cmdComponent);
        this.itemKey = new NamespacedKey("epic_weapons", internalName);
    }

    private static TrimPattern setCustomTrimPattern() {
        NamespacedKey key = NamespacedKey.fromString("copper_armor:custom_copper");
        return Bukkit.getRegistry(TrimPattern.class).get(key);
    }

    private static TrimMaterial setCustomTrimMaterial() {
        NamespacedKey key = NamespacedKey.fromString("copper_armor:custom_copper");
        return Bukkit.getRegistry(TrimMaterial.class).get(key);
    }

    public CustomArmorBuilder addAttributes(double armorValue, double armorTValue, EquipmentSlotGroup slot) {
        AttributeModifier armor = new AttributeModifier(
                new NamespacedKey("epic_weapons", meta.getItemName() + "_armor"),
                armorValue,
                AttributeModifier.Operation.ADD_NUMBER,
                slot
        );
        AttributeModifier armorT = new AttributeModifier(
                new NamespacedKey("epic_weapons", meta.getItemName() + "_armort"),
                -armorTValue,
                AttributeModifier.Operation.ADD_NUMBER,
                slot
        );
        meta.addAttributeModifier(Attribute.ARMOR, armor);
        meta.addAttributeModifier(Attribute.ARMOR_TOUGHNESS, armorT);


        return this;
    }

    public CustomArmorBuilder addRecipe2(String[] shape, Map<Character, Material> ingredients) {
        meta.setLore(lore);
        item.setItemMeta(meta);

        NamespacedKey recipeKey = new NamespacedKey(itemKey.getNamespace(), itemKey.getKey() + "_recipe_" + recipeCount);
        recipeCount++;
        ShapedRecipe recipe = new ShapedRecipe(recipeKey, item);

        recipe.shape(shape);
        for (Map.Entry<Character, Material> entry : ingredients.entrySet()) {
            recipe.setIngredient(entry.getKey(), entry.getValue());
        }

        Bukkit.getServer().addRecipe(recipe);
        return this;
    }

    public ItemStack build() {
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

    public NamespacedKey getKey() {
        return itemKey;
    }
}
