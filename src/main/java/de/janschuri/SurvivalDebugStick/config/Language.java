package de.janschuri.SurvivalDebugStick.config;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class Language extends de.janschuri.lunaticlib.config.Language {

    private static Language instance;
    private Map<String, String> blockStates = new HashMap<>();
    private Map<String, String> blockStatesEnum = new HashMap<>();

    public Language(Path dataDirectory, String[] commands) {
        super(dataDirectory, commands, PluginConfig.getLanguageKey());
        instance = this;
        load();
    }

    public void load() {
        super.load();

        blockStates = getStringMap("block_states");
        blockStatesEnum = getStringMap("block_states_enum");
    }

    public static Language getLanguage() {
        return instance;
    }

    private static String getBlockState(String key) {
        if (getLanguage().blockStates.containsKey(key)) {
            return translateAlternateColorCodes('&', getLanguage().blockStates.get(key.toLowerCase()));
        } else {
            return key + ": %value%";
        }
    }

    private static String getBlockStateEnum(String key) {
        key = key.toLowerCase();
        if (getLanguage().blockStatesEnum.containsKey(key)) {
            return translateAlternateColorCodes('&', getLanguage().blockStatesEnum.get(key));
        } else {
            return key;
        }
    }

    public static String getActionBarMessage(String stateKey, String valueKey) {

        String value = getBlockStateEnum(valueKey);

        return Language.getBlockState(stateKey).replace("%value%", value);
    }
}
