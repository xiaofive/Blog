package com.sxjf.blog.web.controller.jy;

public class HrefTitle {

    private Boolean uncacheable;
    private String raw;
    private String href;
    private String title;

    public HrefTitle() {
    }

    public HrefTitle(Boolean uncacheable, String raw, String href, String title) {
        this.uncacheable = uncacheable;
        this.raw = raw;
        this.href = href;
        this.title = title;
    }

    public Boolean getUncacheable() {
        return uncacheable;
    }

    public void setUncacheable(Boolean uncacheable) {
        this.uncacheable = uncacheable;
    }

    public String getRaw() {
        return raw;
    }

    public void setRaw(String raw) {
        this.raw = raw;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
