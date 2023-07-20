package com.example.recyclerview.Adaptadores;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.recyclerview.Modelos.classProductos;
import com.example.recyclerview.R;

import java.util.ArrayList;
import java.util.List;

public class ImagenesAdapter  extends RecyclerView.Adapter<ImagenesViewHolder>{

    private Context Ctx;
    private ArrayList<String> lstimagenes;
    public ImagenesAdapter(Context mCtx, ArrayList<String> imagenes) {
        Log.i("rrrrrrrr",imagenes.get(0));
        this.lstimagenes = imagenes;
        Ctx=mCtx;
    }


    @NonNull
    @Override
    public ImagenesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(Ctx);
        View view = inflater.inflate(R.layout.item_galeria, null);
        return new ImagenesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImagenesViewHolder holder, int position) {

        Glide.with(Ctx)
                .load(lstimagenes.get(position))
                .into(holder.imegem);
    }

    @Override
    public int getItemCount() {
        return this.lstimagenes.size();
    }
}


class ImagenesViewHolder extends RecyclerView.ViewHolder {

    ImageView imegem;
    public ImagenesViewHolder(@NonNull View itemView) {
        super(itemView);
        imegem=itemView.findViewById(R.id.imgGaleria);
    }
}