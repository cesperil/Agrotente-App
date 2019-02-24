package com.example.carlos.agrotente_desa;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import Objetos.MedicionesVO;

/**
 * Created by Carlos on 13/09/2018.
 */
public class RegistrosAdapter extends ArrayAdapter<MedicionesVO> {


    public RegistrosAdapter(Context context, int resource, List<MedicionesVO> objects) {
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
                    R.layout.list_item_registros,
                    parent,
                    false);
        }

        // Referencias UI.
        TextView min        = (TextView) convertView.findViewById(R.id.tv_min);
        TextView max        = (TextView) convertView.findViewById(R.id.tv_max);
        TextView tipoSensor = (TextView) convertView.findViewById(R.id.tv_tipo);
        TextView hora       = (TextView) convertView.findViewById(R.id.tv_hora);

        // Lead actual.
        MedicionesVO medicionesVO = getItem(position);

        // Setup.
       // Glide.with(getContext()).load(lead.getImage()).into(avatar);
        max.setText(medicionesVO.getMax());
        min.setText(medicionesVO.getMin());
        tipoSensor.setText(medicionesVO.getSensor());
        hora.setText(medicionesVO.getFechaAlta());

        return convertView;
    }



}
