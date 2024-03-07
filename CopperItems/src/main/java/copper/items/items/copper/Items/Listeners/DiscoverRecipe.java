package copper.items.items.copper.Items.Listeners;

import copper.items.items.copper.Items.CopperItems;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRecipeDiscoverEvent;

import java.util.ArrayList;
import java.util.List;

public class DiscoverRecipe implements Listener {
    CopperItems plugin;

    public DiscoverRecipe(CopperItems plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void ItemPickup(PlayerRecipeDiscoverEvent e) {
        Player player = e.getPlayer();
        if (e.getRecipe().equals(NamespacedKey.minecraft("lightning_rod"))) {

            List<NamespacedKey> copperKeys = new ArrayList<>();

            copperKeys.add(NamespacedKey.minecraft("copper_axe"));
            copperKeys.add(NamespacedKey.minecraft("copper_pickaxe"));
            copperKeys.add(NamespacedKey.minecraft("copper_shovel"));
            copperKeys.add(NamespacedKey.minecraft("copper_sword"));
            copperKeys.add(NamespacedKey.minecraft("copper_hoe"));
            copperKeys.add(NamespacedKey.minecraft("copper_helmet"));
            copperKeys.add(NamespacedKey.minecraft("copper_leggings"));
            copperKeys.add(NamespacedKey.minecraft("copper_chestplate"));
            copperKeys.add(NamespacedKey.minecraft("copper_boots"));

            player.discoverRecipes(copperKeys);
        }
    }
}