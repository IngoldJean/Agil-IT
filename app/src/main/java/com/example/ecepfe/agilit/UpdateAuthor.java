package com.example.ecepfe.agilit;

/**
 * Created by Jean on 22/01/2018.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UpdateAuthor {

    @SerializedName("self")
    @Expose
    private String self;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("key")
    @Expose
    private String key;
    @SerializedName("accountId")
    @Expose
    private String accountId;
    @SerializedName("emailAddress")
    @Expose
    private String emailAddress;
    @SerializedName("avatarUrls")
    @Expose
    private AvatarUrls_____ avatarUrls;
    @SerializedName("displayName")
    @Expose
    private String displayName;
    @SerializedName("active")
    @Expose
    private Boolean active;
    @SerializedName("timeZone")
    @Expose
    private String timeZone;

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public AvatarUrls_____ getAvatarUrls() {
        return avatarUrls;
    }

    public void setAvatarUrls(AvatarUrls_____ avatarUrls) {
        this.avatarUrls = avatarUrls;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

}