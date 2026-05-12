package unlar.edu.ar.StreamingMusicaTP.service;

import org.springframework.stereotype.Service;
import unlar.edu.ar.StreamingMusicaTP.model.Cancion;
import unlar.edu.ar.StreamingMusicaTP.model.Genero;
import unlar.edu.ar.StreamingMusicaTP.service.strategy.RecomendacionStrategy;
import unlar.edu.ar.StreamingMusicaTP.exception.ResourceNotFoundException;
import unlar.edu.ar.StreamingMusicaTP.exception.InvalidDataException;

import java.util.*;
import java.util.stream.Collectors;

@Service // Esto le dice a Spring que es un componente de lógica
public class StreamingService {

    private RecomendacionStrategy estrategia;

    public void setEstrategia(RecomendacionStrategy estrategia) {
        this.estrategia = estrategia;
    }

    public List<Cancion> ejecutarRecomendacion(List<Cancion> catalogo, Cancion base) {
        return estrategia.recomendar(catalogo, base);
    }

    // 1. Filtrado 
    public List<Cancion> filtrarCanciones(List<Cancion> catalogo, Genero genero, double ratingMinimo) {
        if (ratingMinimo < 0 || ratingMinimo > 5) {
        throw new InvalidDataException("El rating minimo debe estar entre 0.0 y 5.0. Valor recibido: " + ratingMinimo);
    }

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
    public Cancion obtenerArtistaMasPopular(List<Cancion> catalogo) {
        return catalogo.stream()
                .max(Comparator.comparingInt(c -> c.getReproducciones().get()))
                .orElseThrow(() -> new ResourceNotFoundException("No se pudo determinar el artista mas popular porque el catalogo está vacio."));
    }

    // 4. Distribucion por decadas
    public Map<Integer, List<Cancion>> agruparPorDecada(List<Cancion> catalogo) {
        return catalogo.stream()
                .collect(Collectors.groupingBy(c -> (c.getFechaLanzamiento().getYear() / 10) * 10));
    }
}