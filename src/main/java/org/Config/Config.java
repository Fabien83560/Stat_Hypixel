package org.Config;

public class Config
{
    private String apikey , urlDataBase , usernameDataBase , passwordDataBase;
    public String getApikey()
    {
        return apikey;
    }
    public void setApikey(String apikey)
    {
        this.apikey = apikey;
    }

    public String getPasswordDataBase() {
        return passwordDataBase;
    }

    public String getUrlDataBase() {
        return urlDataBase;
    }

    public String getUsernameDataBase() {
        return usernameDataBase;
    }

    public void setPasswordDataBase(String passwordDataBase) {
        this.passwordDataBase = passwordDataBase;
    }

    public void setUrlDataBase(String urlDataBase) {
        this.urlDataBase = urlDataBase;
    }

    public void setUsernameDataBase(String usernameDataBase) {
        this.usernameDataBase = usernameDataBase;
    }
}
