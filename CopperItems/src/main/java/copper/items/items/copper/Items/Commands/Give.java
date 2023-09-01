package copper.items.items.copper.Items.Commands;

import copper.items.items.copper.Items.CopperItems;
import copper.items.items.copper.Items.Items;
import me.greefox.greefox.me.Greefox.Katanas;
import me.greefox.greefox.me.Greefox.KatanasTypes.Light.CopperLight;
import me.greefox.greefox.me.Greefox.KatanasTypes.Light.DiamondLight;
import me.greefox.greefox.me.Greefox.KatanasTypes.Light.GoldLight;
import me.greefox.greefox.me.Greefox.KatanasTypes.Light.IronLight;
import me.greefox.greefox.me.Greefox.KatanasTypes.Strong.Copper;
import me.greefox.greefox.me.Greefox.KatanasTypes.Strong.Diamond;
import me.greefox.greefox.me.Greefox.KatanasTypes.Strong.Gold;
import me.greefox.greefox.me.Greefox.KatanasTypes.Strong.Iron;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
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
                        if (args[0].equalsIgnoreCase("copper_sword")) {
                            ((Player) closestEntity).getInventory().addItem(Items.copperSword);
                        }
                        if (args[0].equalsIgnoreCase("copper_axe")) {
                            ((Player) closestEntity).getInventory().addItem(Items.copperAxe);
                        }
                        if (args[0].equalsIgnoreCase("copper_pickaxe")) {
                            ((Player) closestEntity).getInventory().addItem(Items.copperPickaxe);
                        }
                        if (args[0].equalsIgnoreCase("copper_helmet")) {
                            ((Player) closestEntity).getInventory().addItem(Items.copperHelmet);
                        }
                        if (args[0].equalsIgnoreCase("copper_chestplate")) {
                            ((Player) closestEntity).getInventory().addItem(Items.copperChestplate);
                        }
                        if (args[0].equalsIgnoreCase("copper_leggings")) {
                            ((Player) closestEntity).getInventory().addItem(Items.copperLeggings);
                        }
                        if (args[0].equalsIgnoreCase("copper_boots")) {
                            ((Player) closestEntity).getInventory().addItem(Items.copperBoots);
                        }
                        if (args[0].equalsIgnoreCase("copper_shovel")) {
                            ((Player) closestEntity).getInventory().addItem(Items.copperShovel);
                        }
                        if (args[0].equalsIgnoreCase("copper_hoe")) {
                            ((Player) closestEntity).getInventory().addItem(Items.copperHoe);
                        }
                    }
                } else if (sender instanceof Player) {
                    Player player = (Player) sender;
                    if (player.isOp()) {
                        sender.sendMessage("Gave 1 [" + args[0] + "] to player " + sender.getName());
                        if (args[0].equalsIgnoreCase("copper_sword")) {
                            player.getInventory().addItem(Items.copperSword);
                        }
                        if (args[0].equalsIgnoreCase("copper_axe")) {
                            player.getInventory().addItem(Items.copperAxe);
                        }
                        if (args[0].equalsIgnoreCase("copper_pickaxe")) {
                            player.getInventory().addItem(Items.copperPickaxe);
                        }
                        if (args[0].equalsIgnoreCase("copper_helmet")) {
                            player.getInventory().addItem(Items.copperHelmet);
                        }
                        if (args[0].equalsIgnoreCase("copper_chestplate")) {
                            player.getInventory().addItem(Items.copperChestplate);
                        }
                        if (args[0].equalsIgnoreCase("copper_leggings")) {
                            player.getInventory().addItem(Items.copperLeggings);
                        }
                        if (args[0].equalsIgnoreCase("copper_boots")) {
                            player.getInventory().addItem(Items.copperBoots);
                        }
                        if (args[0].equalsIgnoreCase("copper_shovel")) {
                            player.getInventory().addItem(Items.copperShovel);
                        }
                        if (args[0].equalsIgnoreCase("copper_hoe")) {
                            player.getInventory().addItem(Items.copperHoe);
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
                                if (args[0].equalsIgnoreCase("copper_sword")) {
                                    chosenPlayer.getInventory().addItem(Items.copperSword);
                                }
                                if (args[0].equalsIgnoreCase("copper_axe")) {
                                    chosenPlayer.getInventory().addItem(Items.copperAxe);
                                }
                                if (args[0].equalsIgnoreCase("copper_pickaxe")) {
                                    chosenPlayer.getInventory().addItem(Items.copperPickaxe);
                                }
                                if (args[0].equalsIgnoreCase("copper_helmet")) {
                                    chosenPlayer.getInventory().addItem(Items.copperHelmet);
                                }
                                if (args[0].equalsIgnoreCase("copper_chestplate")) {
                                    chosenPlayer.getInventory().addItem(Items.copperChestplate);
                                }
                                if (args[0].equalsIgnoreCase("copper_leggings")) {
                                    chosenPlayer.getInventory().addItem(Items.copperLeggings);
                                }
                                if (args[0].equalsIgnoreCase("copper_boots")) {
                                    chosenPlayer.getInventory().addItem(Items.copperBoots);
                                }
                                if (args[0].equalsIgnoreCase("copper_shovel")) {
                                    chosenPlayer.getInventory().addItem(Items.copperShovel);
                                }
                                if (args[0].equalsIgnoreCase("copper_hoe")) {
                                    chosenPlayer.getInventory().addItem(Items.copperHoe);
                                }

                            } else if (chosenPlayer.getInventory().firstEmpty() == -1) {
                                if (args[0].equalsIgnoreCase("copper_sword")) {
                                    chosenPlayer.getWorld().dropItemNaturally(chosenPlayer.getLocation(),Items.copperSword);
                                }
                                if (args[0].equalsIgnoreCase("copper_axe")) {
                                    chosenPlayer.getWorld().dropItemNaturally(chosenPlayer.getLocation(),Items.copperAxe);
                                }
                                if (args[0].equalsIgnoreCase("copper_pickaxe")) {
                                    chosenPlayer.getWorld().dropItemNaturally(chosenPlayer.getLocation(),Items.copperPickaxe);
                                }
                                if (args[0].equalsIgnoreCase("copper_helmet")) {
                                    chosenPlayer.getWorld().dropItemNaturally(chosenPlayer.getLocation(),Items.copperHelmet);
                                }
                                if (args[0].equalsIgnoreCase("copper_chestplate")) {
                                    chosenPlayer.getWorld().dropItemNaturally(chosenPlayer.getLocation(),Items.copperChestplate);
                                }
                                if (args[0].equalsIgnoreCase("copper_leggings")) {
                                    chosenPlayer.getWorld().dropItemNaturally(chosenPlayer.getLocation(),Items.copperLeggings);
                                }
                                if (args[0].equalsIgnoreCase("copper_boots")) {
                                    chosenPlayer.getWorld().dropItemNaturally(chosenPlayer.getLocation(),Items.copperBoots);
                                }
                                if (args[0].equalsIgnoreCase("copper_shovel")) {
                                    chosenPlayer.getWorld().dropItemNaturally(chosenPlayer.getLocation(),Items.copperShovel);
                                }
                                if (args[0].equalsIgnoreCase("copper_hoe")) {
                                    chosenPlayer.getWorld().dropItemNaturally(chosenPlayer.getLocation(),Items.copperHoe);
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
                                if (args[0].equalsIgnoreCase("copper_katana")) {
                                    allOnlinePlayers.getInventory().addItem(Copper.copperKatana);
                                }
                                if (args[0].equalsIgnoreCase("iron_katana")) {
                                    allOnlinePlayers.getInventory().addItem(Iron.ironKatana);
                                }
                                if (args[0].equalsIgnoreCase("diamond_katana")) {
                                    allOnlinePlayers.getInventory().addItem(Diamond.diamondKatana);
                                }
                                if (args[0].equalsIgnoreCase("golden_katana")) {
                                    allOnlinePlayers.getInventory().addItem(Gold.goldKatana);
                                }
                                if (args[0].equalsIgnoreCase("light_copper_katana")) {
                                    allOnlinePlayers.getInventory().addItem(CopperLight.lightCopperKatana);
                                }
                                if (args[0].equalsIgnoreCase("light_golden_katana")) {
                                    allOnlinePlayers.getInventory().addItem(GoldLight.lightGoldKatana);
                                }
                                if (args[0].equalsIgnoreCase("light_iron_katana")) {
                                    allOnlinePlayers.getInventory().addItem(IronLight.lightIronKatana);
                                }
                                if (args[0].equalsIgnoreCase("light_diamond_katana")) {
                                    allOnlinePlayers.getInventory().addItem(DiamondLight.lightDiamondKatana);
                                }
                            } else if (allOnlinePlayers.getInventory().firstEmpty() == -1) {

                                if (args[0].equalsIgnoreCase("copper_katana")) {
                                    allOnlinePlayers.getWorld().dropItemNaturally(allOnlinePlayers.getLocation(), (Copper.copperKatana));
                                }
                                if (args[0].equalsIgnoreCase("iron_katana")) {
                                    allOnlinePlayers.getWorld().dropItemNaturally(allOnlinePlayers.getLocation(), (Iron.ironKatana));
                                }
                                if (args[0].equalsIgnoreCase("diamond_katana")) {
                                    allOnlinePlayers.getWorld().dropItemNaturally(allOnlinePlayers.getLocation(), (Diamond.diamondKatana));
                                }
                                if (args[0].equalsIgnoreCase("golden_katana")) {
                                    allOnlinePlayers.getWorld().dropItemNaturally(allOnlinePlayers.getLocation(), (Gold.goldKatana));
                                }
                                if (args[0].equalsIgnoreCase("golden_katana")) {
                                    allOnlinePlayers.getWorld().dropItemNaturally(allOnlinePlayers.getLocation(), GoldLight.lightGoldKatana);
                                }
                                if (args[0].equalsIgnoreCase("light_copper_katana")) {
                                    allOnlinePlayers.getWorld().dropItemNaturally(allOnlinePlayers.getLocation(), CopperLight.lightCopperKatana);
                                }
                                if (args[0].equalsIgnoreCase("light_iron_katana")) {
                                    allOnlinePlayers.getWorld().dropItemNaturally(allOnlinePlayers.getLocation(), IronLight.lightIronKatana);
                                }
                                if (args[0].equalsIgnoreCase("light_diamond_katana")) {
                                    allOnlinePlayers.getWorld().dropItemNaturally(allOnlinePlayers.getLocation(), DiamondLight.lightDiamondKatana);
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
        final List<String> katanas = new ArrayList<>();
        StringUtil.copyPartialMatches(args[0], Arrays.asList(ARGS), katanas);
        Collections.sort(katanas);
        if (args.length == 1) {
            return katanas;
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
