package principal;

import modelos.Ciudad;
import modelos.InformacionClima;
import servicio.ServicioClima;

import java.io.IOException;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;

public class Principal {
    static Ciudad ciudadEncontrada;
    public static void presentarRespuesta(InformacionClima respuesta){
        DateTimeFormatter formatterDay = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatterHour = DateTimeFormatter.ofPattern("HH:mm");

        String precipitacion = null;
        if(respuesta.getPrecipitacion() != -1.0){
            precipitacion = String.valueOf(respuesta.getPrecipitacion());
        } else {
            precipitacion = "valor no informado";
        }

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
                "Precipitación: " + precipitacion + "\n" +
                "--------------------------";
        System.out.println(respuestaEnTexto);
    }
    public static void obtenerDatosMeteorologicos(String nombreCiudad){
        ServicioClima weatherService = new ServicioClima();
        try {
            InformacionClima weatherData = weatherService.getWeatherData(nombreCiudad);
            presentarRespuesta(weatherData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void busquedaDatosPorCiudad(String nombreCiudad){
        //Solicitud principal
        if(nombreCiudad!=null){
            obtenerDatosMeteorologicos(nombreCiudad);
        } else {
            System.out.println("Ciudad no encontrada, inténtalo de nuevo.");
        }
    }
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner lectura = new Scanner(System.in);
        var respuesta = 0;
        while(respuesta!=7){
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

            switch(respuesta){
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
}