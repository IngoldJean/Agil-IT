package com.example.ecepfe.agilit;

/**
 * Created by Jean on 25/01/2018.
 */

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ListeTaches {

    @SerializedName("list_issue")
    @Expose
    private List<ListIssue> listIssue = null;

    public List<ListIssue> getListIssue() {
        return listIssue;
    }

    public void setListIssue(List<ListIssue> listIssue) {
        this.listIssue = listIssue;
    }

}
