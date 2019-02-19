package com.intive.intivepatronage;

import com.intive.intivepatronage.isscalculation.IssDistanceCalculation;
import com.intive.intivepatronage.isscalculation.IssSpeedCalculation;
import com.intive.intivepatronage.issclient.IssPositionDisplay;
import com.intive.intivepatronage.issdata.IssPosition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("com.intive")
public class IntivePatronageApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(IntivePatronageApplication.class, args);
        IssPositionDisplay issPosition = run.getBean(IssPositionDisplay.class);
        List<IssPosition> issPositions = issPosition.askUserForReadingNumberAndDownload();
        IssDistanceCalculation.calculateDistanceBetweenTwoIssPosition(issPositions);
        IssSpeedCalculation.calculateIssSpeed(issPositions);
    }
}

