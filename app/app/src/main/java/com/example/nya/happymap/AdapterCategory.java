package com.example.nya.happymap;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Locale;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


public class AdapterCategory extends RecyclerView.Adapter<AdapterCategory.CategoryViewHolder> {

    private List<Category> categoryList = new ArrayList<>();

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_item_category, parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder holder, int position) {
        holder.bind(categoryList.get(position));
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public void setItems(Collection<Category> category) {
        categoryList.addAll(category);
        notifyDataSetChanged();
    }

    public void clearItems() {
        categoryList.clear();
        notifyDataSetChanged();
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder {
        private android.widget.ImageView categoryImageView;
        private TextView categoryTextView;

        public CategoryViewHolder(View itemView) {
            super(itemView);
           categoryImageView = (ImageView) itemView.findViewById(R.id.CategoryImage);
           categoryTextView = (TextView) itemView.findViewById(R.id.textCategoryName);
        }

        public void bind(Category category) {
            categoryTextView.setText(category.getName());

            String categoryPhotoUrl = category.getImageURL();
            Picasso.with(itemView.getContext())
                    .load(categoryPhotoUrl)
                    .into(categoryImageView);
            categoryImageView.setVisibility(categoryPhotoUrl != null ? View.VISIBLE : View.GONE);
        }
    }
}



