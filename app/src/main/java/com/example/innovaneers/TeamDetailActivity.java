package com.example.innovaneers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TeamDetailActivity extends AppCompatActivity {
RecyclerView teamRecycler;
    LinearLayoutManager horizontal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_detail);
        teamRecycler = findViewById(R.id.teamrecycler);
        RectrofitInstance.BASEURL = "http://api.innovaneers.in/Team/";
        try {
            Call<List<TeamModel>> lcall = RectrofitInstance.getRetrofit3().getMyApi().getteam();
            lcall.enqueue(new Callback<List<TeamModel>>() {
                @Override
                public void onResponse(Call<List<TeamModel>> call, Response<List<TeamModel>> response) {
                    List<TeamModel> models = response.body();
                    TeamAdapter courseAdapter = new TeamAdapter(models ,TeamDetailActivity.this);

                    // below line is for setting a layout manager for our recycler view.
                    // here we are creating vertical list so we will provide orientation as vertical
                    horizontal =new LinearLayoutManager(TeamDetailActivity.this,LinearLayoutManager.VERTICAL,false);

                    // in below two lines we are setting layoutmanager and adapter to our recycler view.
                    teamRecycler.setLayoutManager(horizontal);
                    teamRecycler.setAdapter(courseAdapter);
                }

                @Override
                public void onFailure(Call<List<TeamModel>> call, Throwable t) {

                }
            });

        }catch (Exception e){

        }

    }
}