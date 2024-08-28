package com.example.innovaneers;

import static com.example.innovaneers.LoginActivity.KEY_NAME;
import static com.example.innovaneers.LoginActivity.KEY_STAFF_ID;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TaskAssignActivity extends AppCompatActivity {
    RecyclerView task_list_recyclerView_task_assign;
    ImageView back_task_activity_task_assign;
    AppCompatButton add_Task_assign;
    DatePickerDialog picker;
    TextInputEditText editTextDate,time_text_edit_popup,editTextDescription,team_text_edit_popup;
    RecyclerView recycler_team_member_list_popup;
    LinearLayoutManager vertical;
    LinearLayout select_day_week;
    TextView day_task_assign,week_task_assign;
    SharedPreferences preferences;
    public static final String SHARED_PREF_NAME = "Innovaneers";

    private static String globalStaffID = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_assign);
        select_day_week = findViewById(R.id.select_day_week);
        day_task_assign = findViewById(R.id.day_task_assign);
        week_task_assign = findViewById(R.id.week_task_assign);
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dayFormat = new SimpleDateFormat("dd", Locale.getDefault());
        SimpleDateFormat weekFormat = new SimpleDateFormat("EEE", Locale.getDefault());
        String currentDayTask = dayFormat.format(calendar.getTime());
        String currentWeekTask = weekFormat.format(calendar.getTime());

        // Set current day and week to TextViews
        day_task_assign.setText(currentDayTask);
        week_task_assign.setText(currentWeekTask);

        select_day_week.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCalendar();
            }
        });
        preferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        String registerName =preferences.getString(KEY_NAME,"");
        String registerStaffId =preferences.getString(KEY_STAFF_ID,"");
        Log.d("StaffIDAssign",registerStaffId);

        back_task_activity_task_assign = findViewById(R.id.back_task_activity_taskAssign);

        back_task_activity_task_assign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(TaskAssignActivity.this,Project_Detail_Activity.class);
                startActivity(i);
                onBackPressed();
            }
        });
        //Task List Show
        task_list_recyclerView_task_assign = findViewById(R.id.task_list_recyclerView_task_assign);
       updateRecyclerview();



        /*ArrayList<TaskListModel> Array1 = new ArrayList<TaskListModel>();
        Array1.add(new TaskListModel("","Buy a pack of coffee","08:00-10:00","2 hours","Ameesha"));
        Array1.add(new TaskListModel("","Skype meeting with the NY contractor ","09:00-02:00","3 hours","Ameesha"));
        Array1.add(new TaskListModel("","Meeting","03:00-05:00","10 hours","Ameesha"));
        LinearLayoutManager manager = new LinearLayoutManager(TaskAssignActivity.this, RecyclerView.VERTICAL, false);
        TaskListProjectAdapter category1 = new TaskListProjectAdapter(TaskAssignActivity.this,Array1);
        task_list_recyclerView_task_assign.setAdapter(category1);
        task_list_recyclerView_task_assign.setLayoutManager(manager);*/



        add_Task_assign = findViewById(R.id.add_Task_assign);
        add_Task_assign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Intent i = new Intent()
                openPopup();
            }
        });
        Intent i = getIntent();
        String StaffID = i.getStringExtra("StaffID");
        globalStaffID = StaffID;

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
    private void openPopup() {
        // Inflate the popup layout
       // View popupView = getLayoutInflater().inflate(R.layout.popup_layout, null);

        // Create the AlertDialog
       // AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //builder.setView(popupView);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.popup_layout, null);
        builder.setView(dialogView);







        editTextDate = dialogView.findViewById(R.id.date_text_edit_popup);
        time_text_edit_popup = dialogView.findViewById(R.id.time_text_edit_popup);
        Button resetButton = dialogView.findViewById(R.id.resetButton);
        Button closeButton = dialogView.findViewById(R.id.closeButton);
        time_text_edit_popup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTimePicker();
            }
        });
        team_text_edit_popup = dialogView.findViewById(R.id.team_text_edit_popup);
        team_text_edit_popup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(TaskAssignActivity.this, "Team", Toast.LENGTH_SHORT).show();
                openTeamPopup();
            }
        });

        editTextDescription = dialogView.findViewById(R.id.edit_text_description);
        editTextDate.setInputType(InputType.TYPE_NULL);
        editTextDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });
        final Dialog dialog = builder.create();
        dialog.show();
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d("ProjectIdglobaltask",Project_Detail_Activity.globalAdapterProjectID);
                RectrofitInstance.BASEURL = " http://api.innovaneers.in/Tasks/";
                ProjectTitleStaffModel model = new ProjectTitleStaffModel();
                model.setProjectID(Project_Detail_Activity.globalAdapterProjectID);
                model.setStaffID(globalStaffID);
                model.setTaskTitle(editTextDescription.getText().toString());
                try {
                    Call<TaskShowListModel> lcall = RectrofitInstance.getRetrofit5().getMyApi().createtask(model);
                    lcall.enqueue(new Callback<TaskShowListModel>() {
                        @Override
                        public void onResponse(Call<TaskShowListModel> call, Response<TaskShowListModel> response) {
                            TaskShowListModel showModel= response.body();
                            Toast.makeText(TaskAssignActivity.this, "Submit", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onFailure(Call<TaskShowListModel> call, Throwable t) {
                            Toast.makeText(TaskAssignActivity.this,t.getMessage(), Toast.LENGTH_SHORT).show();
                            Log.d("error",t.getMessage());
                            Log.d("erroe2",t.getLocalizedMessage());
                            Log.d("erroe3",t.toString());
                            t.printStackTrace();


                        }
                    });


                }catch (Exception e){
                    e.getMessage();
                    e.toString();

                }




                // Reset all fields
                editTextDescription.setText("");
                editTextDate.setText("");
                time_text_edit_popup.setText("");

                // Reset Spinner
                //spinner.setSelection(0);
            }
        });

        // Close button click listener
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               updateRecyclerview();



                dialog.dismiss();
            }
        });

        /*builder.setPositiveButton("Submit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Handle form submission

                String description = editTextDescription.getText().toString();

                String message =  "\ndate: " + editTextDate + "\nDescription: " + description;
                Toast.makeText(TaskAssignActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });*/

        // Create and show the AlertDialog
       // AlertDialog alertDialog = builder.create();
        //alertDialog.show();
    }
    private void openCalendar() {
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(TaskAssignActivity.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        // Set the selected date
                        calendar.set(Calendar.YEAR, year);
                        calendar.set(Calendar.MONTH, monthOfYear);
                        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                        // Format the selected date
                        SimpleDateFormat sdf = new SimpleDateFormat("dd ", Locale.getDefault());
                        SimpleDateFormat weekFormat = new SimpleDateFormat("EEE", Locale.getDefault());
                        String selectedDate = sdf.format(calendar.getTime());
                        String currentWeek = weekFormat.format(calendar.getTime());

                        // Display the selected date
                        Toast.makeText(TaskAssignActivity.this, "Selected Date: " + selectedDate, Toast.LENGTH_LONG).show();
                        day_task_assign.setText(selectedDate);
                        week_task_assign.setText(currentWeek);
                    }
                }, year, month, day);

        datePickerDialog.show();
    }
    private void showDatePickerDialog() {
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(TaskAssignActivity.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        calendar.set(Calendar.YEAR, year);
                        calendar.set(Calendar.MONTH, month);
                        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                        // Update TextInputEditText with selected date
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
                        editTextDate.setText(dateFormat.format(calendar.getTime()));
                    }
                }, year, month, dayOfMonth);
        datePickerDialog.show();
    }
    private void openTeamPopup() {
        // Inflate the popup layout
        View popupView = getLayoutInflater().inflate(R.layout.popup_team_layout, null);

        // Create the AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(popupView);
        recycler_team_member_list_popup= findViewById(R.id.recycler_team_member_list_popup);

       /* RectrofitInstance.BASEURL = " http://api.innovaneers.in/Projects/";
        ProjectIdModel model = new ProjectIdModel(Project_Detail_Activity.globalProjectID);
        try {
            Call<List<TeamListModel>> lcall = RectrofitInstance.getRetrofit1().getMyApi().createprojectteam(model);
            lcall.enqueue(new Callback<List<TeamListModel>>() {
                @Override
                public void onResponse(Call<List<TeamListModel>> call, Response<List<TeamListModel>> response) {
                    List< TeamListModel> showModel= response.body();
                    Log.d("data",response.body().toString());
                    Toast.makeText(TaskAssignActivity.this,showModel.toString(), Toast.LENGTH_SHORT).show();
                    TeamDetailAdapter adapter = new TeamDetailAdapter(showModel, TaskAssignActivity.this);
                    vertical = new LinearLayoutManager(TaskAssignActivity.this,LinearLayoutManager.VERTICAL,false);
                    recycler_team_member_list_popup.setLayoutManager(vertical);
                    recycler_team_member_list_popup.setAdapter(adapter);
                }

                @Override
                public void onFailure(Call<List<TeamListModel>> call, Throwable t) {
                    Toast.makeText(TaskAssignActivity.this,t.getMessage(), Toast.LENGTH_SHORT).show();
                    Log.d("error",t.getMessage());
                    Log.d("erroe2",t.getLocalizedMessage());
                    Log.d("erroe3",t.toString());
                    t.printStackTrace();


                }
            });


        }catch (Exception e){

        }*/


        // Optionally, add buttons or customize the dialog further
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Do something when OK button is clicked
                dialog.dismiss(); // Close the dialog
            }
        });

        // Create and show the AlertDialog
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }
    private void showTimePicker() {
        final Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        // Show time picker dialog
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        String time = hourOfDay + ":" + minute;
                        time_text_edit_popup.setText(time);
                    }
                }, hour, minute, false);
        timePickerDialog.show();
        // Implement logic to show time picker
    }
    private void updateRecyclerview() {
        Log.d("ProjectIdglobal",Project_Detail_Activity.globalAdapterProjectID);
        RectrofitInstance.BASEURL = " http://api.innovaneers.in/Projects/";
        ProjectIdModel model = new ProjectIdModel(Project_Detail_Activity.globalAdapterProjectID);
        try {
            Call<List<TaskShowListModel>> lcall = RectrofitInstance.getRetrofit1().getMyApi().createtasklist(model);
            lcall.enqueue(new Callback<List<TaskShowListModel>>() {
                @Override
                public void onResponse(Call<List<TaskShowListModel>> call, Response<List<TaskShowListModel>> response) {
                    List<TaskShowListModel> showModel= response.body();
                    LinearLayoutManager manager = new LinearLayoutManager(TaskAssignActivity.this, RecyclerView.VERTICAL, false);
                    TaskListProjectAdapter category1 = new TaskListProjectAdapter(TaskAssignActivity.this,showModel );
                    task_list_recyclerView_task_assign.setAdapter(category1);
                    task_list_recyclerView_task_assign.setLayoutManager(manager);
                }

                @Override
                public void onFailure(Call<List<TaskShowListModel>> call, Throwable t) {
                    Toast.makeText(TaskAssignActivity.this,t.getMessage(), Toast.LENGTH_SHORT).show();
                    Log.d("error",t.getMessage());
                    Log.d("erroe2",t.getLocalizedMessage());
                    Log.d("erroe3",t.toString());
                    t.printStackTrace();


                }
            });


        }catch (Exception e){
            e.getMessage();
            e.toString();

        }



    }
}