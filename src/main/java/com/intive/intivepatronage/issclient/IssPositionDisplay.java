package com.intive.intivepatronage.issclient;

import com.intive.intivepatronage.feature.ConsoleColors;
import com.intive.intivepatronage.feature.CountdownTimer;
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
    private ConsoleColors consoleColors;
    private Scanner scanner = new Scanner(System.in);
    private int numberOfReadings;
    private int readingNumber = 1;
//    private final String GREEN_UNDERLINED = "\033[4;32m";
//    private final String RED = "\033[0;31m";
//    private final String RESET = "\033[0m";

    @Autowired
    public IssPositionDisplay(IssPositionDownload issPositionDownload, IssPositionList issPositionList, CountdownTimer countdownTimer, ConsoleColors consoleColors) {
        this.issPositionDownload = issPositionDownload;
        this.issPositionList = issPositionList;
        this.countdownTimer = countdownTimer;
        this.consoleColors = consoleColors;
    }

    public void displayIssPosition() {
        System.out.println("Please enter number of SSI data readings (between 2-10): ");
        numberOfReadings = scanner.nextInt();
        System.out.println("\n" + "The number of data readings: " + numberOfReadings + "\n");
        if (numberOfReadings >= 2 && numberOfReadings <= 10) {
            for (int i = 0; i < numberOfReadings; i++) {
                System.out.println(consoleColors.getGREEN_UNDERLINED() + "Downloading ISS data position no." + readingNumber++ + " of " + numberOfReadings + ". Please wait..." + consoleColors.getRESET());
                countdownTimer.countdownTime();
                System.out.println();
                IssPosition issPosition = issPositionDownload.issPositionDownload();
                issPosition.getIss_position();
                issPositionList.getIssPosList().add(issPosition);
            }
        } else {
            System.out.println(consoleColors.getRED() + "Wrong number! Please choose number between 2 - 10" + consoleColors.getRESET() + "\n");
        }
    }
}
