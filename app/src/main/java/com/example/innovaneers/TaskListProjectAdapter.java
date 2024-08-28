package com.example.innovaneers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TaskListProjectAdapter extends RecyclerView.Adapter<TaskListProjectAdapter.ViewHolder>{
    private final Context context;
    private final List<TaskShowListModel> categoryModelList;

    public TaskListProjectAdapter(Context context, List<TaskShowListModel> categoryModelList) {
        this.context = context;
        this.categoryModelList = categoryModelList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_list_project_layout, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final TaskShowListModel model = categoryModelList.get(position);
        holder.hours_task_layout.setText(model.getAssignDate());
        holder.des_task_layout.setText(model.getTask1());
        holder.time_task_layout.setText(model.getCompletionDate());
       holder.developer_task_layout_project.setText(model.getAssignee());
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
        if(categoryModelList==null) return 0;
        return categoryModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView hours_task_layout,des_task_layout,time_task_layout,developer_task_layout_project;
        CheckBox check_task_layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            check_task_layout = (CheckBox) itemView.findViewById(R.id.check_task_layout_project);
            hours_task_layout = (TextView) itemView.findViewById(R.id.hours_task_layout_project);
            des_task_layout = (TextView) itemView.findViewById(R.id.des_task_layout_project);
            time_task_layout = (TextView) itemView.findViewById(R.id.time_task_layout_project);
            developer_task_layout_project = (TextView) itemView.findViewById(R.id.developer_task_layout_project);



        }
    }
}
