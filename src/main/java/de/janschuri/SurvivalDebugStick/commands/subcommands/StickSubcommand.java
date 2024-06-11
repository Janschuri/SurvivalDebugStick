package de.janschuri.SurvivalDebugStick.commands.subcommands;

import de.janschuri.SurvivalDebugStick.SurvivalDebugStick;
import de.janschuri.SurvivalDebugStick.commands.Subcommand;
import de.janschuri.lunaticlib.CommandMessageKey;
import de.janschuri.lunaticlib.PlayerSender;
import de.janschuri.lunaticlib.Sender;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

public class StickSubcommand extends Subcommand {

    CommandMessageKey stickGivenMK = new CommandMessageKey(this, "stick_given");

    @Override
    public String getName() {
        return "stick";
    }

    @Override
    public String getPermission() {
        return "survivaldebugstick.admin";
    }

    @Override
    public SurvivalDebugStickSubcommand getParentCommand() {
        return new SurvivalDebugStickSubcommand();
    }

    @Override
    public boolean execute(Sender sender, String[] strings) {
        if (!(sender instanceof PlayerSender)) {
            sender.sendMessage(getMessage(NO_CONSOLE_COMMAND_MK));
        } else if (!sender.hasPermission(getPermission())) {
            sender.sendMessage(getMessage(NO_PERMISSION_MK));
        } else {
            PlayerSender player = (PlayerSender) sender;
            Player p = Bukkit.getPlayer(player.getUniqueId());
            ItemStack item = p.getInventory().getItemInMainHand();

            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(SurvivalDebugStick.KEY_STICK, PersistentDataType.BOOLEAN, true);
            item.setItemMeta(meta);

            player.sendMessage(getMessage(stickGivenMK));

        }
        return true;
    }
}
