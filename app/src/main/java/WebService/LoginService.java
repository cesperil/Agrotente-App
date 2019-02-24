package WebService;

import com.google.gson.Gson;

import org.json.JSONObject;

import java.lang.reflect.Type;

import Objetos.UsuarioVO;

/**
 * Clase para gestionar las peticiones de login
 */
public class LoginService {

    public static final String REQ_INFORMACION_USUARIO 	= "userInfo";
    public static final String REQ_UPDATE_TOKEN_FCM		= "updateTokenFCM";

    public static String getInformacionUsuario(String usuario, String password){
        UsuarioVO usuarioVO = new UsuarioVO(usuario, password);
        Gson gson =  new Gson();
        String json =  gson.toJson(usuarioVO);
        String request = AgrotenteServices.urlIndependienteServicio+REQ_INFORMACION_USUARIO+"="+ json;
        AgrotenteServices agrotenteServices = new AgrotenteServices();
        String respuesta = agrotenteServices.getInfoServicio(request);

        return respuesta;
    }


    /**
     * Actualiza el valor del token para notificaciones push segun id usuario
     * @param idUsuario
     * @param token
     * @return
     */
    public static String updateTokenFCMUsuario(String idUsuario, String token){
        /*UsuarioVO usuarioVO = new UsuarioVO(usuario, password);
        Gson gson =  new Gson();
        String json =  gson.toJson(usuarioVO);*/
        String request = AgrotenteServices.urlIndependienteServicio+REQ_UPDATE_TOKEN_FCM+"=1&idUsuario="+idUsuario+"&tokenFCM="+token;
        AgrotenteServices agrotenteServices = new AgrotenteServices();
        String respuesta = agrotenteServices.getInfoServicio(request);

        return respuesta;
    }

}
