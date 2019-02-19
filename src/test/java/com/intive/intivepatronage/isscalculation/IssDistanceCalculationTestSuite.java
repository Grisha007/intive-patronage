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

        IssPosition issPosition1 = new IssPosition(issCoordinate1, 1550388225L, "success1");
        IssPosition issPosition2 = new IssPosition(issCoordinate2, 1550388232L, "success2");

        List<IssPosition> issPositionsList = new ArrayList<>();
        issPositionsList.add(issPosition1);
        issPositionsList.add(issPosition2);

        //When
        double distance = issDistanceCalculation.calculateDistanceBetweenTwoIssPosition(issPositionsList);

        //Then
        assertEquals(2, issPositionsList.size());
        assertEquals(46.02, distance, 0.001);
    }

}