package principal;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import modelos.InformacionClima;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Principal {
    private static final String API_KEY = "tu-api-key";
    private static final String BASE_URL = "http://api.openweathermap.org/data/2.5/weather";

    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner lectura = new Scanner(System.in);
        var respuesta = 0;
        while (respuesta != 7) {
            System.out.println(
                    "\nChallenge Cieloscopio: \n" +
                            "------------------------------------\n" +
                            "Elige una ciudad para obtener los datos meteorológicos: \n" +
                            "1. Ciudad de México  \n" +
                            "2. Buenos Aires \n" +
                            "3. Bogotá \n" +
                            "4. Lima \n" +
                            "5. Santiago \n" +
                            "6. Deseo consultar otra ciudad \n" +
                            "7. Salir \n" +
                            "------------------------------------"
            );

            System.out.println("Elige una opción basada en el numero: ");
            respuesta = Integer.parseInt(lectura.nextLine());

            switch (respuesta) {
                case 1 -> busquedaDatosPorCiudad("Ciudad de México");
                case 2 -> busquedaDatosPorCiudad("Buenos Aires");
                case 3 -> busquedaDatosPorCiudad("Bogotá");
                case 4 -> busquedaDatosPorCiudad("Lima");
                case 5 -> busquedaDatosPorCiudad("Santiago");
                case 6 -> {
                    //Nombre de la ciudad ingresado por el usuario
                    System.out.println("Escriba el nombre de una ciudad: ");
                    var busquedaCiudad = lectura.nextLine();
                    busquedaDatosPorCiudad(busquedaCiudad);
                }
                case 7 -> {
                    System.out.println("Saliendo del programa Cieloscopio, hasta luego...");
                    break;
                }
                default -> {
                    System.out.println("Opción no válida, inténtalo de nuevo.\n");
                }
            }
        }
    }

    public static void busquedaDatosPorCiudad(String ciudad) throws IOException, InterruptedException {
        // Reemplaza los espacios en el nombre de la ciudad para que se pueda usar en la URL correctamente
        ciudad = ciudad.replace(" ", "+");
        String direccion = BASE_URL + String.format("?q=%s&appid=%s&units=metric&lang=es", ciudad, API_KEY);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();
        System.out.println(json);

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();

        JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();

        String nombreCiudad = jsonObject.get("name").getAsString();
        double temperaturaActual = jsonObject.getAsJsonObject("main").get("temp").getAsDouble();
        double temperaturaMinima = jsonObject.getAsJsonObject("main").get("temp_min").getAsDouble();
        double temperaturaMaxima = jsonObject.getAsJsonObject("main").get("temp_max").getAsDouble();
        String condicionClimatica = jsonObject.getAsJsonArray("weather").get(0).getAsJsonObject().get("description").getAsString();

        InformacionClima respuestaInformacion = new InformacionClima(nombreCiudad, temperaturaActual, temperaturaMinima, temperaturaMaxima, condicionClimatica);
        presentarRespuesta(respuestaInformacion);
    }

    public static void presentarRespuesta(InformacionClima respuesta) {
        DateTimeFormatter formatterDay = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatterHour = DateTimeFormatter.ofPattern("HH:mm");

        String respuestaEnTexto = "--------------------------\n" +
                "Respuesta: \n" +
                "Ciudad: " + respuesta.getNombre() + "\n" +
                "Fecha: " + respuesta.getFechaDeSolicitud().format(formatterDay) + "\n" +
                "Horario: " + respuesta.getFechaDeSolicitud().format(formatterHour) + "\n" +
                "\n" +
                "Temperatura actual: " + respuesta.getTemperaturaActual() + "\n" +
                "Condición climática: " + respuesta.getCondicionClimatica() + "\n" +
                "\n" +
                "Temperatura mínima: " + respuesta.getTemperaturaMinima() + "\n" +
                "Temperatura máxima: " + respuesta.getTemperaturaMaxima() + "\n" +
                "--------------------------";
        System.out.println(respuestaEnTexto);
    }
}
