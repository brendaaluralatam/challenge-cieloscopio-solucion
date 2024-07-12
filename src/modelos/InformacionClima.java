package modelos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public class InformacionClima {
    private String nombre;
    private LocalDateTime fechaDeSolicitud;
    private double temperaturaActual;
    private double temperaturaMinima;
    private double temperaturaMaxima;
    private String condicionClimatica;
    private double precipitacion;

    public InformacionClima() {
    }

    public InformacionClima(String nombre,
                            double temperaturaActual,
                            double temperaturaMinima,
                            double temperaturaMaxima,
                            String condicionClimatica,
                            double precipitacion) {
        this.nombre = nombre;
        this.fechaDeSolicitud = LocalDateTime.now();
        this.temperaturaActual = temperaturaActual;
        this.temperaturaMinima = temperaturaMinima;
        this.temperaturaMaxima = temperaturaMaxima;
        this.condicionClimatica = condicionClimatica;
        this.precipitacion = precipitacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDateTime getFechaDeSolicitud() {
        return fechaDeSolicitud;
    }

    public void setFechaDeSolicitud(LocalDateTime fechaDeSolicitud) {
        this.fechaDeSolicitud = fechaDeSolicitud;
    }

    public double getTemperaturaActual() {
        return temperaturaActual;
    }

    public void setTemperaturaActual(double temperaturaActual) {
        this.temperaturaActual = temperaturaActual;
    }

    public double getTemperaturaMinima() {
        return temperaturaMinima;
    }

    public void setTemperaturaMinima(double temperaturaMinima) {
        this.temperaturaMinima = temperaturaMinima;
    }

    public double getTemperaturaMaxima() {
        return temperaturaMaxima;
    }

    public void setTemperaturaMaxima(double temperaturaMaxima) {
        this.temperaturaMaxima = temperaturaMaxima;
    }

    public String getCondicionClimatica() {
        return condicionClimatica;
    }

    public void setCondicionClimatica(String condicionClimatica) {
        this.condicionClimatica = condicionClimatica;
    }

    public double getPrecipitacion() {
        return precipitacion;
    }

    public void setPrecipitacion(double precipitacion) {
        this.precipitacion = precipitacion;
    }

    @Override
    public String toString() {
        return "InformacionClima{" +
                "nombre='" + nombre + '\'' +
                ", fechaDeSolicitud=" + fechaDeSolicitud +
                ", temperaturaActual=" + temperaturaActual +
                ", temperaturaMinima=" + temperaturaMinima +
                ", temperaturaMaxima=" + temperaturaMaxima +
                ", condicionClimatica='" + condicionClimatica + '\'' +
                ", precipitacion=" + precipitacion +
                '}';
    }
}