package unlar.edu.ar.StreamingMusicaTP.service.strategy;

import org.springframework.stereotype.Service;
import unlar.edu.ar.StreamingMusicaTP.model.Cancion;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecomendacionPorGenero implements RecomendacionStrategy {
    @Override
    public List<Cancion> recomendar(List<Cancion> catalogo, Cancion base) {
        return catalogo.stream()
                .filter(c -> c.getGenero().equals(base.getGenero()))
                .filter(c -> !c.getId().equals(base.getId()))
                .sorted(Comparator.comparingDouble(Cancion::getRating).reversed())
                .collect(Collectors.toList());
    }
}