package servicio;

import modelos.InformacionClima;
import utils.JSONUtils;

import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ServicioClima {
    private static final String API_KEY = "inserte-tu-clave-api-aquí";
    private static final String BASE_URL = "http://api.openweathermap.org/data/2.5/weather";
    public InformacionClima getWeatherData(String nombreCiudad) throws Exception {
        nombreCiudad = nombreCiudad.replace(" ", "+");
        String urlString = String.format("%s?q=%s&appid=%s&units=metric&lang=es", BASE_URL, nombreCiudad, API_KEY);
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        int responseCode = conn.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            return JSONUtils.parseWeatherData(nombreCiudad, JsonParser.parseString(response.toString()).getAsJsonObject());
        } else if(responseCode==HttpURLConnection.HTTP_NOT_FOUND){
            throw new IllegalArgumentException ("Ciudad no encontrada, nombre no válido");
        } else {
            throw new RuntimeException("Failed : HTTP error code : " + responseCode);
        }
    }
}
