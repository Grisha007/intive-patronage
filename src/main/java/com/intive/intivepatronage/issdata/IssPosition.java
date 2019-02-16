package com.intive.intivepatronage.issdata;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.stereotype.Component;

@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class IssPosition {
    private IssCoordinate iss_position;
    private int timestamp;
    private String message;
    private static final String BLUE = "\033[0;34m";
    private static final String RESET = "\033[0m";

    public IssPosition() {
    }

    public IssCoordinate getIss_position() {
        return iss_position;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "\n\n" + BLUE + "ISS position: " + RESET + "\n" + iss_position + "\n" +
                "Timestamp: " + timestamp + "\n" +
                "Status: " + BLUE + message + RESET;
    }
}
