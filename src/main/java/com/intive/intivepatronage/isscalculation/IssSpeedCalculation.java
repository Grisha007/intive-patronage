package com.intive.intivepatronage.isscalculation;

import com.intive.intivepatronage.feature.ConsoleColors;
import com.intive.intivepatronage.issdata.IssPositionList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IssSpeedCalculation {
    private IssPositionList issPositionList;
    private ConsoleColors consoleColors;
//    private final String CYAN = "\033[0;36m";
//    private final String RESET = "\033[0m";

    @Autowired
    public IssSpeedCalculation(IssPositionList issPositionList, ConsoleColors consoleColors) {
        this.issPositionList = issPositionList;
        this.consoleColors = consoleColors;
    }

    public IssPositionList getIssPositionList() {
        return issPositionList;
    }

    public ConsoleColors getConsoleColors() {
        return consoleColors;
    }

    public void setIssPositionList(IssPositionList issPositionList) {
        this.issPositionList = issPositionList;
    }

    public void setConsoleColors(ConsoleColors consoleColors) {
        this.consoleColors = consoleColors;
    }

    public double calculateIssSpeed() {
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

        System.out.println(consoleColors.getCYAN() + "ISS speed: " + roundedSpeed + " km/s" + consoleColors.getRESET());

        return roundedSpeed;
    }
}
