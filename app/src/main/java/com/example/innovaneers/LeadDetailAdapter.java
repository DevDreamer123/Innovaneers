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

public class LeadDetailAdapter extends RecyclerView.Adapter<LeadDetailAdapter.ViewHolder> {

    List<LeadModel> leadModels;
    Context context;

    public LeadDetailAdapter(List<LeadModel> leadModels, Context context) {
        this.leadModels = leadModels;
        this.context = context;
    }
    @NonNull
    @Override
    public LeadDetailAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.lead_detail_all_layout,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull LeadDetailAdapter.ViewHolder holder, int position) {
        final LeadModel models = leadModels.get(position);
        holder.detail_lead.setText(models.getManagerID());
        holder.name_lead.setText(models.getEmail());
        holder.mobile_lead.setText(models.getDate());

    }

    @Override
    public int getItemCount() {
        return leadModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView detail_lead,name_lead,mobile_lead;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            detail_lead =  itemView.findViewById(R.id.typePjt);
            name_lead = itemView.findViewById(R.id.namePjt);
            mobile_lead = itemView.findViewById(R.id.datePjt);
        }
    }
}
