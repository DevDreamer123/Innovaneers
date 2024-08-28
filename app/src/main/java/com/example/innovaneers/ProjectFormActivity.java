package com.example.innovaneers;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.innovaneers.account.NewLeadModel;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProjectFormActivity extends AppCompatActivity {
    TextInputEditText id, name, email,mobile, address, city ,title, cost , description;
    TextInputEditText statingDate , deploymentDate;
    Button submit;
    DatePickerDialog picker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_form);
        id = findViewById(R.id.idClient);
        name = findViewById(R.id.nameClient);
        email = findViewById(R.id.emailClient);
        mobile = findViewById(R.id.mobileClient);
        address = findViewById(R.id.addressClient);
        city = findViewById(R.id.cityClient);
        title = findViewById(R.id.titleClient);
        cost = findViewById(R.id.costCilent);
        statingDate = findViewById(R.id.dateClient);
        statingDate.setInputType(InputType.TYPE_NULL);
        statingDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                picker = new DatePickerDialog(ProjectFormActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                statingDate.setText((monthOfYear + 1) + "/" + dayOfMonth + "/" + year);
                            }
                        }, year, month, day);
                picker.show();
            }
        });
        deploymentDate = findViewById(R.id.deploymentClient);
        deploymentDate.setInputType(InputType.TYPE_NULL);
        deploymentDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                picker = new DatePickerDialog(ProjectFormActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                deploymentDate.setText( (monthOfYear + 1) + "/"+dayOfMonth+ "/" + year);
                            }
                        }, year, month, day);
                picker.show();
            }
        });
        description = findViewById(R.id.description);
        submit = findViewById(R.id.submitClient);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProjectRequestModel leads = new ProjectRequestModel();
                leads.setCustomerID(id.getText().toString());
                leads.setCustomerName(name.getText().toString());
                leads.setEmail(email.getText().toString());
                leads.setMobile(mobile.getText().toString());
                leads.setAddress(address.getText().toString());
                leads.setCity(city.getText().toString());
                leads.setProjectTitle(title.getText().toString());
                leads.setProjectCost(cost.getText().toString());
                leads.setStartingDate(statingDate.getText().toString());
                leads.setDeployementDate(deploymentDate.getText().toString());
                leads.setDescription(description.getText().toString());




                RectrofitInstance.BASEURL = "http://api.innovaneers.in/Projects/";
                try {
                    Call<ProjectModel> call = RectrofitInstance.getRetrofit1().getMyApi().createproject(leads);
                    call.enqueue(new Callback<ProjectModel>() {
                        @Override
                        public void onResponse(Call<ProjectModel> call, Response<ProjectModel> response) {
                          //  Toast.makeText(ProjectFormActivity.this,response.body().getProjectID(), Toast.LENGTH_SHORT).show();
                          //  Toast.makeText(ProjectFormActivity.this,id.getText().toString(), Toast.LENGTH_SHORT).show();
                            Toast.makeText(ProjectFormActivity.this, "Successfully", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(ProjectFormActivity.this,Project_Detail_Activity .class);
                            i.putExtra("ProjectID",response.body().getProjectID());
                            startActivity(i);
                            finish();
                        }

                        @Override
                        public void onFailure(Call<ProjectModel> call, Throwable t) {
                            t.printStackTrace();
                            Toast.makeText(ProjectFormActivity.this,t.getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    });
                }catch (Exception e){
                    Toast.makeText(ProjectFormActivity.this,e.getMessage(), Toast.LENGTH_SHORT).show();
                    e.printStackTrace();

                }

                // Toast.makeText(LeadActivity.this, "SuccessFully", Toast.LENGTH_SHORT).show();
                // Intent i = new Intent(LeadActivity.this,MainActivity.class);
                //startActivity(i);


            }
        });




    }
}