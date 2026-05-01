package unlar.edu.ar.StreamingMusicaTP.service;

import org.springframework.stereotype.Service;
import unlar.edu.ar.StreamingMusicaTP.model.Cancion;
import unlar.edu.ar.StreamingMusicaTP.model.Genero;
import java.util.*;
import java.util.stream.Collectors;

@Service // Esto le dice a Spring que es un componente de lógica
public class StreamingService {

    // 1. Filtrado 
    public List<Cancion> filtrarCanciones(List<Cancion> catalogo, Genero genero, double ratingMinimo) {
        return catalogo.stream()
                .filter(c -> c.getGenero().equals(genero))
                .filter(c -> c.getRating() >= ratingMinimo)
                .collect(Collectors.toList());
    }

    // 2. Top 10 
    public List<Cancion> obtenerTop10(List<Cancion> catalogo) {
        return catalogo.stream()
                .sorted(Comparator.comparingInt((Cancion c) -> c.getReproducciones().get()).reversed())
                .limit(10)
                .collect(Collectors.toList());
    }

    // 3. Artista más popular
    public Optional<Cancion> obtenerArtistaMasPopular(List<Cancion> catalogo) {
        return catalogo.stream()
                .max(Comparator.comparingInt(c -> c.getReproducciones().get()));
    }

    // 4. Distribucion por decadas
    public Map<Integer, List<Cancion>> agruparPorDecada(List<Cancion> catalogo) {
        return catalogo.stream()
                .collect(Collectors.groupingBy(c -> (c.getFechaLanzamiento().getYear() / 10) * 10));
    }
}