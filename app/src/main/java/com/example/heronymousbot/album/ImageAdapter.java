package com.example.heronymousbot.album;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {

    private Context mContext;
    private List<Upload> mUploads;
    public ImageAdapter(Context context, List<Upload> uploads){
        mContext = context;
        mUploads = uploads;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.image_item, parent, false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        Upload currentUpload = mUploads.get(position);
        holder.imageNameTextView.setText(currentUpload.getmName());
        Picasso.get()
                .load( currentUpload.getmImageUrl())
                .fit()
                .into(holder.imageDisplayed);
    }

    @Override
    public int getItemCount() {
        return mUploads.size() > 1 ? mUploads.size() : 0;
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder{
        public TextView imageNameTextView;
        public ImageView imageDisplayed;
        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            imageNameTextView = itemView.findViewById(R.id.name_of_image);
            imageDisplayed = itemView.findViewById(R.id.image_displayed);
        }
    }
}
