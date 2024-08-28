package com.example.innovaneers;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TeamDetailAdapter extends RecyclerView.Adapter<TeamDetailAdapter.ViewHolder> {
    List<TeamListModel> teamListModels;
    Context context;
    private static final String CHANNEL_ID = "employee_channel";
    private static final int NOTIFICATION_ID = 100;
    int flag = 0;

    public TeamDetailAdapter(List<TeamListModel> teamListModels, Context context) {
        this.teamListModels = teamListModels;
        this.context = context;

    }

    @NonNull
    @Override
    public TeamDetailAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.team_list_layout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamDetailAdapter.ViewHolder holder, int position) {
        final TeamListModel listModel = teamListModels.get(position);
        holder.name_list.setText(listModel.getName());
        holder.role.setText(listModel.getRole());
        String teamMember = listModel.getName();
        String isAssigned = listModel.getIsAssigned();
        if (isAssigned.equals("true")) {
            holder.check_assign.setVisibility(View.VISIBLE);
            holder.add_assign.setVisibility(View.GONE);


        } else {
            holder.check_assign.setVisibility(View.GONE);
            holder.add_assign.setVisibility(View.VISIBLE);

        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (flag == 0) {
                    if (isAssigned.equals("false")) {
                        RectrofitInstance.BASEURL = " http://api.innovaneers.in/Projects/";
                        ProjectIdStaffIDModel model = new ProjectIdStaffIDModel(listModel.getProjectID(), listModel.getStaffID());
                        //Log.d("ProjectId ",Project_Detail_Activity.globalProjectID);
                        //Log.d("StaffId",MainActivity.globalStaffID);
                        try {
                            Call<AssignModel> call = RectrofitInstance.getRetrofit1().getMyApi().createresponce(model);
                            call.enqueue(new Callback<AssignModel>() {
                                @Override
                                public void onResponse(Call<AssignModel> call, Response<AssignModel> response) {
                                    //Toast.makeText(context,MainActivity.globalStaffID, Toast.LENGTH_SHORT).show();
                                    Toast.makeText(context, "Assigned", Toast.LENGTH_SHORT).show();
                                    assignMemberToProject(teamMember);
                                    fetchData();

                                }

                                @Override
                                public void onFailure(Call<AssignModel> call, Throwable t) {
                                    t.printStackTrace();
                                    t.toString();
                                    t.getMessage();

                                }
                            });


                        } catch (Exception ex) {

                        }


                        holder.check_assign.setVisibility(View.VISIBLE);
                        holder.add_assign.setVisibility(View.GONE);

                    } else if (isAssigned.equals("true")) {
                        RectrofitInstance.BASEURL = " http://api.innovaneers.in/Projects/";
                        ProjectIdStaffIDModel model = new ProjectIdStaffIDModel(listModel.getProjectID(), listModel.getStaffID());
                        //Log.d("ProjectId ",Project_Detail_Activity.globalProjectID);
                        //Log.d("StaffId",MainActivity.globalStaffID);
                        try {
                            Call<RemoveMemberModel> call = RectrofitInstance.getRetrofit1().getMyApi().createremovemember(model);
                            call.enqueue(new Callback<RemoveMemberModel>() {
                                @Override
                                public void onResponse(Call<RemoveMemberModel> call, Response<RemoveMemberModel> response) {
                                    //Toast.makeText(context,MainActivity.globalStaffID, Toast.LENGTH_SHORT).show();
                                    Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                                    removeMemberToProject(teamMember);
                                    fetchData();

                                    // assignMemberToProject(teamMember);

                                }

                                @Override
                                public void onFailure(Call<RemoveMemberModel> call, Throwable t) {
                                    t.printStackTrace();
                                    t.toString();
                                    t.getMessage();

                                }
                            });


                        } catch (Exception ex) {
                            ex.getMessage();

                        }

                        holder.check_assign.setVisibility(View.GONE);
                        holder.add_assign.setVisibility(View.VISIBLE);

                    }
                    flag++;

                    // Gray Other Buttons
                } else if (flag == 1) {
                    if (isAssigned.equals("true")) {
                        RectrofitInstance.BASEURL = " http://api.innovaneers.in/Projects/";
                        ProjectIdStaffIDModel model = new ProjectIdStaffIDModel(listModel.getProjectID(), listModel.getStaffID());
                        //Log.d("ProjectId ",Project_Detail_Activity.globalProjectID);
                        //Log.d("StaffId",MainActivity.globalStaffID);
                        try {
                            Call<RemoveMemberModel> call = RectrofitInstance.getRetrofit1().getMyApi().createremovemember(model);
                            call.enqueue(new Callback<RemoveMemberModel>() {
                                @Override
                                public void onResponse(Call<RemoveMemberModel> call, Response<RemoveMemberModel> response) {
                                    //Toast.makeText(context,MainActivity.globalStaffID, Toast.LENGTH_SHORT).show();
                                    Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                                    removeMemberToProject(teamMember);
                                    fetchData();

                                    // assignMemberToProject(teamMember);

                                }

                                @Override
                                public void onFailure(Call<RemoveMemberModel> call, Throwable t) {
                                    t.printStackTrace();
                                    t.toString();
                                    t.getMessage();

                                }
                            });


                        } catch (Exception ex) {
                            ex.getMessage();

                        }

                        holder.check_assign.setVisibility(View.GONE);
                        holder.add_assign.setVisibility(View.VISIBLE);

                        // Gray Other Buttons


                    } else if (isAssigned.equals("false")) {
                        RectrofitInstance.BASEURL = " http://api.innovaneers.in/Projects/";
                        ProjectIdStaffIDModel model = new ProjectIdStaffIDModel(listModel.getProjectID(), listModel.getStaffID());
                        //Log.d("ProjectId ",Project_Detail_Activity.globalProjectID);
                        //Log.d("StaffId",MainActivity.globalStaffID);
                        try {
                            Call<AssignModel> call = RectrofitInstance.getRetrofit1().getMyApi().createresponce(model);
                            call.enqueue(new Callback<AssignModel>() {
                                @Override
                                public void onResponse(Call<AssignModel> call, Response<AssignModel> response) {
                                    //Toast.makeText(context,MainActivity.globalStaffID, Toast.LENGTH_SHORT).show();
                                    Toast.makeText(context, "Assigned", Toast.LENGTH_SHORT).show();
                                    assignMemberToProject(teamMember);
                                    fetchData();

                                }

                                @Override
                                public void onFailure(Call<AssignModel> call, Throwable t) {
                                    t.printStackTrace();
                                    t.toString();
                                    t.getMessage();

                                }
                            });


                        } catch (Exception ex) {

                        }


                        holder.check_assign.setVisibility(View.VISIBLE);
                        holder.add_assign.setVisibility(View.GONE);

                    }
                    flag--;


                }
            }
        });


        // holder.itemView.setOnClickListener(view -> {
        //  mItemListener.onItemClick(teamListModels.get(position));
        //  holder.add_assign.setVisibility(View.GONE);
        //  holder.check_assign.setVisibility(View.VISIBLE);

        //  });
        //   holder.layout.setOnClickListener(new View.OnClickListener() {
        //     @Override
        //     public void onClick(View view) {
        //         Toast.makeText(context, listModel.getName(), Toast.LENGTH_SHORT).show();
        //      }
        //  });
    }

    private void assignMemberToProject(String teamMember) {
        // Assign the selected team member to the project
        // Show notification about the assignment
        boolean isAssigned = assignToProject(teamMember);
        if (isAssigned) {

            //showNotification("Hello",7783934013);
            NotificationHelper.showNotification(context, "Project Assignment", "Assigned " + teamMember + " to the project.");
        }
    }

  /*  private void showNotification(String message, String phoneNumber) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.drawable.innovaneers)
                .setContentTitle("Employee Selection")
                .setContentText(message + ". Phone: " + phoneNumber) // Include phone number in the notification message
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);
        if (ActivityCompat.checkSelfPermission(context, android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        notificationManager.notify(NOTIFICATION_ID, builder.build());
    }*/

    private void removeMemberToProject(String teamMember) {
        // Assign the selected team member to the project
        // Show notification about the assignment
        boolean isRemove = assignToProject(teamMember);
        if (isRemove) {

            NotificationHelper.showNotification(context, "Project Assignment", "Remove " + teamMember + " to the project.");
        }
    }

    public void fetchData() {
        RectrofitInstance.BASEURL = " http://api.innovaneers.in/Projects/";
        ProjectIdModel model = new ProjectIdModel(Project_Detail_Activity.globalAdapterProjectID);
        try {
            Call<List<TeamListModel>> lcall = RectrofitInstance.getRetrofit1().getMyApi().createprojectteam(model);
            lcall.enqueue(new Callback<List<TeamListModel>>() {
                @Override
                public void onResponse(Call<List<TeamListModel>> call, Response<List<TeamListModel>> response) {
                    List<TeamListModel> showModel = response.body();
                    Log.d("data", response.body().toString());
                    Toast.makeText(context, showModel.toString(), Toast.LENGTH_SHORT).show();


                    //  TeamDetailAdapter adapter = new TeamDetailAdapter(showModel, context);

                    //horizontal = new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false);
                    //recycler_team.setLayoutManager(horizontal);
                    // recycler_team.setAdapter(adapter);
                }

                @Override
                public void onFailure(Call<List<TeamListModel>> call, Throwable t) {
                    Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
                    Log.d("error", t.getMessage());
                    Log.d("erroe2", t.getLocalizedMessage());
                    Log.d("erroe3", t.toString());
                    t.printStackTrace();


                }
            });


        } catch (Exception e) {

        }


    }


    private boolean assignToProject(String teamMember) {
        return true;
    }


    @Override
    public int getItemCount() {
        return teamListModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView layout;
        TextView name_list, role;
        ImageView add_assign, check_assign;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            layout = itemView.findViewById(R.id.team_list_layout);
            name_list = itemView.findViewById(R.id.name_list_Team);
            role = itemView.findViewById(R.id.designation_list_type);
            add_assign = itemView.findViewById(R.id.add_assign);
            check_assign = itemView.findViewById(R.id.check_assign);

        }
    }
}
