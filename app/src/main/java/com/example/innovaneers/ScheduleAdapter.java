package com.example.innovaneers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.ViewHolder>{
    private final Context context;
    private final List<ScheduleModel> categoryModelList;

    public ScheduleAdapter(Context context, List<ScheduleModel> categoryModelList) {
        this.context = context;
        this.categoryModelList = categoryModelList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.schedule_layout, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final ScheduleModel model = categoryModelList.get(position);
       holder.time_schedule_layout.setText(model.getTime());
        holder.des_schedule_layout.setText(model.getDescription());
        holder.day_schedule_layout.setText(model.getDay());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent i = new Intent(context, OptionDetailShow.class);
                // context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView notif_schedule_layout,point_schedule_layout;
        TextView time_schedule_layout,des_schedule_layout,day_schedule_layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            notif_schedule_layout = (ImageView) itemView.findViewById(R.id.notif_schedule_layout);
            point_schedule_layout = (ImageView) itemView.findViewById(R.id.point_schedule_layout);
            time_schedule_layout = (TextView) itemView.findViewById(R.id.time_schedule_layout);
            des_schedule_layout = (TextView) itemView.findViewById(R.id.description_schedule_layout);
            day_schedule_layout = (TextView) itemView.findViewById(R.id.day_schedule_layout);


        }
    }
    }
