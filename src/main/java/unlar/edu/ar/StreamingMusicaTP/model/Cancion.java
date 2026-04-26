package unlar.edu.ar.StreamingMusicaTP.model;

import java.time.LocalDate;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Cancion {
    private String id = UUID.randomUUID().toString(); // Genera un ID único para cada canción 
    private String titulo;
    private String artista;
    private String album;
    private int duracionSegundos; // Duración en segundos
    private AtomicInteger reproducciones = new AtomicInteger(0); // Contador de reproducciones
    private double rating; // Calificación promedio de la canción
    private LocalDate fechaLanzamiento; // Fecha de lanzamiento de la canción
}
