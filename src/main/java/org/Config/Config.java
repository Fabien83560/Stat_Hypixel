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
     * The URL of the Database.
     */
    private String urlDataBase;

    /**
     * The username of the DataBase.
     */
    private String usernameDataBase;

    /**
     * The password of the DataBase.
     */
    private String passwordDataBase;

    /**
     * Default constructor of the Config class.
     */
    public Config(){}

    /**
     * Gets the API Key
     * @return a String Object containing the API Key.
     */
    public String getApikey() {
        return apikey;
    }

    /**
     * Gets the Password of the Username.
     * @return a String Object containing the password of the UserName.
     */
    public String getPasswordDataBase() {
        return passwordDataBase;
    }

    /**
     * Gets the URL of the DataBase.
     * @return a String Object containing the URL of the DataBase.
     */
    public String getUrlDataBase() {
        return urlDataBase;
    }

    /**
     * Gets the Username of the DataBase.
     * @return a String Object containing the Username of the Database.
     */
    public String getUsernameDataBase() {
        return usernameDataBase;
    }

    /**
     * Sets the API Key, in order to change it.
     * @param _apikey A String Object containing the API Key to replace the old one.
     */
    public void setApikey(String _apikey) {
        apikey = _apikey;
    }

    /**
     * Sets the password of the UserName, in order to change it.
     * @param _passwordDataBase A String Object containing the new Password to replace the old one.
     */
    public void setPasswordDataBase(String _passwordDataBase) {
        passwordDataBase = _passwordDataBase;
    }

    /**
     * Sets the URL of the DataBase, in order to change it.
     * @param _urlDataBase A String Object containing the new URL to replace the old one.
     */
    public void setUrlDataBase(String _urlDataBase) {
        urlDataBase = _urlDataBase;
    }

    /**
     * Sets the Username of the DataBase, in order to change it.
     * @param _usernameDataBase A String Object containing the new username to replace the old one.
     */
    public void setUsernameDataBase(String _usernameDataBase) {
        usernameDataBase = _usernameDataBase;
    }
}
