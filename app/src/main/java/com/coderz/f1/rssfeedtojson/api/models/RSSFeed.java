package com.coderz.f1.rssfeedtojson.api.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class RSSFeed {
    @Expose
    @SerializedName("title")
    private String _title;
    @Expose
    @SerializedName("description")
    private String _description;
    @Expose
    @SerializedName("link")
    private String _link;
    @Expose
    @SerializedName("image")
    private String _image;
    @Expose
    @SerializedName("category")
    private String[] _category;
    @Expose
    @SerializedName("items")
    private ArrayList<RSSFeedItem> _items;

    public ArrayList<RSSFeedItem> get_items() {
        return _items;
    }


    public String get_title() {
        return _title;
    }


    public String get_description() {
        return _description;
    }


    public String get_link() {
        return _link;
    }


    public String get_image() {
        return _image;
    }


    public String[] get_category() {
        return _category;
    }


}
