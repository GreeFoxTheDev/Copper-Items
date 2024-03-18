package copper.items.items.copper.Items.Listeners;

import copper.items.items.copper.Items.CopperItems;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/*public class Oxidize implements Listener {
    CopperItems plugin;

    public Oxidize(CopperItems plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void OnHitItem(PlayerItemDamageEvent e) {
        ItemStack item = e.getItem();
        ItemMeta im = e.getItem().getItemMeta();
        String locName = im.getLocalizedName();
        if (item.hasItemMeta() && im.hasLocalizedName()) {
            if (locName.equalsIgnoreCase("copper_axe") || locName.equalsIgnoreCase("copper_sword") || locName.equalsIgnoreCase("copper_hoe") || locName.equalsIgnoreCase("copper_pickaxe") || locName.equalsIgnoreCase("copper_shovel")) {
                int bad_durability = e.getItem().getDurability();
                int durability = e.getItem().getData().getItemType().getMaxDurability() - bad_durability - 1;
                int durability_smol = e.getItem().getData().getItemType().getMaxDurability() / 5;
                int customModelData;
                if (durability >= durability_smol * 4) {
                    customModelData = 1;
                } else if (durability >= durability_smol * 3) {
                    customModelData = 2;
                } else if (durability >= durability_smol * 2) {
                    customModelData = 3;
                } else if (durability >= durability_smol) {
                    customModelData = 4;
                } else {
                    customModelData = 5;
                }
                im.setCustomModelData(customModelData);
                e.getItem().setItemMeta(im);
            }
        }

    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void OnHitArmor(PlayerItemDamageEvent e) {
        ItemStack item = e.getItem();
        ItemMeta im = e.getItem().getItemMeta();
        String locName = im.getLocalizedName();
        if (item.hasItemMeta() && im.hasLocalizedName()) {
            if (locName.equalsIgnoreCase("copper_helmet") || locName.equalsIgnoreCase("copper_chestplate") || locName.equalsIgnoreCase("copper_leggings") || locName.equalsIgnoreCase("copper_boots")) {
                int bad_durability = e.getItem().getDurability();
                int durability = e.getItem().getData().getItemType().getMaxDurability() - bad_durability - 1;
                int durability_smol = e.getItem().getData().getItemType().getMaxDurability() / 5;
                int customModelData;
                String helmetName = CopperItems.getCurrentLang().getString("armor.helmet");
                String chestplateName = CopperItems.getCurrentLang().getString("armor.chestplate");
                String leggingsName = CopperItems.getCurrentLang().getString("armor.leggings");
                String bootsName = CopperItems.getCurrentLang().getString("armor.boots");

                String helmet = helmetName;
                String chestplate = chestplateName;
                String leggings = leggingsName;
                String boots = bootsName;

                String weathered =  CopperItems.getCurrentLang().getString("misc.weathered");
                String slightly_oxidized = CopperItems.getCurrentLang().getString("misc.slightly") + " " + CopperItems.getCurrentLang().getString("misc.oxidized");
                String oxidized = CopperItems.getCurrentLang().getString("misc.oxidized");
                String damaged = CopperItems.getCurrentLang().getString("misc.damaged");
                if (durability >= durability_smol * 4) {
                    customModelData = 1;
                    helmetName = helmet;
                    chestplateName = chestplate;
                    leggingsName = leggings;
                    bootsName = boots;
                } else if (durability >= durability_smol * 3) {
                    customModelData = 2;
                    helmetName = weathered + " " + helmet;
                    chestplateName = weathered + " " + chestplate;
                    leggingsName = weathered + " " + leggings;
                    bootsName = weathered + " " + boots;
                } else if (durability >= durability_smol * 2) {
                    customModelData = 3;
                    helmetName = slightly_oxidized + " " + helmet;
                    chestplateName = slightly_oxidized + " " + chestplate;
                    leggingsName = slightly_oxidized + " " + leggings;
                    bootsName = slightly_oxidized + " " + boots;
                } else if (durability >= durability_smol) {
                    customModelData = 4;
                    helmetName = oxidized + " " + helmet;
                    chestplateName = oxidized + " " + chestplate;
                    leggingsName = oxidized + " " + leggings;
                    bootsName = oxidized + " " + boots;
                } else {
                    customModelData = 5;
                    helmetName = damaged + " " + helmet;
                    chestplateName = damaged + " " + chestplate;
                    leggingsName = damaged + " " + leggings;
                    bootsName = damaged + " " + boots;

                }
                switch (locName) {
                    case "copper_helmet":
                        im.setDisplayName(ChatColor.WHITE + helmetName);
                        break;
                    case "copper_chestplate":
                        im.setDisplayName(ChatColor.WHITE + chestplateName);
                        break;
                    case "copper_leggings":
                        im.setDisplayName(ChatColor.WHITE + leggingsName);
                        break;
                    case "copper_boots":
                        im.setDisplayName(ChatColor.WHITE + bootsName);
                        break;
                }
                im.setCustomModelData(customModelData);
                e.getItem().setItemMeta(im);
            }
        }
    }
}*/
public class Oxidize implements Listener {
    CopperItems plugin;

    public Oxidize(CopperItems plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onItemDamage(PlayerItemDamageEvent e) {
        ItemStack item = e.getItem();
        ItemMeta im = item.getItemMeta();
        if (im == null) return; // Make sure item meta is not null

        String locName = im.getLocalizedName();
        if (locName == null) return; // Make sure localizedName is not null

        if (locName.startsWith("copper_")) {
            int badDurability = item.getDurability();
            int maxDurability = item.getType().getMaxDurability();
            int durability = maxDurability - badDurability - 1;
            int durabilitySmol = maxDurability / 5;

            int customModelData = -1;
            String displayName;


            if (durability >= durabilitySmol * 4) {
                customModelData = 1;
            } else if (durability >= durabilitySmol * 3) {
                customModelData = 2;
            } else if (durability >= durabilitySmol * 2) {
                customModelData = 3;
            } else if (durability >= durabilitySmol) {
                customModelData = 4;
            } else {
                customModelData = 5;
            }

            im.setCustomModelData(customModelData);
            //im.setDisplayName(ChatColor.WHITE + displayName);

            item.setItemMeta(im);
        }
    }
}
