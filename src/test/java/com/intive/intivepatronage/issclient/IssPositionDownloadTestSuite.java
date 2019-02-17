package com.intive.intivepatronage.issclient;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IssPositionDownloadTestSuite {

    @Autowired
    private IssPositionDownload issPositionDownload;

    @Test
    public void testIssPositionDownload() {
        //Given

        //When
        issPositionDownload.getIssUrl();
        //Then
        assertEquals("http://api.open-notify.org/iss-now.json", issPositionDownload.getIssUrl());
    }

}