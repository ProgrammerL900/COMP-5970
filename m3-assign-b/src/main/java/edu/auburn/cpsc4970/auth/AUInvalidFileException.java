package edu.auburn.cpsc4970.auth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

/**
 * Exception handling for invalid file specification
 */
public class AUInvalidFileException extends Exception implements Serializable {
    private static final long serialVersionUID = 2405172041950251807L;


    private final Logger logger = LoggerFactory.getLogger(AUInvalidFileException.class);

    AUInvalidFileException(String message) {
        super(message);


        logger.error(getMessage(), "Invalid File Error: \"{0}\"!");

    }
}
