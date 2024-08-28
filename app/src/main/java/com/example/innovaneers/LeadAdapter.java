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

import com.example.innovaneers.Utils.Methods;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class LeadAdapter extends RecyclerView.Adapter<LeadAdapter.ViewHolder> {

    List<LeadModel> leadModels;
            Context context;

    public LeadAdapter(List<LeadModel> leadModels, Context context) {
        this.leadModels = leadModels;
        this.context = context;
    }

    @NonNull
    @Override
    public LeadAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.leadlist_layout,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull LeadAdapter.ViewHolder holder, int position) {
        final LeadModel model = leadModels.get(position);
        String dateFormat = Methods.UnixToDate(model.getDate());
        holder.typePjt.setText(model.getDescription());
        holder.namePjt.setText(model.getName());
        holder.datePjt.setText(dateFormat);



        holder.lead_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context , LeadShowDetailActivity.class);
                i.putExtra("AdapterLeadID", leadModels.get(position).getLeadID());
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return leadModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        CardView lead_layout;
        TextView typePjt , namePjt,datePjt;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            lead_layout = itemView.findViewById(R.id.leadLayout);
            typePjt =  itemView.findViewById(R.id.typePjt);
            namePjt = itemView.findViewById(R.id.namePjt);
            datePjt = itemView.findViewById(R.id.datePjt);
        }
    }
}
