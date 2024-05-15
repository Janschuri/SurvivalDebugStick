package de.janschuri.SurvivalDebugStick.config;

import org.bukkit.Material;

import java.nio.file.Path;
import java.util.*;

public class PluginConfig extends de.janschuri.lunaticlib.config.Config {

    private static PluginConfig instance;
    private String stick_item;
    private boolean whitelist = false;
    private final Map<String, Set<String>> blockedStates = new HashMap<>();
    private Map<String, Boolean> blockStates = new HashMap<>();
    private String language = "EN";


    public PluginConfig(Path dataDirectory) {
        super(dataDirectory, "config.yml");
        instance = this;
        load();
    }

    public void load() {
        super.load();

        language = getString("language");
        stick_item = getString("stick_item");
        whitelist = getBoolean("invert_list");
        blockStates = getBooleanMap("block_states");


        List<String> blockedStatesList = getStringList("blocked_states");

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
    }

    public static PluginConfig getConfig() {
        return instance;
    }

    public static String getLanguageKey() {
        return getConfig().language;
    }

    public static boolean isAllowedState(String stateEnum, String state) {
        if (getConfig().whitelist) {
            if (getConfig().blockedStates.containsKey(stateEnum)) {
                return getConfig().blockedStates.get(stateEnum).contains(state);
            } else {
                return false;
            }
        } else {
            if (getConfig().blockedStates.containsKey(stateEnum)) {
                return !getConfig().blockedStates.get(stateEnum).contains(state);
            } else {
                return true;
            }

        }
    }

    public static boolean isAllowBlockState (String blockState){
        return getConfig().blockStates.get(blockState);
    }

    public static Material getStorageItem() {
        return Material.valueOf(getConfig().stick_item.toUpperCase());
    }
}
