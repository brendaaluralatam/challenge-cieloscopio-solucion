package modelos;

import com.google.gson.annotations.SerializedName;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public class InformacionClima {
    @SerializedName("name")
    private String nombre;

    private LocalDateTime fechaDeSolicitud;
    @SerializedName("temp")
    private double temperaturaActual;
    @SerializedName("temp_min")
    private double temperaturaMinima;
    @SerializedName("temp_max")
    private double temperaturaMaxima;
    @SerializedName("description")
    private String condicionClimatica;



    public InformacionClima() {
    }

    public InformacionClima(String nombre,
                            double temperaturaActual,
                            double temperaturaMinima,
                            double temperaturaMaxima,
                            String condicionClimatica
                           ) {
        this.nombre = nombre;
        this.fechaDeSolicitud = LocalDateTime.now();
        this.temperaturaActual = temperaturaActual;
        this.temperaturaMinima = temperaturaMinima;
        this.temperaturaMaxima = temperaturaMaxima;
        this.condicionClimatica = condicionClimatica;

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

    @Override
    public String toString() {
        return "InformacionClima{" +
                "nombre='" + nombre + '\'' +
                ", fechaDeSolicitud=" + fechaDeSolicitud +
                ", temperaturaActual=" + temperaturaActual +
                ", temperaturaMinima=" + temperaturaMinima +
                ", temperaturaMaxima=" + temperaturaMaxima +
                ", condicionClimatica='" + condicionClimatica + '\'' +
                '}';
    }
}