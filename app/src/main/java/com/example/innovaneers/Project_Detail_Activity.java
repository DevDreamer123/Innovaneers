package com.example.innovaneers;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.innovaneers.Utils.Methods;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Project_Detail_Activity extends AppCompatActivity {
  TextView name_project , title_project ,mobile_project , email_project , cost_project , date_project , deployment_project,
                    description_project,developer_project_dtl;
  Button assign,Task_project_detail;
  public static String globalProjectID = "";
    public static String globalStaffID = "";
    public static String globalAdapterProjectID = "";
    ImageView edit_img_view_pro_dtl,delete_img_view_pro_dtl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_detail);
        developer_project_dtl = findViewById(R.id.developer_project_dtl);
        edit_img_view_pro_dtl = findViewById(R.id.edit_img_view_pro_dtl);
        delete_img_view_pro_dtl = findViewById(R.id.delete_img_view_pro_dtl);
        delete_img_view_pro_dtl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDeleteDialog();
            }
        });
        edit_img_view_pro_dtl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Project_Detail_Activity.this,EdiProjectAcivity.class);
                startActivity(i);


                Toast.makeText(Project_Detail_Activity.this, "edit", Toast.LENGTH_SHORT).show();
            }
        });
        Task_project_detail= findViewById(R.id.Task_project_detail);
        Task_project_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Project_Detail_Activity.this,TaskAssignActivity.class);
                startActivity(i);
            }
        });




        assign = findViewById(R.id.assign);
        assign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Project_Detail_Activity.this,ProjectAllDetailActivity.class);
                startActivity(i);
            }
        });
        name_project = findViewById(R.id.name_project);
        title_project = findViewById(R.id.title_project);
        mobile_project= findViewById(R.id.mobile_project);
        email_project = findViewById(R.id.email_project);
        cost_project = findViewById(R.id.cost_project);
        date_project = findViewById(R.id.date_project);
        deployment_project = findViewById(R.id.deployment_project);
        description_project = findViewById(R.id.description_project);
        Intent i = getIntent();

        String ProjectID = i.getStringExtra("ProjectID");
        //String glProjectID = i.getStringExtra("ProjectID");
       // globalProjectID = glProjectID ;
       globalAdapterProjectID= ProjectID;
       // Log.d("ProjectID1",globalProjectID);
       Log.d("ProjectID1",globalAdapterProjectID);


        RectrofitInstance.BASEURL = " http://api.innovaneers.in/Projects/";

        try {
            ProjectIdModel idModel = new ProjectIdModel(globalAdapterProjectID);
            Call<ProjectShowModel> lcall = RectrofitInstance.getRetrofit1().getMyApi().createlistproject(idModel);
            lcall.enqueue(new Callback<ProjectShowModel>() {
                @Override
                public void onResponse(Call<ProjectShowModel> call, Response<ProjectShowModel> response) {
                    ProjectShowModel projectShowModel = response.body();
                   globalProjectID = response.body().getProjectID();
                    assert projectShowModel != null;
                    String dateFormatNew = Methods.UnixToDate(projectShowModel.getStartDate());
                    String dateDeployment = Methods.UnixToDate(projectShowModel.getDeploymentDate());
                    if (projectShowModel.getCustomerName() ==  null){
                        name_project.setVisibility(View.GONE);
                    }else {
                        name_project.setText(projectShowModel.getCustomerName());
                    }
                    if (projectShowModel.getTitle() ==  null){
                        title_project.setVisibility(View.GONE);
                    }else {
                        title_project.setText(projectShowModel.getTitle());
                    }
                    if (projectShowModel.getMobile() ==  null){
                        mobile_project.setVisibility(View.GONE);
                    }else {
                        mobile_project.setText(projectShowModel.getMobile());
                    }
                    if (projectShowModel.getEmail() ==  null){
                        email_project.setVisibility(View.GONE);
                    }else {
                        email_project.setText(projectShowModel.getEmail());
                    }
                    if (projectShowModel.getCost() ==  null){
                        cost_project.setVisibility(View.GONE);
                    }else {
                        cost_project.setText(projectShowModel.getCost());
                    }

                    if (projectShowModel.getStartDate() ==  null){

                        date_project.setVisibility(View.GONE);
                    }else {
                        date_project.setText(dateFormatNew);
                    }
                    if (projectShowModel.getDeploymentDate() ==  null){
                        deployment_project.setVisibility(View.GONE);
                    }else {
                        deployment_project.setText(dateDeployment);
                    }
                    if (projectShowModel.getDescription() ==  null){
                        description_project.setVisibility(View.GONE);
                    }else {
                        description_project.setText(projectShowModel.getDescription());
                    }
                    //Toast.makeText(Project_Detail_Activity.this,response.body().toString(), Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<ProjectShowModel> call, Throwable t) {
                    t.getMessage();
                    t.printStackTrace();
                    Log.d("Error2",t.getLocalizedMessage());
                    Toast.makeText(Project_Detail_Activity.this,t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

                }
            });
           ProjectIdModel model = new ProjectIdModel(globalAdapterProjectID);
            Call<ProjectShowModel> call = RectrofitInstance.getRetrofit1().getMyApi().createlistproject(model);
            call.enqueue(new Callback<ProjectShowModel>() {
                @Override
                public void onResponse(Call<ProjectShowModel> call, Response<ProjectShowModel> response) {
                    ProjectShowModel projectModel = response.body();

                    //  globalProjectID = response.body().getProjectID();
                    assert projectModel != null;
                    String dateFormatNew = Methods.UnixToDate(projectModel.getStartDate());
                String dateDeployment = Methods.UnixToDate(projectModel.getDeploymentDate());
                    if (projectModel.getCustomerName() ==  null){
                        name_project.setVisibility(View.GONE);
                    }else {
                        name_project.setText(projectModel.getCustomerName());
                    }
                    if (projectModel.getTitle() ==  null){
                        title_project.setVisibility(View.GONE);
                    }else {
                        title_project.setText(projectModel.getTitle());
                    }
                    if (projectModel.getMobile() ==  null){
                        mobile_project.setVisibility(View.GONE);
                    }else {
                        mobile_project.setText(projectModel.getMobile());
                    }
                    if (projectModel.getEmail() ==  null){
                        email_project.setVisibility(View.GONE);
                    }else {
                        email_project.setText(projectModel.getEmail());
                    }
                    if (projectModel.getCost() ==  null){
                        cost_project.setVisibility(View.GONE);
                    }else {
                        cost_project.setText(projectModel.getCost());
                    }

                    if (projectModel.getStartDate() ==  null){

                        date_project.setVisibility(View.GONE);
                    }else {
                        date_project.setText(dateFormatNew);
                    }
                    if (projectModel.getDeploymentDate() ==  null){
                        deployment_project.setVisibility(View.GONE);
                    }else {
                        deployment_project.setText(dateDeployment);
                    }
                    if (projectModel.getDescription() ==  null){
                        description_project.setVisibility(View.GONE);
                    }else {
                        description_project.setText(projectModel.getDescription());
                    }
                    //Toast.makeText(Project_Detail_Activity.this,response.body().toString(), T
                }

                @Override
                public void onFailure(Call<ProjectShowModel> call, Throwable t) {
                    t.getMessage();
                    t.printStackTrace();
                    Log.d("ErrorProjectDetail",t.getLocalizedMessage());
                    Toast.makeText(Project_Detail_Activity.this,t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

                }
            });
        }catch (Exception e){
            e.printStackTrace();
            Log.d("ErrorProjectDetail1",e.getLocalizedMessage());

        }
        RectrofitInstance.BASEURL = " http://api.innovaneers.in/Projects/";
        ProjectIdModel model = new ProjectIdModel(globalAdapterProjectID);
        try {
            Call<List<TeamListModel>> lcall = RectrofitInstance.getRetrofit1().getMyApi().createprojectteam(model);
            lcall.enqueue(new Callback<List<TeamListModel>>() {
                @Override
                public void onResponse(Call<List<TeamListModel>> call, Response<List<TeamListModel>> response) {
                    List< TeamListModel> showModel= response.body();
                    Log.d("data",response.body().toString());
                    if (showModel != null && showModel.size() > 0) {
                        String[] Categorys = new String[showModel.size()];
                        for (int i = 0; i < showModel.size(); i++) {
                            Categorys[i] = response.body().get(i).getIsAssigned();
                            if (Categorys[i].equals("true")){
                                /*if (showModel != null && showModel.size() > 0) {
                                    String[] Category = new String[showModel.size()];
                                    for (int j = 0; j < showModel.size(); j++) {
                                        Category[j] = response.body().get(i).getName();*/
                                        developer_project_dtl.setText(response.body().get(i).getName());
                                        Toast.makeText(Project_Detail_Activity.this, "Hello", Toast.LENGTH_SHORT).show();


                            }else {
                                Toast.makeText(Project_Detail_Activity.this, "Hii", Toast.LENGTH_SHORT).show();
                            }
                          //  developer_project_dtl.setText(Categorys[i]);
                        }
                    }
                    Toast.makeText(Project_Detail_Activity.this,showModel.toString(), Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<List<TeamListModel>> call, Throwable t) {
                    Toast.makeText(Project_Detail_Activity.this,t.getMessage(), Toast.LENGTH_SHORT).show();
                    Log.d("error",t.getMessage());
                    Log.d("erroe2",t.getLocalizedMessage());
                    Log.d("erroe3",t.toString());
                    t.printStackTrace();


                }
            });


        }catch (Exception e){

        }


    }
    public void showDeleteDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.delete_layout, null);
        builder.setView(dialogView);

        Button logoutButton = dialogView.findViewById(R.id.button_ok);
        Button cancelButton = dialogView.findViewById(R.id.button_no);

        final AlertDialog dialog = builder.create();

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform logout action

                Intent intent = new Intent(Project_Detail_Activity.this, LoginActivity.class);
                startActivity(intent);
                finish();

                // For example, you can clear session data, navigate to login screen, etc.
                dialog.dismiss(); // Dismiss the dialog
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss(); // Dismiss the dialog
            }
        });

        dialog.show();
    }
}