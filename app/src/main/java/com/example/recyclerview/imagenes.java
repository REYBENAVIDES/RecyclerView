package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.recyclerview.Adaptadores.ImagenesAdapter;

public class imagenes extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagenes);

        try {
            Bundle bundle = this.getIntent().getExtras();
            //
            recyclerView = (RecyclerView) findViewById(R.id.resultados);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new GridLayoutManager(this,2));
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            //
            ImagenesAdapter imagenesAdapter = new ImagenesAdapter(this, bundle.getStringArrayList("IMAGENES"));
            recyclerView.setAdapter(imagenesAdapter);
        }catch (Exception ex){
            Log.i("ttttttt",ex.getMessage());
        }
    }
}