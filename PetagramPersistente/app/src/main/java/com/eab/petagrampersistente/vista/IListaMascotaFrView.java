package com.eab.petagrampersistente.vista;

import com.eab.petagrampersistente.adapter.MascotaAdapter;
import com.eab.petagrampersistente.pojo.Mascota;

import java.util.ArrayList;

public interface IListaMascotaFrView {
    public void generarLinearLayoutVertical();
    public MascotaAdapter crearAdapter(ArrayList<Mascota> mascota);
    public void inicializarAdaptadorRV(MascotaAdapter adapter);
}
