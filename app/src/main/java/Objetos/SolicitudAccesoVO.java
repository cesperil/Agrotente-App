package Objetos;

public class SolicitudAccesoVO {

    private String  id;
    private String  nombreUsuarioPeticion;
    private String  estado;
    private String  idParcela;
    private String  nombreParcela;

    public SolicitudAccesoVO (String id, String nombreUsuarioPeticion, String estado, String idParcela, String nombreParcela){
        this.id                    = id;
        this.nombreUsuarioPeticion = nombreUsuarioPeticion;
        this.estado                = estado;
        this.idParcela             = idParcela;
        this.nombreParcela         = nombreParcela;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreUsuarioPeticion() {
        return nombreUsuarioPeticion;
    }

    public void setNombreUsuarioPeticion(String nombreUsuarioPeticion) {
        this.nombreUsuarioPeticion = nombreUsuarioPeticion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getIdParcela() {
        return idParcela;
    }

    public void setIdParcela(String idParcela) {
        this.idParcela = idParcela;
    }

    public String getNombreParcela() {
        return nombreParcela;
    }

    public void setNombreParcela(String nombreParcela) {
        this.nombreParcela = nombreParcela;
    }



}
