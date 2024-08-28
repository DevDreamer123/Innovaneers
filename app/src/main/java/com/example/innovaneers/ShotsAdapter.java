package com.example.innovaneers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.innovaneers.home.BucketsModel;

import org.w3c.dom.Text;

import java.util.List;

public class ShotsAdapter extends RecyclerView.Adapter<ShotsAdapter.ViewHolder> {
    private final Context context;
    private final List<ShotsModel> categoryModel;

    public ShotsAdapter(Context context, List<ShotsModel> categoryModel) {
        this.context = context;
        this.categoryModel = categoryModel;
    }
    @NonNull
    @Override
    public ShotsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shots_layout, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShotsAdapter.ViewHolder holder, int position) {
        final ShotsModel model = categoryModel.get(position);
        holder.name_shots.setText(model.getText());
       // Glide.with(context).load(R.drawable.support).into(holder.image_shots);
    }

    @Override
    public int getItemCount() {
        return categoryModel.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image_shots;
        TextView name_shots;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image_shots = itemView.findViewById(R.id.image_shots);
            name_shots = itemView.findViewById(R.id.name_shots);
        }
    }
}
