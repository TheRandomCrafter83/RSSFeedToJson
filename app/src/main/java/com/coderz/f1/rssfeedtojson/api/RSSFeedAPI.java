package com.coderz.f1.rssfeedtojson.api;

import androidx.lifecycle.LiveData;

import com.coderz.f1.rssfeedtojson.api.models.RSSFeed;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RSSFeedAPI {
    @GET("api")
    Call<RSSFeed> getRssFeed(@Query("feedURL") String url);
}
