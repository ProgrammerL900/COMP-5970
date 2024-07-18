package edu.auburn.cpsc4970.auth;

import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import java.util.Map;



/**
 * Simple Authenticator using a json file based database
 */
public class UsernamePasswordAuthenticator implements AuthProviderInterface {
    /**
     * Logging class
     */

    /**
     * Login handler taking a simple username and password to validate
     *
     * @param username
     * @param password
     * @return User session context
     * @throws AULoginException
     * @throws IOException
     */
    @Override
    public UserSession login(String username, String password) throws AULoginException, IOException {




        if (username == null) throw new AULoginException("\"Username can not be null\"");
        if (password == null) throw new AULoginException("\"Password can not be null\"");

        // Find the user database file on the classpath
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("users.json");

        // Read in json database of
        String result = IOUtils.toString(in, StandardCharsets.UTF_8);
        Map<String, String> userList = Utils.parseUserJson(result);

        if (!userList.containsKey(username)) throw new AULoginException("User \"" + username + "\" does not exist.");
        if (!password.equals(userList.get(username)))
            throw new AULoginException("Password \"" + password + "\" for \"" + username + "\" is invalid");


        return new UserSession(username, password);


    }

    /**
     * Passwords need to be at least 2 characters long
     *
     * @param password to be checked.
     * @return
     */
    public boolean checkPasswordComplexity(String password) {


            if (password.length() <= 2) return false;
            return true;




    }
}
