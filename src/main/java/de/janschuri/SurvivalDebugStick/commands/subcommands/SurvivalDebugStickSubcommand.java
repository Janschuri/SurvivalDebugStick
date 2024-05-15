package de.janschuri.SurvivalDebugStick.commands.subcommands;

import de.janschuri.SurvivalDebugStick.commands.Subcommand;
import de.janschuri.lunaticlib.commands.AbstractSubcommand;
import de.janschuri.lunaticlib.senders.AbstractSender;

public class SurvivalDebugStickSubcommand extends Subcommand {

    private static final String PERMISSION = "survivaldebugstick.admin";
    private static final String MAIN_COMMAND = "survivaldebugstick";
    private static final String NAME = "survivaldebugstick";

    private final HelpSubcommand helpSubcommand = new HelpSubcommand();

    public SurvivalDebugStickSubcommand() {
        super(MAIN_COMMAND, NAME, PERMISSION, new AbstractSubcommand[] {
                    new HelpSubcommand(),
                    new ReloadSubcommand(),
                    new StickSubcommand(),
                }
        );
    }

    @Override
    public boolean execute(AbstractSender sender, String[] args) {
        if (!sender.hasPermission(PERMISSION)) {
            sender.sendMessage(language.getPrefix() + language.getMessage("no_permission"));
        } else {
            if (args.length == 0) {
                helpSubcommand.execute(sender, args);
            } else {
                final String subcommand = args[0];

                for (AbstractSubcommand sc : subcommands) {
                    if (language.checkIsSubcommand(NAME, sc.getName(), subcommand)) {
                        String[] newArgs = new String[args.length - 1];
                        System.arraycopy(args, 1, newArgs, 0, args.length - 1);
                        return sc.execute(sender, newArgs);
                    }
                }
                sender.sendMessage(language.getPrefix() + language.getMessage("wrong_usage"));
            }
        }
        return true;
    }

}
