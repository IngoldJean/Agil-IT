package com.example.ecepfe.agilit;

/**
 * Created by Jean on 25/01/2018.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ListIssue {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("description")
    @Expose
    private Object description;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("time_remaining")
    @Expose
    private Object timeRemaining;
    @SerializedName("story_points")
    @Expose
    private Object storyPoints;
    @SerializedName("assignee")
    @Expose
    private Assignee assignee;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getTimeRemaining() {
        return timeRemaining;
    }

    public void setTimeRemaining(Object timeRemaining) {
        this.timeRemaining = timeRemaining;
    }

    public Object getStoryPoints() {
        return storyPoints;
    }

    public void setStoryPoints(Object storyPoints) {
        this.storyPoints = storyPoints;
    }

    public Assignee getAssignee() {
        return assignee;
    }

    public void setAssignee(Assignee assignee) {
        this.assignee = assignee;
    }

}
