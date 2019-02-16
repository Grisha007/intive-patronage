package com.intive.intivepatronage.issclient;

import com.intive.intivepatronage.features.CountdownTimer;
import com.intive.intivepatronage.issdata.IssPosition;
import com.intive.intivepatronage.issdata.IssPositionList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class IssPositionDisplay {
    private IssPositionDownload issPositionDownload;
    private IssPositionList issPositionList;
    private CountdownTimer countdownTimer;
    private Scanner scanner = new Scanner(System.in);
    private int numberOfReadings;
    private int readingNumber = 1;
    private static final String GREEN_UNDERLINED = "\033[4;32m";
    private static final String RED = "\033[0;31m";
    private static final String RESET = "\033[0m";

    @Autowired
    public IssPositionDisplay(IssPositionDownload issPositionDownload, IssPositionList issPositionList, CountdownTimer countdownTimer) {
        this.issPositionDownload = issPositionDownload;
        this.issPositionList = issPositionList;
        this.countdownTimer = countdownTimer;
    }

    public void displayIssPosition() {
        System.out.println("Please enter number of SSI data readings (between 2-10): ");
        numberOfReadings = scanner.nextInt();
        System.out.println("\n" + "The number of data readings: " + numberOfReadings + "\n");
        if (numberOfReadings >= 2 && numberOfReadings <= 10) {
            for (int i = 0; i < numberOfReadings; i++) {
                System.out.println(GREEN_UNDERLINED + "Downloading ISS data position no." + readingNumber++ + " of " + numberOfReadings + ". Please wait..." + RESET);
                countdownTimer.countdownTime();
                System.out.println();
                IssPosition issPosition = issPositionDownload.issPositionDownload();
                issPosition.getIss_position();
                issPositionList.getIssPosList().add(issPosition);
            }
        } else {
            System.out.println(RED + "Wrong number! Please choose number between 2 - 10" + RESET + "\n");
        }
    }
}
