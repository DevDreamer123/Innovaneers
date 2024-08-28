package com.example.innovaneers;



import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.innovaneers.AlarmReceiver;
import com.example.innovaneers.account.NewLeadModel;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LeadActivity extends AppCompatActivity {
TextInputEditText name , email, mobile , address, city , projectType, remark;
TextView  date;
    Button submit;
    DatePickerDialog picker;
    Button set_notification;
    private Calendar calendar;

    private static final int NOTIFICATION_ID = 1;
    private static final String CHANNEL_ID = "MyChannel";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_lead);
        name = findViewById(R.id.nameLead);
        email = findViewById(R.id.emailLeads);
        mobile = findViewById(R.id.mobileLeads);
        address = findViewById(R.id.addressLeads);
        city = findViewById(R.id.cityLeads);
        projectType = findViewById(R.id.typeLeads);
        date = findViewById(R.id.dateLeads);
        date.setInputType(InputType.TYPE_NULL);
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                picker = new DatePickerDialog(LeadActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                date.setText(  (monthOfYear + 1)+ "/" + dayOfMonth+ "/" + year);
                            }
                        }, year, month, day);
                picker.show();
            }
        });
        remark = findViewById(R.id.remarkLeads);
        submit = findViewById(R.id.submitLeads);


        //proceed to login




        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LeadRequestModel leads = new LeadRequestModel();
                leads.setName(name.getText().toString());
                leads.setEmail(email.getText().toString());
                leads.setMobile(mobile.getText().toString());
                leads.setAddress(address.getText().toString());
                leads.setCity(city.getText().toString());
                leads.setLeadType(projectType.getText().toString());
                leads.setDate(date.getText().toString());
                leads.setDescription(remark.getText().toString());



                RectrofitInstance.BASEURL = "http://api.innovaneers.in/Leads/";
                try {
                    Call<NewLeadModel> lcall = RectrofitInstance.getInstance().getMyApi().createLead(leads);
                    lcall.enqueue(new Callback<NewLeadModel>() {
                        @Override
                        public void onResponse(Call<NewLeadModel> call, Response<NewLeadModel> response) {
                           // Toast.makeText(LeadActivity.this,date.getText().toString(), Toast.LENGTH_SHORT).show();
                            Toast.makeText(LeadActivity.this, "Successfully", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(LeadActivity.this,LeadShowDetailActivity.class);
                            i.putExtra("LeadID",response.body().getLeadID());
                        //   i.putExtra("Description",response.body().getDescription());
                            startActivity(i);
                            finish();
                        }

                        @Override
                        public void onFailure(Call<NewLeadModel> call, Throwable t) {
                            t.printStackTrace();
                            Toast.makeText(LeadActivity.this,t.getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    });

                }catch (Exception e){
                    Toast.makeText(LeadActivity.this,e.getMessage(), Toast.LENGTH_SHORT).show();
                    e.printStackTrace();

                }

                // Toast.makeText(LeadActivity.this, "SuccessFully", Toast.LENGTH_SHORT).show();
               // Intent i = new Intent(LeadActivity.this,MainActivity.class);
                //startActivity(i);


            }
        });
        set_notification =  findViewById(R.id.set_notification_btn);
        calendar = Calendar.getInstance();

        createNotificationChannel();
        set_notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LeadActivity.this, "Set Alarm", Toast.LENGTH_SHORT).show();

              //  String work_link = remark.getText().toString().trim();
               // SharedPreferences sharedPref = getSharedPreferences("myKey", MODE_PRIVATE);
               // SharedPreferences.Editor editor = sharedPref.edit();
              //  editor.putString("value", work_link);
              //  editor.apply();
              //  Intent intent = new Intent(LeadActivity.this,BaseURL.class);

               // startActivity(intent);
               showDateTimePicker();
            }
        });


    }
    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "My Notification Channel";
            String description = "Channel description";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
    private void showDateTimePicker() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                TimePickerDialog timePickerDialog = new TimePickerDialog(LeadActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
                        calendar.set(Calendar.MINUTE, minute);


                        setAlarm(calendar);
                    }
                }, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), false);
                timePickerDialog.show();
            }
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
        datePickerDialog.show();
        Toast.makeText(this, "calender"+calendar.toString(), Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "date"+datePickerDialog.toString(), Toast.LENGTH_SHORT).show();
    }

    private void setAlarm(Calendar calendar) {

      //  AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
      //  Intent intent = new Intent(this, AlarmReceiver.class);
      //  PendingIntent pendingIntent = PendingIntent.getBroadcast(this, NOTIFICATION_ID, intent, PendingIntent.FLAG_UPDATE_CURRENT);

       // alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
       // Toast.makeText(this, "Alarm set for " + calendar.getTime().toString(), Toast.LENGTH_SHORT).show();



        // Set the alarm to trigger at 30 seconds from now
     //  Calendar calendar = Calendar.getInstance();
       // calendar.add(Calendar.SECOND, 10);
        Toast.makeText(this,calendar.toString(), Toast.LENGTH_SHORT).show();

        // Get AlarmManager instance
       AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        // Create an Intent for the alarm receiver
        Intent intent = new Intent(this, AlarmReceiver.class);
       PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_MUTABLE);

        // Set the alarm to trigger at the specified time
       alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);

       //Toast.makeText(this, "Alarm set for 30 seconds from now", Toast.LENGTH_SHORT).show();
    }
}