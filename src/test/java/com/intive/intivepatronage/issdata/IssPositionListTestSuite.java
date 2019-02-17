package com.intive.intivepatronage.issdata;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IssPositionListTestSuite {

    @Autowired
    private IssPositionList issPositionList;

    @Test
    public void testIssPositionList() {
        //Given
        IssCoordinate issCoordinate1 = new IssCoordinate("31.5855", "51.1582");
        IssCoordinate issCoordinate2 = new IssCoordinate("32.2263", "51.2158");
        IssCoordinate issCoordinate3 = new IssCoordinate("32.8687", "51.2695");

        IssPosition issPosition1 = new IssPosition(issCoordinate1, 1550394715, "success1");
        IssPosition issPosition2 = new IssPosition(issCoordinate2, 1550394721, "success2");
        IssPosition issPosition3 = new IssPosition(issCoordinate3, 1550394728, "success3");

        ArrayList<IssPosition> issPositionsList = new ArrayList<>();
        issPositionsList.add(issPosition1);
        issPositionsList.add(issPosition2);
        issPositionsList.add(issPosition3);

        //When
        issPositionList.setIssPosList(issPositionsList);

        //Then
        assertEquals("31.5855", issPositionList.getIssPosList().get(0).getIss_position().getLongitude());
        assertEquals("51.1582", issPositionList.getIssPosList().get(0).getIss_position().getLatitude());
        assertEquals(1550394715, issPositionList.getIssPosList().get(0).getTimestamp());
        assertEquals("success1", issPositionList.getIssPosList().get(0).getMessage());
        assertEquals("32.2263", issPositionList.getIssPosList().get(1).getIss_position().getLongitude());
        assertEquals("51.2158", issPositionList.getIssPosList().get(1).getIss_position().getLatitude());
        assertEquals(1550394721, issPositionList.getIssPosList().get(1).getTimestamp());
        assertEquals("success2", issPositionList.getIssPosList().get(1).getMessage());
        assertEquals("32.8687", issPositionList.getIssPosList().get(2).getIss_position().getLongitude());
        assertEquals("51.2695", issPositionList.getIssPosList().get(2).getIss_position().getLatitude());
        assertEquals(1550394728, issPositionList.getIssPosList().get(2).getTimestamp());
        assertEquals("success3", issPositionList.getIssPosList().get(2).getMessage());
        assertEquals(3, issPositionList.getIssPosList().size());
    }

}