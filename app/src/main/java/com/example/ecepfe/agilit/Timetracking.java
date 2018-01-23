package com.example.ecepfe.agilit;

/**
 * Created by Jean on 22/01/2018.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Timetracking {

    @SerializedName("remainingEstimate")
    @Expose
    private String remainingEstimate;
    @SerializedName("timeSpent")
    @Expose
    private String timeSpent;
    @SerializedName("remainingEstimateSeconds")
    @Expose
    private Integer remainingEstimateSeconds;
    @SerializedName("timeSpentSeconds")
    @Expose
    private Integer timeSpentSeconds;

    public String getRemainingEstimate() {
        return remainingEstimate;
    }

    public void setRemainingEstimate(String remainingEstimate) {
        this.remainingEstimate = remainingEstimate;
    }

    public String getTimeSpent() {
        return timeSpent;
    }

    public void setTimeSpent(String timeSpent) {
        this.timeSpent = timeSpent;
    }

    public Integer getRemainingEstimateSeconds() {
        return remainingEstimateSeconds;
    }

    public void setRemainingEstimateSeconds(Integer remainingEstimateSeconds) {
        this.remainingEstimateSeconds = remainingEstimateSeconds;
    }

    public Integer getTimeSpentSeconds() {
        return timeSpentSeconds;
    }

    public void setTimeSpentSeconds(Integer timeSpentSeconds) {
        this.timeSpentSeconds = timeSpentSeconds;
    }

}
