package com.intive.intivepatronage.issdata;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IssCoordinateTestSuite {

    @Autowired
    private IssCoordinate issCoordinate;

    @Test
    public void testIssCordinate(){
        //Given

        //When
        issCoordinate.setLongitude("-5.7312");
        issCoordinate.setLatitude("17.9365");

        //Then
        assertEquals("-5.7312", issCoordinate.getLongitude());
        assertEquals("17.9365", issCoordinate.getLatitude());
    }
}