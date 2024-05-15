package de.janschuri.SurvivalDebugStick.commands.subcommands;

import de.janschuri.SurvivalDebugStick.SurvivalDebugStick;
import de.janschuri.SurvivalDebugStick.commands.Subcommand;
import de.janschuri.SurvivalDebugStick.config.PluginConfig;
import de.janschuri.lunaticlib.senders.AbstractPlayerSender;
import de.janschuri.lunaticlib.senders.AbstractSender;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

public class StickSubcommand extends Subcommand {

    private static final String PERMISSION = "survivaldebugstick.admin";
    private static final String MAIN_COMMAND = "survivaldebugstick";
    private static final String NAME = "stick";

    protected StickSubcommand() {
        super(MAIN_COMMAND, NAME, PERMISSION);
    }

    @Override
    public boolean execute(AbstractSender sender, String[] strings) {
        if (!(sender instanceof AbstractPlayerSender)) {
            sender.sendMessage(language.getPrefix() + language.getMessage("no_console_command"));
        } else if (!sender.hasPermission(PERMISSION)) {
            sender.sendMessage(language.getPrefix() + language.getMessage("no_permission"));
        } else {
            AbstractPlayerSender player = (AbstractPlayerSender) sender;
            ItemStack item = new ItemStack(PluginConfig.getStorageItem());

            int[] invs = new int[]{};

            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(SurvivalDebugStick.KEY_STICK, PersistentDataType.INTEGER_ARRAY, invs);
            item.setItemMeta(meta);

            Player p = Bukkit.getPlayer(player.getUniqueId());
            p.getInventory().addItem(item);
        }
        return true;
    }
}
