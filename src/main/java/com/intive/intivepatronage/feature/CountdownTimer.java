package com.intive.intivepatronage.feature;

import org.springframework.stereotype.Component;

@Component
public class CountdownTimer {

    public CountdownTimer() {
    }

    public void countdownTime() {
        try {
            for (int y = 5; y >= 0; y--) {
                Thread.sleep(1000);
                System.out.println("Time remaining: " + y + " sec");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
