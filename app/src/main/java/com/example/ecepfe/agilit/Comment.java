package com.example.ecepfe.agilit;

/**
 * Created by Jean on 22/01/2018.
 */

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Comment {

    @SerializedName("comments")
    @Expose
    private List<Object> comments = null;
    @SerializedName("maxResults")
    @Expose
    private Integer maxResults;
    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("startAt")
    @Expose
    private Integer startAt;

    public List<Object> getComments() {
        return comments;
    }

    public void setComments(List<Object> comments) {
        this.comments = comments;
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

    public Integer getStartAt() {
        return startAt;
    }

    public void setStartAt(Integer startAt) {
        this.startAt = startAt;
    }

}