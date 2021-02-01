package com.upc.aforofront.recycler;

public class SedeAforo {

    private String id;
    private String nombre;
    private String direccion;
    private String referencia;
    private String latitud;
    private String longitud;
    private String idListado;

    public SedeAforo() {
    }

    public SedeAforo(String id, String nombre, String direccion, String referencia, String latitud, String longitud, String idListado) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.referencia = referencia;
        this.latitud = latitud;
        this.longitud = longitud;
        this.idListado = idListado;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
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

    public String getIdListado() {
        return idListado;
    }

    public void setIdListado(String idListado) {
        this.idListado = idListado;
    }
}
