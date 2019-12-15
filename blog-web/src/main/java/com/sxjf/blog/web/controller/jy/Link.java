package com.sxjf.blog.web.controller.jy;

import java.util.ArrayList;
import java.util.List;

public class Link {

    private List attachments = new ArrayList();
    private HrefTitle category = new HrefTitle();
    private HrefTitle type = new HrefTitle();
    private HrefTitle priority = new HrefTitle();
    private HrefTitle project = new HrefTitle();
    private HrefTitle status = new HrefTitle();
    private HrefTitle author = new HrefTitle();
    private HrefTitle responsible = new HrefTitle();
    private HrefTitle assignee = new HrefTitle();
    private HrefTitle version = new HrefTitle();
    private HrefTitle parent = new HrefTitle();
    private HrefTitle costObject = new HrefTitle();
    private HrefTitle self = new HrefTitle();

    public Link() {
    }

    public Link(List attachments, HrefTitle category, HrefTitle type, HrefTitle priority, HrefTitle project, HrefTitle status, HrefTitle author, HrefTitle responsible, HrefTitle assignee, HrefTitle version, HrefTitle parent, HrefTitle costObject, HrefTitle self) {
        this.attachments = attachments;
        this.category = category;
        this.type = type;
        this.priority = priority;
        this.project = project;
        this.status = status;
        this.author = author;
        this.responsible = responsible;
        this.assignee = assignee;
        this.version = version;
        this.parent = parent;
        this.costObject = costObject;
        this.self = self;
    }

    public List getAttachments() {
        return attachments;
    }

    public void setAttachments(List attachments) {
        this.attachments = attachments;
    }

    public HrefTitle getCategory() {
        return category;
    }

    public void setCategory(HrefTitle category) {
        this.category = category;
    }

    public HrefTitle getType() {
        return type;
    }

    public void setType(HrefTitle type) {
        this.type = type;
    }

    public HrefTitle getPriority() {
        return priority;
    }

    public void setPriority(HrefTitle priority) {
        this.priority = priority;
    }

    public HrefTitle getProject() {
        return project;
    }

    public void setProject(HrefTitle project) {
        this.project = project;
    }

    public HrefTitle getStatus() {
        return status;
    }

    public void setStatus(HrefTitle status) {
        this.status = status;
    }

    public HrefTitle getAuthor() {
        return author;
    }

    public void setAuthor(HrefTitle author) {
        this.author = author;
    }

    public HrefTitle getResponsible() {
        return responsible;
    }

    public void setResponsible(HrefTitle responsible) {
        this.responsible = responsible;
    }

    public HrefTitle getAssignee() {
        return assignee;
    }

    public void setAssignee(HrefTitle assignee) {
        this.assignee = assignee;
    }

    public HrefTitle getVersion() {
        return version;
    }

    public void setVersion(HrefTitle version) {
        this.version = version;
    }

    public HrefTitle getParent() {
        return parent;
    }

    public void setParent(HrefTitle parent) {
        this.parent = parent;
    }

    public HrefTitle getCostObject() {
        return costObject;
    }

    public void setCostObject(HrefTitle costObject) {
        this.costObject = costObject;
    }

    public HrefTitle getSelf() {
        return self;
    }

    public void setSelf(HrefTitle self) {
        this.self = self;
    }
}
