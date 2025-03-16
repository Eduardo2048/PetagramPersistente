package com.eab.petagrampersistente;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eab.petagrampersistente.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
// * Use the {@link ListaMascotaFragment#
newInstance} factory method to
 * create an instance of this fragment.
 */





public class ListaMascotaFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
  /*  private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
*/

    private ArrayList<Mascota> mascotas;
    private RecyclerView rvMascotas;

    // TODO: Rename and change types of parameters
  /*  private String mParam1;
    private String mParam2;
*/
    public ListaMascotaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
 //    * @param param1 Parameter 1.
  //   * @param param2 Parameter 2.
     * @return A new instance of fragment ListaMascotaFragment.
     */
    // TODO: Rename and change types and number of parameters
    /*
    public static ListaMascotaFragment newInstance(String param1, String param2) {
        ListaMascotaFragment fragment = new ListaMascotaFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }*/
/*
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
*/
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_lista_mascota,container,false);
        rvMascotas=(RecyclerView) v.findViewById(R.id.rvMascotas);

        //  + GridLayoutManager   LLM= new GridLayoutManager(this,2);
        LinearLayoutManager LLM= new LinearLayoutManager(getActivity());
        LLM.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotas.setLayoutManager(LLM);
        InicializarListaMascotas();
        InicializarAdaptador();


        return v;
    }
    private void InicializarAdaptador() {
        MascotaAdapter Adapter = new MascotaAdapter(mascotas,getActivity());
        rvMascotas.setAdapter(Adapter);
    }
    private void  InicializarListaMascotas()
    {
        mascotas=new ArrayList<Mascota>();
        mascotas.add(new Mascota(R.drawable.perro1,getResources().getString(R.string.perro1),3,R.drawable.ic_hueso1));
        mascotas.add(new Mascota(R.drawable.perro2,getResources().getString(R.string.perro2),1,R.drawable.ic_hueso1));
        mascotas.add(new Mascota(R.drawable.perro5,getResources().getString(R.string.perro5),6,R.drawable.ic_hueso1));
        mascotas.add(new Mascota(R.drawable.perro3,getResources().getString(R.string.perro3),1,R.drawable.ic_hueso1));
        mascotas.add(new Mascota(R.drawable.perro4,getResources().getString(R.string.perro4),4,R.drawable.ic_hueso1));
        mascotas.add(new Mascota(R.drawable.perro6,getResources().getString(R.string.perro6),3,R.drawable.ic_hueso1));
        mascotas.add(new Mascota(R.drawable.perro7,getResources().getString(R.string.perro7),2,R.drawable.ic_hueso1));
        mascotas.add(new Mascota(R.drawable.perro8,getResources().getString(R.string.perro8),5,R.drawable.ic_hueso1));


    }
}