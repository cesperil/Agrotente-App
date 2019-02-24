package com.example.carlos.agrotente_desa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

import Objetos.ActivadoresVO;
import Objetos.SolicitudAccesoVO;
import Utilidades.Constantes;
import WebService.FincasService;


public class SolicitudesAccesoActivity extends AppCompatActivity {

    ListView           listaSolicitudes;
    SolicitudesAccesoAdapter solicitudesAccesoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitudes_acceso);

        final String idUsuario = getIntent().getExtras().getString(Constantes.ID_USUARIO);


        listaSolicitudes = (ListView) findViewById(R.id.listViewAccesos);
        solicitudesAccesoAdapter = new SolicitudesAccesoAdapter(getApplicationContext(),0, datosSolicitudesAcceso(idUsuario));
        listaSolicitudes.setAdapter(solicitudesAccesoAdapter);

    }

    /**
     * carga los datos de la pestania ON/OFF
     */
    public List<SolicitudAccesoVO> datosSolicitudesAcceso(String idUsuario){

        List<SolicitudAccesoVO> listaSolicitudes= FincasService.getInformacionSolicitudesAcceso(idUsuario);

        return listaSolicitudes;
    }
}
