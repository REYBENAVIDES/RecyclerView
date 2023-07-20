package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.recyclerview.Adaptadores.AdaptadorProductos;
import com.example.recyclerview.Modelos.classProductos;
import com.example.recyclerview.WebService.Asynchtask;
import com.example.recyclerview.WebService.WebService;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements Asynchtask {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.rcvItems);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //recyclerView.setItemAnimator(new DefaultItemAnimator());

        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService(
                "https://dummyjson.com/products",
                datos, MainActivity.this, MainActivity.this);
        ws.execute("GET");
    }

    @Override
    public void processFinish(String result)  {
        try {
            JSONObject jsonObject = new JSONObject(result);
            JSONArray jsonArray = new JSONArray(jsonObject.getString("products"));
            List<classProductos> lista_pro = new ArrayList<>();
            for (Integer j = 0; j < jsonArray.length(); j++) {
                JSONObject jsonObject1 = jsonArray.getJSONObject(j);
                lista_pro.add(new classProductos(jsonObject1));
            }
            AdaptadorProductos productos = new AdaptadorProductos(MainActivity.this, lista_pro);
            recyclerView.setAdapter(productos);
        }catch (Exception ex){
            Log.i("dddddddd",ex.getMessage());
        }
    }
}