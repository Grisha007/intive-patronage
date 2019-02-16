package com.intive.intivepatronage.isscalculation;

import com.intive.intivepatronage.issdata.IssPositionList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IssDistanceCalculation {
    private IssPositionList issPositionList;
    private final String CYAN = "\033[0;36m";
    private final String RESET = "\033[0m";

    @Autowired
    public IssDistanceCalculation(IssPositionList issPositionList) {
        this.issPositionList = issPositionList;
    }


    public void calculateDistanceBetweenTwoIssPosition() {
        int pow = 2;
        double oneDegreeInKm = 111.1;
        double longitude1 = Double.parseDouble(issPositionList.getIssPosList().get(0).getIss_position().getLongitude());
        double latitude1 = Double.parseDouble(issPositionList.getIssPosList().get(0).getIss_position().getLatitude());
        double longitude2 = Double.parseDouble(issPositionList.getIssPosList().get(1).getIss_position().getLongitude());
        double latitude2 = Double.parseDouble(issPositionList.getIssPosList().get(1).getIss_position().getLatitude());
        double longitudeDelta = longitude2 - longitude1;
        double latitudeDelta = latitude2 - latitude1;
        double longitudeDeltaPow = Math.pow(longitudeDelta, pow);
        double latitudeDeltaPow = Math.pow(latitudeDelta, pow);
        double powSum = longitudeDeltaPow + latitudeDeltaPow;
        double distanceInKm = (Math.sqrt(powSum) * oneDegreeInKm);
        double roundedDistance = Math.round(distanceInKm * 100.0) / 100.0;
        System.out.println(CYAN + "Distance between the first two ISS points: " + roundedDistance + " km" + RESET);
    }
}
