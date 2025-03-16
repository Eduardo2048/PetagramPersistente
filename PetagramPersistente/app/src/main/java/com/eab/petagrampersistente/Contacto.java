package com.eab.petagrampersistente;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.eab.petagrampersistente.R;

public class Contacto extends AppCompatActivity {
    private Button SendMail;
    private TextView tv_Email;
    private TextView tv_Contacto;
    private TextView tv_Menasaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_contacto);
        Toolbar miToolbar=(Toolbar) findViewById(R.id.miActionBarCnt);
        setSupportActionBar(miToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setTitle(getString(R.string.app_name));


        setSupportActionBar(miToolbar);

        SendMail=(Button)findViewById(R.id.bt_mail);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }
@SuppressLint("ResourceType")
public void CambiaACorreo(View v)
{
    tv_Email=(TextView)findViewById(R.id.cnt_email);
    tv_Contacto=(TextView)findViewById(R.id.cnt_nombre);
    tv_Menasaje=(TextView)findViewById(R.id.cnt_menaje);

    String miNombre = String.valueOf(tv_Contacto.getText());
    String miMail=String.valueOf(tv_Email.getText());
    String miMensaje = String.valueOf(tv_Menasaje.getText());

    if (miNombre.isBlank()) {
        Toast.makeText(getApplicationContext(), getResources().getString(R.string.error_nombre), Toast.LENGTH_LONG).show();
    }
    else if (miMail.isBlank()) {
        Toast.makeText(getApplicationContext(), getResources().getString(R.string.error_mail), Toast.LENGTH_LONG).show();
    }
    else if (miMensaje.isBlank()) {
        Toast.makeText(getApplicationContext(), getResources().getString(R.string.error_mensaje), Toast.LENGTH_LONG).show();
    }
    else {
        Intent intent = new Intent(v.getContext(), Correo.class);

        intent.putExtra(getResources().getString(R.string.clave_email), miMail);
        intent.putExtra(getResources().getString(R.string.clave_mensaje), miMensaje);
        intent.putExtra(getResources().getString(R.string.clave_nomebre), miNombre);

        startActivity(intent);
    }
}


}

