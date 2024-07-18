package edu.auburn.cpsc4970.auth;


import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;




import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.HashMap;

import java.util.Map;
import java.util.ResourceBundle;

public class Utils {
    private Utils() {
        throw new IllegalStateException("Utility class");
    }


    private static final Logger logger = LoggerFactory.getLogger(Utils.class);

    private static Map<String, String> userList = null;
    private static ResourceBundle systemProperties = null;

    public static Map<String,String> parseUserJson(String userJsonList) {




        if (userList == null) {

            // Initialize return HashMap
           userList = new HashMap<>();

            // Parse Json String
            JSONObject obj = new JSONObject(userJsonList);
            JSONArray arr = obj.getJSONArray("users");
            for (int i = 0; i < arr.length(); i++) {
                String username = arr.getJSONObject(i).getString("user");
                String password = arr.getJSONObject(i).getString("password");
                userList.put(username, password);
            }
        }

        return userList;
    }

    public static boolean checkPassword(String password) {

        SecureRandom random = new SecureRandom();

        byte[] salt = new byte[16];
        random.nextBytes(salt);
        logger.info("Hex to String ", salt);

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt);
            byte[] hashedPassword = md.digest(password.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedPassword) {
                sb.append(String.format("%02X", 0xff & b));
            }
            logger.info("log this {}", sb);
        } catch (NoSuchAlgorithmException e) {
            logger.debug("context", e);
        }

        return true;
    }

    public static String toHexString(byte[] hash)
    {
        /* Convert byte array of hash into digest */
        BigInteger number = new BigInteger(1, hash);

        /* Convert the digest into hex value */
        StringBuilder hexString = new StringBuilder(number.toString(16));

        /* Pad with leading zeros */
        while (hexString.length() < 32)
        {
            hexString.insert(0, '0');
        }

        return hexString.toString();
    }

    /**
     * Utility methods to retrieve a value from the resources/system.properties file.
     * @param propertyKey the key of the property to retrieve
     * @return the value associated with the key
     */
    public static String getProperty(String propertyKey) {


        if (systemProperties == null)
             systemProperties = ResourceBundle.getBundle("system");

        return systemProperties.getString(propertyKey);

    }

    public static Cipher getCipher () {

        Cipher cipher = null;
        try {
           cipher = Cipher.getInstance("AES/GCM/NoPadding");
        } catch(NoSuchAlgorithmException|NoSuchPaddingException e) {
            logger.error(e.getMessage());
        }

        return cipher;
    }



}
