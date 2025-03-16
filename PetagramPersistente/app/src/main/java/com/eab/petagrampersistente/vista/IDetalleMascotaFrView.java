package com.eab.petagrampersistente.vista;

import com.eab.petagrampersistente.adapter.MascotaAdapterDetalle;
import com.eab.petagrampersistente.pojo.Mascota;

import java.util.ArrayList;

public interface IDetalleMascotaFrView {
    public void generarGridLayout();
    public MascotaAdapterDetalle crearAdapter(ArrayList<Mascota> mascota);
    public void inicializarAdaptadorRV(MascotaAdapterDetalle adapter);
}
