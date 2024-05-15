package de.janschuri.SurvivalDebugStick;

import de.janschuri.SurvivalDebugStick.commands.StickCommand;
import de.janschuri.SurvivalDebugStick.config.Language;
import de.janschuri.SurvivalDebugStick.config.PluginConfig;
import de.janschuri.SurvivalDebugStick.listener.BlockClickListener;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.nio.file.Path;

public final class SurvivalDebugStick extends JavaPlugin {

    public static final String PLUGIN_NAMESPACE = "survivaldebugstick";
    public static final NamespacedKey KEY_STICK = new NamespacedKey(PLUGIN_NAMESPACE, "invs");
    private static Path dataDirectory;
    static final String[] commands = {
            "survivaldebugstick",
    };


    @Override
    public void onEnable() {
        dataDirectory = getDataFolder().toPath();

        loadConfig(this);
        getServer().getPluginManager().registerEvents(new BlockClickListener(this), this);
        getCommand("survivaldebugstick").setExecutor(new StickCommand(this));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void loadConfig(Plugin plugin) {

        new PluginConfig(dataDirectory);
        new Language(dataDirectory, commands);


    }
}
