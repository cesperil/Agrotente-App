package Objetos;

public class ParcelasVO {

    private String id;

    private String nombre;

    private String latitud;

    private String longitud;

    private String codMunicipio;

    private String poligono;

    private String parcela;

    private String fechaAlta;


    public ParcelasVO(String id, String nombre, String latitud, String longitud){
        this.id 		= id;
        this.nombre 	= nombre;
        this.latitud 	= latitud;
        this.longitud 	= longitud;
    }

    public ParcelasVO(String id, String nombre, String latitud, String longitud, String codMunicipio, String poligono, String parcela, String fechaAlta){
        this.id 		= id;
        this.nombre 	= nombre;
        this.latitud 	= latitud;
        this.longitud 	= longitud;
        this.codMunicipio = codMunicipio;
        this.poligono	= poligono;
        this.parcela	= parcela;
        this.fechaAlta	= fechaAlta;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(String fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String getCodMunicipio() {
        return codMunicipio;
    }

    public void setCodMunicipio(String codMunicipio) {
        this.codMunicipio = codMunicipio;
    }

    public String getPoligono() {
        return poligono;
    }

    public void setPoligono(String poligono) {
        this.poligono = poligono;
    }

    public String getParcela() {
        return parcela;
    }

    public void setParcela(String parcela) {
        this.parcela = parcela;
    }

}
