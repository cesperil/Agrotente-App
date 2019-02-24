package com.example.carlos.agrotente_desa;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;

//import com.getbase.floatingactionbutton.FloatingActionButton;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Objetos.ActivadoresVO;
import Objetos.MedicionesVO;
import Objetos.ParcelasVO;
import Utilidades.Constantes;
import WebService.FincasService;

public class RegistrosActivity extends AppCompatActivity {
    private final String ruta_fotos = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + "/misfotos/";
    private File file = new File(ruta_fotos);
    ListView listaRegistros;
    ListView listaActivadores;
    RegistrosAdapter mLeadsAdapter;
    ActivadoresAdapter mActivadoresAdapter;
    TabHost TbH;
    TextView tvCodMunicipio;
    TextView tvFechaAlta;
    TextView tvPoligono;
    TextView tvParcela;
    private GridView gridView;
   // private GridViewAdapter gridAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registros);

        TbH = (TabHost) findViewById(R.id.tabHost); //llamamos al Tabhost

        montarTabHost(TbH);
        String idParcela = getIntent().getExtras().getString(Constantes.ID_PARCELA);
        datosInformacion(idParcela);


        listaRegistros = (ListView) findViewById(R.id.listView);

        mLeadsAdapter = new RegistrosAdapter(getApplicationContext(),0, datosMediciones(idParcela));
        listaRegistros.setAdapter(mLeadsAdapter);

        listaActivadores = (ListView) findViewById(R.id.listView3);
        mActivadoresAdapter = new ActivadoresAdapter(getApplicationContext(),0, datosActivadores(idParcela));
        listaActivadores.setAdapter(mActivadoresAdapter);



    }




        //lista.setAdapter(mLeadsAdapter);

        /*
            cargar imagenes de la galeria
         */

       /* gridView = (GridView) findViewById(R.id.gridView);
        gridAdapter = new GridViewAdapter(this, R.layout.grid_item_layout, getData());
        gridView.setAdapter(gridAdapter);*/

        /*
        RegistrosFragment registrosFragment = (RegistrosFragment)
                getSupportFragmentManager().findFragmentById(R.id.registros_list);

        if (registrosFragment == null) {
            registrosFragment = RegistrosFragment.newInstance();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.registros_list, registrosFragment)
                    .commit();
        }
        */

       // final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
      /*  fab.setScaleX(0);
        fab.setScaleY(0);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            final Interpolator interpolador = AnimationUtils.loadInterpolator(getBaseContext(),
                    android.R.interpolator.fast_out_slow_in);

            fab.animate()
                    .scaleX(1)
                    .scaleY(1)
                    .setInterpolator(interpolador)
                    .setDuration(600)
                    .setStartDelay(1000)
                    .setListener(new Animator.AnimatorListener() {
                        @Override
                        public void onAnimationStart(Animator animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animator animation) {
                            fab.animate()
                                    .scaleY(0)
                                    .scaleX(0)
                                    .setInterpolator(interpolador)
                                    .setDuration(600)
                                    .start();
                        }

                        @Override
                        public void onAnimationCancel(Animator animation) {

                        }

                        @Override
                        public void onAnimationRepeat(Animator animation) {

                        }
                    });
        }*/
       /* final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.accion_favorito);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Se presionó el FAB Ultima semana", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        final FloatingActionButton fab2 = (FloatingActionButton) findViewById(R.id.accion_buscar);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Se presionó el FAB Ultimo mes", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        final FloatingActionButton fadCamara = (FloatingActionButton) findViewById(R.id.accion_camara);
        fadCamara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String file = ruta_fotos + getCode() + ".jpg";
                File mi_foto = new File( file );
                try {
                    mi_foto.createNewFile();
                } catch (IOException ex) {
                    Log.e("ERROR ", "Error:" + ex);
                }
                //
                Uri uri = Uri.fromFile( mi_foto );
                //Abre la camara para tomar la foto
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                //Guarda imagen
                cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
                //Retorna a la actividad
                startActivityForResult(cameraIntent, 0);



            }
        });





    }

    @SuppressLint("SimpleDateFormat")
    private String getCode()
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyymmddhhmmss");
        String date = dateFormat.format(new Date() );
        String photoCode = "pic_" + date;
        return photoCode;
    }

    /**
     * carga los datos de la pestania informacion
     */
    public void datosInformacion(String idParcela){

        ParcelasVO parcela = FincasService.getInformacionParcelaByIdParcela(idParcela);

        tvCodMunicipio  = (TextView) findViewById(R.id.tvValCodMunicipio);
        tvFechaAlta     = (TextView) findViewById(R.id.tvValFechaAlta);
        tvPoligono      = (TextView) findViewById(R.id.tvValPoligono);
        tvParcela       = (TextView) findViewById(R.id.tvValParcela);


        tvCodMunicipio.setText(parcela.getCodMunicipio());
        tvPoligono.setText(parcela.getPoligono());
        tvParcela.setText(parcela.getParcela());
        tvFechaAlta.setText(parcela.getFechaAlta());



    }

    /**
     * carga los datos de la pestania registros
     */
    public List<MedicionesVO>  datosMediciones(String idParcela){

        List<MedicionesVO> listaMediciones = FincasService.getInformacionMediciones(idParcela);


        return listaMediciones;
    }

    public void montarTabHost(TabHost TbH){
        TbH.setup();                                                         //lo activamos

        TabHost.TabSpec tab1 = TbH.newTabSpec("tab1");  //aspectos de cada Tab (pestaña)
        TabHost.TabSpec tab2 = TbH.newTabSpec("tab2");
        TabHost.TabSpec tab3 = TbH.newTabSpec("tab3");

        tab1.setIndicator("Registros");    //qué queremos que aparezca en las pestañas
        tab1.setContent(R.id.linearLayout); //definimos el id de cada Tab (pestaña)

        tab2.setIndicator("Parcela");
        tab2.setContent(R.id.linearLayout2);

        tab3.setIndicator("ON/OFF");
        tab3.setContent(R.id.linearLayout3);




        TbH.addTab(tab1); //añadimos los tabs ya programados
        TbH.addTab(tab2);
        TbH.addTab(tab3);

    }


    /**
     * carga los datos de la pestania ON/OFF
     */
    public List<ActivadoresVO>  datosActivadores(String idParcela){

        List<ActivadoresVO> listaActivadores= FincasService.getInformacionActivadores(idParcela);

        return listaActivadores;
    }




    /**
     * cesperilla_pendiente Implementar la busqueda de imganes
     */
    // Prepare some dummy data for gridview
    /*private ArrayList<ImageItem> getData() {
        final ArrayList<ImageItem> imageItems = new ArrayList<>();
        /*TypedArray imgs = getResources().obtainTypedArray(R.array.image_ids);
        for (int i = 0; i < imgs.length(); i++) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), imgs.getResourceId(i, -1));
            imageItems.add(new ImageItem(bitmap, "Image#" + i));
        }*/
      //  return imageItems;
    //}



}
