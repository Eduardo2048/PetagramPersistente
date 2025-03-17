package com.eab.petagrampersistente.presentador;

import android.content.Context;

import com.eab.petagrampersistente.db.ConstructorDetalleMascota;
import com.eab.petagrampersistente.pojo.Mascota;
import com.eab.petagrampersistente.vista.IDetalleMascotaFrView;

import java.util.ArrayList;

public class DetalleMascotaFrPresenter implements IDetalleMascotaFrPresenter {
    private IDetalleMascotaFrView iDetalleMascotaFrView;
    private Context context;

    private ConstructorDetalleMascota constructorDetalleMascota;
    private ArrayList<Mascota> mascotas;


    public DetalleMascotaFrPresenter(IDetalleMascotaFrView iDetalleMascotaFrView, Context context) {
        this.iDetalleMascotaFrView = iDetalleMascotaFrView;
        this.context = context;
        obtenerDetalleMascota();
    }

    @Override
    public void obtenerDetalleMascota() {
        constructorDetalleMascota =new ConstructorDetalleMascota(context);
        mascotas = constructorDetalleMascota.obtenerListaDetalleMascotas();
        mostrarDetalleMascotasRV();
    }


    @Override
    public void mostrarDetalleMascotasRV() {
        iDetalleMascotaFrView.inicializarAdaptadorRV(iDetalleMascotaFrView.crearAdapter(mascotas));
        iDetalleMascotaFrView.generarGridLayout();
    }
}
