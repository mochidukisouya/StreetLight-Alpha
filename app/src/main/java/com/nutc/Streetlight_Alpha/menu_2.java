package com.nutc.Streetlight_Alpha;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.security.MessageDigest;
import java.util.ArrayList;

/**
 * Created by Mochiduki on 2018/1/11.
 */

public class menu_2 extends AppCompatActivity {
    ListView Last_list_view,Un_list_view;
    String account,serverIP,MESSAGE,SEQNO,CLSEQNO,SLNO,CITYNO,CITYNM,LNG,LAT,AREA,O_KINDSEQNO="",N_KINDSEQNO="",O_TYPE,N_TYPE,O_WATTS,N_WATTS, LAMPSTYLE,WATTS, OLDLAMPSTYLE,OLDWATTS, QTY;
    String LAMPNO_PICS, LAMPNO_PICS_FILE,B_PICS,B_PICS_FILE,I_PICS,I_PICS_FILE,A_PICS,A_PICS_FILE,P_PICS,P_PICS_FILE;
    int area_index;
    String[] LampTypeArray,LampAllArray,lampdetail,AREAlist;
    Boolean isLAST=false;
    SharedPreferences sharedPreferences ;
    private ArrayList<String> lightlist = new ArrayList<>();
    private ArrayAdapter<String> listAdapter;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(Menu.NONE, 0, Menu.NONE, "返回").setShowAsAction(1);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //item.get.setTitle(PagesIndex+"");
        switch (item.getItemId()){
            case 0:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dataedit);
        getSupportActionBar().setTitle("上筆/未上傳資料");

        init();
        addlist_Last();

    }

    private void  init(){
        sharedPreferences = getSharedPreferences("LastData" , MODE_PRIVATE);
        Last_list_view = (ListView)findViewById(R.id.Last_list_view);
        Un_list_view = (ListView)findViewById(R.id.Un_list_view);
        CLSEQNO =sharedPreferences.getString("CLSEQNO" ,"0");
        SEQNO =sharedPreferences.getString("SEQNO" ,"0");
        lampdetail[2]=SEQNO;
        area_index =sharedPreferences.getInt("area_index" , 0);
        LNG = sharedPreferences.getString("LNG" , "0");
        LAT = sharedPreferences.getString("LAT" , "0");
        QTY = sharedPreferences.getString("QTY" , "0");
        O_TYPE = sharedPreferences.getString("O_TYPE" , "0");
        O_WATTS = sharedPreferences.getString("O_WATTS" , "0");
        N_TYPE = sharedPreferences.getString("N_TYPE" , "0");
        N_WATTS = sharedPreferences.getString("N_WATTS" , "0");
    }


    public void addlist_Last(){
        Last_list_view.setAdapter(null);
        lightlist.clear();
        lightlist.add("路燈編號:" + lampdetail[2] + "　地區:" + lampdetail[7] + "\n燈種:" + lampdetail[8] + "　瓦特數:" + lampdetail[9] + "W");
        listAdapter = new ArrayAdapter(this, R.layout.font, lightlist) {
            @NonNull
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                ViewGroup.LayoutParams params = view.getLayoutParams();
                params.height = RelativeLayout.LayoutParams.WRAP_CONTENT;
                view.setLayoutParams(params);
                return view;
            }
        };
        Last_list_view.setAdapter(listAdapter);
        Last_list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


            }
        });


    }
}
