package com.intive.intivepatronage.issdata;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.stereotype.Component;

@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class IssCoordinate {
    private String longitude;
    private String latitude;

    public IssCoordinate() {
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
