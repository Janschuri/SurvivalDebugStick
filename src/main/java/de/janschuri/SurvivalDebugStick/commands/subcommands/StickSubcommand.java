package de.janschuri.SurvivalDebugStick.commands.subcommands;

import de.janschuri.SurvivalDebugStick.SurvivalDebugStick;
import de.janschuri.SurvivalDebugStick.commands.Subcommand;
import de.janschuri.lunaticlib.CommandMessageKey;
import de.janschuri.lunaticlib.PlayerSender;
import de.janschuri.lunaticlib.Sender;
import de.janschuri.lunaticlib.common.command.HasParentCommand;
import de.janschuri.lunaticlib.common.config.LunaticCommandMessageKey;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.Map;

public class StickSubcommand extends Subcommand implements HasParentCommand {

    private static final StickSubcommand INSTANCE = new StickSubcommand();
    private static final CommandMessageKey HELP_MK = new LunaticCommandMessageKey(INSTANCE, "help")
            .defaultMessage("en", "&6/%command% %subcommand% &7- Get the SurvivalDebugStick.")
            .defaultMessage("de", "&6/%command% %subcommand% &7- Erhalte den SurvivalDebugStick.");
    private static final CommandMessageKey STICK_GIVEN_MK = new LunaticCommandMessageKey(INSTANCE, "stick_given")
            .defaultMessage("en", "&aYou have been given the SurvivalDebugStick.")
            .defaultMessage("de", "&aDu hast den SurvivalDebugStick erhalten.");

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

            boolean addItem = false;


            if (item == null || item.getType() == Material.AIR) {
                addItem = true;
                item = new ItemStack(Material.BLAZE_ROD);
            }

            ItemMeta meta = item.getItemMeta();
            meta.getPersistentDataContainer().set(SurvivalDebugStick.KEY_STICK, PersistentDataType.INTEGER, 1);
            item.setItemMeta(meta);

            if (addItem) {
                p.getInventory().addItem(item);
            }

            player.sendMessage(getMessage(STICK_GIVEN_MK));

        }
        return true;
    }

    @Override
    public Map<CommandMessageKey, String> getHelpMessages() {
        return Map.of(
                HELP_MK, getPermission()
        );
    }
}
