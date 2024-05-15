package de.janschuri.SurvivalDebugStick.commands.subcommands;

import de.janschuri.SurvivalDebugStick.SurvivalDebugStick;
import de.janschuri.SurvivalDebugStick.commands.Subcommand;
import de.janschuri.lunaticlib.senders.AbstractSender;

public class ReloadSubcommand extends Subcommand {

    private static final String MAIN_COMMAND = "survivaldebugstick";
    private static final String PERMISSION = "survivaldebugstick.admin";
    private static final String NAME = "reload";

    protected ReloadSubcommand() {
        super(MAIN_COMMAND, NAME, PERMISSION);
    }

    @Override
    public boolean execute(AbstractSender sender, String[] strings) {
        if (!sender.hasPermission(PERMISSION)) {
            sender.sendMessage(language.getPrefix() + language.getMessage("no_permission"));
        } else {
            SurvivalDebugStick.loadConfig();
            sender.sendMessage(language.getPrefix() + language.getMessage("config_reloaded"));
        }
        return true;
    }
}
