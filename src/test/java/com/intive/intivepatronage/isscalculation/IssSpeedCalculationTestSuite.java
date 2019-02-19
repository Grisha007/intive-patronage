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

        IssPosition issPosition1 = new IssPosition(issCoordinate1, 1550394715, "success1");
        IssPosition issPosition2 = new IssPosition(issCoordinate2, 1550394721, "success2");
        IssPosition issPosition3 = new IssPosition(issCoordinate3, 1550394728, "success3");

        List<IssPosition> issPositionsList = new ArrayList<>();
        issPositionsList.add(issPosition1);
        issPositionsList.add(issPosition2);
        issPositionsList.add(issPosition3);

        //When
        double speed = issSpeedCalculation.calculateIssSpeed(issPositionsList);

        //Then
        assertEquals("31.5855", issCoordinate1.getLongitude());
        assertEquals("51.1582", issCoordinate1.getLatitude());
        assertEquals("32.2263", issCoordinate2.getLongitude());
        assertEquals("51.2158", issCoordinate2.getLatitude());
        assertEquals("32.8687", issCoordinate3.getLongitude());
        assertEquals("51.2695", issCoordinate3.getLatitude());
        assertEquals(1550394715, issPosition1.getTimestamp());
        assertEquals("success1", issPosition1.getMessage());
        assertEquals(1550394721, issPosition2.getTimestamp());
        assertEquals("success2", issPosition2.getMessage());
        assertEquals(1550394728, issPosition3.getTimestamp());
        assertEquals("success3", issPosition3.getMessage());
        assertEquals(3, issPositionsList.size());
        assertEquals(11.01, speed, 0.001);
    }
}