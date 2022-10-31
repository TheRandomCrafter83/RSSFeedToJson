package com.coderz.f1.rssfeedtojson.api.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RSSFeedItem {
    @Expose
    @SerializedName("title")
    private String _title;
    @Expose
    @SerializedName("description")
    private String _description;
    @Expose
    @SerializedName("url")
    private String _url;
    @Expose
    @SerializedName("link")
    private String _link;
    @Expose
    @SerializedName("published")
    private long _published;
    @Expose
    @SerializedName("created")
    private long _created;
    @Expose
    @SerializedName("category")
    private String[] _category;
    @Expose
    @SerializedName("content")
    private Object _content;
    @Expose
    @SerializedName("enclosures")
    private Object[] _enclosures;

    public String getTitle() {
        return _title;
    }


    public String getDescription() {
        return _description;
    }


    public String getUrl() {
        return _url;
    }


    public String getLink() {
        return _link;
    }


    public long getPublished() {
        return _published;
    }


    public long getCreated() {
        return _created;
    }


    public String[] getCategory() {
        return _category;
    }


    public Object getContent() {
        return _content;
    }


    public Object[] getEnclosures() {
        return _enclosures;
    }


}
