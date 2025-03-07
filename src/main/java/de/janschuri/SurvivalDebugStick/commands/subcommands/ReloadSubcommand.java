package de.janschuri.SurvivalDebugStick.commands.subcommands;

import de.janschuri.SurvivalDebugStick.SurvivalDebugStick;
import de.janschuri.SurvivalDebugStick.commands.Subcommand;
import de.janschuri.lunaticlib.CommandMessageKey;
import de.janschuri.lunaticlib.Sender;
import de.janschuri.lunaticlib.common.command.HasParentCommand;
import de.janschuri.lunaticlib.common.config.LunaticCommandMessageKey;

import java.util.Map;

public class ReloadSubcommand extends Subcommand implements HasParentCommand {

    private static final ReloadSubcommand INSTANCE = new ReloadSubcommand();
    private static final CommandMessageKey HELP_MK = new LunaticCommandMessageKey(INSTANCE, "help")
            .defaultMessage("en", "&6/%command% %subcommand% &7- Reload the config.")
            .defaultMessage("de", "&6/%command% %subcommand% &7- Lade die Konfiguration neu.");
    private static final CommandMessageKey CONFIG_RELOADED_MK = new LunaticCommandMessageKey(INSTANCE, "config_reloaded")
            .defaultMessage("en", "&aConfig reloaded.")
            .defaultMessage("de", "&aKonfiguration neu geladen.");

    @Override
    public String getPermission() {
        return "survivaldebugstick.admin";
    }

    @Override
    public String getName() {
        return "reload";
    }

    @Override
    public SurvivalDebugStickSubcommand getParentCommand() {
        return new SurvivalDebugStickSubcommand();
    }

    @Override
    public boolean execute(Sender sender, String[] strings) {
        if (!sender.hasPermission(getPermission())) {
            sender.sendMessage(getMessage(NO_PERMISSION_MK));
        } else {
            SurvivalDebugStick.loadConfig();
            sender.sendMessage(getMessage(CONFIG_RELOADED_MK));
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
