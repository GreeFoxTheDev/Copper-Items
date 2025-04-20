package copper.items.items.copper.Items.Commands;

import copper.items.items.copper.Items.CopperItems;
import copper.items.items.copper.Items.Items;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.StringUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public class Give implements CommandExecutor, TabCompleter {
    private static final String[] ITEM_NAMES = {
            "copper_sword", "copper_axe", "copper_pickaxe", "copper_helmet",
            "copper_chestplate", "copper_leggings", "copper_boots",
            "copper_shovel", "copper_hoe"
    };

    private final CopperItems plugin;

    public Give(CopperItems plugin) {
        this.plugin = plugin;
    }

    private void giveOrDrop(Player player, ItemStack item) {
        if (player.getInventory().firstEmpty() != -1) {
            player.getInventory().addItem(item);
        } else {
            player.getWorld().dropItemNaturally(player.getLocation(), item);
        }
    }

    private ItemStack getItemByName(String name) {
        return switch (name) {
            case "copper_sword" -> Items.copperSword;
            case "copper_axe" -> Items.copperAxe;
            case "copper_pickaxe" -> Items.copperPickaxe;
            case "copper_helmet" -> Items.copperHelmet;
            case "copper_chestplate" -> Items.copperChestplate;
            case "copper_leggings" -> Items.copperLeggings;
            case "copper_boots" -> Items.copperBoots;
            case "copper_shovel" -> Items.copperShovel;
            case "copper_hoe" -> Items.copperHoe;
            default -> null;
        };
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, String label, String[] args) {
        if (!label.equalsIgnoreCase("givecopperitem")) return true;
        if (args.length < 1 || args.length > 2) return false;

        String itemKey = args[0];
        ItemStack item = getItemByName(itemKey);
        if (item == null) {
            sender.sendMessage(ChatColor.RED + "Unknown item: " + itemKey);
            return true;
        }

        if (args.length == 1) {
            if (sender instanceof Player player) {
                if (player.isOp()) {
                    giveOrDrop(player, item);
                } else {
                    sender.sendMessage(ChatColor.RED + "You don't have permission to do that!");
                }
            } else if (sender instanceof BlockCommandSender blockSender) {
                Location loc = blockSender.getBlock().getLocation();
                Player closest = loc.getWorld().getNearbyEntities(loc, 100, 100, 100).stream()
                        .filter(e -> e instanceof Player)
                        .map(e -> (Player) e)
                        .min(Comparator.comparingDouble(p -> p.getLocation().distance(loc)))
                        .orElse(null);
                if (closest != null) {
                    giveOrDrop(closest, item);
                }
            }
        } else if (args.length == 2) {
            if (!(sender instanceof ConsoleCommandSender) && !sender.isOp()) {
                sender.sendMessage(ChatColor.RED + "You don't have permission to do that!");
                return true;
            }

            if (args[1].equalsIgnoreCase("@a")) {
                for (Player p : Bukkit.getOnlinePlayers()) {
                    giveOrDrop(p, item);
                }
                sender.sendMessage("Gave [" + itemKey + "] to all players.");
                return true;
            }

            Player target = Bukkit.getPlayerExact(args[1]);
            if (target == null) {
                sender.sendMessage(ChatColor.RED + "Unable to find player " + args[1]);
                return true;
            }

            giveOrDrop(target, item);
            sender.sendMessage("Gave 1 [" + itemKey + "] to player " + args[1]);
        }

        return true;
    }

    @Nullable
    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command,
                                      @NotNull String label, @NotNull String[] args) {
        if (args.length == 1) {
            return StringUtil.copyPartialMatches(args[0], Arrays.asList(ITEM_NAMES), new ArrayList<>());
        } else if (args.length == 2) {
            List<String> names = new ArrayList<>();
            names.add("@a");
            for (Player p : Bukkit.getOnlinePlayers()) {
                names.add(p.getName());
            }
            return StringUtil.copyPartialMatches(args[1], names, new ArrayList<>());
        }
        return Collections.emptyList();
    }
}
