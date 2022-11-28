package com.example.examensao;

public class ListaGanadores {
    private String nombre;
    private String numero;
    private String urlImg;

    public ListaGanadores(String Nombre,String Cantidad,String urlImg)
    {
        this.nombre=nombre;
        this.numero=numero;
        this.urlImg=urlImg;
    }

    public String getNombre() {return nombre;}

    public void setNombre(String nombre) {nombre = nombre;}

    public String getCantidad() {return numero;}

    public void setCantidad(String numero) {numero = numero;}

    public String getUrlImg() {return urlImg;}

    public void setUrlImg(String urlImg) {this.urlImg = urlImg;}
}
