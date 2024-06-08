package de.janschuri.SurvivalDebugStick.commands;

import de.janschuri.SurvivalDebugStick.SurvivalDebugStick;
import de.janschuri.SurvivalDebugStick.config.LanguageConfig;
import de.janschuri.lunaticlib.MessageKey;
import de.janschuri.lunaticlib.common.command.AbstractLunaticCommand;

public abstract class Subcommand extends AbstractLunaticCommand {

    protected static final MessageKey NO_PERMISSION_MK = new MessageKey("no_permission");
    protected static final MessageKey WRONG_USAGE_MK = new MessageKey("wrong_usage");
    protected static final MessageKey NO_CONSOLE_COMMAND_MK = new MessageKey("no_console_command");

    @Override
    public LanguageConfig getLanguageConfig() {
        return SurvivalDebugStick.getLanguageConfig();
    }
}
