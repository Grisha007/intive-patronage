package com.intive.intivepatronage.issdata;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class IssPositionList {
    private ArrayList<IssPosition> issPosList;

    public IssPositionList(ArrayList<IssPosition> issPosList) {
        this.issPosList = issPosList;
    }

    public ArrayList<IssPosition> getIssPosList() {
        return issPosList;
    }

    public void setIssPosList(ArrayList<IssPosition> issPosList) {
        this.issPosList = issPosList;
    }
}
