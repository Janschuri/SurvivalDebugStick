package de.janschuri.SurvivalDebugStick.config;

import de.janschuri.lunaticlib.common.config.LunaticLanguageConfig;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class LanguageConfig extends LunaticLanguageConfig {

    private Map<String, String> blockStates = new HashMap<>();
    private Map<String, String> blockStatesEnum = new HashMap<>();

    public LanguageConfig(Path dataDirectory, String languageKey) {
        super(dataDirectory, languageKey);
    }

    public void load() {
        super.load();

        blockStates = getStringMap("block_states");
        blockStatesEnum = getStringMap("block_states_enum");
    }

    @Override
    protected String getPackage() {
        return "de.janschuri.SurvivalDebugStick";
    }

    private String getBlockState(String key) {
        if (blockStates.containsKey(key)) {
            return translateAlternateColorCodes('&', blockStates.get(key.toLowerCase()));
        } else {
            return key + ": %value%";
        }
    }

    private String getBlockStateEnum(String key) {
        key = key.toLowerCase();
        if (blockStatesEnum.containsKey(key)) {
            return translateAlternateColorCodes('&', blockStatesEnum.get(key));
        } else {
            return key;
        }
    }

    public String getActionBarMessage(String stateKey, String valueKey) {

        String value = getBlockStateEnum(valueKey);

        return getString("message_format").replace("%state%", getBlockState(stateKey)).replace("%value%", value);
    }

    public String getActionBarMessage(String stateKey) {
        return getBlockState(stateKey);
    }
}
