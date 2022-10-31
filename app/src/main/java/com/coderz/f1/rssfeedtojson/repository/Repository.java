package com.coderz.f1.rssfeedtojson.repository;



import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.coderz.f1.rssfeedtojson.api.RSSFeedAPI;
import com.coderz.f1.rssfeedtojson.api.models.RSSFeed;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Repository {
    private static final String TAG = "Repository";
    static String BASE_URL = "https://rss-to-json-serverless-api.vercel.app/";

    private RSSFeedAPI feedAPI;
    private final MutableLiveData<RSSFeed> feed;

    public Repository(){
        feed = new MutableLiveData<>();
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        feedAPI = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RSSFeedAPI.class);
    }

    public void loadFeed(String url){
        feedAPI.getRssFeed(url).enqueue(new Callback<RSSFeed>() {
            @Override
            public void onResponse(Call<RSSFeed> call, Response<RSSFeed> response) {
                Log.d(TAG, "onResponse: "+ response.toString());
                if(response.isSuccessful()){
                    feed.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<RSSFeed> call, Throwable t) {
                Log.e(TAG, "onFailure: ",t);
            }
        });
    }

    public LiveData<RSSFeed> getFeed(){
        return feed;
    }
}
