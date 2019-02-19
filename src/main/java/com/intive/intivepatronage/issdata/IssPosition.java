package com.intive.intivepatronage.issdata;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IssPosition {
    private final IssCoordinate issPosition;
    private final Long timestamp;
    private final String message;

    @JsonCreator
    public IssPosition(@JsonProperty("iss_position") IssCoordinate issPosition, @JsonProperty("timestamp") Long timestamp, @JsonProperty("message") String message) {
        this.issPosition = issPosition;
        this.timestamp = timestamp;
        this.message = message;
    }

    public IssCoordinate getIssPosition() {
        return issPosition;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "\n\n" + "ISS position: " + "\n" + issPosition + "\n" +
                "Timestamp: " + timestamp + "\n" +
                "Status: " + message;
    }
}
