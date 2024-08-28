package com.example.innovaneers;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CallLogAdapter extends RecyclerView.Adapter<CallLogAdapter.MyViewHolder> {
 //   private int px;
    Context context;
    ArrayList<CallLogModel> callLogModels;

    public CallLogAdapter(Context context , ArrayList<CallLogModel> callLogModels){
        this.context = context;
        this.callLogModels =callLogModels;
    }

    @NonNull
    @Override
    public CallLogAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      //  Resources r = parent.getResources();
     //   px = Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,8,r.getDisplayMetrics()));
       View v = LayoutInflater.from(context).inflate(R.layout.layout_call_log,parent,false);
       return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CallLogAdapter.MyViewHolder holder, int position) {
      //  int i = position;
       // if (i ==0){
   //         ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) holder.cardview.getLayoutParams();
  //          layoutParams.topMargin = px ;
   //         holder.cardview.requestLayout();
   //     }
        CallLogModel currentlog = callLogModels.get(position);
        holder.number.setText(currentlog.getNumber());
        holder.name.setText(currentlog.getContactName());
        holder.type.setText(currentlog.getCallType());
        holder.date.setText(currentlog.getCallDate());
        holder.duration.setText(currentlog.getCallDuration());

    }

    @Override
    public int getItemCount() {
        return callLogModels == null ? 0 : callLogModels.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        CardView cardview;
        TextView number,name,type,date,tme,duration;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            cardview = (itemView).findViewById(R.id.cardview);
            number = (itemView).findViewById(R.id.number);
            name = (itemView).findViewById(R.id.callname);
            type = (itemView).findViewById(R.id.calltype);
            date = (itemView).findViewById(R.id.calldate);
            tme = (itemView).findViewById(R.id.calltime);
            duration = (itemView).findViewById(R.id.callduration);

        }
    }
}
