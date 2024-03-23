package de.janschuri.SurvivalDebugStick;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.*;

public final class SurvivalDebugStick extends JavaPlugin {

    private static FileConfiguration config;
    public Material storageItem;
    public static String language;
    private static boolean whitelist = false;
    static String pluginNamespace = "survivaldebugstick";
    static NamespacedKey keyStick = new NamespacedKey(pluginNamespace, "invs");

    private static Map<String, Set<String>> blockedStates = new HashMap<>();
    private static Set<String> blockStates = new HashSet<>();
    @Override
    public void onEnable() {
        saveDefaultConfig();

        loadConfig(this);
        getServer().getPluginManager().registerEvents(new BlockClickListener(this), this);
        getCommand("survivaldebugstick").setExecutor(new StickCommand(this));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void loadConfig(Plugin plugin) {

        File cfgfile = new File(plugin.getDataFolder().getAbsolutePath() + "/config.yml");
        plugin.saveResource("defaultConfig.yml", true);

        if (!cfgfile.exists()) {
            plugin.saveResource("/config.yml", false);
            addMissingProperties(cfgfile, "defaultConfig.yml");
        } else {
            addMissingProperties(cfgfile, "defaultConfig.yml");
        }

        plugin.saveResource("lang/EN.yml", true);
        plugin.saveResource("lang/DE.yml", true);

        language = config.getString("language");

        File langfile = new File(plugin.getDataFolder().getAbsolutePath() + "/lang.yml");

        if (!langfile.exists()) {
            plugin.saveResource("lang.yml", false);
            addMissingProperties(langfile, "/lang/" + language + ".yml");
        } else {
            addMissingProperties(langfile, "/lang/" + language + ".yml");
        }

        config = YamlConfiguration.loadConfiguration(cfgfile);

        //block states
        ConfigurationSection blockStatesSection = config.getConfigurationSection("block_states");
        if (blockStatesSection != null) {
            for (String key : blockStatesSection.getKeys(false)) {
                if (blockStatesSection.getBoolean(key)) {
                    blockStates.add(key);
                }
            }
        } else {
            getLogger().warning("Could not find 'block_states' section in config.yml");
        }

        List<String> blockedStatesList = config.getStringList("blocked_states");

        for (String entry : blockedStatesList) {
            int lastDotIndex = entry.lastIndexOf('.');
            if (lastDotIndex != -1) {
                String type = entry.substring(lastDotIndex + 1).toLowerCase();
                String key = entry.substring(0, lastDotIndex).toLowerCase();

                if (!blockedStates.containsKey(key)) {
                    blockedStates.put(key, new HashSet<>());
                }

                blockedStates.get(key).add(type);
            }
        }

        whitelist = config.getBoolean("invert_list", false);
        storageItem = Material.matchMaterial(getConfig().getString("stick_item", "BLAZE_ROD"));


    }

    public static boolean isAllowedState(String stateEnum, String state) {
        if (SurvivalDebugStick.whitelist) {
            if (blockedStates.containsKey(stateEnum)) {
                return blockedStates.get(stateEnum).contains(state);
            } else {
                return false;
            }
        } else {
            if (blockedStates.containsKey(stateEnum)) {
                return !blockedStates.get(stateEnum).contains(state);
            } else {
                return true;
            }

        }
    }

    public static boolean isAllowBlockState (String blockState){
        return blockStates.contains(blockState);
    }

    private void addMissingProperties(File file, String filePath) {
        YamlConfiguration langConfig = YamlConfiguration.loadConfiguration(file);
        YamlConfiguration defaultLangConfig = YamlConfiguration.loadConfiguration(new File(this.getDataFolder(), filePath));

        for (String key : defaultLangConfig.getKeys(true)) {
            if (!langConfig.contains(key)) {
                langConfig.set(key, defaultLangConfig.get(key));
            }
        }

        try {
            langConfig.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
