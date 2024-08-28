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

import java.util.List;

public class ProjectDetaiAdapter extends RecyclerView.Adapter<ProjectDetaiAdapter.ViewHolder> {
    List<ProjectShowModel> projectShowModels;
    Context context;

    public ProjectDetaiAdapter(List<ProjectShowModel> projectShowModels, Context context) {
        this.projectShowModels = projectShowModels;
        this.context = context;
    }

    @NonNull
    @Override
    public ProjectDetaiAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.project_show_layout,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ProjectDetaiAdapter.ViewHolder holder, int position) {
        final ProjectShowModel pro = projectShowModels.get(position);
        holder.title.setText(pro.getTitle());
        holder.name.setText(pro.getCustomerName());
        holder.description.setText(pro.getDescription());
        String dateFormate = Methods.UnixToDate(pro.getStartDate());
        holder.date.setText(dateFormate);
        holder.projecvt_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context,Project_Detail_Activity.class);
                i.putExtra("ProjectID", projectShowModels.get(position).getProjectID());
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return projectShowModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        CardView projecvt_layout;
        TextView title, name , description,date;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            projecvt_layout = itemView.findViewById(R.id.projectLayout);
            title = itemView.findViewById(R.id.titlePjt);
            name = itemView.findViewById(R.id.nameshowPjt);
            description = itemView.findViewById(R.id.desshow);
            date = itemView.findViewById(R.id.dateshowPjt);
        }
    }
}
