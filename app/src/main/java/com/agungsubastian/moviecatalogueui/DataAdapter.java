package com.agungsubastian.moviecatalogueui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ListViewHolder> {

    private ArrayList<DataModel> listData;
    private OnItemClickCallback onItemClickCallback;

    void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    DataAdapter(ArrayList<DataModel> listData) {
        this.listData = listData;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        DataModel dataModel = listData.get(position);
        holder.imgData.setImageResource(dataModel.getImage());
        holder.txtTitle.setText(dataModel.getTitle());
        holder.txtScore.setText(dataModel.getScore());
        holder.txtDate.setText(dataModel.getDate());
        holder.txtDescription.setText(dataModel.getDescription());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(listData.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        private TextView txtTitle;
        private TextView txtScore;
        private TextView txtDate;
        private TextView txtDescription;
        private ImageView imgData;

        ListViewHolder(@NonNull View view) {
            super(view);
            txtTitle = view.findViewById(R.id.txt_title);
            txtScore = view.findViewById(R.id.txt_score);
            txtDate = view.findViewById(R.id.txt_date);
            txtDescription = view.findViewById(R.id.txt_description);
            imgData = view.findViewById(R.id.img_photo);
        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(DataModel dataModel);
    }
}
