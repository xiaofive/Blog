package com.sxjf.blog.web.controller.jy;

/**
 * 工作包vo
 */
//@NoArgsConstructor
public class WorkSpace {

    private int lockVersion;
    private String subject;
    private HrefTitle description;
    private String startDate;
    private String dueDate;
    private String estimatedTime;
    private int percentageDone;
    private String remainingTime;
    private Link _links = new Link();

    public WorkSpace() {
    }

    public WorkSpace(int lockVersion, String subject, HrefTitle description, String startDate, String dueDate, String estimatedTime, int percentageDone, String remainingTime, Link _links) {
        this.lockVersion = lockVersion;
        this.subject = subject;
        this.description = description;
        this.startDate = startDate;
        this.dueDate = dueDate;
        this.estimatedTime = estimatedTime;
        this.percentageDone = percentageDone;
        this.remainingTime = remainingTime;
        this._links = _links;
    }

    public int getLockVersion() {
        return lockVersion;
    }

    public void setLockVersion(int lockVersion) {
        this.lockVersion = lockVersion;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public HrefTitle getDescription() {
        return description;
    }

    public void setDescription(HrefTitle description) {
        this.description = description;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(String estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    public int getPercentageDone() {
        return percentageDone;
    }

    public void setPercentageDone(int percentageDone) {
        this.percentageDone = percentageDone;
    }

    public String getRemainingTime() {
        return remainingTime;
    }

    public void setRemainingTime(String remainingTime) {
        this.remainingTime = remainingTime;
    }

    public Link get_links() {
        return _links;
    }

    public void set_links(Link _links) {
        this._links = _links;
    }
}
