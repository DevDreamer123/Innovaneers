package com.example.innovaneers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashActivity extends AppCompatActivity {

//    public static SharedPreferences preferences;
 //   private static final String SHARED_PREF_NAME = "Innovaneers";
    TextView hello;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        hello =  findViewById(R.id.hello);
       SharedPreferences preferences = getSharedPreferences(LoginActivity.SHARED_PREF_NAME, MODE_PRIVATE);
      //  String registeredUserNumber = preferences.getString(LoginActivity.KEY_MOBILE,"");
    //    new Handler().postDelayed(new Runnable() {
       //     @Override
       //     public void run() {
                //   Intent i = new Intent(SplashActivity.this,LoginActivity.class);
                //  startActivity(i);
                actUserLogin();


           //     finish();
    //    },5000);

    }
    private void actUserLogin(){
        SharedPreferences preferences = getSharedPreferences(LoginActivity.SHARED_PREF_NAME, MODE_PRIVATE);
        RectrofitInstance.BASEURL = "http://api.innovaneers.in/Home/";
        try {
            Call<HomeStackModel> lcall = RectrofitInstance.getRetrofit4().getMyApi().gethomestack();
            lcall.enqueue(new Callback<HomeStackModel>() {
                @Override
                public void onResponse(Call<HomeStackModel> call, Response<HomeStackModel> response) {
                    HomeStackModel homeStackModel = response.body();
                   // hello.setText(response.body().getTeam());
                          /*  newLeads.setText(response.body().getNewLeads());
                            onGoingLeads.setText(response.body().getOngoingLeads());
                            team_number.setText(response.body().getTeam());
                            new_Project.setText(response.body().getNewProjects());
                            active_Project.setText(response.body().getActiveProjects());
                            panding_Project.setText(response.body().getPendingProjects());
                            completed_project.setText(response.body().getCompletedProjects());*/

                }

                @Override
                public void onFailure(Call<HomeStackModel> call, Throwable t) {
                         /*   Toast.makeText(getContext(), "Error"+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                            Toast.makeText(getContext(), "Error"+t.getMessage(), Toast.LENGTH_SHORT).show();*/
                    Log.e("Error",t.getMessage());
                    Log.e("Error1",t.getLocalizedMessage());

                }
            });
        }catch (Exception e){

        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Simulated data fetching is complete, start the main activity
             //   Intent mainIntent = new Intent(SplashActivity.this, MainActivity.class);
             //   startActivity(mainIntent);
             //   finish(); // Close the splash screen activity

        if (preferences != null && !preferences.equals("")) {
            Intent i = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(i);
            finish();
        } else {
            // Toast.makeText(this, "Login Activity", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(SplashActivity.this, LoginActivity.class);
            startActivity(i);
        }
            }
        }, 2000); // Simulated data fetching time (2 seconds)


    }

}