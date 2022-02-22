package com.malinskiy.materialicons.sample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.malinskiy.materialicons.IconDrawable;
import com.malinskiy.materialicons.Iconify;

public class IconsAdapter extends RecyclerView.Adapter<IconsAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView iconView;
        public TextView nameView;

        public ViewHolder(View itemView, ImageView iconView, TextView nameView) {
            super(itemView);
            this.iconView = iconView;
            this.nameView = nameView;
        }
    }

    public IconsAdapter() {
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_icon, parent, false);
        ImageView textView = view.findViewById(R.id.item_icon);
        TextView nameView = view.findViewById(R.id.item_text);
        return new ViewHolder(view, textView, nameView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Iconify.IconValue iconValue = Iconify.IconValue.values()[position];
        holder.iconView.setImageDrawable(new IconDrawable(holder.iconView.getContext(), iconValue).sizeRes(R.dimen.icon_size).colorRes(R.color.primary_dark_material_light));
        holder.nameView.setText(iconValue.name());
    }

    @Override
    public int getItemCount() {
        return Iconify.IconValue.values().length;
    }
}
