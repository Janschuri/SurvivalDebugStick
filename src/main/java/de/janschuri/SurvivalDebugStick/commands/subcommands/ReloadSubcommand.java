package de.janschuri.SurvivalDebugStick.commands.subcommands;

import de.janschuri.SurvivalDebugStick.SurvivalDebugStick;
import de.janschuri.SurvivalDebugStick.commands.Subcommand;
import de.janschuri.lunaticlib.CommandMessageKey;
import de.janschuri.lunaticlib.Sender;

public class ReloadSubcommand extends Subcommand {

    CommandMessageKey configReloadedMK = new CommandMessageKey(this, "config_reloaded");

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
            sender.sendMessage(getMessage(configReloadedMK));
        }
        return true;
    }
}
