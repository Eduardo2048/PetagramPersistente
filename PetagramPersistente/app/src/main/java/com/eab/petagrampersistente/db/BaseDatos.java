package com.eab.petagrampersistente.db;

import static com.eab.petagrampersistente.db.ConstantesDB.DATABASE_NAME;
import static com.eab.petagrampersistente.db.ConstantesDB.DATABASE_VERSION;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.eab.petagrampersistente.R;
import com.eab.petagrampersistente.pojo.Mascota;

import java.util.ArrayList;

public class BaseDatos extends SQLiteOpenHelper {
    private Context context;

    public BaseDatos(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearDB = "CREATE  TABLE " + ConstantesDB.TABLA_MASCOTAS + " (" +
                ConstantesDB.TABLA_MASCOTAS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesDB.TABLA_MASCOTAS_FOTO + " INTEGER , " +
                ConstantesDB.TABLA_MASCOTAS_NOMBRE + " TEXT, " +
                ConstantesDB.TABLA_MASCOTAS_LIKES + " INTEGER )";

        String queryNroMascotas = "SELECT COUNT ( * ) FROM " + ConstantesDB.TABLA_MASCOTAS;

        db.execSQL(queryCrearDB);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST " + ConstantesDB.TABLA_MASCOTAS);
        onCreate(db);
    }

    public ArrayList<Mascota> obtenerListaMascotas() {
        ArrayList<Mascota> mascotas = new ArrayList<>();


        String queryGetMascotas = "SELECT * FROM " + ConstantesDB.TABLA_MASCOTAS;
        SQLiteDatabase db = this.getReadableDatabase();
        //insertarMascotas();
        Cursor registro = db.rawQuery(queryGetMascotas, null);
        while (registro.moveToNext()) {
            Mascota mascotaActual = new Mascota();
            mascotaActual.setI_ID(registro.getInt(ConstantesDB.REGISTRO_ID));
            mascotaActual.setI_Imagen(registro.getInt(ConstantesDB.REGISTRO_FOTO));
            mascotaActual.setS_Name(registro.getString(ConstantesDB.REGISTRO_NOMBRE));
            mascotaActual.setI_Likes(registro.getInt(ConstantesDB.REGISTRO_LIKES));
            mascotas.add(mascotaActual);
        }
       db.close();
        return mascotas;
    }


    private void insertarMascota(ContentValues contentValues) {

        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesDB.TABLA_MASCOTAS,null,contentValues);
        db.close();
    }
    private void insertarUnaMascota( int Foto, String Nombre, int Likes){
        ContentValues contentValues =new ContentValues();
        contentValues.put(ConstantesDB.TABLA_MASCOTAS_FOTO,Foto);
        contentValues.put(ConstantesDB.TABLA_MASCOTAS_NOMBRE,Nombre);
        contentValues.put(ConstantesDB.TABLA_MASCOTAS_LIKES,Likes);
        insertarMascota(contentValues);

    }
    public void insertarMascotas () {


        SQLiteDatabase db = this.getWritableDatabase();
        String queryNroMascotas = "SELECT COUNT (*) FROM "+ConstantesDB.TABLA_MASCOTAS ;
        Cursor registro = db.rawQuery(queryNroMascotas,null);
        registro.moveToNext();
        //Si la cuenta de registros en nula, inserto los registros.
        if (registro.getInt(0)==0)
            {
                insertarUnaMascota(R.drawable.perro1,context.getResources().getString(R.string.perro1),0);
                insertarUnaMascota(R.drawable.perro2,context.getResources().getString(R.string.perro2),0);
                insertarUnaMascota(R.drawable.perro3,context.getResources().getString(R.string.perro3),0);
                insertarUnaMascota(R.drawable.perro4,context.getResources().getString(R.string.perro4),0);
                insertarUnaMascota(R.drawable.perro5,context.getResources().getString(R.string.perro5),0);
                insertarUnaMascota(R.drawable.perro6,context.getResources().getString(R.string.perro6),0);
                insertarUnaMascota(R.drawable.perro7,context.getResources().getString(R.string.perro7),0);
                insertarUnaMascota(R.drawable.perro8,context.getResources().getString(R.string.perro8),0);

            }
        db.close();

    }

    public int incrementaLikes (ContentValues contentValues){
        int myLike=0;
        SQLiteDatabase db = this.getWritableDatabase();
        String queryUpdateLike = "UPDATE "+ConstantesDB.TABLA_MASCOTAS +
                " SET "+ConstantesDB.TABLA_MASCOTAS_LIKES+ " = "+
                String.valueOf( contentValues.getAsInteger(ConstantesDB.TABLA_MASCOTAS_LIKES)) +
                " WHERE "+ConstantesDB.TABLA_MASCOTAS_ID+" = "+
                String.valueOf(contentValues.getAsInteger(ConstantesDB.TABLA_MASCOTAS_ID));

        String queryLeeLike= "SELECT * FROM " + ConstantesDB.TABLA_MASCOTAS +
                " WHERE  "+ConstantesDB.TABLA_MASCOTAS_ID+" = "+
                String.valueOf(contentValues.getAsInteger(ConstantesDB.TABLA_MASCOTAS_ID));

        //db.rawQuery(queryUpdateLike,null);
        db.execSQL(queryUpdateLike);
        Cursor registro = db.rawQuery(queryLeeLike, null);
        registro.moveToNext();
        myLike=registro.getInt(ConstantesDB.REGISTRO_LIKES);
        db.close();
        return myLike;
    }


        public ArrayList<Mascota> obtenerMasBuscados() {
        ArrayList<Mascota> mascotas = new ArrayList<>();
        int NroMascotas = 0;


        String queryGetMasBuscados = "SELECT * FROM " + ConstantesDB.TABLA_MASCOTAS +
                " ORDER BY "+ ConstantesDB.TABLA_MASCOTAS_LIKES+
                " DESC";

        SQLiteDatabase db = this.getReadableDatabase();
       // insertarMascotas();
        Cursor registro = db.rawQuery(queryGetMasBuscados, null);
        while (registro.moveToNext() && NroMascotas++<5) {
            Mascota mascotaActual = new Mascota();
            mascotaActual.setI_ID(registro.getInt(ConstantesDB.REGISTRO_ID));
            mascotaActual.setI_Imagen(registro.getInt(ConstantesDB.REGISTRO_FOTO));
            mascotaActual.setS_Name(registro.getString(ConstantesDB.REGISTRO_NOMBRE));
            mascotaActual.setI_Likes(registro.getInt(ConstantesDB.REGISTRO_LIKES));
            mascotas.add(mascotaActual);
        }
        db.close();
        return mascotas;
    }
}
