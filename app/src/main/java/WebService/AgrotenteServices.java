package WebService;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.IBinder;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import Utilidades.Utilidades;


/**
 * Clase para enviar peticiones rest al servicio
 */
public class AgrotenteServices {

    private static String URL_SERVICIO = "http://192.168.1.14:8084/Agrotente";

    private static String SERVICIO_APP   = "app=1";
    private static String SERVICIO_LOGIN = "login";

    public static String urlIndependienteServicio = URL_SERVICIO + "/" + SERVICIO_LOGIN + "?"
            + SERVICIO_APP + "&";

    String resultadoJSON =  "";


    //llamada a servicio recibiendo cadena json
    public  String getInfoServicio(final String request){

        resultadoJSON =  "";
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                // All your networking logic
                // should be here
                // Create URL
                URL githubEndpoint = null;
                try {
                    githubEndpoint = new URL(request);
                    Log.i("aaaaaaaaa",   "Direcccion: " + request );
                    HttpURLConnection myConnection =
                            (HttpURLConnection) githubEndpoint.openConnection();


                    if (myConnection.getResponseCode() == 200) {
                        // Success
                        InputStream responseBody = myConnection.getInputStream();
                        InputStreamReader responseBodyReader =
                                new InputStreamReader(responseBody, "UTF-8");
                        String respuesta = Utilidades.readFromStream(responseBody);
                        Log.i("Respuesta del Servicio ",   respuesta);
                        resultadoJSON = respuesta;
                    }


                } catch (MalformedURLException e1) {
                    e1.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

        while (resultadoJSON.equals("")) {

        }

        return resultadoJSON;

    }

}
