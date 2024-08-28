package com.example.innovaneers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.innovaneers.home.BucketsModel;

import org.w3c.dom.Text;

import java.util.List;

public class BucketsAdapter extends RecyclerView.Adapter<BucketsAdapter.ViewHolder> {
    private final Context context;
    private final List<BucketsModel> categoryModelList;

    public BucketsAdapter(Context context, List<BucketsModel> categoryModelList) {
        this.context = context;
        this.categoryModelList = categoryModelList;
    }
    @NonNull
    @Override
    public BucketsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.buckets_layout, parent, false);

        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull BucketsAdapter.ViewHolder holder, int position) {
        final BucketsModel model = categoryModelList.get(position);
        holder.text_buckets.setText(model.getText());
    }

    @Override
    public int getItemCount() {
        return categoryModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView text_buckets;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            text_buckets = (TextView) itemView.findViewById(R.id.text_buckets);
        }
    }
}
