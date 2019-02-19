package com.intive.intivepatronage.isscalculation;

import com.intive.intivepatronage.issdata.IssPosition;

import java.util.ArrayList;
import java.util.List;

public class IssDistanceCalculation {

    public static double calculateDistanceBetweenTwoIssPosition(List<IssPosition> issPosList) {
        if(issPosList.size() < 2) {throw new IllegalArgumentException("You need at least two ISS positions!");}
        int pow = 2;
        double oneDegreeInKm = 111.1;
        double longitude1 = Double.parseDouble(issPosList.get(0).getIssPosition().getLongitude());
        double latitude1 = Double.parseDouble(issPosList.get(0).getIssPosition().getLatitude());
        double longitude2 = Double.parseDouble(issPosList.get(1).getIssPosition().getLongitude());
        double latitude2 = Double.parseDouble(issPosList.get(1).getIssPosition().getLatitude());
        double longitudeDelta = longitude2 - longitude1;
        double latitudeDelta = latitude2 - latitude1;
        double longitudeDeltaPow = Math.pow(longitudeDelta, pow);
        double latitudeDeltaPow = Math.pow(latitudeDelta, pow);
        double powSum = longitudeDeltaPow + latitudeDeltaPow;
        double distanceInKm = (Math.sqrt(powSum) * oneDegreeInKm);
        double roundedDistance = Math.round(distanceInKm * 100.0) / 100.0;
        System.out.println("Distance between the first two ISS points: " + roundedDistance + " km");
        return roundedDistance;
    }
}
