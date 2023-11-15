package org.Config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.io.File;
import java.io.IOException;

public class ConfigReader {
    public static String getApiKey()
    {
        File configFile = new File("config.yml");
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        try
        {
            Config config = objectMapper.readValue(configFile, Config.class);
            return config.getApikey();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        return "";
    }
}