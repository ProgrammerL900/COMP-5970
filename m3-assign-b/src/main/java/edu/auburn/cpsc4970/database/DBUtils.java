package edu.auburn.cpsc4970.database;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.lang.NullPointerException;




public class DBUtils {
    private DBUtils() {
        throw new IllegalStateException("Utility class");
    }


    /**
     * Logging class
     */
    private static final Logger logger = LoggerFactory.getLogger(DBUtils.class);


    public static String getNameForUser (String searchUser) {

        String userValue = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {

            // Load the database driver


            // Registering drivers
            DriverManager.registerDriver(new org.postgresql.Driver());

            // Get connection to the remote database
            //do something to encode encryption
            connection = DriverManager.getConnection("jdbc:postgresql://secretsdb.au-csse-cpsc4970.com:5432/user_db", "aubie", "tiger");


            // Setup query to execute
            preparedStatement = connection.prepareStatement("select name, password from users where login= ?");
            preparedStatement.setString(1,searchUser);





            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                userValue = resultSet.getString(1);

                logger.info("Found: %s", userValue);

            }

            // Closing the connection
            preparedStatement.close();
            connection.close();
        }

        // Catch block to handle exceptions
        catch (Exception ex) {
            // Display message when exceptions occurs
            logger.debug("context", ex);
            logger.info(String.valueOf(ex));
        }
        finally {
            // Quietly try to close connections.
            try { resultSet.close(); } catch (Exception e) {throw new NullPointerException(); }
            try { preparedStatement.close(); } catch (Exception e) { throw new NullPointerException();}
            try { connection.close(); } catch (Exception e) { throw new NullPointerException(); }
        }

        return userValue;
    }
}
