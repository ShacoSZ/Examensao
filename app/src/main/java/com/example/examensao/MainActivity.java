package com.example.examensao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class MainActivity extends AppCompatActivity  {
public List<numeros_random> ran;
private RequestQueue obtain;
TextView scoresao,mensajin;
Button gvnumber,enviar;
int Numero;
int Sumador=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        obtain=SingletonRequest.getInstance(MainActivity.this).getRequestQueue();

        gvnumber=findViewById(R.id.pedirnum);
        enviar=findViewById(R.id.enviar);

    gvnumber.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            scoresao=findViewById(R.id.scoresao);
            mensajin=findViewById(R.id.mensajin);
            String url="https://ramiro.uttics.com/api/numero";
            JsonObjectRequest request =new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    Gson jueson =new Gson();
                    numeros_random numero =jueson.fromJson(response.toString(), numeros_random.class);
                    Numero=numero.getNumero();
                    Sumador=Sumador+Numero;
                    scoresao.setText(""+Sumador);
                    if(Sumador==21)
                    {
                        mensajin.setText("Has Ganado");
                        gvnumber.setEnabled(false);
                    }
                    else if(Sumador>21)
                    {
                        mensajin.setText("Te has pasado de 21, has perdido");
                        gvnumber.setEnabled(false);
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    error.printStackTrace();
                }
            });
            obtain.add(request);
        }
    });

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://ramiro.uttics.com/api/enviarnumero";
                JSONObject jsonBody = new JSONObject();
                JSONObject array =new JSONObject();
                try {
                    jsonBody.put("nombre","Salazar");
                    jsonBody.put("numero","" + Sumador);
//                    jsonBody.put("urlImg","imagen");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                try {
                    array.put("persona", jsonBody);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                JsonObjectRequest Enviasao = new JsonObjectRequest(Request.Method.POST, url,array, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Toast.makeText(MainActivity.this,"Su Puntuacion ha sido enviada UwU",Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this,"Hubo un Error al Enviar los datos UnU",Toast.LENGTH_SHORT).show();
                        error.printStackTrace();
                    }
                });
                obtain.add(Enviasao);
            }
        });
    }
    public void resultado(View v)
    {
        Intent Resultado=new Intent(this,Second_Activisao.class);
        startActivity(Resultado);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}