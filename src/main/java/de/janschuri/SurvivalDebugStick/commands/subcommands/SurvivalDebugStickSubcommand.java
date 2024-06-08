package de.janschuri.SurvivalDebugStick.commands.subcommands;

import de.janschuri.SurvivalDebugStick.commands.Subcommand;
import de.janschuri.lunaticlib.LunaticCommand;
import de.janschuri.lunaticlib.Sender;
import de.janschuri.lunaticlib.common.command.LunaticHelpCommand;

import java.util.List;

public class SurvivalDebugStickSubcommand extends Subcommand {

    @Override
    public LunaticHelpCommand getHelpCommand() {
        return new LunaticHelpCommand(getLanguageConfig(), this);
    }

    @Override
    public List<LunaticCommand> getSubcommands() {
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

                for (LunaticCommand sc : getSubcommands()) {
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
}
