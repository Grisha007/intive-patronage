package com.intive.intivepatronage.isscalculation;

import com.intive.intivepatronage.issdata.IssPosition;

import java.util.ArrayList;
import java.util.List;

public class IssSpeedCalculation {

    public static double calculateIssSpeed(List<IssPosition> issPosList) {
        if(issPosList.size() < 2) {throw new IllegalArgumentException("Size...");}
        int issLocListSize = issPosList.size();
        int pow = 2;
        double oneDegreeInKm = 111.1;

        double longitude1 = Double.parseDouble(issPosList.get(0).getIssPosition().getLongitude());
        double latitude1 = Double.parseDouble(issPosList.get(0).getIssPosition().getLatitude());
        double longitudeLast = Double.parseDouble(issPosList.get(issLocListSize - 1).getIssPosition().getLongitude());
        double latitudeLast = Double.parseDouble(issPosList.get(issLocListSize - 1).getIssPosition().getLatitude());
        double longitudeDelta = longitudeLast - longitude1;
        double latitudeDelta = latitudeLast - latitude1;
        double longitudeDeltaPow = Math.pow(longitudeDelta, pow);
        double latitudeDeltaPow = Math.pow(latitudeDelta, pow);
        double powSum = longitudeDeltaPow + latitudeDeltaPow;
        double distanceInKm = (Math.sqrt(powSum) * oneDegreeInKm);

        Long firstIssPositionTimestamp = issPosList.get(0).getTimestamp();
        Long lastIssPositionTimestamp = issPosList.get(issLocListSize - 1).getTimestamp();
        Long time = lastIssPositionTimestamp - firstIssPositionTimestamp;

        double speed = (distanceInKm / time);
        double roundedSpeed = Math.round(speed * 100.0) / 100.0;

        System.out.println("ISS speed: " + roundedSpeed + " km/s");

        return roundedSpeed;
    }
}
