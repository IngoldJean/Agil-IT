package com.example.ecepfe.agilit;

/**
 * Created by Jean on 22/01/2018.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Aggregateprogress {

    @SerializedName("progress")
    @Expose
    private Integer progress;
    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("percent")
    @Expose
    private Integer percent;

    public Integer getProgress() {
        return progress;
    }

    public void setProgress(Integer progress) {
        this.progress = progress;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getPercent() {
        return percent;
    }

    public void setPercent(Integer percent) {
        this.percent = percent;
    }

}