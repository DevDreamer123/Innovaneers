package com.example.innovaneers;


import com.example.innovaneers.account.NewLeadModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIInterface {


    @POST("NewLead")
    Call<NewLeadModel> createLead(@Body LeadRequestModel leadRequestModel);

    @POST("NewProject")
    Call<ProjectModel> createproject(@Body ProjectRequestModel projectRequestModel);

    @POST("Login") //Login
    Call<LoginModel> createlogin(@Body RequestModel requestModel);

    @GET("AllLeads")        //NewLeadShow
    Call<List<LeadModel>> getnewlead();


    @GET("AllProjects")        //Newproject
    Call<List<ProjectShowModel>> getproject();

    @POST("ProjectTeam")        //projectteam
    Call<List<TeamListModel>> createprojectteam(@Body ProjectIdModel projectIdModel);



    @GET("AllMembers") //tem
    Call<List<TeamModel>> getteam();


    @GET("HomeStats") //HomeStack
    Call<HomeStackModel> gethomestack();
    @GET("HomeStats") //HomeStack
    Call<List<HomeStackModel>> gethomestack1();

    @POST("Details?")
    Call<ProjectShowModel> createlistproject(@Body ProjectIdModel projectIdModel);

    @POST("AssignMember") //AssignMember
    Call<AssignModel>  createresponce(@Body ProjectIdStaffIDModel projectIdStaffIDModel);

    @POST("Details?")  //Lead
   Call<LeadModel>  createleaddetail(@Body LeadIdModel leadIdModel);

    @POST("RemoveMember")  //remove ember assign
    Call<RemoveMemberModel>  createremovemember(@Body ProjectIdStaffIDModel projectIdStaffIDModel);

    @POST("AddTask")  //add task
    Call<TaskShowListModel>  createtask(@Body ProjectTitleStaffModel projectTitleStaffModel);

    @POST("allProjectTasks")  //add tasklist
    Call<List<TaskShowListModel>>  createtasklist(@Body ProjectIdModel projectIdModel);




}
