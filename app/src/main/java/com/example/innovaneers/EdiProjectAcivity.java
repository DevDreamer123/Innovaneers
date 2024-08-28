package com.example.innovaneers;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import com.example.innovaneers.Utils.Methods;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EdiProjectAcivity extends AppCompatActivity {
    TextInputEditText id, name, email,mobile, address, city ,title, cost , description;
    TextInputEditText statingDate , deploymentDate;
    Button submit;
    DatePickerDialog picker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edi_project_acivity);
        id = findViewById(R.id.idClient_edit);
        name = findViewById(R.id.nameClient_edit);
        email = findViewById(R.id.emailClient_edit);
        mobile = findViewById(R.id.mobileClient_edit);
        address = findViewById(R.id.addressClient_edit);
        city = findViewById(R.id.cityClient_edit);
        title = findViewById(R.id.titleClient_edit);
        cost = findViewById(R.id.costCilent_edit);
        statingDate = findViewById(R.id.dateClient_edit);
       /* statingDate.setInputType(InputType.TYPE_NULL);
        statingDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                picker = new DatePickerDialog(EdiProjectAcivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                statingDate.setText((monthOfYear + 1) + "/" + dayOfMonth + "/" + year);
                            }
                        }, year, month, day);
                picker.show();
            }
        });*/
        deploymentDate = findViewById(R.id.deploymentClient_edit);
       /* deploymentDate.setInputType(InputType.TYPE_NULL);
        deploymentDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                picker = new DatePickerDialog(EdiProjectAcivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                deploymentDate.setText( (monthOfYear + 1) + "/"+dayOfMonth+ "/" + year);
                            }
                        }, year, month, day);
                picker.show();
            }
        });*/
        description = findViewById(R.id.description_edit);
        RectrofitInstance.BASEURL = " http://api.innovaneers.in/Projects/";

        try {
            ProjectIdModel idModel = new ProjectIdModel(Project_Detail_Activity.globalAdapterProjectID);
            Call<ProjectShowModel> lcall = RectrofitInstance.getRetrofit1().getMyApi().createlistproject(idModel);
            lcall.enqueue(new Callback<ProjectShowModel>() {
                @Override
                public void onResponse(Call<ProjectShowModel> call, Response<ProjectShowModel> response) {
                    ProjectShowModel projectShowModel = response.body();
                    //  globalProjectID = response.body().getProjectID();
                    assert projectShowModel != null;
                    String dateFormatNew = Methods.UnixToDate(projectShowModel.getStartDate());
                    String dateDeployment = Methods.UnixToDate(projectShowModel.getDeploymentDate());
                    if (projectShowModel.getCustomerName() ==  null){
                        name.setVisibility(View.GONE);
                    }else {
                        name.setText(projectShowModel.getCustomerName());
                    }
                    if (projectShowModel.getTitle() ==  null){
                        title.setVisibility(View.GONE);
                    }else {
                        title.setText(projectShowModel.getTitle());
                    }
                    if (projectShowModel.getMobile() ==  null){
                        mobile.setVisibility(View.GONE);
                    }else {
                        mobile.setText(projectShowModel.getMobile());
                    }
                    if (projectShowModel.getEmail() ==  null){
                        email.setVisibility(View.GONE);
                    }else {
                        email.setText(projectShowModel.getEmail());
                    }
                    if (projectShowModel.getCost() ==  null){
                        cost.setVisibility(View.GONE);
                    }else {
                        cost.setText(projectShowModel.getCost());
                    }

                    if (projectShowModel.getStartDate() ==  null){

                        statingDate.setVisibility(View.GONE);
                    }else {
                        statingDate.setText(dateFormatNew);
                    }
                    if (projectShowModel.getDeploymentDate() ==  null){
                        deploymentDate.setVisibility(View.GONE);
                    }else {
                        deploymentDate.setText(dateDeployment);
                    }
                    if (projectShowModel.getDescription() ==  null){
                        description.setVisibility(View.GONE);
                    }else {
                        description.setText(projectShowModel.getDescription());
                    }
                    //Toast.makeText(Project_Detail_Activity.this,response.body().toString(), Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<ProjectShowModel> call, Throwable t) {
                    t.getMessage();
                    t.printStackTrace();
                    Log.d("Error2",t.getLocalizedMessage());
                    Toast.makeText(EdiProjectAcivity.this,t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

                }
            });

        }catch (Exception e){
            e.printStackTrace();
            Log.d("ErrorProjectDetail1",e.getLocalizedMessage());

        }

    }
}