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
public class IssDistanceCalculationTestSuite {

    private IssDistanceCalculation issDistanceCalculation = new IssDistanceCalculation();

    @Test
    public void testIssDistanceCalculation() {
        //Given
        IssCoordinate issCoordinate1 = new IssCoordinate("-5.7312", "17.9365");
        IssCoordinate issCoordinate2 = new IssCoordinate("-5.4683", "18.2566");

        IssPosition issPosition1 = new IssPosition(issCoordinate1, 1550388225, "success1");
        IssPosition issPosition2 = new IssPosition(issCoordinate2, 1550388232, "success2");

        List<IssPosition> issPositionsList = new ArrayList<>();
        issPositionsList.add(issPosition1);
        issPositionsList.add(issPosition2);

        //When
        double distance = issDistanceCalculation.calculateDistanceBetweenTwoIssPosition(issPositionsList);

        //Then
        assertEquals("-5.7312", issCoordinate1.getLongitude());
        assertEquals("17.9365", issCoordinate1.getLatitude());
        assertEquals("-5.4683", issCoordinate2.getLongitude());
        assertEquals("18.2566", issCoordinate2.getLatitude());
        assertEquals(1550388225, issPosition1.getTimestamp());
        assertEquals("success1", issPosition1.getMessage());
        assertEquals(1550388232, issPosition2.getTimestamp());
        assertEquals("success2", issPosition2.getMessage());
        assertEquals(2, issPositionsList.size());
        assertEquals(46.02, distance, 0.001);
    }

}