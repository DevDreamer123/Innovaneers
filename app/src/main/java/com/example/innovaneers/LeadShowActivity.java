package com.example.innovaneers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.innovaneers.account.NewLeadModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LeadShowActivity extends AppCompatActivity {
RecyclerView lead;
    LinearLayoutManager horizontal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lead_show);
        lead = findViewById(R.id.leadRecyler);
        RectrofitInstance.BASEURL = "http://api.innovaneers.in/Leads/";
        try {
            Call<List<LeadModel>> lcall = RectrofitInstance.getInstance().getMyApi().getnewlead();
            lcall.enqueue(new Callback<List<LeadModel>>() {
                @Override
                public void onResponse(Call<List<LeadModel>> call, Response<List<LeadModel>> response) {
                    List<LeadModel> models = response.body();
                    LeadAdapter courseAdapter = new LeadAdapter(models ,LeadShowActivity.this);

                    // below line is for setting a layout manager for our recycler view.
                    // here we are creating vertical list so we will provide orientation as vertical
                    horizontal =new LinearLayoutManager(LeadShowActivity.this,LinearLayoutManager.VERTICAL,false);

                    // in below two lines we are setting layoutmanager and adapter to our recycler view.
                    lead.setLayoutManager(horizontal);
                    lead.setAdapter(courseAdapter);
                }

                @Override
                public void onFailure(Call<List<LeadModel>> call, Throwable t) {

                }
            });

        }catch (Exception e){

        }

    }
}