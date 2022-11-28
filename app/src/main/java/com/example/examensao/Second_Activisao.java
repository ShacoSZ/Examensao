package com.example.examensao;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Second_Activisao extends AppCompatActivity {
    adaptador adapter;
    List<ganadores> gamma;
    List<ListaGanadores> lstgamma;

    private RequestQueue pancakes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_activisao);

        pancakes = SingletonRequest.getInstance(Second_Activisao.this).getRequestQueue();
        gamma = new ArrayList<>();
        lstgamma= new ArrayList<>();

        quesada();
        RecyclerView recyclerView = findViewById(R.id.dos);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new adaptador(lstgamma);
        recyclerView.setAdapter(adapter);

    }
    public void quesada(){
        String urlApi ="https://ramiro.uttics.com/api/ganadores/";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, urlApi, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                RecyclerView lista =findViewById(R.id.dos);

                lista.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                Gson gson = new Gson();
                ganadores gn = gson.fromJson(String.valueOf(response),ganadores.class);
                adapter =new adaptador(gn.getData());

                lista.setAdapter(adapter);
            }
        },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        pancakes.add(request);
    }


   /* JsonObjectRequest peticion = new JsonObjectRequest(Request.Method.POST, url, jsonbody, new Response.Listener<JSONObject>() {
        @Override
        public void onResponse(JSONObject response) {

        }
    }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {

        }
    }){
        @Override
        public Map<String, String> getHeaders() throws AuthFailureError {
            HashMap<String,String> headers =new HashMap<String,String>();

            headers.put("aoi_key","leocouocoebnvnorvrvd");
            return headers;

        }
    };*/
}