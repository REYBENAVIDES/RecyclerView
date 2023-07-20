package com.example.recyclerview.Modelos;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class classProductos {
    private String titulo;
    private String discripcion;
    private ArrayList<String> lstImagen;
    private String imagen;

    private String precio;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDiscripcion() {
        return discripcion;
    }

    public void setDiscripcion(String discripcion) {
        this.discripcion = discripcion;
    }

    public ArrayList<String> getLstImagen() {
        return lstImagen;
    }

    public void setLstImagen(ArrayList<String> lstImagen) {
        this.lstImagen = lstImagen;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public classProductos(JSONObject jsonObject) throws JSONException {
        titulo=jsonObject.getString("title");
        precio=jsonObject.getString("price");
        discripcion=jsonObject.getString("description");
        imagen=jsonObject.getString("thumbnail");
        JSONArray jsonArray =jsonObject.getJSONArray("images");
        List<String> lista=new ArrayList<>();
        for(int y=0;y<jsonArray.length();y++)
            lista.add(jsonArray.getString(y));
    }



}
