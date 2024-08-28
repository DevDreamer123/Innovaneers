package com.example.innovaneers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
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

import com.example.innovaneers.home.HomeFragment;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class ScheduleActivity extends AppCompatActivity {
RecyclerView time_Schedule_recyclerView;
ImageView back_schedule_activity;
LinearLayout day_set_layout;
TextView day_schedule , set_week_schedule;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        day_set_layout = findViewById(R.id.day_set_layout);
        set_week_schedule = findViewById(R.id.set_week_schedule);
        day_schedule = findViewById(R.id.day_schedule);
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dayFormat = new SimpleDateFormat("dd", Locale.getDefault());
        SimpleDateFormat weekFormat = new SimpleDateFormat("EEE", Locale.getDefault());
        String currentDay = dayFormat.format(calendar.getTime());
        String currentWeek = weekFormat.format(calendar.getTime());

        // Set current day and week to TextViews
        day_schedule.setText(currentDay);
        set_week_schedule.setText(currentWeek);




        day_set_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCalendar();
            }
        });
        back_schedule_activity = findViewById(R.id.back_schedule_activity);
        back_schedule_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ScheduleActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
        time_Schedule_recyclerView =  findViewById(R.id.time_Schedule_recyclerView);
        ArrayList<ScheduleModel> Array1 = new ArrayList<ScheduleModel>();
        Array1.add(new ScheduleModel("","Morning meeting in the Pak","08.00","Mon-Thu"));
        Array1.add(new ScheduleModel("","Skype meeting with the NY contractor ","05.10","Sun-Fri"));
        Array1.add(new ScheduleModel("","Meeting","03.00","Tus-Sat"));
        LinearLayoutManager manager = new LinearLayoutManager(ScheduleActivity.this, RecyclerView.VERTICAL, false);
        ScheduleAdapter category1 = new ScheduleAdapter(ScheduleActivity.this,Array1);
        time_Schedule_recyclerView.setAdapter(category1);
        time_Schedule_recyclerView.setLayoutManager(manager);

    }
    private void openCalendar() {
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(ScheduleActivity.this,
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
                        Toast.makeText(ScheduleActivity.this, "Selected Date: " + selectedDate, Toast.LENGTH_LONG).show();
                 day_schedule.setText(selectedDate);
                 set_week_schedule.setText(currentWeek);
                    }
                }, year, month, day);

        datePickerDialog.show();
    }
}