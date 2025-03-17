package com.eab.petagrampersistente.presentador;

import android.content.Context;

import com.eab.petagrampersistente.db.ConstructorMascotas;
import com.eab.petagrampersistente.pojo.Mascota;
import com.eab.petagrampersistente.vista.IListaMascotaFrView;

import java.util.ArrayList;

public class ListaMascotaFrPresenter implements IListaMascotaFrPresenter{

    private IListaMascotaFrView iListaMascotaFrView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota>  mascotas;

    public ListaMascotaFrPresenter(IListaMascotaFrView iListaMascotaFrView, Context context) {
        this.iListaMascotaFrView = iListaMascotaFrView;
        this.context = context;
        obtenerListaMascotas();
    }

    @Override
    public void obtenerListaMascotas() {
        constructorMascotas =new ConstructorMascotas(context);
        mascotas=constructorMascotas.obtenerListaMascotas();
        mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {
        iListaMascotaFrView.inicializarAdaptadorRV(iListaMascotaFrView.crearAdapter(mascotas));
        iListaMascotaFrView.generarLinearLayoutVertical();
    }
}
