package com.eab.petagrampersistente.presentador;

import android.content.Context;

import com.eab.petagrampersistente.db.ConstructorDetalleMascota;
import com.eab.petagrampersistente.db.ConstructorMasBuscados;
import com.eab.petagrampersistente.pojo.Mascota;
import com.eab.petagrampersistente.vista.IMasBuscadosView;

import java.util.ArrayList;

public class MasBuscadosPresenter implements IMasBuscadosPresenter {

    private IMasBuscadosView iMasBuscadosView;
    private Context context;
    private ConstructorMasBuscados constructorMasBuscados;

    private ArrayList<Mascota> mascotasArrayList;

    public MasBuscadosPresenter(IMasBuscadosView iMasBuscadosView, Context context) {
        this.iMasBuscadosView = iMasBuscadosView;
        this.context = context;
        obtenerListaMasBuscados();
    }


    @Override
    public void obtenerListaMasBuscados() {
        constructorMasBuscados =new ConstructorMasBuscados(context);
        mascotasArrayList = constructorMasBuscados.obtenerMasBuscados();
        mostrarMasBuscadosRV();


    }

    @Override
    public void mostrarMasBuscadosRV() {
        iMasBuscadosView.inicializarAdaptadorRV(iMasBuscadosView.crearAdapter(mascotasArrayList));
        iMasBuscadosView.generarLinearLayoutVertical();

    }
}
