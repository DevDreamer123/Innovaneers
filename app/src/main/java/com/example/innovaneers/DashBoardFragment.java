package com.example.innovaneers;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class DashBoardFragment extends Fragment {
Button log;
CardView projectsShow,leadsshow,team;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dash_board, container, false);
        projectsShow = view.findViewById(R.id.projectsShow);
        projectsShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), projectListActivity.class);
                startActivity(i);
            }
        });
        leadsshow = view.findViewById(R.id.leadsshow);
        leadsshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(),LeadShowActivity.class);
                startActivity(i);
            }
        });
        team = view.findViewById(R.id.teamShow);
        team.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(),TeamDetailActivity.class);
                startActivity(i);
            }
        });


     //   log = view.findViewById(R.id.log);
     //   log.setOnClickListener(new View.OnClickListener() {
      //      @Override
       //     public void onClick(View view) {
       //      Intent i = new Intent(getActivity(),CallHistoryActivity.class);
       //      startActivity(i);
       //     }
      //  });
        return view;
    }
}