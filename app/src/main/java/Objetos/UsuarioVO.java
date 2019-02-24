package Objetos;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class UsuarioVO {

    public UsuarioVO(){

    }

    public UsuarioVO(String user, String pass) {
        setPass(pass);
        setUser(user);
    }

    private String user;

    private String pass;


    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
