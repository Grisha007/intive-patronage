package com.intive.intivepatronage.isscalculation;

import com.intive.intivepatronage.issdata.IssCoordinate;
import com.intive.intivepatronage.issdata.IssPosition;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class IssSpeedCalculationTestSuite {

    private IssSpeedCalculation issSpeedCalculation = new IssSpeedCalculation();

    @Test
    public void testIssSpeedCalculation() {
        //Given
        IssCoordinate issCoordinate1 = new IssCoordinate("31.5855", "51.1582");
        IssCoordinate issCoordinate2 = new IssCoordinate("32.2263", "51.2158");
        IssCoordinate issCoordinate3 = new IssCoordinate("32.8687", "51.2695");

        IssPosition issPosition1 = new IssPosition(issCoordinate1, 1550394715L, "success1");
        IssPosition issPosition2 = new IssPosition(issCoordinate2, 1550394721L, "success2");
        IssPosition issPosition3 = new IssPosition(issCoordinate3, 1550394728L, "success3");

        List<IssPosition> issPositionsList = new ArrayList<>();
        issPositionsList.add(issPosition1);
        issPositionsList.add(issPosition2);
        issPositionsList.add(issPosition3);

        //When
        double speed = issSpeedCalculation.calculateIssSpeed(issPositionsList);

        //Then
        assertEquals(3, issPositionsList.size());
        assertEquals(11.01, speed, 0.001);
    }
}