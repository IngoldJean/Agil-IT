package com.example.ecepfe.agilit;

/**
 * Created by Jean on 25/01/2018.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Assignee {

    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("img_link")
    @Expose
    private String imgLink;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getImgLink() {
        return imgLink;
    }

    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
    }

}
