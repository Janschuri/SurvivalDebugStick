package de.janschuri.SurvivalDebugStick.commands.subcommands;

import de.janschuri.SurvivalDebugStick.commands.Subcommand;
import de.janschuri.lunaticlib.Command;
import de.janschuri.lunaticlib.CommandMessageKey;
import de.janschuri.lunaticlib.MessageKey;
import de.janschuri.lunaticlib.Sender;
import de.janschuri.lunaticlib.common.command.HasHelpCommand;
import de.janschuri.lunaticlib.common.command.HasSubcommands;
import de.janschuri.lunaticlib.common.config.LunaticCommandMessageKey;

import java.util.List;
import java.util.Map;

public class SurvivalDebugStickSubcommand extends Subcommand implements HasSubcommands, HasHelpCommand {

    private static final SurvivalDebugStickSubcommand INSTANCE = new SurvivalDebugStickSubcommand();
    private static final CommandMessageKey HELP_MK = new LunaticCommandMessageKey(INSTANCE, "help")
            .defaultMessage("en", "&6/%command% %subcommand% &7- Show this help message.")
            .defaultMessage("de", "&6/%command% %subcommand% &7- Zeige diese Hilfe Nachricht.");
    private static final CommandMessageKey HELP_HEADER_MK = new LunaticCommandMessageKey(INSTANCE, "help_header")
            .defaultMessage("en", "SurvivalDebugStick-Help")
            .defaultMessage("de", "SurvivalDebugStick-Hilfe");


    @Override
    public List<Command> getSubcommands() {
        return List.of(
                new ReloadSubcommand(),
                new StickSubcommand(),
                getHelpCommand()
        );
    }

    @Override
    public String getPermission() {
        return "survivaldebugstick.admin";
    }

    @Override
    public String getName() {
        return "survivaldebugstick";
    }

    @Override
    public boolean execute(Sender sender, String[] args) {
        if (!sender.hasPermission(getPermission())) {
            sender.sendMessage(getMessage(NO_PERMISSION_MK));
        } else {
            if (args.length == 0) {

            } else {
                final String subcommand = args[0];

                for (Command sc : getSubcommands()) {
                    if (checkIsSubcommand(sc, subcommand)) {
                        String[] newArgs = new String[args.length - 1];
                        System.arraycopy(args, 1, newArgs, 0, args.length - 1);
                        return sc.execute(sender, newArgs);
                    }
                }
                sender.sendMessage(getMessage(WRONG_USAGE_MK));
            }
        }
        return true;
    }

    @Override
    public Map<CommandMessageKey, String> getHelpMessages() {
        return Map.of(
                HELP_MK, getPermission()
        );
    }

    @Override
    public boolean isPrimaryCommand() {
        return true;
    }

    @Override
    public MessageKey pageParamName() {
        return PAGE_MK;
    }

    @Override
    public MessageKey getHelpHeader() {
        return HELP_HEADER_MK;
    }
}
