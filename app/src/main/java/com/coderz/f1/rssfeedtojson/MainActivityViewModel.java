package com.coderz.f1.rssfeedtojson;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.coderz.f1.rssfeedtojson.api.models.RSSFeed;
import com.coderz.f1.rssfeedtojson.repository.Repository;

public class MainActivityViewModel extends AndroidViewModel {
    private Repository repository;
    private LiveData<RSSFeed> feedLiveData;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
    }

    public void init() {
        repository = new Repository();
        feedLiveData = repository.getFeed();
    }

    public void loadFeed(String url) {
        repository.loadFeed(url);
    }

    public LiveData<RSSFeed> getFeedLiveData() {
        return feedLiveData;
    }
}
