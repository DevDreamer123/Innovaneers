package com.example.innovaneers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.InputType;
import android.text.Selection;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.innovaneers.account.NewLeadModel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LeadShowDetailActivity extends AppCompatActivity {
    Spinner spinner;
    ArrayList<String> spi = new ArrayList<>();
    RecyclerView reyclerStatus;
    Button submit;
    String selection = "";
    EditText description;

    private static String globalLeadID = "";
    private static String globalAdapterLeadID = "";
    TextView detail_lead, name_lead, mobile_lead;
    DatePickerDialog picker;
    EditText eText;
    private DBHandler dbHandler;
    private ArrayList<StatusModel> courseModalArrayList;
    private LocalReyclerViewAdapter statusAdapter;

    Button set_notification_Lead_btn;
    private Calendar calendar;
    private static final String CHANNEL_ID = "MyChannel";












    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lead_show_detail);





        eText = (EditText) findViewById(R.id.editText1);
        eText.setInputType(InputType.TYPE_NULL);
        eText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                picker = new DatePickerDialog(LeadShowDetailActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                eText.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                picker.show();
            }
        });
        detail_lead = findViewById(R.id.detail_lead);
        name_lead = findViewById(R.id.name_lead);
        mobile_lead = findViewById(R.id.mobile_lead);

        Intent i = getIntent();

        String glLeadID = i.getStringExtra("LeadID");
        String AdapterLeadID = i.getStringExtra("AdapterLeadID");

        globalLeadID = glLeadID;
        globalAdapterLeadID = AdapterLeadID;
        // Log.d("ProjectID",globalLeadID);

        RectrofitInstance.BASEURL = "http://api.innovaneers.in/Leads/";

        // Log.d("GlobalLeadIdShow",globalLeadID);
        try {
            LeadIdModel leadIdModel = new LeadIdModel(globalLeadID);
            Call<LeadModel> call = RectrofitInstance.getInstance().getMyApi().createleaddetail(leadIdModel);
            call.enqueue(new Callback<LeadModel>() {
                @Override
                public void onResponse(Call<LeadModel> call, Response<LeadModel> response) {
                    LeadModel model = response.body();
                    //   Log.d("Data",response.body().toString());
                    detail_lead.setText(model.getDescription());
                    name_lead.setText(model.getName());
                    mobile_lead.setText(model.getMobile());
                    // Toast.makeText(LeadShowDetailActivity.this,response.body().toString(), Toast.LENGTH_SHORT).show();

                }

                @Override
                public void onFailure(Call<LeadModel> call, Throwable t) {
                    t.printStackTrace();

                }
            });
            LeadIdModel leadModel = new LeadIdModel(globalAdapterLeadID);
            Call<LeadModel> call1 = RectrofitInstance.getInstance().getMyApi().createleaddetail(leadModel);
            call1.enqueue(new Callback<LeadModel>() {
                @Override
                public void onResponse(Call<LeadModel> call, Response<LeadModel> response) {
                    LeadModel models = response.body();
                    // Log.d("Data",response.body().toString());
                    detail_lead.setText(models.getDescription());
                    name_lead.setText(models.getName());
                    mobile_lead.setText(models.getMobile());
                    // Toast.makeText(LeadShowDetailActivity.this,response.body().toString(), Toast.LENGTH_SHORT).show();

                }

                @Override
                public void onFailure(Call<LeadModel> call, Throwable t) {
                    t.printStackTrace();

                }
            });


        } catch (Exception ex) {

        }


        description = findViewById(R.id.descriptionform);


        submit = findViewById(R.id.submit_lead_detail);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LeadShowDetailActivity.this, "Done", Toast.LENGTH_SHORT).show();
                String Date = eText.getText().toString().trim();
                String Description = description.getText().toString().trim();
                courseModalArrayList = new ArrayList<>();
                dbHandler = new DBHandler(LeadShowDetailActivity.this);
                courseModalArrayList = dbHandler.readCourses();
                reyclerStatus = findViewById(R.id.recyclerstatus);
                statusAdapter = new LocalReyclerViewAdapter(courseModalArrayList, LeadShowDetailActivity.this);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(LeadShowDetailActivity.this, RecyclerView.VERTICAL, false);
                reyclerStatus.setLayoutManager(linearLayoutManager);
                reyclerStatus.setAdapter(statusAdapter);

                dbHandler.addNewStatus(selection, Date, Description);

                // after adding the data we are displaying a toast message.
                Toast.makeText(LeadShowDetailActivity.this, "Status has been added.", Toast.LENGTH_SHORT).show();
                eText.setText("");
                description.setText("");


             //selectspinner(selection);










            }
        });
        courseModalArrayList = new ArrayList<>();
        // dbHandler = new DBHandler(LeadShowDetailActivity.this);

        spinner = findViewById(R.id.spinner);
        spi.add("Select Status");
        spi.add("Approved");
        spi.add("Reject");
        spi.add("Remind");
        spi.add("Call Again");
        spi.add("Meeting Schedule");
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, spi);
        spinner.setAdapter(spinnerAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selection = adapterView.getItemAtPosition(i).toString();
                selectspinner(selection);
                Toast.makeText(LeadShowDetailActivity.this, selection, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        Bundle bund = getIntent().getExtras();
        if (bund != null) {
            //  String date = bund.getString("Date");
            // String des = bund.getString("Description");
            // String status = bund.getString("Status");
            //  description_show =  findViewById(R.id.description_show);
            // date_show =  findViewById(R.id.date_show);
            //  status_show =  findViewById(R.id.status_show);
            //  date_show.setText(date);
            //  description_show.setText(des);
            //  status_show.setText(status);
        }
        calendar = Calendar.getInstance();
        set_notification_Lead_btn = findViewById(R.id.set_notification_Lead_btn);
        createNotificationChannel();
        set_notification_Lead_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LeadShowDetailActivity.this, "Set Alarm", Toast.LENGTH_SHORT).show();
                showDateTimePicker();
            }
        });


    }

    private void selectspinner(String selection){
        if (selection.equals("Meeting Schedule")){
            set_notification_Lead_btn.setVisibility(View.VISIBLE);

        } else if (selection.equals("Call Again")) {
            set_notification_Lead_btn.setVisibility(View.VISIBLE);

        }else if (selection.equals("Remind")) {
            set_notification_Lead_btn.setVisibility(View.VISIBLE);

        }else if (selection.equals("Approved")) {
            set_notification_Lead_btn.setVisibility(View.GONE);

        }else if (selection.equals("Reject")) {
            set_notification_Lead_btn.setVisibility(View.GONE);

        }


    }
    private void buttonnotificationwork() {



    }

    private void reyclerviewstatus() {
        courseModalArrayList = new ArrayList<>();
        dbHandler = new DBHandler(LeadShowDetailActivity.this);

        // getting our course array
        // list from db handler class.
        courseModalArrayList = dbHandler.readCourses();

        // on below line passing our array list to our adapter class.
        LocalReyclerViewAdapter stausadapter = new LocalReyclerViewAdapter(courseModalArrayList, LeadShowDetailActivity.this);
        reyclerStatus = findViewById(R.id.recyclerstatus);

        // setting layout manager for our recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(LeadShowDetailActivity.this, RecyclerView.VERTICAL, false);
        reyclerStatus.setLayoutManager(linearLayoutManager);

        // setting our adapter to recycler view.
        reyclerStatus.setAdapter(stausadapter);
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

                TimePickerDialog timePickerDialog = new TimePickerDialog(LeadShowDetailActivity.this, new TimePickerDialog.OnTimeSetListener() {
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
        Toast.makeText(this, "calender" + calendar.toString(), Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "date" + datePickerDialog.toString(), Toast.LENGTH_SHORT).show();
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
        Toast.makeText(this, calendar.toString(), Toast.LENGTH_SHORT).show();

        // Get AlarmManager instance
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        // Create an Intent for the alarm receiver
        Intent intent = new Intent(this, AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_MUTABLE);

        // Set the alarm to trigger at the specified time
        alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);

       // Toast.makeText(this, "Alarm set for 30 seconds from now", Toast.LENGTH_SHORT).show();
    }
}