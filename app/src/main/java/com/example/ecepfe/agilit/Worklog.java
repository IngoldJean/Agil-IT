package com.example.ecepfe.agilit;

/**
 * Created by Jean on 22/01/2018.
 */

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Worklog {

    @SerializedName("startAt")
    @Expose
    private Integer startAt;
    @SerializedName("maxResults")
    @Expose
    private Integer maxResults;
    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("worklogs")
    @Expose
    private List<Worklog_> worklogs = null;

    public Integer getStartAt() {
        return startAt;
    }

    public void setStartAt(Integer startAt) {
        this.startAt = startAt;
    }

    public Integer getMaxResults() {
        return maxResults;
    }

    public void setMaxResults(Integer maxResults) {
        this.maxResults = maxResults;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<Worklog_> getWorklogs() {
        return worklogs;
    }

    public void setWorklogs(List<Worklog_> worklogs) {
        this.worklogs = worklogs;
    }

}