package unlar.edu.ar.StreamingMusicaTP.model;

import java.util.List;
import java.util.UUID;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Productora {
    private String id = UUID.randomUUID().toString(); // Genera un ID unico para cada productora
    private String nombre;
    private List<Album> albumes; // Lista de albumes asociados a la productora
}
