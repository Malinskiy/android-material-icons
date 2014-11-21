package com.malinskiy.materialicons.sample;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.malinskiy.materialicons.widget.IconTextView;
import com.devspark.robototextview.widget.RobotoTextView;
import com.malinskiy.materialicons.Iconify;

public class IconsAdapter extends RecyclerView.Adapter<IconsAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public IconTextView   textView;
        public RobotoTextView nameView;

        public ViewHolder(View itemView, IconTextView textView, RobotoTextView nameView) {
            super(itemView);
            this.textView = textView;
            this.nameView = nameView;
        }
    }

    public IconsAdapter() {
    }

    @Override
    public IconsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_icon, parent, false);
        IconTextView textView = (IconTextView) view.findViewById(R.id.item_icon);
        RobotoTextView nameView = (RobotoTextView) view.findViewById(R.id.item_text);
        ViewHolder viewHolder = new ViewHolder(view, textView, nameView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Iconify.IconValue iconValue = Iconify.IconValue.values()[position];
        holder.textView.setText(iconValue.formattedName());
        holder.nameView.setText(iconValue.name());
    }

    @Override
    public int getItemCount() {
        return Iconify.IconValue.values().length;
    }
}