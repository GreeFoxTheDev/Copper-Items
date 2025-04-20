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
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.components.CustomModelDataComponent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class CustomItemBuilder {

    private final ItemStack item;
    private final ItemMeta meta;
    private final List<String> lore = new ArrayList<>();
    private final NamespacedKey itemKey;

    public CustomItemBuilder(Material material, String displayName, String internalName, int modelData) {
        this.item = new ItemStack(material, 1);
        this.meta = item.getItemMeta();
        this.meta.setDisplayName(displayName);
        this.meta.setItemName(internalName);
        this.meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        CustomModelDataComponent cmdComponent = meta.getCustomModelDataComponent();
        cmdComponent.setFloats(Collections.singletonList((float) modelData));
        meta.setCustomModelDataComponent(cmdComponent);
        this.itemKey = new NamespacedKey("epic_weapons", internalName);
    }

    public CustomItemBuilder addAttributes(double damageValue, double attackSpeedValue, double miningSpeedValue, double blockInteractionValue, double entityInteractionValue) {
                AttributeModifier damage = new AttributeModifier(
                new NamespacedKey("epic_weapons", "custom_damage"),
                        damageValue,
                AttributeModifier.Operation.ADD_NUMBER,
                EquipmentSlotGroup.HAND
        );
        AttributeModifier speed = new AttributeModifier(
                new NamespacedKey("epic_weapons", "custom_speed"),
                -4.0 + attackSpeedValue,
                AttributeModifier.Operation.ADD_NUMBER,
                EquipmentSlotGroup.HAND
        );
        AttributeModifier miningSpeed = new AttributeModifier(new NamespacedKey("epic_weapons", "custom_mining_speed"),
                miningSpeedValue,
                AttributeModifier.Operation.ADD_NUMBER,
                EquipmentSlotGroup.HAND);
        AttributeModifier blockInteraction = new AttributeModifier(new NamespacedKey("epic_weapons", "custom_block_interaction"),
                blockInteractionValue,
                AttributeModifier.Operation.ADD_NUMBER,
                EquipmentSlotGroup.HAND);
        AttributeModifier entityInteraction = new AttributeModifier(new NamespacedKey("epic_weapons", "custom_block_interaction"),
                entityInteractionValue,
                AttributeModifier.Operation.ADD_NUMBER,
                EquipmentSlotGroup.HAND);
        meta.addAttributeModifier(Attribute.ATTACK_SPEED, speed);
        meta.addAttributeModifier(Attribute.ATTACK_DAMAGE, damage);
        meta.addAttributeModifier(Attribute.BLOCK_BREAK_SPEED, miningSpeed);
        meta.addAttributeModifier(Attribute.BLOCK_INTERACTION_RANGE, blockInteraction);
        meta.addAttributeModifier(Attribute.ENTITY_INTERACTION_RANGE, entityInteraction);

        return this;
    }

    public CustomItemBuilder addLoreLine(String line) {
        lore.add(line);
        return this;
    }

    public CustomItemBuilder addRecipe(String[] shape, Map<Character, Material> ingredients) {
        meta.setLore(lore);
        item.setItemMeta(meta);
        ShapedRecipe recipe = new ShapedRecipe(itemKey, item);
        recipe.shape(shape);
        for (Map.Entry<Character, Material> entry : ingredients.entrySet()) {
            recipe.setIngredient(entry.getKey(), entry.getValue());
        }
        Bukkit.getServer().addRecipe(recipe);
        return this;
    }

    private int recipeCount = 0;

    public CustomItemBuilder addRecipe2(String[] shape, Map<Character, Material> ingredients) {
        meta.setLore(lore);
        item.setItemMeta(meta);

        NamespacedKey recipeKey = new NamespacedKey(itemKey.getNamespace(), itemKey.getKey() + "_recipe_" + recipeCount++);
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
