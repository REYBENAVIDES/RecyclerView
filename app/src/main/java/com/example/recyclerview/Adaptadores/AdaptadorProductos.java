package com.example.recyclerview.Adaptadores;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.recyclerview.Modelos.classProductos;
import com.example.recyclerview.R;
import com.example.recyclerview.imagenes;

import java.util.List;

public class AdaptadorProductos extends RecyclerView.Adapter<ProductoViewHolder>{
    private Context Ctx;
    private List<classProductos> lstProductos;


    public AdaptadorProductos(Context mCtx, List<classProductos> productos) {
        this.lstProductos = productos;
        Ctx=mCtx;
    }


    @NonNull
    @Override
    public ProductoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(Ctx);
        View view = inflater.inflate(R.layout.item_productos, null);
        return new ProductoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductoViewHolder holder, int position) {
        classProductos productos = lstProductos.get(position);
        holder.txtTitulo.setText(productos.getTitulo());
        holder.txtDescripcion.setText(productos.getDiscripcion());
        holder.txtPrecio.setText(productos.getPrecio());
        Glide.with(Ctx)
                .load(productos.getImagen())
                .into(holder.imageView);

        holder.itemView.getRootView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Ctx, imagenes.class);
                Bundle b = new Bundle();
                b.putStringArrayList("IMAGENES", productos.getLstImagen());
                intent.putExtras(b);
                Ctx.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return this.lstProductos.size();
    }
}

class ProductoViewHolder extends RecyclerView.ViewHolder {

    TextView txtTitulo, txtPrecio, txtDescripcion;
    ImageView imageView;

    public ProductoViewHolder(View itemView) {
        super(itemView);
        txtTitulo = itemView.findViewById(R.id.txtTitulo);
        txtPrecio = itemView.findViewById(R.id.txtPrecio);
        txtDescripcion = itemView.findViewById(R.id.txtDescripcion);
        imageView = itemView.findViewById(R.id.imgPortada);
    }
}