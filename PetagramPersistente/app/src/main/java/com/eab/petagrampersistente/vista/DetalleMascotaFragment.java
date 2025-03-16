package com.eab.petagrampersistente.vista;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eab.petagrampersistente.MascotaAdapterDetalle;
import com.eab.petagrampersistente.R;
import com.eab.petagrampersistente.pojo.Mascota;
import com.eab.petagrampersistente.presentador.DetalleMascotaFrPresenter;
import com.eab.petagrampersistente.presentador.IDetalleMascotaFrPresenter;

import java.util.ArrayList;



public class DetalleMascotaFragment extends Fragment implements IDetalleMascotaFrView {


    private ArrayList<Mascota> mascotas;
    private RecyclerView rvMascotas;

    private IDetalleMascotaFrPresenter presenter;

    public DetalleMascotaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_detalle_mascota, container, false);
        rvMascotas = (RecyclerView) v.findViewById(R.id.rvMascotasDetalle);
        presenter = new DetalleMascotaFrPresenter(this,getContext());
        return v;
    }




    @Override
    public void generarGridLayout() {

        GridLayoutManager GLM = new GridLayoutManager(getContext(), 3);
        rvMascotas.setLayoutManager(GLM);
    }

    @Override
    public MascotaAdapterDetalle crearAdapter(ArrayList<Mascota> mascotas) {
        MascotaAdapterDetalle adapter  = new MascotaAdapterDetalle(mascotas, getActivity());
        return adapter;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdapterDetalle adapter) {

        rvMascotas.setAdapter(adapter);
    }
}
