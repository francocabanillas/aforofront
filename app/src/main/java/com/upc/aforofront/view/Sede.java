package com.upc.aforofront.view;

public class Sede {

    private String id;
    private String nombre;
    private String direccion;
    private String latitud;
    private String longitud;
    private String aforo;
    private String idmarca;
    private String imagen;

    public Sede() {
    }

    public Sede(String id, String nombre, String direccion, String latitud, String longitud, String aforo, String idmarca, String imagen) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.latitud = latitud;
        this.longitud = longitud;
        this.aforo = aforo;
        this.idmarca = idmarca;
        this.imagen = imagen;
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

    public String getAforo() {
        return aforo;
    }

    public void setAforo(String aforo) {
        this.aforo = aforo;
    }

    public String getIdmarca() {
        return idmarca;
    }

    public void setIdmarca(String idmarca) {
        this.idmarca = idmarca;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
