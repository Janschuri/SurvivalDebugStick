package de.janschuri.SurvivalDebugStick.config;

import de.janschuri.lunaticlib.common.config.LunaticConfig;

import java.nio.file.Path;
import java.util.*;

public class PluginConfig extends LunaticConfig {

    private final Map<String, Set<String>> blockedStates = new HashMap<>();
    private Map<String, Boolean> blockStates = new HashMap<>();
    private String language = "EN";


    public PluginConfig(Path dataDirectory) {
        super(dataDirectory, "config.yml");
    }

    public void load() {
        super.load("config.yml");

        language = getString("language");
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

    public String getLanguageKey() {
        return language;
    }

    public boolean isAllowedState(String stateEnum, String state) {
        if (blockedStates.containsKey(stateEnum)) {
            return !blockedStates.get(stateEnum).contains(state);
        } else {
            return true;
        }
    }

    public boolean isAllowBlockState (String blockState){
        return blockStates.get(blockState);
    }
}
