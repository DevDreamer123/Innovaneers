package com.example.innovaneers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginInnoActivity extends AppCompatActivity {
TextInputEditText userNameLogin,userPasswordLogin;
Button loginBtnLogin;
    SharedPreferences shp;
    public static final String SHARED_PREF_NAME = "Innovaneers";
    public static final String KEY_MOBILE = "Mobile";
    public static final String KEY_NAME = "Name";
    public static final String KEY_USERID = "UserId";
    public static final String KEY_STAFF_ID = "StaffId";
    public static final String KEY_EMAIL = "Email";
    public static final String KEY_PASSWORD = "Password";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_inno);
        userNameLogin = findViewById(R.id.user_name_login);
        userPasswordLogin = findViewById(R.id.user_password_login);
        loginBtnLogin = findViewById(R.id.login_btn_Login);
        shp = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        loginBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(userNameLogin.getText().toString()) || TextUtils.isEmpty(userPasswordLogin.getText().toString())) {
                    Toast.makeText(LoginInnoActivity.this, "Username/Password Required", Toast.LENGTH_LONG).show();
                } else {


                    RequestModel namemobel = new RequestModel();
                    namemobel.setMobile(userNameLogin.getText().toString());
                    namemobel.setPassword(userPasswordLogin.getText().toString());


                    RectrofitInstance.BASEURL = " http://api.innovaneers.in/User/";
                    try {
                        Call<LoginModel> lcall = RectrofitInstance.getRetrofit2().getMyApi().createlogin(namemobel);
                        lcall.enqueue(new Callback<LoginModel>() {
                            @Override
                            public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {
                                // Toast.makeText(LoginActivity.this, "Hello", Toast.LENGTH_SHORT).show();
                                if (response.isSuccessful()) {
                                    LoginModel loginResponse = response.body();
                                    SharedPreferences.Editor editor = shp.edit();
                                    editor.putString(KEY_STAFF_ID, response.body().getStaffID());
                                    editor.putString(KEY_MOBILE, response.body().getMobile());
                                    //editor.putString(KEY_USERID, response.body().getUserID());
                                    editor.putString(KEY_NAME, response.body().getName());
                                    editor.putString(KEY_EMAIL, response.body().getEmail());
                                    editor.putString(KEY_PASSWORD, response.body().getPassword());
                                    //   editor.putString(KEY_USERTYPE,response.body().getUserType());
                                    editor.apply();
                                    // Toast.makeText(LoginActivity.this,response.body().getName(), Toast.LENGTH_SHORT).show();
                                    //  Toast.makeText(LoginActivity.this, "SuccessFully", Toast.LENGTH_SHORT).show();
                                    Intent i = new Intent(LoginInnoActivity.this, MainActivity.class);
                                    Toast.makeText(LoginInnoActivity.this, "SuccessFully", Toast.LENGTH_SHORT).show();
                                    i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                    startActivity(i);
                                    finish();
                                } else {
                                    Toast.makeText(LoginInnoActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                                }

                            }

                            @Override
                            public void onFailure(Call<LoginModel> call, Throwable t) {
                                Toast.makeText(LoginInnoActivity.this,t.toString(), Toast.LENGTH_SHORT).show();
                                Log.d("error",t.getMessage());

                                t.toString();

                            }
                        });

                    } catch (Exception e) {
                        Toast.makeText(LoginInnoActivity.this,e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                        Log.d("error1",e.getMessage());
                        e.getMessage();
                    }

                }
            }
        });

    }
}