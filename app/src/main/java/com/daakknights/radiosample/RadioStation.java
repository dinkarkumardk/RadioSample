package com.daakknights.radiosample;

public class RadioStation {

    // variables for our course
    // name and description.
    private String name;
    private String favicon;
    private String url;
    private String url_resolved;

    // creating constructor for our variables.
    public RadioStation(String name, String favicon, String url, String url_resolved) {
        this.name = name;
        this.favicon = favicon;
        this.url = url;
        this.url_resolved = url_resolved;
    }

    // creating getter and setter methods.
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFavicon() {
        return favicon;
    }

    public void setFavicong(String favicon) {
        this.favicon = favicon;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl_resolved() {
        return url_resolved;
    }

    public void setUrl_resolved(String url_resolved) {
        this.url_resolved = url_resolved;
    }
}
