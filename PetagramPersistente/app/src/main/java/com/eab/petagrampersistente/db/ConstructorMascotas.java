package com.eab.petagrampersistente.db;

import android.content.ContentValues;
import android.content.Context;

import com.eab.petagrampersistente.R;
import com.eab.petagrampersistente.pojo.Mascota;

import java.util.ArrayList;

public class ConstructorMascotas {
    private Context contexto;

    public ConstructorMascotas(Context contexto) {
        this.contexto = contexto;
    }

    public ArrayList<Mascota> obtenerListaMascotas() {
            /*
            ArrayList<Mascota> mascotas =new ArrayList<Mascota>();
            mascotas.add(new Mascota(R.drawable.perro1,String.valueOf(R.string.perro1),3));
            mascotas.add(new Mascota(R.drawable.perro2,String.valueOf(R.string.perro2),1));
            mascotas.add(new Mascota(R.drawable.perro5,String.valueOf(R.string.perro5),6));
            mascotas.add(new Mascota(R.drawable.perro3,String.valueOf(R.string.perro3),1));
            mascotas.add(new Mascota(R.drawable.perro4,String.valueOf(R.string.perro4),4));
            mascotas.add(new Mascota(R.drawable.perro6,String.valueOf(R.string.perro6),3));
            mascotas.add(new Mascota(R.drawable.perro7,String.valueOf(R.string.perro7),2));
            mascotas.add(new Mascota(R.drawable.perro8,String.valueOf(R.string.perro8),5));
                    return mascotas;
*/
        BaseDatos db = new BaseDatos(contexto);
        return db.obtenerListaMascotas();




    }

    public void incrementaLike (Mascota mascota){
        BaseDatos db = new BaseDatos(contexto);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesDB.TABLA_MASCOTAS_ID,mascota.getI_ID());
        contentValues.put(ConstantesDB.TABLA_MASCOTAS_LIKES,mascota.getI_Likes()+1);
        mascota.setI_Likes(db.incrementaLikes(contentValues));
    }
}
