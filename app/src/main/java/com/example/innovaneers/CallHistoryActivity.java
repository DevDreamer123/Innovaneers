package com.example.innovaneers;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.CallLog;
import android.view.View;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class CallHistoryActivity extends AppCompatActivity {

    //  private ArrayList<CallLogModel> callLogModels;
  //   private RecyclerView rv_call_logs;
    //  private CallLogAdapter callLogAdapter;
    //  public String str_number , str_name , str_type , str_full_date , str_date , str_time , str_time_formatted,
    //          str_duration;
    //  private SwipeRefreshLayout swipeRefreshLayout;
    //  private static final int PERMISSIONS_REQUEST_CODE = 999;
    //  String[] appPermission = {
//            Manifest.permission.READ_CALL_LOG,
//            Manifest.permission.PROCESS_OUTGOING_CALLS,
    //           Manifest.permission.READ_PHONE_STATE
    //   };
    //   private int flag = 0;
   private TextView textView ;
   // ArrayList<CallLogModel> mItems = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_history);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CALL_LOG}, PackageManager.PERMISSION_GRANTED);
        textView = findViewById(R.id.text_btn);

    }

    public void btnCallLog(View view){
        textView.setText("Call Logging Started...");
        String stringOutput = "";
        Uri uriCallLogs = Uri.parse("content://call_log/calls");
        Cursor cursorCalllogs = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            cursorCalllogs = getContentResolver().query(uriCallLogs,null,null,null);


        }

       do {
           cursorCalllogs.moveToFirst();

           String stringNumber = cursorCalllogs.getString(cursorCalllogs.getColumnIndex(CallLog.Calls.NUMBER));
           String stringName = cursorCalllogs.getString(cursorCalllogs.getColumnIndex(CallLog.Calls.CACHED_NAME));
           String stringDuration = cursorCalllogs.getString(cursorCalllogs.getColumnIndex(CallLog.Calls.DURATION));
           String stringType = cursorCalllogs.getString(cursorCalllogs.getColumnIndex(CallLog.Calls.TYPE));
           String stringDate = cursorCalllogs.getString(cursorCalllogs.getColumnIndex(CallLog.Calls.DATE));

           stringOutput = stringOutput + "Number:" + stringNumber
                   + "\nName:" + stringName
                   + "\nDuration:" + stringDuration
                   + "\nDate:" + stringDate
                   + "\nType" + stringType + "\n\n";

       }

       while (cursorCalllogs.moveToNext());
       textView.setText(stringOutput);
       // rv_call_logs.setAdapter(a);

}
}
      //  getSupportActionBar().setTitle( "Call Logs");
     //   Init();
     //   if (CheckAndRequestPermission()) {
    //        FetchCallLogs();
    //    }

      //  swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
       //     @Override
       //     public void onRefresh() {
      //          if (CheckAndRequestPermission()) {
      //              FetchCallLogs();
      //          }
     //           swipeRefreshLayout.setRefreshing(false);
     //       }
   //     });
  //  }
   // public boolean CheckAndRequestPermission(){
   //     List<String> listPermisssionNeeded = new ArrayList<>();
   //     for (String item : appPermission){
   //         if (ContextCompat.checkSelfPermission(this , item)!= PackageManager.PERMISSION_GRANTED)
   //             listPermisssionNeeded.add(item);
    //    }
    //    if (!listPermisssionNeeded.isEmpty()){
    //        ActivityCompat.requestPermissions(this,listPermisssionNeeded.toArray(new String[listPermisssionNeeded.size()]),PERMISSIONS_REQUEST_CODE);
    //        return false;
    //    }
   //     return true;
  //  }
  //  private void Init(){
     //   swipeRefreshLayout = findViewById(R.id.activity_main_swipe_refresh_layout);
    //    rv_call_logs = findViewById(R.id.call_History);
     //   rv_call_logs.setHasFixedSize(true);
    //    rv_call_logs.setLayoutManager(new LinearLayoutManager(this));
    //    callLogModels = new ArrayList<>();
   //     callLogAdapter = new CallLogAdapter(this, callLogModels);
    //    rv_call_logs.setAdapter(callLogAdapter);
  //  }
   // @RequiresApi(api = Build.VERSION_CODES.M)

   // @Override
   // public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
   //     super.onRequestPermissionsResult(requestCode, permissions, grantResults);
   //     if (requestCode == PERMISSIONS_REQUEST_CODE){
    //        for(int i = 0 ; i < permissions.length ; i++){
   //             if (grantResults[i] == PackageManager.PERMISSION_DENIED){
   //                 flag = 1;
   //                 break;
    //            }
     //       }
     //       if (flag == 0)
     //           FetchCallLogs();
     //   }
  //  }

 //   public void FetchCallLogs(){
 //       String sortOrder = CallLog.Calls.DATE+"DESC";
  //      Cursor cursor = this.getContentResolver().query(CallLog.Calls.CONTENT_URI,null,
  //              null,null,sortOrder);
  //      callLogModels.clear();

     //   while (cursor.moveToNext()){
    //        str_number = cursor.getString(cursor.getColumnIndex(android.provider.CallLog.Calls.NUMBER));
    //        str_name = cursor.getString(cursor.getColumnIndex(android.provider.CallLog.Calls.CACHED_NAME));
    //        str_name = str_name == null || str_name .equals("") ? "Unknown" : str_name;
     //       str_type = cursor.getString(cursor.getColumnIndex(android.provider.CallLog.Calls.TYPE));
      //      str_full_date = cursor.getString(cursor.getColumnIndex(CallLog.Calls.DATE));
     //       str_duration = cursor.getString(cursor.getColumnIndex(CallLog.Calls.DURATION));


      //      SimpleDateFormat dateFormat = new SimpleDateFormat("dd MM yyyy");

         //  str_date = dateFormat.format(new Date(Long.parseLong(str_full_date)));
        //   SimpleDateFormat timeFormat =new SimpleDateFormat("HH:mm:ss");
         //  str_time = timeFormat.format(new Date(Long.parseLong(str_full_date)));
         //  str_time_formatted = getFormateDateTime(str_time,"HH:mm:ss" ,"hh:mm a");
        //    str_duration = DurationFormat(str_duration);
        //   switch (Integer.parseInt(str_type)){
        //       case CallLog.Calls.INCOMING_TYPE:
        //           str_type = "Incoming";
       //            break;
      //         case CallLog.Calls.OUTGOING_TYPE:
       //            str_type = "Outgoing";
       //            break;
       //        case CallLog.Calls.MISSED_TYPE:
       //            str_type = "Missed";
       //            break;
       //        case CallLog.Calls.VOICEMAIL_TYPE:
       //            str_type = "Voicemail";
       //            break;
       //        case CallLog.Calls.REJECTED_TYPE:
       //            str_type = "Rejected";
       //            break;
       //        case CallLog.Calls.BLOCKED_TYPE:
      //             str_type = "Blocked";
       //            break;
        //       case CallLog.Calls.ANSWERED_EXTERNALLY_TYPE:
       //            str_type = "Externally Answered";
         //          break;
           //    default:
          //         str_type ="NA";
         //  }

        //   CallLogModel callLogModel = new CallLogModel(str_number ,str_name, str_type,str_date,str_time_formatted,str_duration);
       //    callLogModels.add(callLogModel);


  //      }
  //      callLogAdapter.notifyDataSetChanged();
 //   }
  //  private String getFormateDateTime(String datestr ,String strInputFormat , String strOutputFormat) {

  //      String formateDate = datestr;
   //     DateFormat inputFormate = new SimpleDateFormat(strInputFormat, Locale.getDefault());
  //      DateFormat outputFormate = new SimpleDateFormat(strOutputFormat,Locale.getDefault());
  //      Date date = null ;
   //     try {
    //        date = inputFormate.parse(datestr);
   //     } catch (ParseException e) {
    //        e.printStackTrace();
    //    }
   //     if (date != null){
    //        formateDate = outputFormate.format(date);
    //    }

   //     return formateDate;
  //  }
   // private String DurationFormat(String duration){
   //     String durationFormatted =null;
     //   if (Integer.parseInt(duration)< 60){
     //       durationFormatted = duration+"sec";

     //   }else {
      //      int min = Integer.parseInt(duration)/60;
      //      int sec = Integer.parseInt(duration)%60;

      //      if (sec == 0)
       //         durationFormatted = min + "min";
       //     else
        //        durationFormatted = min + "min" +sec + "sec";

     //   }
     //   return durationFormatted;
 //   }
//}