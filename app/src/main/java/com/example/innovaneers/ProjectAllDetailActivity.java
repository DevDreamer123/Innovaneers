package com.example.innovaneers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProjectAllDetailActivity extends AppCompatActivity {
RecyclerView recycler_team;
LinearLayoutManager horizontal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_all_detail);


        recycler_team = findViewById(R.id.recycler_team);
        RectrofitInstance.BASEURL = " http://api.innovaneers.in/Projects/";
        ProjectIdModel model = new ProjectIdModel(Project_Detail_Activity.globalAdapterProjectID);
        try {
            Call<List<TeamListModel>> lcall = RectrofitInstance.getRetrofit1().getMyApi().createprojectteam(model);
            lcall.enqueue(new Callback<List<TeamListModel>>() {
                @Override
                public void onResponse(Call<List<TeamListModel>> call, Response<List<TeamListModel>> response) {
                   List< TeamListModel> showModel= response.body();
                    Log.d("data",response.body().toString());
                    Toast.makeText(ProjectAllDetailActivity.this,showModel.toString(), Toast.LENGTH_SHORT).show();
                    TeamDetailAdapter adapter = new TeamDetailAdapter(showModel, ProjectAllDetailActivity.this);
                    horizontal = new LinearLayoutManager(ProjectAllDetailActivity.this,LinearLayoutManager.VERTICAL,false);
                    recycler_team.setLayoutManager(horizontal);
                    recycler_team.setAdapter(adapter);
                }

                @Override
                public void onFailure(Call<List<TeamListModel>> call, Throwable t) {
                    Toast.makeText(ProjectAllDetailActivity.this,t.getMessage(), Toast.LENGTH_SHORT).show();
                    Log.d("error",t.getMessage());
                    Log.d("erroe2",t.getLocalizedMessage());
                    Log.d("erroe3",t.toString());
                    t.printStackTrace();


                }
            });


        }catch (Exception e){

        }
 // recycler_team.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
  //    @Override
   //   public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {


     //     return false;
    //  }

    //  @Override
   //   public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {

   //   }

    //  @Override
    //  public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

   //   }
//  });

    }
}