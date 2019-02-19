package com.intive.intivepatronage.issclient;

import com.intive.intivepatronage.IntivePatronageApplication;
import com.intive.intivepatronage.issdata.IssPosition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class IssPositionDownload {

    private static final Logger log = LoggerFactory.getLogger(IntivePatronageApplication.class);

    @Value("${iss.position.api.url}")
    private String issUrl;

    public IssPosition issPositionDownload() {
        RestTemplate restTemplate = new RestTemplate();
        IssPosition issPosition = restTemplate.getForObject(
                issUrl, IssPosition.class);
        if (issPosition != null) {
            log.info(issPosition.toString() + "\n");
        }
        return issPosition;
    }
}
