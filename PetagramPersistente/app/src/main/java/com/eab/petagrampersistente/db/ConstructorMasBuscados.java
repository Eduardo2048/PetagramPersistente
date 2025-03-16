package com.eab.petagrampersistente.db;
import android.content.Context;
import com.eab.petagrampersistente.R;
import com.eab.petagrampersistente.pojo.Mascota;

import java.util.ArrayList;

public class ConstructorMasBuscados {
    private Context context;

    public ConstructorMasBuscados(Context context) {
        this.context = context;
    }
    public ArrayList<Mascota> obtenerMasBuscados() {

        ArrayList<Mascota> mascotas =new ArrayList<Mascota>();
        mascotas.add(new Mascota(R.drawable.perro1,String.valueOf(R.string.perro1),3));
        mascotas.add(new Mascota(R.drawable.perro2,String.valueOf(R.string.perro2),1));
        mascotas.add(new Mascota(R.drawable.perro5,String.valueOf(R.string.perro5),6));
        mascotas.add(new Mascota(R.drawable.perro3,String.valueOf(R.string.perro3),1));
        mascotas.add(new Mascota(R.drawable.perro8,String.valueOf(R.string.perro8),5));
        return mascotas;



    }
}
