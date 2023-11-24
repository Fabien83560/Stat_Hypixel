package org.Config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;

public class ConfigReader {
    private static final String CONFIG_FILE_PATH = "config.yml";
    public static String getApiKey() {
        Config config = readConfig();
        return config != null ? config.getApikey() : "";
    }
    public static void setApiKey(String key) {
        Config config = readConfig();
        if (config != null) {
            config.setApikey(key);
            writeConfig(config);
        }
    }
    public static String getUrlDataBase() {
        Config config = readConfig();
        return config != null ? config.getUrlDataBase() : "";
    }
    public static String getUsernameDataBase() {
        Config config = readConfig();
        return config != null ? config.getUsernameDataBase() : "";
    }
    public static String getPasswordDataBase() {
        Config config = readConfig();
        return config != null ? config.getPasswordDataBase() : "";
    }
    private static Config readConfig() {
        File configFile = new File(CONFIG_FILE_PATH);
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        try {
            return objectMapper.readValue(configFile, Config.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    private static void writeConfig(Config config) {
        File configFile = new File(CONFIG_FILE_PATH);
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        try {
            objectMapper.writeValue(configFile, config);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}