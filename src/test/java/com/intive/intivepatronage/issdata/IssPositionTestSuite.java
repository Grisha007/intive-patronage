package com.intive.intivepatronage.issdata;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IssPositionTestSuite {

    @Autowired
    private IssPosition issPosition;

    @Test
    public void testIssPosition() {
        //Given
        IssCoordinate issCoordinate = new IssCoordinate("32.8687", "51.2695");

        //When
        issPosition.setIss_position(issCoordinate);
        issPosition.setTimestamp(1550394728);
        issPosition.setMessage("success1");

        //Then
        assertEquals("32.8687", issPosition.getIss_position().getLongitude());
        assertEquals("51.2695", issPosition.getIss_position().getLatitude());
        assertEquals(1550394728, issPosition.getTimestamp());
        assertEquals("success1", issPosition.getMessage());
    }

}