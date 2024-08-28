package com.example.innovaneers.home;

import static com.example.innovaneers.LoginActivity.KEY_MOBILE;
import static com.example.innovaneers.LoginActivity.KEY_NAME;
import static com.example.innovaneers.LoginActivity.KEY_PASSWORD;
import static com.example.innovaneers.LoginActivity.SHARED_PREF_NAME;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.innovaneers.CreateTaskActivity;
import com.example.innovaneers.HomeStackModel;
import com.example.innovaneers.LeadActivity;
import com.example.innovaneers.LeadShowActivity;
import com.example.innovaneers.ProjectFormActivity;
import com.example.innovaneers.R;
import com.example.innovaneers.RectrofitInstance;
import com.example.innovaneers.ScheduleActivity;
import com.example.innovaneers.TeamDetailActivity;
import com.example.innovaneers.account.NewLeadModel;
import com.example.innovaneers.projectListActivity;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeFragment extends Fragment {
Button lead,project;
    CardView  all_tasks_home,create_task_home,new_lead_home,new_project_home;
    ImageSlider slider;
    CardView team;
    BarChart bar;
    PieChart pieChart;
    SharedPreferences preferences;
    public static final String SHARED_PREF_NAME = "Innovaneers";
    TextView user_dashboard_name,newLeads , onGoingLeads , team_number, new_Project , active_Project , panding_Project , completed_project;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view= inflater.inflate(R.layout.fragment_home, container, false);
        user_dashboard_name= view.findViewById(R.id.user_dashboard_name);

        preferences = getActivity().getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        String registerName =preferences.getString(KEY_NAME,"");
       String registeredUserNumber = preferences.getString(KEY_MOBILE,"");
        String registeredPassword = preferences.getString(KEY_PASSWORD,"");
        if (registeredUserNumber != null || registeredPassword != null)
        {

            Toast.makeText(getContext(),"value"+registeredUserNumber, Toast.LENGTH_SHORT).show();
            //  name.setText(registerName);
            user_dashboard_name.setText(registerName);
            // Toast.makeText(getContext(),"KeyMemberId"+KEY_MEMBER_ID, Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();
        }
        new_lead_home = view.findViewById(R.id.new_lead_home);
        new_lead_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), LeadShowActivity.class);
                startActivity(i);
            }
        });
        new_project_home = view.findViewById(R.id.new_project_home);
        new_project_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), projectListActivity.class);
                startActivity(i);
            }
        });

        all_tasks_home = view.findViewById(R.id.all_task_home);
        all_tasks_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), ScheduleActivity.class);
                startActivity(i);
            }
        });
        create_task_home = view.findViewById(R.id.create_task_home);
        create_task_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), CreateTaskActivity.class);
                startActivity(i);
            }
        });
       pieChart = view.findViewById(R.id.pichart);
        RectrofitInstance.BASEURL = "http://api.innovaneers.in/Home/";
        try {
            Call<HomeStackModel> lcall = RectrofitInstance.getRetrofit4().getMyApi().gethomestack();
            lcall.enqueue(new Callback<HomeStackModel>() {
                @Override
                public void onResponse(Call<HomeStackModel> call, Response<HomeStackModel> response) {
                    if (response.isSuccessful()) {
                        // Data retrieval successful, populate pie chart
                        HomeStackModel apiResponse = response.body();
                        if (apiResponse != null) {
                            setDataToPieChart(apiResponse);
                            setDataTobar(apiResponse);
                        }
                    } else {
                        // Data retrieval failed, show error message
                        Toast.makeText(getContext(), "Failed to retrieve data", Toast.LENGTH_SHORT).show();
                    }

            }

                @Override
                public void onFailure(Call<HomeStackModel> call, Throwable t) {
                    Toast.makeText(getContext(), "Error"+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    Toast.makeText(getContext(), "Error"+t.getMessage(), Toast.LENGTH_SHORT).show();
                    Log.e("Error",t.getMessage());
                    Log.e("Error1",t.getLocalizedMessage());

                }
            });
        }catch (Exception e){

        }









     /*  ArrayList<PieEntry> info = new ArrayList<>();
        info.add(new PieEntry(32,"Quarter1"));
        info.add(new PieEntry(60,"Quarter2"));
        info.add(new PieEntry(20,"Quarter3"));
        info.add(new PieEntry(45,"Quarter4"));
        info.add(new PieEntry(82,"Quarter5"));
        info.add(new PieEntry(50,"Quarter6"));
        PieDataSet set = new PieDataSet(info,"report");
        set.setColors(ColorTemplate.MATERIAL_COLORS);
        set.setValueTextColor(Color.BLACK);
        set.setValueTextSize(20f);

        PieData data = new PieData(set);
      //  pieChart.setData(true);
        pieChart.setData(data);
        pieChart.getDescription().setEnabled(true);
        pieChart.setCenterText("Quarterly");
        pieChart.animate();*/

       bar = view.findViewById(R.id.barchart);
       /*ArrayList<BarEntry> infomation = new ArrayList<>();
        infomation.add(new BarEntry(2018,399));
        infomation.add(new BarEntry(2020,5000));
        infomation.add(new BarEntry(2021,20000));
        infomation.add(new BarEntry(2022,100000));
        infomation.add(new BarEntry(2023,50000));
        BarDataSet dataSet = new BarDataSet(infomation,"report");
        dataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        dataSet.setValueTextColor(Color.BLACK);
        dataSet.setValueTextSize(20f);

        BarData barData = new BarData(dataSet);
        bar.setFitBars(true);
        bar.setData(barData);
        bar.getDescription().setText("Bar Report Demo");
        bar.animateY(2000);*/
       newLeads = view.findViewById(R.id.new_leads_number);
        onGoingLeads = view.findViewById(R.id.on_going_number);
        team_number = view.findViewById(R.id.team_number);
        new_Project = view.findViewById(R.id.new_project_number);
        active_Project = view.findViewById(R.id.active_project_number);
        panding_Project = view.findViewById(R.id.panding_project_number);
        completed_project = view.findViewById(R.id.completed_project_number);



       RectrofitInstance.BASEURL = "http://api.innovaneers.in/Home/";
        try {
            Call<HomeStackModel> lcall = RectrofitInstance.getRetrofit4().getMyApi().gethomestack();
            lcall.enqueue(new Callback<HomeStackModel>() {
                @Override
                public void onResponse(Call<HomeStackModel> call, Response<HomeStackModel> response) {
                    HomeStackModel homeStackModel = response.body();
                    if (homeStackModel != null) {
                        // Call methods on homeStackModel safely
                        newLeads.setText(response.body().getNewLeads());
                        onGoingLeads.setText(response.body().getOngoingLeads());
                        team_number.setText(response.body().getTeam());
                        new_Project.setText(response.body().getNewProjects());
                        active_Project.setText(response.body().getActiveProjects());
                        panding_Project.setText(response.body().getPendingProjects());
                        completed_project.setText(response.body().getCompletedProjects());
                        String team = homeStackModel.getTeam();
                    } else {
                        // Handle the case when homeStackModel is null
                    }


                }

                @Override
                public void onFailure(Call<HomeStackModel> call, Throwable t) {
                    Toast.makeText(getContext(), "Error"+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    Toast.makeText(getContext(), "Error"+t.getMessage(), Toast.LENGTH_SHORT).show();
                    Log.e("Error",t.getMessage());
                    Log.e("Error1",t.getLocalizedMessage());

                }
            });
        }catch (Exception e){

        }





       team = view.findViewById(R.id.teamCard);
       team.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent i = new Intent(getContext(), TeamDetailActivity.class);
               startActivity(i);
           }
       });
       project = view.findViewById(R.id.project);
       project.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent i = new Intent(getContext(), ProjectFormActivity.class);
               startActivity(i);
           }
       });

        slider = view.findViewById(R.id.image_slider);
        ArrayList<SlideModel> imageList = new ArrayList<>();// Create image list

        imageList.add(new SlideModel(R.drawable.slideimg1, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.sliderimg2, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.slideimg3, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.slideimg4, ScaleTypes.FIT));
        slider.setImageList(imageList);

        lead= view.findViewById(R.id.newlead);
        lead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(),LeadActivity.class);
                startActivity(i);
            }
        });


       return view;

    }
    private void setDataToPieChart(HomeStackModel apiResponse) {
        List<PieEntry> pieEntries = new ArrayList<>();
        pieEntries.add(new PieEntry(Float.parseFloat(apiResponse.getNewLeads()), "New Leads"));
        pieEntries.add(new PieEntry(Float.parseFloat(apiResponse.getOngoingLeads()), "Ongoing Leads"));
        pieEntries.add(new PieEntry(Float.parseFloat(apiResponse.getTeam()), "Team"));
        pieEntries.add(new PieEntry(Float.parseFloat(apiResponse.getNewProjects()), "New Projects"));
        pieEntries.add(new PieEntry(Float.parseFloat(apiResponse.getActiveProjects()), "Active Projects"));
        pieEntries.add(new PieEntry(Float.parseFloat(apiResponse.getPendingProjects()), "Pending Projects"));
        pieEntries.add(new PieEntry(Float.parseFloat(apiResponse.getCompletedProjects()), "Completed Projects"));

        PieDataSet dataSet = new PieDataSet(pieEntries, "Project Data");
        dataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        dataSet.setValueTextColor(Color.BLACK);
        dataSet.setValueTextSize(12f);

        PieData pieData = new PieData(dataSet);
        pieChart.setData(pieData);
        pieChart.invalidate();
    }
    private void setDataTobar(HomeStackModel apiResponse) {
        ArrayList<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(Float.parseFloat(apiResponse.getNewLeads()), 1));
        entries.add(new BarEntry(Float.parseFloat(apiResponse.getOngoingLeads()), 2));
        entries.add(new BarEntry(Float.parseFloat(apiResponse.getTeam()), 3));
        entries.add(new BarEntry(Float.parseFloat(apiResponse.getNewProjects()), 4));
        entries.add(new BarEntry(Float.parseFloat(apiResponse.getActiveProjects()), 5));
        entries.add(new BarEntry(Float.parseFloat(apiResponse.getPendingProjects()), 6));
        entries.add(new BarEntry(Float.parseFloat(apiResponse.getCompletedProjects()), 7));

        BarDataSet dataSet = new BarDataSet(entries, "Project Data");
        dataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        dataSet.setValueTextColor(Color.BLACK);
        dataSet.setValueTextSize(12f);

        BarData barData = new BarData(dataSet);
        bar.setData(barData);
        bar.invalidate();
    }
}