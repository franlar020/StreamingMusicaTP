package unlar.edu.ar.StreamingMusicaTP.model;

import java.time.LocalDate;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

import lombok.*;

@Data
@NoArgsConstructor


public class Cancion {
    private String id = UUID.randomUUID().toString(); // Genera un ID único para cada canción 
    private String titulo;
    private String artista;
    private String album;
    private Genero genero;
    private int duracionSegundos; // Duración en segundos
    private AtomicInteger reproducciones = new AtomicInteger(0); // Contador de reproducciones
    private double rating; // Calificación promedio de la canción
    private LocalDate fechaLanzamiento; // Fecha de lanzamiento de la canción


    // Constructor manual para facilitar la creación de canciones con todos los atributos
    public Cancion(String id, String titulo, String artista, String album, Genero genero, int duracionSegundos, double rating, LocalDate fechaLanzamiento) {
        this.id = id;
        this.titulo = titulo;
        this.artista = artista;
        this.album = album;
        this.genero = genero;
        this.duracionSegundos = duracionSegundos;
        this.rating = rating;
        this.fechaLanzamiento = fechaLanzamiento;
}
}