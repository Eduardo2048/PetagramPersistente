package com.eab.petagrampersistente.vista;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.eab.petagrampersistente.R;
import com.eab.petagrampersistente.adapter.MascotaAdapter;
import com.eab.petagrampersistente.pojo.Mascota;
import com.eab.petagrampersistente.presentador.IMasBuscadosPresenter;
import com.eab.petagrampersistente.presentador.MasBuscadosPresenter;

import java.util.ArrayList;

public class MasBuscados extends AppCompatActivity  implements IMasBuscadosView {

    ArrayList<Mascota> mascotas;
    RecyclerView rvMasBuscadas;

    IMasBuscadosPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.mas_buscados);
       Toolbar miToolbar=(Toolbar) findViewById(R.id.miActionBarMB);
        setSupportActionBar(miToolbar);
        getSupportActionBar().setIcon(R.drawable.ic_pata);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setTitle(getString(R.string.app_name));


        setSupportActionBar(miToolbar);


        rvMasBuscadas =(RecyclerView) findViewById(R.id.rvMascotasMB);
        presenter=new MasBuscadosPresenter(this,getApplicationContext()) ;

      ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mas_buscados), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


    }


    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager LLM= new LinearLayoutManager(this);
        LLM.setOrientation(LinearLayoutManager.VERTICAL);
        rvMasBuscadas.setLayoutManager(LLM);
    }

    @Override
    public MascotaAdapter crearAdapter(ArrayList<Mascota> mascotas) {
        MascotaAdapter Adapter = new MascotaAdapter(mascotas,this);
        return Adapter;
  
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdapter adapter) {
        rvMasBuscadas.setAdapter(adapter);
    }
}
