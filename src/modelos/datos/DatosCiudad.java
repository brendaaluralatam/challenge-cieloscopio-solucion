package modelos.datos;

import com.google.gson.annotations.SerializedName;

public record DatosCiudad(
        @SerializedName("lat") double latitud,
        @SerializedName("lon") double longitud
    )
{
}