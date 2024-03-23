package de.janschuri.SurvivalDebugStick;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;

public class StickCommand implements CommandExecutor {

    private final SurvivalDebugStick plugin;

    public StickCommand(SurvivalDebugStick plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        // Check if the sender is a player
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use this command.");
            return true;
        } else {
            Player player = (Player) sender;

            if (args.length < 1) {

            } else if (args[0].equalsIgnoreCase("stick")) {
                ItemStack item = new ItemStack(plugin.storageItem);

                int[] invs = new int[] {};

                ItemMeta meta = item.getItemMeta();
                meta.getPersistentDataContainer().set(SurvivalDebugStick.keyStick, PersistentDataType.INTEGER_ARRAY, invs);
                item.setItemMeta(meta);

                player.getInventory().addItem(item);
            } else if (args[0].equalsIgnoreCase("reload")) {
                if (!sender.hasPermission("survivaldebugstick.admin")) {
//                    sender.sendMessage(plugin.prefix + plugin.messages.get("no_permission"));
                } else {
                    plugin.loadConfig(plugin);
//                    sender.sendMessage(plugin.prefix + plugin.messages.get("reload"));
                }
            }
        }

        return true;
    }

}