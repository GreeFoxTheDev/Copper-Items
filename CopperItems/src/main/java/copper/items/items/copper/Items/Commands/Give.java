package copper.items.items.copper.Items.Commands;

import copper.items.items.copper.Items.CopperItems;
import copper.items.items.copper.Items.Items;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.StringUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Give implements CommandExecutor, TabCompleter {
    private static final String[] ARGS = {"copper_sword", "copper_axe", "copper_pickaxe", "copper_helmet", "copper_chestplate", "copper_leggings", "copper_boots", "copper_shovel", "copper_hoe"};
    CopperItems plugin;

    public Give(CopperItems plugin) {
        this.plugin = plugin;
    }
    private void addItemToInventory(Player player, ItemStack item) {
        player.getInventory().addItem(item);
    }
    private void dropItem(Player player, ItemStack itemStack) {
        player.getWorld().dropItemNaturally(player.getLocation(), itemStack);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("givecopperitem")) {
            if (args.length == 1) {
                if (sender instanceof BlockCommandSender) {
                    Location loc = ((BlockCommandSender) sender).getBlock().getLocation();
                    Entity closestEntity = null;
                    double lowestDistSoFar = Double.MAX_VALUE;
                    for (Entity entity : loc.getWorld().getNearbyEntities(loc, 100, 100, 100)) {
                        if (entity instanceof Player) {
                            double distance = entity.getLocation().distance(loc);
                            if (distance < lowestDistSoFar) {
                                lowestDistSoFar = distance;
                                closestEntity = entity;

                            }
                        }
                    }
                    if (closestEntity != null) {
                        switch (args[0]) {
                            case "copper_sword": addItemToInventory((Player) closestEntity, Items.copperSword); break;
                            case "copper_axe": addItemToInventory((Player) closestEntity, Items.copperAxe); break;
                            case "copper_pickaxe": addItemToInventory((Player) closestEntity, Items.copperPickaxe); break;
                            case "copper_helmet": addItemToInventory((Player) closestEntity, Items.copperHelmet); break;
                            case "copper_chestplate": addItemToInventory((Player) closestEntity, Items.copperChestplate); break;
                            case "copper_leggings": addItemToInventory((Player) closestEntity, Items.copperLeggings); break;
                            case "copper_boots": addItemToInventory((Player) closestEntity, Items.copperBoots); break;
                            case "copper_shovel": addItemToInventory((Player) closestEntity, Items.copperShovel); break;
                            case "copper_hoe": addItemToInventory((Player) closestEntity, Items.copperHoe); break;
                        }
                    }
                } else if (sender instanceof Player) {
                    Player player = (Player) sender;
                    if (player.isOp()) {
                        switch (args[0]) {
                            case "copper_sword": addItemToInventory(player, Items.copperSword); break;
                            case "copper_axe": addItemToInventory(player, Items.copperAxe); break;
                            case "copper_pickaxe": addItemToInventory(player, Items.copperPickaxe); break;
                            case "copper_helmet": addItemToInventory(player, Items.copperHelmet); break;
                            case "copper_chestplate": addItemToInventory(player, Items.copperChestplate); break;
                            case "copper_leggings": addItemToInventory(player, Items.copperLeggings); break;
                            case "copper_boots": addItemToInventory(player, Items.copperBoots); break;
                            case "copper_shovel": addItemToInventory(player, Items.copperShovel); break;
                            case "copper_hoe": addItemToInventory(player, Items.copperHoe); break;
                        }
                    } else sender.sendMessage(ChatColor.RED + "You don't have permission to do that!");
                }
            } else if (args.length == 2) {
                String playerName = args[1];
                Player chosenPlayer = Bukkit.getPlayer(playerName);
                assert chosenPlayer != null;
                if (Arrays.toString(Bukkit.getOnlinePlayers().toArray()).contains(playerName)) {
                    if (sender instanceof Player || sender instanceof BlockCommandSender) {
                        if (sender.isOp()) {
                            sender.sendMessage("Gave 1 [" + args[0] + "] to player " + args[1]);
                            if (!(chosenPlayer.getInventory().firstEmpty() == -1)) {
                                switch (args[0]) {
                                    case "copper_sword": addItemToInventory(chosenPlayer, Items.copperSword); break;
                                    case "copper_axe": addItemToInventory(chosenPlayer, Items.copperAxe); break;
                                    case "copper_pickaxe": addItemToInventory(chosenPlayer, Items.copperPickaxe); break;
                                    case "copper_helmet": addItemToInventory(chosenPlayer, Items.copperHelmet); break;
                                    case "copper_chestplate": addItemToInventory(chosenPlayer, Items.copperChestplate); break;
                                    case "copper_leggings": addItemToInventory(chosenPlayer, Items.copperLeggings); break;
                                    case "copper_boots": addItemToInventory(chosenPlayer, Items.copperBoots); break;
                                    case "copper_shovel": addItemToInventory(chosenPlayer, Items.copperShovel); break;
                                    case "copper_hoe": addItemToInventory(chosenPlayer, Items.copperHoe); break;
                                }
                            } else if (chosenPlayer.getInventory().firstEmpty() == -1) {
                                switch (args[0]) {
                                    case "copper_sword": dropItem(chosenPlayer, Items.copperSword); break;
                                    case "copper_axe": dropItem(chosenPlayer, Items.copperAxe); break;
                                    case "copper_pickaxe": dropItem(chosenPlayer, Items.copperPickaxe); break;
                                    case "copper_helmet": dropItem(chosenPlayer, Items.copperHelmet); break;
                                    case "copper_chestplate": dropItem(chosenPlayer, Items.copperChestplate); break;
                                    case "copper_leggings": dropItem(chosenPlayer, Items.copperLeggings); break;
                                    case "copper_boots": dropItem(chosenPlayer, Items.copperBoots); break;
                                    case "copper_shovel": dropItem(chosenPlayer, Items.copperShovel); break;
                                    case "copper_hoe": dropItem(chosenPlayer, Items.copperHoe); break;
                                }
                            }
                        } else sender.sendMessage(ChatColor.RED + "You don't have permission to do that!");
                    } else if (sender instanceof ConsoleCommandSender) {
                        sender.sendMessage("Player only command!");
                    }
                } else if (!(args[1].equals("@a"))) {
                    sender.sendMessage(ChatColor.RED + "Unable to find player " + args[1]);
                }
                if ((sender instanceof Player || sender instanceof BlockCommandSender) && args[1].equalsIgnoreCase("@a")) {
                    if (sender.isOp()) {
                        sender.sendMessage("Gave [" + args[0] + "] to all players.");
                        for (Player allOnlinePlayers : Bukkit.getOnlinePlayers()) {
                            if (!(allOnlinePlayers.getInventory().firstEmpty() == -1)) {
                                switch (args[0]) {
                                    case "copper_sword": addItemToInventory(allOnlinePlayers, Items.copperSword); break;
                                    case "copper_axe": addItemToInventory(allOnlinePlayers, Items.copperAxe); break;
                                    case "copper_pickaxe": addItemToInventory(allOnlinePlayers, Items.copperPickaxe); break;
                                    case "copper_helmet": addItemToInventory(allOnlinePlayers, Items.copperHelmet); break;
                                    case "copper_chestplate": addItemToInventory(allOnlinePlayers, Items.copperChestplate); break;
                                    case "copper_leggings": addItemToInventory(allOnlinePlayers, Items.copperLeggings); break;
                                    case "copper_boots": addItemToInventory(allOnlinePlayers, Items.copperBoots); break;
                                    case "copper_shovel": addItemToInventory(allOnlinePlayers, Items.copperShovel); break;
                                    case "copper_hoe": addItemToInventory(allOnlinePlayers, Items.copperHoe); break;
                                }
                            } else if (allOnlinePlayers.getInventory().firstEmpty() == -1) {
                                switch (args[0]) {
                                    case "copper_sword": dropItem(allOnlinePlayers, Items.copperSword); break;
                                    case "copper_axe": dropItem(allOnlinePlayers, Items.copperAxe); break;
                                    case "copper_pickaxe": dropItem(allOnlinePlayers, Items.copperPickaxe); break;
                                    case "copper_helmet": dropItem(allOnlinePlayers, Items.copperHelmet); break;
                                    case "copper_chestplate": dropItem(allOnlinePlayers, Items.copperChestplate); break;
                                    case "copper_leggings": dropItem(allOnlinePlayers, Items.copperLeggings); break;
                                    case "copper_boots": dropItem(allOnlinePlayers, Items.copperBoots); break;
                                    case "copper_shovel": dropItem(allOnlinePlayers, Items.copperShovel); break;
                                    case "copper_hoe": dropItem(allOnlinePlayers, Items.copperHoe); break;
                                }
                            }
                        }
                    } else sender.sendMessage(ChatColor.RED + "You don't have permission to do that!");
                }
            }
        }
        return true;
    }

    @Nullable
    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        final List<String> items = new ArrayList<>();
        StringUtil.copyPartialMatches(args[0], Arrays.asList(ARGS), items);
        Collections.sort(items);
        if (args.length == 1) {
            return items;
        }

        final ArrayList<String> finalNames = new ArrayList<>();
        ArrayList<String> names = new ArrayList<>();
        names.add("@a");

        String[] ARGS1 = new String[names.size()];
        for (Player p : Bukkit.getOnlinePlayers()) {
            String name = p.getName();
            names.add(name);
        }
        ARGS1 = names.toArray(ARGS1);
        StringUtil.copyPartialMatches(args[1], Arrays.asList(ARGS1), finalNames);
        if (args.length == 2) {
            return finalNames;
        }
        return new ArrayList<>();
    }
}
