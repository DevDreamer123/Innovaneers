package com.example.innovaneers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.innovaneers.account.NewLeadModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    public static final String SHARED_PREF_NAME = "Innovaneers";
    Button login;
    EditText    username , password ;
    public static SharedPreferences preferences;
    public static final String KEY_MOBILE = "Mobile";
    public static final String KEY_NAME = "Name";
    public static final String KEY_STAFF_ID = "StaffID";
    public static final String KEY_EMAIL = "Email";
    public static final String KEY_PASSWORD = "Password";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        preferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);


        username = findViewById(R.id.username);
        password = findViewById(R.id.userpassword);
        login = findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(username.getText().toString()) || TextUtils.isEmpty(password.getText().toString())) {
                    Toast.makeText(LoginActivity.this, "Username/Password Required", Toast.LENGTH_LONG).show();
                } else {

                    RequestModel requestModel = new RequestModel();
                    requestModel.setMobile(username.getText().toString());
                    requestModel.setPassword(password.getText().toString());
                    RectrofitInstance.BASEURL = " http://api.innovaneers.in/User/";
                    try {
                        Call<LoginModel> lcall = RectrofitInstance.getRetrofit2().getMyApi().createlogin(requestModel);
                        lcall.enqueue(new Callback<LoginModel>() {
                            @Override
                            public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {
                                if (response.isSuccessful()) {
                                    LoginModel loginResponse = response.body();
                                    SharedPreferences.Editor editor = preferences.edit();
                                    editor.putString(KEY_STAFF_ID,response.body().getStaffID());
                                    editor.putString(KEY_MOBILE, response.body().getMobile());
                                    editor.putString(KEY_NAME, response.body().getName());
                                    editor.putString(KEY_EMAIL, response.body().getEmail());
                                    editor.putString(KEY_PASSWORD, response.body().getPassword());
                                    //   editor.putString(KEY_USERTYPE,response.body().getUserType());
                                    editor.apply();
                                    // Toast.makeText(LoginActivity.this,response.body().getName(), Toast.LENGTH_SHORT).show();
                                    //  Toast.makeText(LoginActivity.this, "SuccessFully", Toast.LENGTH_SHORT).show();
                                    Intent i = new Intent(LoginActivity.this, MainActivity.class);
                                    Toast.makeText(LoginActivity.this, "SuccessFully", Toast.LENGTH_SHORT).show();
                                    i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                    startActivity(i);
                                    finish();
                                } else {
                                    Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                                }

                            }
                            @Override
                            public void onFailure(Call<LoginModel> call, Throwable t) {
                                Toast.makeText(LoginActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                                t.toString();
                                t.printStackTrace();
                            }
                        });

                    } catch (Exception e) {
                        e.printStackTrace();
                        Toast.makeText(LoginActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });
    }
}