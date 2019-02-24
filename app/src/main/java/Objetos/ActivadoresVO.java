package Objetos;

public class ActivadoresVO {

    /**
     *
     * @param estado
     * @param fkIdeParcela
     * @param nombreParcela
     */
    public ActivadoresVO(String id, String estado, String fkIdeParcela, String nombreParcela){

        this.id				= id;
        this.nombreEstado	= obtenerNombreEstado(estado);
        this.estado 		= estado;
        this.fkIdeParcela 	= fkIdeParcela;
        this.nombreParcela 	= nombreParcela;
        this.checkedEstado  = obtenerEstadoChecked(estado);

    }

    private String id;

    private String checkedEstado;

    private String nombreEstado;

    private String estado;

    private String fkIdeParcela;

    private String nombreParcela;

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFkIdeParcela() {
        return fkIdeParcela;
    }

    public void setFkIdeParcela(String fkIdeParcela) {
        this.fkIdeParcela = fkIdeParcela;
    }

    public String getNombreParcela() {
        return nombreParcela;
    }

    public void setNombreParcela(String nombreParcela) {
        this.nombreParcela = nombreParcela;
    }

    public String getNombreEstado() {
        return nombreEstado;
    }

    public void setNombreEstado(String nombreEstado) {
        this.nombreEstado = nombreEstado;
    }


    public static String obtenerNombreEstado(String estado){

        String resultado = "";
        switch (estado) {
            case "0":
                resultado = "INACTIVO";
                break;
            case "1":
                resultado = "ACTIVO";
                break;

            default:
                break;
        }
        return resultado;
    }


    public static String obtenerEstadoChecked(String estado){

        String resultado = "";
        switch (estado) {
            case "0":
                resultado = "false";
                break;
            case "1":
                resultado = "true";
                break;

            default:
                break;
        }
        return resultado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCheckedEstado() {
        return checkedEstado;
    }

    public void setCheckedEstado(String checkedEstado) {
        this.checkedEstado = checkedEstado;
    }

}
