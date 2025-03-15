package com.eab.petagram2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;



public class MainActivity extends AppCompatActivity {

    private MenuItem menuItem;

    private Toolbar miToolbar;
    private TabLayout miTablayout;
    private ViewPager  miViewPager;


    RecyclerView   ListaMascotas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        miToolbar=(Toolbar) findViewById(R.id.miActionBar);
        miTablayout=(TabLayout) findViewById(R.id.miTabLayout);
        miViewPager=(ViewPager) findViewById(R.id.miViewPager);

        if (miToolbar!= null) {
            setSupportActionBar(miToolbar);
            getSupportActionBar().setIcon(R.drawable.ic_pata);
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            getSupportActionBar().setTitle(getString(R.string.app_name));
            setSupportActionBar(miToolbar);
        }
            setUpViewPager();

/*
        ListaMascotas=(RecyclerView) findViewById(R.id.rvMascotas);
     //  + GridLayoutManager   LLM= new GridLayoutManager(this,2);
        LinearLayoutManager  LLM= new LinearLayoutManager(this);
        LLM.setOrientation(LinearLayoutManager.VERTICAL);
        ListaMascotas.setLayoutManager(LLM);
        InicializarListaMascotas();
        InicializarAdaptador();
*/
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu,menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()== R.id.mn_favoritos)
        {
            CambiaAFavoritos();
        }
        else if (item.getItemId()== R.id.mn_acerca_de) {
            CambiaAAcercaDe();
        }
        else if (item.getItemId()==R.id.mn_contacto) {
            CambiaAContacto();
        }
        else {
            Toast.makeText(this,"Seleccion "+String.valueOf(item.getItemId()),Toast.LENGTH_SHORT).show();

        }

        return super.onOptionsItemSelected(item);
    }


    private void CambiaAFavoritos(){
        Intent intent =new Intent(MainActivity.this, MasBuscados.class);
        startActivity(intent);

    }
    private void CambiaAAcercaDe(){
        Intent intent =new Intent(MainActivity.this, AcercaDe.class);
        startActivity(intent);

    }

    private void CambiaAContacto(){
        Intent intent =new Intent(MainActivity.this, Contacto.class);
        startActivity(intent);

    }
    private ArrayList<Fragment> agregarFragments(){
        ArrayList<androidx.fragment.app.Fragment> fragments=new ArrayList<>();
        fragments.add(new ListaMascotaFragment());

        fragments.add( new DetalleMascotaFragment());
        return fragments;
    }
    private void setUpViewPager(){
        miViewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragments()));
        miTablayout.setupWithViewPager(miViewPager);
        miTablayout.getTabAt(0).setIcon(R.drawable.ic_hueso1);
        miTablayout.getTabAt(1).setIcon(R.drawable.ic_pata);
    }

}