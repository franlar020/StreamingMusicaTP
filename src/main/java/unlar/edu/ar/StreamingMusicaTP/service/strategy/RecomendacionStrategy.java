package unlar.edu.ar.StreamingMusicaTP.service.strategy;

import unlar.edu.ar.StreamingMusicaTP.model.Cancion;
import java.util.List;

public interface RecomendacionStrategy {
    List<Cancion> recomendar(List<Cancion> catalogo, Cancion base);
}