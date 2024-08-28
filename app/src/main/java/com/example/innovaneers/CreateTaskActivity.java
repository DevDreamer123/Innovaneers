package com.example.innovaneers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class CreateTaskActivity extends AppCompatActivity {
RecyclerView task_list_recyclerView;
ImageView back_task_activity;
LinearLayout task_day_week_layout;
TextView day_task_set , week_task_set;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_task);
        task_day_week_layout = findViewById(R.id.task_day_week_Layout);
        day_task_set = findViewById(R.id.day_task_set);
        week_task_set = findViewById(R.id.week_task_set);
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dayFormat = new SimpleDateFormat("dd", Locale.getDefault());
        SimpleDateFormat weekFormat = new SimpleDateFormat("EEE", Locale.getDefault());
        String currentDayTask = dayFormat.format(calendar.getTime());
        String currentWeekTask = weekFormat.format(calendar.getTime());

        // Set current day and week to TextViews
        day_task_set.setText(currentDayTask);
        week_task_set.setText(currentWeekTask);

        task_day_week_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCalendar();
            }
        });

        back_task_activity = findViewById(R.id.back_task_activity);
        back_task_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CreateTaskActivity.this,MainActivity.class);
                startActivity(i);
            }
        });
        task_list_recyclerView = findViewById(R.id.task_list_recyclerView);
        ArrayList<ScheduleModel> Array1 = new ArrayList<ScheduleModel>();
        Array1.add(new ScheduleModel("","Buy a pack of coffee","08:00-10:00","2 hours"));
        Array1.add(new ScheduleModel("","Skype meeting with the NY contractor ","09:00-02:00","3 hours"));
        Array1.add(new ScheduleModel("","Meeting","03:00-05:00","10 hours"));
        LinearLayoutManager manager = new LinearLayoutManager(CreateTaskActivity.this, RecyclerView.VERTICAL, false);
        TaskCreateAdapter category1 = new TaskCreateAdapter(CreateTaskActivity.this,Array1);
        task_list_recyclerView.setAdapter(category1);
        task_list_recyclerView.setLayoutManager(manager);

    }
    private void openCalendar() {
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(CreateTaskActivity.this,
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
                        Toast.makeText(CreateTaskActivity.this, "Selected Date: " + selectedDate, Toast.LENGTH_LONG).show();
                        day_task_set.setText(selectedDate);
                        week_task_set.setText(currentWeek);
                    }
                }, year, month, day);

        datePickerDialog.show();
    }
}