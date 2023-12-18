package org.Config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.io.File;
import java.io.IOException;

/**
 * This class reads all the data stored in the 'config.yml' file, such as the API Key.
 * The Config class uses this one to store these information. Both Config and ConfigReader
 * classes don't have any constructor.
 * @see Config
 */
public class ConfigReader {

    /**
     * The file where all the configuration data is stored.
     */
    private static final String CONFIG_FILE_PATH = "config.yml";

    /**
     * Default constructor of the ConfigReader class.
     */
    public ConfigReader(){}

    /**
     * Gets the API Key stored in the 'CONFIG_FILE_PATH' file.
     * @return A String containing the API Key stored in the 'CONFIG_FILE_PATH' file.
     * @see Config#getApikey()
     */
    public static String getApiKey() {
        Config config = readConfig();
        return config != null ? config.getApikey() : "";
    }

    /**
     * Gets the URL of the DataBase stored in the 'CONFIG_FILE_PATH' file.
     * @return A String containing the URL of the DataBase stored in the 'CONFIG_FILE_PATH' file.
     * @see Config#getUrlDataBase()
     */
    public static String getUrlDataBase() {
        Config config = readConfig();
        return config != null ? config.getUrlDataBase() : "";
    }

    /**
     * Gets the Username of the DataBase stored in the 'CONFIG_FILE_PATH' file.
     * @return A String containing the Username of the DataBase stored in the 'CONFIG_FILE_PATH' file.
     * @see Config#getUsernameDataBase()
     */
    public static String getUsernameDataBase() {
        Config config = readConfig();
        return config != null ? config.getUsernameDataBase() : "";
    }

    /**
     * Gets the Password of the Username stored in the 'CONFIG_FILE_PATH' file.
     * @return A String containing the Password of the Username stored in the 'CONFIG_FILE_PATH' file.
     * @see Config#getPasswordDataBase()
     */
    public static String getPasswordDataBase() {
        Config config = readConfig();
        return config != null ? config.getPasswordDataBase() : "";
    }

    /**
     * Sets the API Key of the DataBase.
     * @param key A String Object containing the API Key to replace the old one
     *            stored in the 'CONFIG_FILE_PATH' file.
     * @see Config#setApikey(String)
     */
    public static void setApiKey(String key) {
        Config config = readConfig();
        if (config != null) {
            config.setApikey(key);
            writeConfig(config);
        }
    }

    /**
     * Method reading all the config stored in the 'CONFIG_FILE_PATH' file.
     * This method reads every field in the 'CONFIG_FILE_PATH', as a YAMLFactory Object.
     * @return A Config Object that will initialize the Objects stored in the 'Config' class.
     */
    private static Config readConfig() {
        File configFile = new File(CONFIG_FILE_PATH);
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        try {
            return objectMapper.readValue(configFile, Config.class);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Method writing all the config stored in the 'CONFIG_FILE_PATH' file.
     * @param config A Config Object containing all the data stored in the 'CONFIG_FILE_PATH' file.
     */
    private static void writeConfig(Config config) {
        File configFile = new File(CONFIG_FILE_PATH);
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        try {
            objectMapper.writeValue(configFile, config);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}