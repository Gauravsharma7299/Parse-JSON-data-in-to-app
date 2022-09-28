package com.example.parsingjsonresponse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MyAdapter adapter;
    List<Model>mydata;
    private static   String url="https://random-data-api.com/api/v2/beers?size=10&response_type=json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.rc);
        mydata=new ArrayList<>();
        extractData();


    }

    private void extractData() {
        RequestQueue requestQueue;
        requestQueue=Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i=0;i<response.length();i++){
                    try {
                        JSONObject jsonObject=response.getJSONObject(i);
                        Model items=new Model();
                        items.setName(jsonObject.getString("name").toString());
                        items.setBrand(jsonObject.getString("brand").toString());
                        items.setAlcohol(jsonObject.getString("alcohol").toString());
                        mydata.add(items);


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
//                LinearLayoutManager llm=new LinearLayoutManager(getApplicationContext());
//                llm.setOrientation(LinearLayoutManager.VERTICAL);;
//                recyclerView.setLayoutManager(llm);
//                recyclerView.setAdapter(adapter);}
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                adapter=new MyAdapter(getApplicationContext(),mydata);
                recyclerView.setAdapter(adapter);}
        },
                new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("myapp", "somthing went wrong");

            }
        });
        requestQueue.add(jsonArrayRequest);
    }
}