package edu.auburn.cpsc4970.auth;

/**
 * Login factory for providing concrete login handlers.
 */
public class AuthProviderFactory {
    private AuthProviderFactory() {
        throw new IllegalStateException("Utility class");
    }


    public static AuthProviderInterface getAuthProvider() {

        return new UsernamePasswordAuthenticator();

    }
}
