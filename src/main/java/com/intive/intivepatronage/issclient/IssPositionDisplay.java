package com.intive.intivepatronage.issclient;

import com.intive.intivepatronage.issdata.IssPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class IssPositionDisplay {
    private IssPositionDownload issPositionDownload;
    private Scanner scanner = new Scanner(System.in);

    @Autowired
    public IssPositionDisplay(IssPositionDownload issPositionDownload) {
        this.issPositionDownload = issPositionDownload;
    }

    public List<IssPosition> askUserForReadingNumberAndDownload() {
        return downloadIssPosition(askUserForNumberOfReadings());
    }

    private List<IssPosition> downloadIssPosition(int numberOfReadings) {
        List<IssPosition> issPosList = new ArrayList<>();
        int readingNumber = 1;
        for (int i = 0; i < numberOfReadings; i++) {
            System.out.println("Downloading ISS data position no." + readingNumber++ + " of " + numberOfReadings + ". Please wait...");
            countdownTimer();
            System.out.println();
            IssPosition issPosition = issPositionDownload.issPositionDownload();
            issPosition.getIssPosition();
            issPosList.add(issPosition);
        }
        return issPosList;
    }

    private void countdownTimer() {
        try {
            for (int y = 5; y >= 0; y--) {
                Thread.sleep(1000);
                System.out.println("Time remaining: " + y + " sec");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private int askUserForNumberOfReadings() {
        int numberOfReadings;
        do {
            System.out.println("Please enter number of SSI data readings (between 2-10): ");
            numberOfReadings = scanner.nextInt();
            System.out.println("\n" + "The number of data readings: " + numberOfReadings + "\n");
            if (isInRange(numberOfReadings)) {
                System.out.println("Wrong number! Please choose number between 2 - 10" + "\n");
            }
        } while (isInRange(numberOfReadings));

        return numberOfReadings;
    }

    private boolean isInRange(int numberOfReadings) {
        return !(numberOfReadings >= 2 && numberOfReadings <= 10);
    }
}

