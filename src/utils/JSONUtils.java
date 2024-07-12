package utils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import modelos.InformacionClima;
import com.google.gson.JsonObject;

public class JSONUtils {
    public static InformacionClima parseWeatherData(String nombreCiudad, JsonObject jsonResponse) {
        Gson gson = new Gson();

        JsonObject main = jsonResponse.getAsJsonObject("main");
        JsonArray weatherArray = jsonResponse.getAsJsonArray("weather");
        JsonObject weather = weatherArray.get(0).getAsJsonObject();

        double temperaturaActual = 0.0;
        double temperaturaMinima = 0.0;
        double temperaturaMaxima = 0.0;
        String condicionClimatica = null;
        double precipitacion = -1;

        temperaturaActual = main.getAsJsonPrimitive("temp").getAsDouble();
        temperaturaMinima = main.getAsJsonPrimitive("temp_min").getAsDouble();
        temperaturaMaxima = main.getAsJsonPrimitive("temp_max").getAsDouble();

        condicionClimatica = weather.getAsJsonPrimitive("description").getAsString();

        if(jsonResponse.has("rain")){
            JsonObject rain = jsonResponse.getAsJsonObject("rain");
            if(rain!=null) precipitacion = rain.getAsJsonPrimitive("1h").getAsDouble(); //valor en mm (en la última hora)
        }

        nombreCiudad = nombreCiudad.replace("+", " ");
        return new InformacionClima(
                nombreCiudad,
                temperaturaActual,
                temperaturaMinima,
                temperaturaMaxima,
                condicionClimatica,
                precipitacion
        );
    }
}