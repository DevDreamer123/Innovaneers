package com.example.innovaneers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class projectListActivity extends AppCompatActivity {
RecyclerView project;
    LinearLayoutManager horizontal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_list);

        project = findViewById(R.id.projectRecyler);
        RectrofitInstance.BASEURL = "http://api.innovaneers.in/Projects/";
        try {
            Call<List<ProjectShowModel>> lcall = RectrofitInstance.getRetrofit1().getMyApi().getproject();
            lcall.enqueue(new Callback<List<ProjectShowModel>>() {
                @Override
                public void onResponse(Call<List<ProjectShowModel>> call, Response<List<ProjectShowModel>> response) {
                    List<ProjectShowModel> models = response.body();
                    ProjectDetaiAdapter adapter = new ProjectDetaiAdapter(models,projectListActivity.this);
                    horizontal = new LinearLayoutManager(projectListActivity.this,LinearLayoutManager.VERTICAL,false);
                    project.setLayoutManager(horizontal);
                    project.setAdapter(adapter);

                }

                @Override
                public void onFailure(Call<List<ProjectShowModel>> call, Throwable t) {
                    Toast.makeText(projectListActivity.this,t.getMessage(), Toast.LENGTH_SHORT).show();
                    t.printStackTrace();

                }
            });





        }catch (Exception e ){

        }

    }
}