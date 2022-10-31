package com.coderz.f1.rssfeedtojson;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.coderz.f1.rssfeedtojson.api.models.RSSFeedItem;
import com.coderz.f1.rssfeedtojson.databinding.RecyclerItemBinding;

import java.util.ArrayList;

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.FeedItemHolder> {

    private ArrayList<RSSFeedItem> _items;

    public FeedAdapter(ArrayList<RSSFeedItem> items) {
        this._items = items;
    }

    public void setItems(ArrayList<RSSFeedItem> newList) {
        this._items = newList;
    }

    @NonNull
    @Override
    public FeedItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerItemBinding binding = RecyclerItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new FeedItemHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull FeedItemHolder holder, int position) {
        RSSFeedItem item = _items.get(position);

        holder.title.setText(item.getTitle());
        holder.description.setText(Html.fromHtml(item.getDescription(),Html.FROM_HTML_MODE_LEGACY));
    }

    @Override
    public int getItemCount() {
        return _items.size();
    }

    public static class FeedItemHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView description;

        public FeedItemHolder(RecyclerItemBinding binding) {
            super(binding.getRoot());
            title = binding.title;
            description = binding.description;
        }
    }
}
