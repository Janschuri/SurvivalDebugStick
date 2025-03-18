package de.janschuri.SurvivalDebugStick.commands;

import de.janschuri.SurvivalDebugStick.SurvivalDebugStick;
import de.janschuri.SurvivalDebugStick.config.LanguageConfig;
import de.janschuri.lunaticlib.MessageKey;
import de.janschuri.lunaticlib.Sender;
import de.janschuri.lunaticlib.common.command.LunaticCommand;
import de.janschuri.lunaticlib.common.config.LunaticMessageKey;
import net.kyori.adventure.text.Component;

import javax.naming.CompositeName;

public abstract class Subcommand extends LunaticCommand {

    protected static final MessageKey NO_PERMISSION_MK = new LunaticMessageKey("no_permission");
    protected static final MessageKey WRONG_USAGE_MK = new LunaticMessageKey("wrong_usage");
    protected static final MessageKey NO_CONSOLE_COMMAND_MK = new LunaticMessageKey("no_console_command");
    protected static final MessageKey PAGE_MK = new LunaticMessageKey("page")
            .defaultMessage("en", "Page")
            .defaultMessage("de", "Seite");

    @Override
    public LanguageConfig getLanguageConfig() {
        return SurvivalDebugStick.getLanguageConfig();
    }

    @Override
    public Component noPermissionMessage(Sender sender, String[] strings) {
        return getMessage(NO_PERMISSION_MK);
    }

    @Override
    public Component wrongUsageMessage(Sender sender, String[] strings) {
        return getMessage(WRONG_USAGE_MK);
    }
}
