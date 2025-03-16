package com.eab.petagrampersistente;

public class Mascota {
private int i_Imagen;
private String s_Name;
private int i_Likes;

//private int i_Hueso;

    public Mascota(int i_Imagen, String s_Name, int i_Likes ) {
        this.i_Imagen = i_Imagen;
        this.s_Name = s_Name;
        this.i_Likes = i_Likes;
        //this.i_Hueso = i_Hueso;
    }

    //public int getI_Hueso() {
     //   return i_Hueso;
   // }

    //public void setI_Hueso(int i_Hueso) {
    //    this.i_Hueso = i_Hueso;
   // }

    public int getI_Imagen() {
        return i_Imagen;
    }

    public void setI_Imagen(int i_Imagen) {
        this.i_Imagen = i_Imagen;
    }

    public int getI_Likes() {
        return i_Likes;
    }

    public void setI_Likes(int i_Likes) {
        this.i_Likes = i_Likes;
    }

    public String getS_Name() {
        return s_Name;
    }

    public void setS_Name(String s_Name) {
        this.s_Name = s_Name;
    }
}
