package edu.auburn.cpsc4970.auth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserSession {

    private String userName;
    private String password;
    private static final Logger logger = LoggerFactory.getLogger(UserSession.class);

    UserSession (String userName, String password) {


        logger.info("Created new user session for %s, %s");

        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
