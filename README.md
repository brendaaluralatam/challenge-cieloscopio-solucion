# Cieloscopio

## Descripción

Cieloscopio es un proyecto Java que utiliza los fundamentos de Java y la programación orientada a objetos (POO), junto con el uso de dos bibliotecas para manipular archivos en formato JSON: Gson y Json.

El objetivo y enfoque principal del proyecto es practicar los fundamentos de Java y POO y realizar el consumo de API de datos meteorológicos para la previsión del clima para una o más ciudades, presentando datos como temperatura, precipitación y condición climática, etc.

La [API OpenWeather](https://openweathermap.org/api), también conocida como OpenWeatherMap, es un servicio popular que proporciona datos meteorológicos actualizados e históricos. Ofrece una amplia gama de información meteorológica para desarrolladores que desean incorporar datos del clima en sus aplicaciones, sitios web o servicios. Esta es la API que usamos en este proyecto.

Este proyecto se utiliza como la primera parte (de dos partes) del primer desafío del primer Bootcamp Java de Alura Latam. Este código no se presenta a los alumnos, solo se muestra la interacción con el terminal en un video de presentación del *challenge*.

## Estructura

- El proyecto solo realiza consultas en la API, es decir, realiza solicitudes del tipo `GET` utilizando la clase `HttpRequest` y más clases relacionadas en el contexto del proyecto hecho con Java.
- Luego, los datos se presentan en el terminal de la IDE, no se utiliza interfaz gráfica ni aplicación web para presentar los datos. Esta elección se hizo para mantener el enfoque en ejercitar **los fundamentos de Java** pensando en el contexto de un usuario principiante en programación, especialmente programación *backend*.
- El proyecto consulta **cinco atributos de la API**: temperatura actual, temperatura mínima (del día), temperatura máxima (del día), condición climática (del día) y precipitación (del día); cabe señalar que dependiendo de la ubicación (ciudad) y la condición climática del día, no es posible obtener el valor de la precipitación del día.
- El proyecto primero realiza la solicitud de geolocalización para obtener los datos de latitud y longitud de la ciudad, la solicitud se hace con base en el nombre de la ciudad y devuelve el primer resultado obtenido. Luego realiza la solicitud de los datos meteorológicos con la latitud y longitud obtenidas: solicitud [Current weather data](https://openweathermap.org/current) presente en el **plan gratuito**. 
- En el menú del proyecto tenemos cinco ciudades fijas (ejemplos de capitales presentes en América del Sur) y una opción donde es posible ingresar el nombre de otra ciudad para consultar los datos del clima.

## Tecnologías Utilizadas

- Java, versión 17: https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html
- Biblioteca Gson, versión 2.10.1 (en formato .jar): https://mvnrepository.com/artifact/com.google.code.gson/gson
- Biblioteca JSON, versión 20230618 (en formato .jar): https://jar-download.com/artifacts/org.json/json
- Intellij Community (opcional): https://www.jetbrains.com/idea/download/?section=windows
- API Open Weather App: https://openweathermap.org/api

## Flujo de ejecución

Menú presentado durante la ejecución del proyecto:

```
Challenge Cieloscopio: 
------------------------------------
Elige una ciudad para obtener los datos meteorológicos: 
1. Ciudad de México  
2. Buenos Aires 
3. Bogotá 
4. Lima 
5. Santiago 
6. Deseo consultar otra ciudad 
7. Salir 
------------------------------------
```

- Ejemplo 01 - Elegir una ciudad ya disponible en el menú:

```
Elige una opción basada en el número: 
```

En este caso, vamos a ingresar el número 1 para acceder a los datos de Ciudad de México (con base en las opciones del menú). El proyecto devuelve estos atributos como resultado:

```
--------------------------
Respuesta: 
Ciudad: Ciudad de México
Fecha: 24/05/2024
Horario: 17:18

Temperatura actual: 30.7
Condición climática: nubes dispersas

Temperatura mínima: 30.5
Temperatura máxima: 32.23
Precipitación: valor no informado
--------------------------
```

- Ejemplo 02 - Ingresar el nombre de una ciudad no disponible en el menú:

```
Escriba el nombre de una ciudad:
```

En este caso, vamos a ingresar el nombre Natal, para acceder a los datos de la ciudad brasileña llamada Natal. El proyecto devuelve estos atributos como resultado:

```
--------------------------
Respuesta: 
Ciudad: Natal
Fecha: 24/05/2024
Horario: 17:19

Temperatura actual: 25.11
Condición climática: muy nuboso

Temperatura mínima: 25.11
Temperatura máxima: 25.36
Precipitación: valor no informado
--------------------------
```

- Ejemplo 03 - El usuario desea salir del programa (ingresa el número 7 después de la ejecución del proyecto) y antes de que el proyecto se cierre, se devuelve este texto de respuesta/despedida:

```
Saliendo del programa Cieloscopio, hasta luego...
```

## Pruebas

Las pruebas realizadas fueron simples y se centraron en la ejecución del menú, por lo que se presentan algunos ejemplos relacionados con el menú:

- Ejemplo 01 - El usuario ingresa una opción no válida en el menú:

```
Opción no válida, inténtalo de nuevo.
```

- Ejemplo 02 - El usuario ingresa una ciudad no presente en la API o una ciudad inexistente:

```
Ciudad no encontrada, inténtalo de nuevo.
```

## Implementación

Para implementar este proyecto localmente es necesario:

- Tener Java instalado en su máquina;
- Abrir este proyecto Java en la IDE de su preferencia;
- Verificar si las bibliotecas Gson y JSON están añadidas al proyecto, si no es así, es posible realizar la descarga y añadirlas manualmente en la parte de añadir archivos externos .jar en el proyecto Java;
- Crear una cuenta en el sitio web de la API y obtener su clave de API (recuerde: no comparta públicamente la clave, mantenga su uso de forma individual y personal);
- Añadir su clave de API en el lugar indicado del proyecto en la clase `Principal` y ejecutar el proyecto.
- ¡Listo! Ahora puedes usar las opciones del menú o implementar nuevas opciones según desee.

## Ejecución

Para ejecutar este proyecto localmente basta con crear el archivo .jar del proyecto Java. Para generar un archivo JAR (Java ARchive) de un proyecto Java, puedes seguir diferentes métodos dependiendo de las herramientas y entornos de desarrollo que estés utilizando.

Aquí están los pasos básicos para generar un JAR usando herramientas comunes como la línea de comando, IDEs como Eclipse e IntelliJ IDEA.

### Usando la Línea de Comando (javac y jar)

1. **Compila tu código**: Navega hasta el directorio donde se encuentra tu código fuente y compila los archivos `.java` a `.class` usando el comando `javac`.

   ```
   bash
   Copiar código
   javac -d out src/com/tuProyecto/*.java
   ```

   En este ejemplo, los archivos `.java` están en la carpeta `src/com/tuProyecto` y los archivos `.class` generados se colocarán en la carpeta `out`.

2. **Crea el archivo JAR**: Usa el comando `jar` para crear el archivo JAR a partir de los archivos `.class` compilados.

   ```
   bash
   Copiar código
   jar cvf miProyecto.jar -C out .
   ```

   Este comando crea un archivo JAR llamado `miProyecto.jar` que contiene todos los archivos `.class` del directorio `out`.

### Usando Eclipse

1. Exportar como JAR:
   - Haz clic derecho en el proyecto en la pestaña Project Explorer.
   - Selecciona `Export` y luego `Java > JAR file`.
   - Elige los recursos que deseas exportar y el lugar donde deseas guardar el archivo JAR.
   - Configura las opciones de exportación según sea necesario y haz clic en `Finish`.

### Usando IntelliJ IDEA

1. Crear Artefacto:
   - Ve a `File > Project Structure`.
   - En la pestaña `Artifacts`, haz clic en `+` y selecciona `JAR > From modules with dependencies`.
   - Selecciona el módulo principal de tu proyecto y configura las opciones según sea necesario.
   - Haz clic en `OK` y luego en `Apply`.
2. Construir el Artefacto:
   - Ve a `Build > Build Artifacts` y selecciona el artefacto que acabas de crear.
   - Haz clic en `Build` para generar el archivo JAR.

Pero recuerda que también es posible agregar herramientas de construcción como Maven y Gradle al proyecto y crear el `.jar` utilizándolas también.

## Autores

Brenda Souza y Luis Ezequiel Puig (Scubas/Monitores *backend* de Alura Latam).

## Más información

Proyecto implementado en mayo de 2024.

## Licencia

Este proyecto está disponible bajo la licencia [MIT License](https://github.com/brendaaluralatam/challenge-cieloscopio?tab=MIT-1-ov-file).