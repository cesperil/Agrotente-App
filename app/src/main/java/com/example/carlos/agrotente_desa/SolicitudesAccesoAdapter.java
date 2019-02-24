package com.example.carlos.agrotente_desa;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.example.carlos.agrotente_desa.R;

import java.util.List;

import Objetos.SolicitudAccesoVO;
import WebService.FincasService;

public class SolicitudesAccesoAdapter extends ArrayAdapter<SolicitudAccesoVO> {

    public SolicitudesAccesoAdapter(Context context, int resource, List<SolicitudAccesoVO> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtener inflater.
        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // ¿Existe el view actual?
        if (null == convertView) {
            convertView = inflater.inflate(
                    R.layout.list_items_solicitudes_accesos,
                    parent,
                    false);
        }

        // Referencias UI.
        TextView texto      = (TextView) convertView.findViewById(R.id.textView);
        TextView textoSub   = (TextView) convertView.findViewById(R.id.textView2);
        Switch onoff        = (Switch) convertView.findViewById(R.id.switch1);

        // Lead actual.
        final SolicitudAccesoVO solicitudAccesoVO = getItem(position);

        // Setup.
        // Glide.with(getContext()).load(lead.getImage()).into(avatar);
        texto.setText(solicitudAccesoVO.getNombreUsuarioPeticion());
        textoSub.setText(solicitudAccesoVO.getNombreParcela());
        if(solicitudAccesoVO.getEstado().equals("0") || solicitudAccesoVO.getEstado().equals("2")){
            onoff.setChecked(false);
        }else{
            onoff.setChecked(true);
        }


        onoff.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.v("Switch State= ", " position " + solicitudAccesoVO.getId() + " checked "+isChecked);
                FincasService.updateEstadoSolicitudAcceso(solicitudAccesoVO.getId(), isChecked);
            }

        });


        return convertView;
    }

}
