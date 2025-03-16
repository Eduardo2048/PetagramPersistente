package com.eab.petagrampersistente.vista;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eab.petagrampersistente.R;
import com.eab.petagrampersistente.adapter.MascotaAdapter;
import com.eab.petagrampersistente.pojo.Mascota;
import com.eab.petagrampersistente.presentador.IListaMascotaFrPresenter;
import com.eab.petagrampersistente.presentador.ListaMascotaFrPresenter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
// * Use the {@link ListaMascotaFragment#
newInstance} factory method to
 * create an instance of this fragment.
 */





public class ListaMascotaFragment extends Fragment implements IListaMascotaFrView {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
  /*  private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
*/

    private ArrayList<Mascota> mascotas;
    private RecyclerView rvMascotas;
    private IListaMascotaFrPresenter presenter;

    // TODO: Rename and change types of parameters
  /*  private String mParam1;
    private String mParam2;
*/
    public ListaMascotaFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_lista_mascota,container,false);
        rvMascotas=(RecyclerView) v.findViewById(R.id.rvMascotas);
        presenter = new ListaMascotaFrPresenter(this,getContext());
        return v;
    }



    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager LLM= new LinearLayoutManager(getActivity());
        LLM.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotas.setLayoutManager(LLM);
    }

    @Override
    public MascotaAdapter crearAdapter(ArrayList<Mascota> mascotas) {
        MascotaAdapter Adapter = new MascotaAdapter(mascotas,getActivity());
        return Adapter;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdapter adapter) {
        rvMascotas.setAdapter(adapter);
    }
}