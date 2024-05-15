package de.janschuri.SurvivalDebugStick.commands.subcommands;

import de.janschuri.SurvivalDebugStick.config.Language;
import de.janschuri.lunaticlib.commands.AbstractHelpSubcommand;

public class HelpSubcommand extends AbstractHelpSubcommand {

    private static final String PERMISSION = "survivaldebugstick.admin";
    private static final String MAIN_COMMAND = "survivaldebugstick";
    private static final String NAME = "help";

    public HelpSubcommand() {
        super(Language.getLanguage(), MAIN_COMMAND, NAME, PERMISSION, SurvivalDebugStickSubcommand.class);
    }
}
