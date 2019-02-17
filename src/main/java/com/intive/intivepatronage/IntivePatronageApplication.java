package com.intive.intivepatronage;

import com.intive.intivepatronage.isscalculation.IssDistanceCalculation;
import com.intive.intivepatronage.isscalculation.IssSpeedCalculation;
import com.intive.intivepatronage.issclient.IssPositionDisplay;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("com.intive")
public class IntivePatronageApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(IntivePatronageApplication.class, args);
        IssPositionDisplay issPosition = run.getBean(IssPositionDisplay.class);
        issPosition.displayIssPosition();
        IssDistanceCalculation issDistanceCalculation = run.getBean(IssDistanceCalculation.class);
        issDistanceCalculation.calculateDistanceBetweenTwoIssPosition();
        IssSpeedCalculation issSpeedCalculation = run.getBean(IssSpeedCalculation.class);
        issSpeedCalculation.calculateIssSpeed();
    }
}

