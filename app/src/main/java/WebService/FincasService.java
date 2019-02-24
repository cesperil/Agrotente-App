package WebService;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import Objetos.ActivadoresVO;
import Objetos.MedicionesVO;
import Objetos.ParcelasVO;
import Objetos.SolicitudAccesoVO;
import Objetos.UsuarioVO;

/**
 * Clase para gestionar las peticiones de login
 */
public class FincasService {

    public static final String REQ_PARCELAS_POR_USUARIO     = "parcelasInfo";

    public static final String REQ_PARCELAS_POR_ID		    = "parcelasIdInfo";

    public static final String REQ_MEDICIONES_PARCELA	    = "medParcelasInfo";

    public static final String REQ_ACTIVADORES_POR_USUARIO  = "activadoresInfo";

    public static final String REQ_SOLICITUDES_ACCESO_POR_USUARIO  = "solicitudesAccesoInfo";


    public static final String REQ_UPDATE_ESTADO_ACTIVADOR	     = "updateEstadoActivador";
    public static final String REQ_UPDATE_ESTADO_SOLICITUD_ACCESO= "updateEstadoSolicitudAcceso";

    /**
     *
     * @param idusuario
     * @return
     */
    public static List<ParcelasVO> getInformacionParcelas(String idusuario){
        Gson gson =  new Gson();
        String url = AgrotenteServices.urlIndependienteServicio+REQ_PARCELAS_POR_USUARIO+"="+ idusuario;
        AgrotenteServices agrotenteServices = new AgrotenteServices();
        String respuesta = agrotenteServices.getInfoServicio(url);
        Type collectionType = new TypeToken<Collection<ParcelasVO>>(){}.getType();
        Collection<ParcelasVO> enums = gson.fromJson(respuesta, collectionType);
        //List<ParcelasVO> listaParcelas = gson.fromJson(respuesta, ParcelasVO.class);
        List listaParcelas = new ArrayList(enums);
        return listaParcelas;
    }

    /**
     *
     * @param idParcela
     * @return
     */
    public static ParcelasVO getInformacionParcelaByIdParcela(String idParcela){
        Gson gson =  new Gson();
        String url = AgrotenteServices.urlIndependienteServicio+REQ_PARCELAS_POR_ID+"="+ idParcela;
        AgrotenteServices agrotenteServices = new AgrotenteServices();
        String respuesta = agrotenteServices.getInfoServicio(url);
        //Type collectionType = new TypeToken<Collection<ParcelasVO>>(){}.getType();
        //Collection<ParcelasVO> enums = gson.fromJson(respuesta, collectionType);
        ParcelasVO parcelas = gson.fromJson(respuesta, ParcelasVO.class);
        //List listaParcelas = new ArrayList(enums);
        return parcelas;
    }

    /**
     *
     * @param idParcela
     * @return
     */
    public static List<MedicionesVO> getInformacionMediciones(String idParcela){
        Gson gson =  new Gson();
        String url = AgrotenteServices.urlIndependienteServicio+REQ_MEDICIONES_PARCELA+"="+ idParcela;
        AgrotenteServices agrotenteServices = new AgrotenteServices();
        String respuesta = agrotenteServices.getInfoServicio(url);
        Type collectionType = new TypeToken<Collection<MedicionesVO>>(){}.getType();
        Collection<MedicionesVO> enums = gson.fromJson(respuesta, collectionType);
        List listaMediciones= new ArrayList(enums);
        return listaMediciones;
    }

    /**
     *
     * @param idParcela
     * @return
     */
    public static List<ActivadoresVO> getInformacionActivadores(String idParcela){
        Gson gson =  new Gson();
        String url = AgrotenteServices.urlIndependienteServicio+REQ_ACTIVADORES_POR_USUARIO+"="+ idParcela;
        AgrotenteServices agrotenteServices = new AgrotenteServices();
        String respuesta = agrotenteServices.getInfoServicio(url);
        Type collectionType = new TypeToken<Collection<ActivadoresVO>>(){}.getType();
        Collection<ActivadoresVO> enums = gson.fromJson(respuesta, collectionType);
        List listaActivadores = new ArrayList(enums);
        return listaActivadores;
    }



    public static String updateEstadoActivador(String id, boolean estado){
        String textoEstado = "";
        if(estado){
            textoEstado = "1";
        }else{
            textoEstado = "0";
        }
        String request = AgrotenteServices.urlIndependienteServicio+REQ_UPDATE_ESTADO_ACTIVADOR+"="+ id + "&estadoNuevo="+textoEstado;
        AgrotenteServices agrotenteServices = new AgrotenteServices();
        String respuesta = agrotenteServices.getInfoServicio(request);

        return respuesta;
    }

    /**
     *
     * @param idUsuario
     * @return
     */
    public static List<SolicitudAccesoVO> getInformacionSolicitudesAcceso(String idUsuario){
        Gson gson =  new Gson();
        String url = AgrotenteServices.urlIndependienteServicio+REQ_SOLICITUDES_ACCESO_POR_USUARIO+"="+ 1+ "&idUsuario=" + idUsuario;
        AgrotenteServices agrotenteServices = new AgrotenteServices();
        String respuesta = agrotenteServices.getInfoServicio(url);
        Type collectionType = new TypeToken<Collection<SolicitudAccesoVO>>(){}.getType();
        Collection<SolicitudAccesoVO> enums = gson.fromJson(respuesta, collectionType);
        List listaSolicitudesAcceso= new ArrayList(enums);
        return listaSolicitudesAcceso;
    }


    public static String updateEstadoSolicitudAcceso(String id, boolean estado){
        String textoEstado = "";
        if(estado){
            textoEstado = "1";
        }else{
            textoEstado = "2";
        }
        String request = AgrotenteServices.urlIndependienteServicio+REQ_UPDATE_ESTADO_SOLICITUD_ACCESO+"="+ id + "&estadoNuevo="+textoEstado;
        AgrotenteServices agrotenteServices = new AgrotenteServices();
        String respuesta = agrotenteServices.getInfoServicio(request);

        return respuesta;
    }

}
