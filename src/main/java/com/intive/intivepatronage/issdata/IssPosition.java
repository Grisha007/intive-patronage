package com.intive.intivepatronage.issdata;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.stereotype.Component;

@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class IssPosition {
    private IssCoordinate iss_position;
    private int timestamp;
    private String message;
    private final String BLUE = "\033[0;34m";
    private final String RESET = "\033[0m";

    public IssPosition() {
    }

    public IssPosition(IssCoordinate iss_position, int timestamp, String message) {
        this.iss_position = iss_position;
        this.timestamp = timestamp;
        this.message = message;
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

    public void setIss_position(IssCoordinate iss_position) {
        this.iss_position = iss_position;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "\n\n" + BLUE + "ISS position: " + RESET + "\n" + iss_position + "\n" +
                "Timestamp: " + timestamp + "\n" +
                "Status: " + BLUE + message + RESET;
    }
}
