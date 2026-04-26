package unlar.edu.ar.StreamingMusicaTP.model;

import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor 

public class Album {
    private String id = UUID.randomUUID().toString();
    private String nombre;
    private String artista;
    private int anioLanzamiento;
    private List<Cancion> canciones;

}
