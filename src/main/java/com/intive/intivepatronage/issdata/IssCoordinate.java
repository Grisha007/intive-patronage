package com.intive.intivepatronage.issdata;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IssCoordinate {
    private final String longitude;
    private final String latitude;

    @JsonCreator
    public IssCoordinate(@JsonProperty("longitude") String longitude, @JsonProperty("latitude") String latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    @Override
    public String toString() {
        return "Longitude: " + longitude + '\n' +
                "Latitude: " + latitude;
    }
}
