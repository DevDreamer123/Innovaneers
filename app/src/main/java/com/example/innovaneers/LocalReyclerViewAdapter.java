package com.example.innovaneers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class LocalReyclerViewAdapter extends RecyclerView.Adapter<LocalReyclerViewAdapter.ViewHolder> {
    private ArrayList<StatusModel> ModalArrayList;
    private Context context;

    // constructor
    public LocalReyclerViewAdapter(ArrayList<StatusModel> ModalArrayList, Context context) {
        this.ModalArrayList = ModalArrayList;
        this.context = context;
    }
    @NonNull
    @Override
    public LocalReyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.statusrecyler_layout,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull LocalReyclerViewAdapter.ViewHolder holder, int position) {
        StatusModel modal = ModalArrayList.get(position);
        holder.desStatus.setText(modal.getDescription());
        holder.statusStatus.setText(modal.getStatus());
        holder.dateStatus.setText(modal.getDate());

    }

    @Override
    public int getItemCount() {
        return ModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView desStatus,statusStatus,dateStatus;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            desStatus = itemView.findViewById(R.id.desStatus);
            statusStatus = itemView.findViewById(R.id.statusStatus);
            dateStatus = itemView.findViewById(R.id.dateStatus);

        }
    }
}
