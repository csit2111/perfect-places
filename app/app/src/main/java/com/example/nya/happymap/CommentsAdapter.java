package com.example.nya.happymap;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.CommentViewHolder> {

    private List<Comment> placeComments = new ArrayList<>();
    private Context context;

    public CommentsAdapter(Context context) {
        this.context = context;
    }

    @Override
    public CommentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_comment, parent, false);

        return new CommentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CommentViewHolder holder, final int position) {
        holder.bind(placeComments.get(position));
    }

    @Override
    public int getItemCount() {
        return placeComments.size();
    }

    public void setItems(Collection<Comment> comments) {
        placeComments.addAll(comments);
        notifyDataSetChanged();
    }

    public void clearItems() {
        placeComments.clear();
        notifyDataSetChanged();
    }

    class CommentViewHolder extends RecyclerView.ViewHolder {
        private android.widget.ImageView placeValue;
        private TextView userComment;
        private TextView userName;

        public CommentViewHolder(View itemView) {
            super(itemView);
            placeValue = (ImageView) itemView.findViewById(R.id.Value);
            userName = (TextView) itemView.findViewById(R.id.UserName);
            userComment = (TextView) itemView.findViewById(R.id.TextComment);
        }


        public void bind(Comment comment) {
            userName.setText(comment.getUser().getUserLogin().toString());
            userComment.setText(comment.getDescription().toString());

            switch (comment.getRateValue()){

                case (1): {

                    break;
                }

                case (2): {

                    break;
                }

                case (3): {

                    break;
                }

                case (4): {

                    break;
                }

                case (5): {

                    break;
                }

            }

        }

    }
}