package com.test.2023ampmhackathon;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class RoomMateView extends AppCompatActivity {

    private ListView roomMateDescListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.room_mate);

        String[] dormitoryOptions = {"평화관", "대동관", "참빛관", "새빛관", "한빛관", "창의관", "혜민관"};
        ArrayAdapter<String> domitoryAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dormitoryOptions);
        domitoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Button dormitoryButton = findViewById(R.id.Domitory);
        final Spinner dormitorySpinner = findViewById(R.id.Domitory_Spinner);
        dormitorySpinner.setVisibility(View.GONE);
        dormitoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dormitorySpinner.setVisibility(View.VISIBLE);
            }
        });
        dormitorySpinner.setAdapter(domitoryAdapter);
        dormitorySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }
        });

        String[] classOptions = {"23학번", "22학번", "21학번", "20학번", "19학번", "18학번", "17학번"};
        ArrayAdapter<String> classAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, classOptions);
        classAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Button classButton = findViewById(R.id.Class);
        final Spinner classSpinner = findViewById(R.id.Class_Spinner);
        classSpinner.setVisibility(View.GONE);
        classButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                classSpinner.setVisibility(View.VISIBLE);
            }
        });
        classSpinner.setAdapter(classAdapter);
        classSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }
        });

        String[] genderOptions = {"남자","여자"};
        ArrayAdapter<String> genderAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, genderOptions);
        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Button genderButton = findViewById(R.id.Gender);
        final Spinner genderSpinner = findViewById(R.id.Gender_Spinner);
        genderSpinner.setVisibility(View.GONE);
        genderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                genderSpinner.setVisibility(View.VISIBLE);
            }
        });
        genderSpinner.setAdapter(genderAdapter);
        genderSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }
        });

        roomMateDescListView = findViewById(R.id.room_mate_listview);
        fetchDormDataAndSetToListView();
    }

    private void fetchDormDataAndSetToListView() {
        String url = "http://forhackathon.site/read_dorm";
        Log.d("TAG", "onResponse: 망했어");

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            Log.d("TAG", "onResponse: " + response.toString());
                            List<StudentInfo> studentInfoList = new ArrayList<>();
                            for (int i = 0; i < response.length(); i++) {
                                JSONObject jsonObject = response.getJSONObject(i);
                                StudentInfo studentInfo = new StudentInfo();
                                studentInfo.setDormitoryName(jsonObject.getString("dormitoryName"));
                                studentInfo.setGender(jsonObject.getString("gender"));
                                studentInfo.setIsSmoker(jsonObject.getString("isSmoker").equalsIgnoreCase("Yes"));
                                studentInfo.setIsSnorer(jsonObject.getString("isSnorer").equalsIgnoreCase("Yes"));
                                studentInfo.setMbti(jsonObject.getString("mbti"));
                                studentInfo.setStudentNumber(jsonObject.getString("studentNumber"));
                                studentInfoList.add(studentInfo);
                            }

                            CustomListAdapter madapter = new CustomListAdapter(RoomMateView.this, studentInfoList);
                            roomMateDescListView.setAdapter(madapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("TAG", "onError: " + error.toString());

                    }
                });

        // Access the RequestQueue through your singleton class.
        MySingleton.getInstance(this).addToRequestQueue(jsonArrayRequest);
    }
}