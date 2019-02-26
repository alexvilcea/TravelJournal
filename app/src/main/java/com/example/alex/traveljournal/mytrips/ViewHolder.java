package com.example.alex.traveljournal.mytrips;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.alex.traveljournal.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class ViewHolder extends RecyclerView.ViewHolder {
    CircleImageView image;
    TextView image_title;
    TextView image_description;
    RelativeLayout parent_layout;

    public ViewHolder(View itemView) {
        super(itemView);
        image = itemView.findViewById(R.id.image);
        image_title = itemView.findViewById(R.id.image_title);
        image_description = itemView.findViewById(R.id.image_description);
        parent_layout = itemView.findViewById(R.id.parent_layout);
    }
}
