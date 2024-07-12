package servicio;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import modelos.Ciudad;
import modelos.datos.DatosCiudad;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class SolicitudGeolocalizacion {
    /*
        EJEMPLO DE SOLICITUD GEOLOCALIZACION:

        http://api.openweathermap.org/geo/1.0/direct?
        q={city name},{state code},{country code}&limit={limit}&appid={API key}
    */

    private Gson objetoGson;
    private String direccionGeo = "http://api.openweathermap.org/geo/1.0/direct?";
    private String claveApi;

    public SolicitudGeolocalizacion(String claveApi) {
        this.objetoGson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
            .setPrettyPrinting()
            .create();

        this.claveApi = claveApi;
    }

    public Ciudad obtenerCiudad(String nombreCiudad){
        Ciudad ciudadEncontrada = null;

        // Ajuste en el nombre (de tipo string) pensando en la querie de solicitud
        nombreCiudad = nombreCiudad.replace(" ", "+");

        if (!nombreCiudad.isEmpty()){
            String direccionGeolocalizacion = this.direccionGeo + "q=" + nombreCiudad + "&limit=1&appid=" + this.claveApi;

            /* Solicitud de geolocalización */
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest solicitudGeolocalizacion = HttpRequest.newBuilder()
                    .uri(URI.create(direccionGeolocalizacion))
                    .build();
            HttpResponse<String> respuestaGeolocalizacion = null;

            try {
                respuestaGeolocalizacion = client
                        .send(solicitudGeolocalizacion, HttpResponse.BodyHandlers.ofString());
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }

            String respuestaJson = respuestaGeolocalizacion.body();
            //System.out.println(respuestaJson);

            // Una manera sencilla de obtener el primero objeto json de la respuesta
            respuestaJson = respuestaJson.replace("[", "");
            respuestaJson = respuestaJson.replace("]", "");

            DatosCiudad datosCiudad = objetoGson.fromJson(respuestaJson, DatosCiudad.class);
            if(datosCiudad!=null)
                ciudadEncontrada = new Ciudad(nombreCiudad, datosCiudad);
        }

        return ciudadEncontrada;
    }
}
