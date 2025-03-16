package com.eab.petagrampersistente;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eab.petagrampersistente.R;

import java.util.ArrayList;



public class DetalleMascotaFragment extends Fragment {


    private ArrayList<Mascota> mascotas;
    private RecyclerView rvMascotas;

    public DetalleMascotaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_detalle_mascota, container, false);
        rvMascotas = (RecyclerView) v.findViewById(R.id.rvMascotasDetalle);

        GridLayoutManager GLM = new GridLayoutManager(getContext(), 3);

        rvMascotas.setLayoutManager(GLM);
        InicializarListaMascotas();
        InicializarAdaptador();


        return v;
    }

    private void InicializarAdaptador() {
        MascotaAdapterDetalle Adapter = new MascotaAdapterDetalle(mascotas, getActivity());
        rvMascotas.setAdapter(Adapter);
    }

    private void InicializarListaMascotas() {
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota(R.drawable.perro1, getResources().getString(R.string.perro1), 3));
        mascotas.add(new Mascota(R.drawable.perro2, getResources().getString(R.string.perro2), 1));
        mascotas.add(new Mascota(R.drawable.perro5, getResources().getString(R.string.perro5), 6));
        mascotas.add(new Mascota(R.drawable.perro3, getResources().getString(R.string.perro3), 1));
        mascotas.add(new Mascota(R.drawable.perro4, getResources().getString(R.string.perro4), 4));
        mascotas.add(new Mascota(R.drawable.perro6, getResources().getString(R.string.perro6), 3));
        mascotas.add(new Mascota(R.drawable.perro7, getResources().getString(R.string.perro7), 2));
        mascotas.add(new Mascota(R.drawable.perro8, getResources().getString(R.string.perro8), 5));


    }
}
