package com.example.innovaneers;

import static com.example.innovaneers.LoginActivity.KEY_MOBILE;
import static com.example.innovaneers.LoginActivity.KEY_STAFF_ID;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentTransaction;

import android.Manifest;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.innovaneers.account.AccountFragment;
import com.example.innovaneers.home.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    SharedPreferences preferences;
   private static final String SHARED_PREF_NAME = "Innovaneers";
    public static String globalStaffID ="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences preferences =getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);



        String registeredUserNumber = preferences.getString(KEY_MOBILE,"");
        String registeredUserStaffId = preferences.getString(KEY_STAFF_ID,"");
        globalStaffID = registeredUserStaffId;
       // globalMemberID = registeredUserNumber;
       // Log.d("MemberIDMain",globalMemberID);
        String registeredPassword = preferences.getString("",LoginActivity.KEY_PASSWORD);
        if (registeredUserNumber != null || registeredPassword != null)
      {

                Toast.makeText(MainActivity.this,"value"+registeredUserNumber, Toast.LENGTH_SHORT).show();
          Toast.makeText(this,registeredUserStaffId, Toast.LENGTH_SHORT).show();
          Toast.makeText(this, registeredUserStaffId, Toast.LENGTH_SHORT).show();

       }else{
            Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
       }
        showHomeFragment();
        bottomNavigationView = findViewById(R.id.bottonnav);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                switch (item.getItemId()) {
                    case R.id.home:

                        transaction.replace(R.id.container, new HomeFragment());

                        break;
                    case R.id.dashboard:

                        transaction.replace(R.id.container, new DashBoardFragment());

                        break;

                    case R.id.account:
                        transaction.replace(R.id.container, new AccountFragment());
                        break;
                }
                transaction.commit();
                return true;
            }
        });
    }

    private void showHomeFragment() {
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container,new HomeFragment());
        transaction.commit();

    }
}