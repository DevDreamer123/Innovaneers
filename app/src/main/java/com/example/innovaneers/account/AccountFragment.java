package com.example.innovaneers.account;

import static android.content.Context.MODE_PRIVATE;

import static com.example.innovaneers.LoginActivity.KEY_MOBILE;
import static com.example.innovaneers.LoginActivity.KEY_PASSWORD;
import static com.example.innovaneers.LoginActivity.SHARED_PREF_NAME;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.innovaneers.IDCardActivity;
import com.example.innovaneers.LoginActivity;
import com.example.innovaneers.LoginInnoActivity;
import com.example.innovaneers.ProfileActivity;
import com.example.innovaneers.ProfileShowActiviy;
import com.example.innovaneers.R;

public class AccountFragment extends Fragment {

    TextView contact,logout,id_card,faq_account_inno;
    CardView person1, person2,person3,person4,person5,person6;
    SharedPreferences preferences;
   /// public static final String SHARED_PREF_NAME = "Innovaneers";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_account, container, false);
        faq_account_inno = view.findViewById(R.id.faq_account_inno);
        faq_account_inno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  Intent i = new Intent(getContext(), LoginInnoActivity.class);
              //  startActivity(i);
            }
        });
        contact = view.findViewById(R.id.account_contact);
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), ProfileActivity.class);
                startActivity(i);
            }
        });
        id_card = view.findViewById(R.id.account_id_card);
        id_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), IDCardActivity.class);
                startActivity(i);
            }
        });


        logout = view.findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showLogoutDialog();
               /* try {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        getContext());

                // set title
                alertDialogBuilder.setTitle("Logout");

                // set dialog message
                alertDialogBuilder
                        .setMessage("Are you sure you want to logout?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //Toast.makeText(getContext(), "ok", Toast.LENGTH_SHORT).show();
                                if (preferences == null)
                                    preferences = getActivity().getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);

                                SharedPreferences.Editor editor = preferences.edit();
                                editor.clear();
                                editor.apply();
                                editor.putString(KEY_MOBILE, "");
                                editor.putString(KEY_PASSWORD, "");
                                editor.commit();

                                Intent intent = new Intent(getActivity(), LoginActivity.class);
                                startActivity(intent);
                                getActivity().finish();


                            }
                        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //   Toast.makeText(getContext(), "No", Toast.LENGTH_SHORT).show();
                                dialogInterface.dismiss();
                            }
                        });

                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();
                alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(Color.RED);
                alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(Color.GREEN);

            } catch (Exception ex) {
                Toast.makeText(getContext(), ex.getMessage().toString(), Toast.LENGTH_LONG).show();
            }*/



               /* try {
                    if (preferences == null)
                        preferences = getActivity().getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);

                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString(KEY_MOBILE,"");
                    editor.putString(KEY_PASSWORD,"");
                    editor.commit();

                    Intent intent = new Intent(getActivity(),LoginActivity.class);
                    startActivity(intent);


                } catch (Exception ex) {
                    Toast.makeText(getContext(), ex.getMessage().toString(), Toast.LENGTH_LONG).show();
                }*/
            }

        });








   /*     person1 = view. findViewById(R.id.person1);
        person1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), ProfileShowActiviy.class);
                startActivity(i);
            }
        });
        person2 = view. findViewById(R.id.person2);
        person2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), ProfileShowActiviy.class);
                startActivity(i);
            }
        });
        person3 = view. findViewById(R.id.person3);
        person3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), ProfileShowActiviy.class);
                startActivity(i);
            }
        });**/

        return  view;


    }
    public void showLogoutDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.logout_layout, null);
        builder.setView(dialogView);

        Button logoutButton = dialogView.findViewById(R.id.button_ok_log);
        Button cancelButton = dialogView.findViewById(R.id.button_no_log);

        final AlertDialog dialog = builder.create();

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform logout action
                if (preferences == null)
                    preferences = getActivity().getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);

                SharedPreferences.Editor editor = preferences.edit();
                editor.clear();
                editor.apply();
                editor.putString(KEY_MOBILE, "");
                editor.putString(KEY_PASSWORD, "");
                editor.commit();

                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss(); // Dismiss the dialog
            }
        });

        dialog.show();
    }
}