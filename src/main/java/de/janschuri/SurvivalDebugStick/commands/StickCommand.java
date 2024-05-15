package de.janschuri.SurvivalDebugStick.commands;

import de.janschuri.SurvivalDebugStick.commands.subcommands.SurvivalDebugStickSubcommand;
import de.janschuri.lunaticlib.senders.AbstractSender;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class StickCommand implements CommandExecutor, TabCompleter {

    private final SurvivalDebugStickSubcommand subcommand = new SurvivalDebugStickSubcommand();

    @Override
    public boolean onCommand(@NotNull org.bukkit.command.CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        AbstractSender commandSender = AbstractSender.getSender(sender);
        return subcommand.execute(commandSender, args);
    }

    @Override
    public List<String> onTabComplete(@NotNull org.bukkit.command.CommandSender sender, @NotNull Command cmd, @NotNull String commandLabel, String[] args) {
        String[] newArgs = new String[args.length + 1];
        newArgs[0] = "survivaldebugstick";
        System.arraycopy(args, 0, newArgs, 1, args.length);
        AbstractSender commandSender = AbstractSender.getSender(sender);
        return new ArrayList<>(subcommand.tabComplete(commandSender, newArgs));
    }

}