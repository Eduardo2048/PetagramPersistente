package com.eab.petagrampersistente;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.eab.petagrampersistente.R;

import org.w3c.dom.Text;

public class Correo extends AppCompatActivity {
    private TextView tv_Email;
    private TextView tv_Contacto;
    private TextView tv_Mensaje;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String miNombre="Error !";
        String miEmail ="Error !";
                String miMensaje="Error !";

        //EdgeToEdge.enable(this);
        setContentView(R.layout.correo);
        Toolbar miToolbar=(Toolbar) findViewById(R.id.miActionBarCorreo);
        setSupportActionBar(miToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setTitle(getString(R.string.app_name));

        Bundle Data = getIntent().getExtras();

        if (Data!= null)
        {
              miNombre = Data.getString(getResources().getString(R.string.clave_nomebre));
             miEmail = Data.getString(getResources().getString(R.string.clave_email));
             miMensaje = Data.getString(getResources().getString(R.string.clave_mensaje));
        }




       // Toast.makeText(getApplicationContext(),miNombre,Toast.LENGTH_LONG).show();
        tv_Email=(TextView) findViewById(R.id.email_contacto);
        tv_Email.setText(miEmail);
        tv_Contacto=(TextView)findViewById(R.id.nombre_contacto);
        tv_Contacto.setText(miNombre);
        tv_Mensaje=(TextView)findViewById(R.id.contenido_contacto);
        tv_Mensaje.setText(miMensaje);
        setSupportActionBar(miToolbar);


    }
}
