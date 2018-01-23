package com.example.ecepfe.agilit;

/**
 * Created by Jean on 22/01/2018.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Votes {

    @SerializedName("self")
    @Expose
    private String self;
    @SerializedName("votes")
    @Expose
    private Integer votes;
    @SerializedName("hasVoted")
    @Expose
    private Boolean hasVoted;

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    public Integer getVotes() {
        return votes;
    }

    public void setVotes(Integer votes) {
        this.votes = votes;
    }

    public Boolean getHasVoted() {
        return hasVoted;
    }

    public void setHasVoted(Boolean hasVoted) {
        this.hasVoted = hasVoted;
    }

}