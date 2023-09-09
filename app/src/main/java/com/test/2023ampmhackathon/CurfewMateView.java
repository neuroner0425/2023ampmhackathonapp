package com.test.2023ampmhackathon;

import android.annotation.SuppressLint;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class CurfewMateView  extends AppCompatActivity {

    private ListView curfewMateDescListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.curfew_mate);

        curfewMateDescListView = findViewById(R.id.curfew_mate_listview);
        fetchDormDataAndSetToListView();
    }
    private void fetchDormDataAndSetToListView() {
        String url = "http://forhackathon.site/read_curfewmate";
        Log.d("TAG", "onResponse: 망했어");

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            Log.d("TAG", "onResponse: " + response.toString());
                            List<CurfewMateInfo> curfewInfoList = new ArrayList<>();
                            for (int i = 0; i < response.length(); i++) {
                                JSONObject jsonObject = response.getJSONObject(i);
                                CurfewMateInfo curfewInfo = new CurfewMateInfo();
                                curfewInfo.setTime(jsonObject.getString("time"));
                                curfewInfo.setDormName(jsonObject.getString("dorm"));
                                curfewInfoList.add(curfewInfo);
                            }

                            CurfewMateDecAdapter madapter = new CurfewMateDecAdapter(CurfewMateView.this, curfewInfoList);
                            curfewMateDescListView.setAdapter(madapter);

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
