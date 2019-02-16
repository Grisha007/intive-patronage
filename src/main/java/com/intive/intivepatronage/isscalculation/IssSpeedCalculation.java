package com.intive.intivepatronage.isscalculation;

import com.intive.intivepatronage.issdata.IssPositionList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IssSpeedCalculation {
    private IssPositionList issPositionList;
    public static final String CYAN = "\033[0;36m";
    private final String RESET = "\033[0m";

    @Autowired
    public IssSpeedCalculation(IssPositionList issPositionList) {
        this.issPositionList = issPositionList;
    }

    public void calculateIssSpeed() {
        int issLocListSize = issPositionList.getIssPosList().size();
        int pow = 2;
        double oneDegreeInKm = 111.1;

        double longitude1 = Double.parseDouble(issPositionList.getIssPosList().get(0).getIss_position().getLongitude());
        double latitude1 = Double.parseDouble(issPositionList.getIssPosList().get(0).getIss_position().getLatitude());
        double longitudeLast = Double.parseDouble(issPositionList.getIssPosList().get(issLocListSize - 1).getIss_position().getLongitude());
        double latitudeLast = Double.parseDouble(issPositionList.getIssPosList().get(issLocListSize - 1).getIss_position().getLatitude());
        double longitudeDelta = longitudeLast - longitude1;
        double latitudeDelta = latitudeLast - latitude1;
        double longitudeDeltaPow = Math.pow(longitudeDelta, pow);
        double latitudeDeltaPow = Math.pow(latitudeDelta, pow);
        double powSum = longitudeDeltaPow + latitudeDeltaPow;
        double distanceInKm = (Math.sqrt(powSum) * oneDegreeInKm);

        int firstIssPositionTimestamp = issPositionList.getIssPosList().get(0).getTimestamp();
        int lastIssPositionTimestamp = issPositionList.getIssPosList().get(issLocListSize - 1).getTimestamp();
        int time = lastIssPositionTimestamp - firstIssPositionTimestamp;

        double speed = (distanceInKm / time);
        double roundedSpeed = Math.round(speed * 100.0) / 100.0;

        System.out.println(CYAN + "ISS speed: " + roundedSpeed + " km/s" + RESET);
    }
}
