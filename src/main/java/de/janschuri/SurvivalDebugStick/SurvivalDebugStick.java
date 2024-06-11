package de.janschuri.SurvivalDebugStick;

import de.janschuri.SurvivalDebugStick.commands.subcommands.SurvivalDebugStickSubcommand;
import de.janschuri.SurvivalDebugStick.config.LanguageConfig;
import de.janschuri.SurvivalDebugStick.config.PluginConfig;
import de.janschuri.SurvivalDebugStick.listener.BlockClickListener;
import de.janschuri.lunaticlib.platform.bukkit.PlatformImpl;
import de.janschuri.lunaticlib.platform.bukkit.external.Metrics;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;

import java.nio.file.Path;

public final class SurvivalDebugStick extends JavaPlugin {

    public static final String PLUGIN_NAMESPACE = "survivaldebugstick";
    public static final NamespacedKey KEY_STICK = new NamespacedKey(PLUGIN_NAMESPACE, "stick");
    private static Path dataDirectory;

    private static LanguageConfig languageConfig;
    private static PluginConfig pluginConfig;

    static final String[] commands = {
            "survivaldebugstick",
    };


    @Override
    public void onEnable() {
        dataDirectory = getDataFolder().toPath();

        int pluginId = 22241;
        Metrics metrics = new Metrics(this, pluginId);

        loadConfig();
        getServer().getPluginManager().registerEvents(new BlockClickListener(this), this);
        new PlatformImpl().registerCommand(this, new SurvivalDebugStickSubcommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static void loadConfig() {

        pluginConfig = new PluginConfig(dataDirectory);
        pluginConfig.load();

        String languageKey = pluginConfig.getLanguageKey();
        languageConfig = new LanguageConfig(dataDirectory, languageKey);
        languageConfig.load();


    }

    public static LanguageConfig getLanguageConfig() {
        return languageConfig;
    }

    public static PluginConfig getPluginConfig() {
        return pluginConfig;
    }
}
