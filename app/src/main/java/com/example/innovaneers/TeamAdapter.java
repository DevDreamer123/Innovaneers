package com.example.innovaneers;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.ViewHolder> {
    List<TeamModel> tm_models;
    Context context;

    public TeamAdapter(List<TeamModel> models, Context context) {
        tm_models = models;
        this.context = context;
    }

    @NonNull
    @Override
    public TeamAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.team_detail_layout,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamAdapter.ViewHolder holder, int position) {
        final TeamModel model = tm_models.get(position);
        holder.typePjt.setText(model.getDesignation());
        holder.namePjt.setText(model.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context , TeamProfileDetailActivity.class);
                i.putExtra("StaffID",model.getStaffID());
                context.startActivity(i);
            }
        });

    }


    @Override
    public int getItemCount() {
        return tm_models.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        CardView team_layout;
        TextView typePjt , namePjt;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            team_layout = itemView.findViewById(R.id.team_layout);
            typePjt =  itemView.findViewById(R.id.designation_type);
            namePjt = itemView.findViewById(R.id.name_Team);
        }
    }
}
