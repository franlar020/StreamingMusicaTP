package unlar.edu.ar.StreamingMusicaTP.service.strategy;

import org.springframework.stereotype.Service;
import unlar.edu.ar.StreamingMusicaTP.model.Cancion;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecomendacionPorPopularidad implements RecomendacionStrategy {
    @Override
    public List<Cancion> recomendar(List<Cancion> catalogo, Cancion base) {
        return catalogo.stream()
                .sorted(Comparator.comparingInt((Cancion c) -> c.getReproducciones().get()).reversed())
                .limit(5)
                .collect(Collectors.toList());
    }
}