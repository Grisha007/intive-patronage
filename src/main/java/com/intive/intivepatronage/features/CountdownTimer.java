package com.intive.intivepatronage.features;

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
