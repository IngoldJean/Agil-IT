package com.example.ecepfe.agilit;

/**
 * Created by Jean on 22/01/2018.
 */

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Fields {

    @SerializedName("issuetype")
    @Expose
    private Issuetype issuetype;
    @SerializedName("timespent")
    @Expose
    private Integer timespent;
    @SerializedName("project")
    @Expose
    private Project project;
    @SerializedName("fixVersions")
    @Expose
    private List<Object> fixVersions = null;
    @SerializedName("aggregatetimespent")
    @Expose
    private Integer aggregatetimespent;
    @SerializedName("resolution")
    @Expose
    private Object resolution;
    @SerializedName("resolutiondate")
    @Expose
    private Object resolutiondate;
    @SerializedName("workratio")
    @Expose
    private Integer workratio;
    @SerializedName("watches")
    @Expose
    private Watches watches;
    @SerializedName("lastViewed")
    @Expose
    private String lastViewed;
    @SerializedName("created")
    @Expose
    private String created;
    @SerializedName("customfield_10020")
    @Expose
    private Object customfield10020;
    @SerializedName("customfield_10021")
    @Expose
    private Object customfield10021;
    @SerializedName("customfield_10022")
    @Expose
    private Object customfield10022;
    @SerializedName("priority")
    @Expose
    private Priority priority;
    @SerializedName("customfield_10023")
    @Expose
    private Object customfield10023;
    @SerializedName("customfield_10024")
    @Expose
    private Object customfield10024;
    @SerializedName("labels")
    @Expose
    private List<Object> labels = null;
    @SerializedName("customfield_10017")
    @Expose
    private Object customfield10017;
    @SerializedName("customfield_10018")
    @Expose
    private Object customfield10018;
    @SerializedName("customfield_10019")
    @Expose
    private Object customfield10019;
    @SerializedName("aggregatetimeoriginalestimate")
    @Expose
    private Object aggregatetimeoriginalestimate;
    @SerializedName("timeestimate")
    @Expose
    private Integer timeestimate;
    @SerializedName("versions")
    @Expose
    private List<Object> versions = null;
    @SerializedName("issuelinks")
    @Expose
    private List<Object> issuelinks = null;
    @SerializedName("assignee")
    @Expose
    private Assignee assignee;
    @SerializedName("updated")
    @Expose
    private String updated;
    @SerializedName("status")
    @Expose
    private Status status;
    @SerializedName("components")
    @Expose
    private List<Object> components = null;
    @SerializedName("timeoriginalestimate")
    @Expose
    private Object timeoriginalestimate;
    @SerializedName("description")
    @Expose
    private Object description;
    @SerializedName("customfield_10010")
    @Expose
    private List<String> customfield10010 = null;
    @SerializedName("customfield_10011")
    @Expose
    private String customfield10011;
    @SerializedName("customfield_10012")
    @Expose
    private Object customfield10012;
    @SerializedName("customfield_10013")
    @Expose
    private Object customfield10013;
    @SerializedName("customfield_10014")
    @Expose
    private Integer customfield10014;
    @SerializedName("timetracking")
    @Expose
    private Timetracking timetracking;
    @SerializedName("security")
    @Expose
    private Object security;
    @SerializedName("customfield_10008")
    @Expose
    private Object customfield10008;
    @SerializedName("attachment")
    @Expose
    private List<Object> attachment = null;
    @SerializedName("customfield_10009")
    @Expose
    private Object customfield10009;
    @SerializedName("aggregatetimeestimate")
    @Expose
    private Integer aggregatetimeestimate;
    @SerializedName("summary")
    @Expose
    private String summary;
    @SerializedName("creator")
    @Expose
    private Creator creator;
    @SerializedName("subtasks")
    @Expose
    private List<Object> subtasks = null;
    @SerializedName("reporter")
    @Expose
    private Reporter reporter;
    @SerializedName("aggregateprogress")
    @Expose
    private Aggregateprogress aggregateprogress;
    @SerializedName("customfield_10000")
    @Expose
    private String customfield10000;
    @SerializedName("customfield_10001")
    @Expose
    private Object customfield10001;
    @SerializedName("customfield_10002")
    @Expose
    private Object customfield10002;
    @SerializedName("customfield_10003")
    @Expose
    private Object customfield10003;
    @SerializedName("customfield_10004")
    @Expose
    private Object customfield10004;
    @SerializedName("environment")
    @Expose
    private Object environment;
    @SerializedName("duedate")
    @Expose
    private Object duedate;
    @SerializedName("progress")
    @Expose
    private Progress progress;
    @SerializedName("votes")
    @Expose
    private Votes votes;
    @SerializedName("comment")
    @Expose
    private Comment comment;
    @SerializedName("worklog")
    @Expose
    private Worklog worklog;

    public Issuetype getIssuetype() {
        return issuetype;
    }

    public void setIssuetype(Issuetype issuetype) {
        this.issuetype = issuetype;
    }

    public Integer getTimespent() {
        return timespent;
    }

    public void setTimespent(Integer timespent) {
        this.timespent = timespent;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public List<Object> getFixVersions() {
        return fixVersions;
    }

    public void setFixVersions(List<Object> fixVersions) {
        this.fixVersions = fixVersions;
    }

    public Integer getAggregatetimespent() {
        return aggregatetimespent;
    }

    public void setAggregatetimespent(Integer aggregatetimespent) {
        this.aggregatetimespent = aggregatetimespent;
    }

    public Object getResolution() {
        return resolution;
    }

    public void setResolution(Object resolution) {
        this.resolution = resolution;
    }

    public Object getResolutiondate() {
        return resolutiondate;
    }

    public void setResolutiondate(Object resolutiondate) {
        this.resolutiondate = resolutiondate;
    }

    public Integer getWorkratio() {
        return workratio;
    }

    public void setWorkratio(Integer workratio) {
        this.workratio = workratio;
    }

    public Watches getWatches() {
        return watches;
    }

    public void setWatches(Watches watches) {
        this.watches = watches;
    }

    public String getLastViewed() {
        return lastViewed;
    }

    public void setLastViewed(String lastViewed) {
        this.lastViewed = lastViewed;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public Object getCustomfield10020() {
        return customfield10020;
    }

    public void setCustomfield10020(Object customfield10020) {
        this.customfield10020 = customfield10020;
    }

    public Object getCustomfield10021() {
        return customfield10021;
    }

    public void setCustomfield10021(Object customfield10021) {
        this.customfield10021 = customfield10021;
    }

    public Object getCustomfield10022() {
        return customfield10022;
    }

    public void setCustomfield10022(Object customfield10022) {
        this.customfield10022 = customfield10022;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Object getCustomfield10023() {
        return customfield10023;
    }

    public void setCustomfield10023(Object customfield10023) {
        this.customfield10023 = customfield10023;
    }

    public Object getCustomfield10024() {
        return customfield10024;
    }

    public void setCustomfield10024(Object customfield10024) {
        this.customfield10024 = customfield10024;
    }

    public List<Object> getLabels() {
        return labels;
    }

    public void setLabels(List<Object> labels) {
        this.labels = labels;
    }

    public Object getCustomfield10017() {
        return customfield10017;
    }

    public void setCustomfield10017(Object customfield10017) {
        this.customfield10017 = customfield10017;
    }

    public Object getCustomfield10018() {
        return customfield10018;
    }

    public void setCustomfield10018(Object customfield10018) {
        this.customfield10018 = customfield10018;
    }

    public Object getCustomfield10019() {
        return customfield10019;
    }

    public void setCustomfield10019(Object customfield10019) {
        this.customfield10019 = customfield10019;
    }

    public Object getAggregatetimeoriginalestimate() {
        return aggregatetimeoriginalestimate;
    }

    public void setAggregatetimeoriginalestimate(Object aggregatetimeoriginalestimate) {
        this.aggregatetimeoriginalestimate = aggregatetimeoriginalestimate;
    }

    public Integer getTimeestimate() {
        return timeestimate;
    }

    public void setTimeestimate(Integer timeestimate) {
        this.timeestimate = timeestimate;
    }

    public List<Object> getVersions() {
        return versions;
    }

    public void setVersions(List<Object> versions) {
        this.versions = versions;
    }

    public List<Object> getIssuelinks() {
        return issuelinks;
    }

    public void setIssuelinks(List<Object> issuelinks) {
        this.issuelinks = issuelinks;
    }

    public Assignee getAssignee() {
        return assignee;
    }

    public void setAssignee(Assignee assignee) {
        this.assignee = assignee;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Object> getComponents() {
        return components;
    }

    public void setComponents(List<Object> components) {
        this.components = components;
    }

    public Object getTimeoriginalestimate() {
        return timeoriginalestimate;
    }

    public void setTimeoriginalestimate(Object timeoriginalestimate) {
        this.timeoriginalestimate = timeoriginalestimate;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public List<String> getCustomfield10010() {
        return customfield10010;
    }

    public void setCustomfield10010(List<String> customfield10010) {
        this.customfield10010 = customfield10010;
    }

    public String getCustomfield10011() {
        return customfield10011;
    }

    public void setCustomfield10011(String customfield10011) {
        this.customfield10011 = customfield10011;
    }

    public Object getCustomfield10012() {
        return customfield10012;
    }

    public void setCustomfield10012(Object customfield10012) {
        this.customfield10012 = customfield10012;
    }

    public Object getCustomfield10013() {
        return customfield10013;
    }

    public void setCustomfield10013(Object customfield10013) {
        this.customfield10013 = customfield10013;
    }

    public Integer getCustomfield10014() {
        return customfield10014;
    }

    public void setCustomfield10014(Integer customfield10014) {
        this.customfield10014 = customfield10014;
    }

    public Timetracking getTimetracking() {
        return timetracking;
    }

    public void setTimetracking(Timetracking timetracking) {
        this.timetracking = timetracking;
    }

    public Object getSecurity() {
        return security;
    }

    public void setSecurity(Object security) {
        this.security = security;
    }

    public Object getCustomfield10008() {
        return customfield10008;
    }

    public void setCustomfield10008(Object customfield10008) {
        this.customfield10008 = customfield10008;
    }

    public List<Object> getAttachment() {
        return attachment;
    }

    public void setAttachment(List<Object> attachment) {
        this.attachment = attachment;
    }

    public Object getCustomfield10009() {
        return customfield10009;
    }

    public void setCustomfield10009(Object customfield10009) {
        this.customfield10009 = customfield10009;
    }

    public Integer getAggregatetimeestimate() {
        return aggregatetimeestimate;
    }

    public void setAggregatetimeestimate(Integer aggregatetimeestimate) {
        this.aggregatetimeestimate = aggregatetimeestimate;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Creator getCreator() {
        return creator;
    }

    public void setCreator(Creator creator) {
        this.creator = creator;
    }

    public List<Object> getSubtasks() {
        return subtasks;
    }

    public void setSubtasks(List<Object> subtasks) {
        this.subtasks = subtasks;
    }

    public Reporter getReporter() {
        return reporter;
    }

    public void setReporter(Reporter reporter) {
        this.reporter = reporter;
    }

    public Aggregateprogress getAggregateprogress() {
        return aggregateprogress;
    }

    public void setAggregateprogress(Aggregateprogress aggregateprogress) {
        this.aggregateprogress = aggregateprogress;
    }

    public String getCustomfield10000() {
        return customfield10000;
    }

    public void setCustomfield10000(String customfield10000) {
        this.customfield10000 = customfield10000;
    }

    public Object getCustomfield10001() {
        return customfield10001;
    }

    public void setCustomfield10001(Object customfield10001) {
        this.customfield10001 = customfield10001;
    }

    public Object getCustomfield10002() {
        return customfield10002;
    }

    public void setCustomfield10002(Object customfield10002) {
        this.customfield10002 = customfield10002;
    }

    public Object getCustomfield10003() {
        return customfield10003;
    }

    public void setCustomfield10003(Object customfield10003) {
        this.customfield10003 = customfield10003;
    }

    public Object getCustomfield10004() {
        return customfield10004;
    }

    public void setCustomfield10004(Object customfield10004) {
        this.customfield10004 = customfield10004;
    }

    public Object getEnvironment() {
        return environment;
    }

    public void setEnvironment(Object environment) {
        this.environment = environment;
    }

    public Object getDuedate() {
        return duedate;
    }

    public void setDuedate(Object duedate) {
        this.duedate = duedate;
    }

    public Progress getProgress() {
        return progress;
    }

    public void setProgress(Progress progress) {
        this.progress = progress;
    }

    public Votes getVotes() {
        return votes;
    }

    public void setVotes(Votes votes) {
        this.votes = votes;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public Worklog getWorklog() {
        return worklog;
    }

    public void setWorklog(Worklog worklog) {
        this.worklog = worklog;
    }

}