package org.Config;

/**
 * This class stores all the essential data for the application to work.
 * It includes API Key and all database related data. Used by ConfigReader class.
 */
public class Config
{
    /**
     * The API Key of the application.
     */
    private String apikey;

    /**
     * Default constructor of the Config class.
     */
    public Config() {
        apikey = "";
    }

    /**
     * Gets the API Key
     * @return a String Object containing the API Key.
     */
    public String getApikey() {
        return apikey;
    }


    /**
     * Sets the API Key, in order to change it.
     * @param _apikey A String Object containing the API Key to replace the old one.
     */
    public void setApikey(String _apikey) {
        apikey = _apikey;
    }

}
