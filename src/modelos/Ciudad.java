package modelos;

import modelos.datos.DatosCiudad;

public class Ciudad {
    private String nombre;
    private double latitud;
    private double longitud;

    public Ciudad() {
    }

    public Ciudad(String nombre, Double latitud, Double longitud) {
        this.nombre = nombre;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public Ciudad(String nombre, DatosCiudad datosCiudad){
        this.nombre = nombre;
        this.latitud = datosCiudad.latitud();
        this.longitud = datosCiudad.longitud();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    @Override
    public String toString() {
        return "Ciudad {" +
                "nombre='" + nombre + '\'' +
                ", latitud=" + latitud +
                ", longitud=" + longitud +
                '}';
    }
}
