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

import java.util.List;

import Objetos.ActivadoresVO;
import Objetos.MedicionesVO;
import WebService.FincasService;

/**
 * Created by Carlos on 13/09/2018.
 */
public class ActivadoresAdapter extends ArrayAdapter<ActivadoresVO> {


    public ActivadoresAdapter(Context context, int resource, List<ActivadoresVO> objects) {
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
                    R.layout.list_item_activadores,
                    parent,
                    false);
        }

        // Referencias UI.
        TextView texto        = (TextView) convertView.findViewById(R.id.textView);
        Switch   onoff        = (Switch) convertView.findViewById(R.id.switch1);

        // Lead actual.
        final ActivadoresVO activadoresVO = getItem(position);

        // Setup.
       // Glide.with(getContext()).load(lead.getImage()).into(avatar);
        texto.setText(activadoresVO.getNombreParcela());
        if(activadoresVO.getEstado().equals("0")){
            onoff.setChecked(false);
        }else{
            onoff.setChecked(true);
        }


        onoff.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.v("Switch State= ", " position " + activadoresVO.getId() + " checked "+isChecked);
                FincasService.updateEstadoActivador(activadoresVO.getId(), isChecked);
            }

        });


        return convertView;
    }



}
