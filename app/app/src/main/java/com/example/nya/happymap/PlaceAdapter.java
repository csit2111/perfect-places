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


public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.PlaceViewHolder> {

    private List<Place> placeList = new ArrayList<>();
    private Context context;

    public PlaceAdapter(MainActivity mainActivity) {
        this.context = mainActivity;
    }

    @Override
    public PlaceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_item_category, parent, false);

        return new PlaceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PlaceViewHolder holder, final int position) {
        holder.bind(placeList.get(position));

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                Toast.makeText(context, "ID " + placeList.get(position).getId(), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(context, PlaceInfo.class);
                int id = placeList.get(position).getId();
                intent.putExtra("ID", id);

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return placeList.size();
    }

    public void setItems(Collection<Place> places) {
        placeList.addAll(places);
        notifyDataSetChanged();
    }

    public void clearItems() {
        placeList.clear();
        notifyDataSetChanged();
    }

    class PlaceViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private android.widget.ImageView placeImageView;
        private TextView placeTextView;

        private ItemClickListener itemClickListener;

        public PlaceViewHolder(View itemView) {
            super(itemView);
            placeImageView = (ImageView) itemView.findViewById(R.id.CategoryImage);
            placeTextView = (TextView) itemView.findViewById(R.id.textCategoryName);

            itemView.setOnClickListener(this);
        }

        public void setItemClickListener(ItemClickListener itemClickListener){
            this.itemClickListener = itemClickListener;
        }

        public void bind(Place place) {
            placeTextView.setText(place.getName());

            String placePhotoUrl = place.getPhotos().get(0).getImagePath().toString();
            Picasso.with(itemView.getContext())
                    .load(placePhotoUrl)
                    .into(placeImageView);
        }

        @Override
        public void onClick(View v) {
            itemClickListener.onClick(v, getAdapterPosition());
        }

    }
}