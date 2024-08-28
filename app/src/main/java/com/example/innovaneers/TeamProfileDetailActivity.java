package com.example.innovaneers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.innovaneers.home.BucketsModel;

import java.util.ArrayList;

public class TeamProfileDetailActivity extends AppCompatActivity {
RecyclerView buckets_recycler,short_recycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_profile_detail);
        buckets_recycler = findViewById(R.id.buckets_recycler);
        ArrayList<BucketsModel> Array1 = new ArrayList<BucketsModel>();
        Array1.add(new BucketsModel("1","Interface"));
        Array1.add(new BucketsModel("1","Illustration"));
        Array1.add(new BucketsModel("1","Web Design"));
        buckets_recycler.setLayoutManager(new LinearLayoutManager(TeamProfileDetailActivity.this,RecyclerView.HORIZONTAL,false));
        BucketsAdapter category1 = new BucketsAdapter(TeamProfileDetailActivity.this,Array1);
        buckets_recycler.setAdapter(category1);


        short_recycler = findViewById(R.id.short_recycler);
        ArrayList<ShotsModel> ModelArrayList = new ArrayList<ShotsModel>();
        ModelArrayList.add(new ShotsModel("","Support"));
        ModelArrayList.add(new ShotsModel("","Web Design"));
        ModelArrayList.add(new ShotsModel("","Web Design"));
        ModelArrayList.add(new ShotsModel("","Web Design"));
        ModelArrayList.add(new ShotsModel("","Web Design"));
        ModelArrayList.add(new ShotsModel("","Web Design"));
        short_recycler.setLayoutManager(new GridLayoutManager(TeamProfileDetailActivity.this,2));
        ShotsAdapter category = new ShotsAdapter(TeamProfileDetailActivity.this,ModelArrayList);
        short_recycler.setAdapter(category);


    }
}