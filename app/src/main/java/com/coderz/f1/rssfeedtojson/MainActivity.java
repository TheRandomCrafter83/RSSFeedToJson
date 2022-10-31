package com.coderz.f1.rssfeedtojson;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.coderz.f1.rssfeedtojson.databinding.ActivityMainBinding;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

import kotlin.text.Charsets;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        MainActivityViewModel viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        FeedAdapter adapter = new FeedAdapter(new ArrayList<>());

        viewModel.init();
        viewModel.getFeedLiveData().observe(this, rssFeed -> {
            setTitle(rssFeed.get_title());
            adapter.setItems(rssFeed.get_items());
            adapter.notifyDataSetChanged();
        });
        String url = "https://www.codeproject.com/WebServices/MessageRSS.aspx?fid=1848626";
        viewModel.loadFeed(url);

        binding.recyclerview.setAdapter(adapter);
    }
}