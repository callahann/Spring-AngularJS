package edu.usach.grupo2mingeso2s2017.models;

import org.springframework.security.oauth2.provider.OAuth2Authentication;
import java.io.IOException;

public class LogIn
{
    private static LogIn logIn = new LogIn();

    private String email;
    private Object details;

    public static LogIn getInstance()
    {
        if(logIn == null)
        {
            logIn= new LogIn();
        }
        return logIn;
    }

    private LogIn()
    {
    }

    public void setUserDetails(OAuth2Authentication authentication) throws IOException
    {

        if(this.details == null)
        {
            this.details = authentication.getUserAuthentication().getDetails();
        }
    }
}
