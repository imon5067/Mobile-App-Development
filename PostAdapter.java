package com.example.post.view;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.post.MainActivity;
import com.example.post.PostDetailsActivity;
import com.example.post.R;
import com.example.post.model.Post;

import java.util.ArrayList;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {

    //All methods in this adapter are required for a bare minimum recyclerview adapter
    private int listItemLayout;
    private List<Post> itemList;
    private Context context;
    // Constructor of the class
    public PostAdapter(Context context, List<Post> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    // get the size of the list
    @Override
    public int getItemCount() {
        return itemList == null ? 0 : itemList.size();
    }


    // specify the row layout file and click for each row
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item, parent, false);
        return new ViewHolder(context, view);
    }

    // load data in each row element
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int listPosition) {
        TextView item = holder.item;
        TextView tvTitle = holder.tvTitle;
        tvTitle.setText(itemList.get(listPosition).getTitle());
        item.setText(itemList.get(listPosition).getBody());
    }

    // Static inner class to initialize the views of rows
    static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView item, tvTitle;
        public Context context;
        public ViewHolder(Context context, View itemView) {
            super(itemView);
            this.context = context;
            itemView.setOnClickListener(this);
            item = (TextView) itemView.findViewById(R.id.row_item);
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
        }
        @Override
        public void onClick(View view) {
            Log.d("onclick", "onClick test " + getLayoutPosition() + " " + item.getText());
            Intent intent = new Intent(this.context, PostDetailsActivity.class);
            intent.putExtra("title", tvTitle.getText());
            this.context.startActivity(intent);
        }
    }
}
