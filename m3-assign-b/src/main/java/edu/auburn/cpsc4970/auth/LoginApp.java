package edu.auburn.cpsc4970.auth;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;







/**
 * App for call login handlers locally.
 *
 */
public class LoginApp
{
    private static final Logger logger = LoggerFactory.getLogger(LoginApp.class);

    public static void main( String[] args )
    {
        AuthProviderInterface authProvider = AuthProviderFactory.getAuthProvider();



        try {
            authProvider.login("Jordan","1957");
            authProvider.login("Jordan","19s57");
        } catch (Exception e) {
            logger.debug("context", e);
        }

    }
}
