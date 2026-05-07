package unlar.edu.ar.StreamingMusicaTP.service.strategy;

import org.springframework.stereotype.Service;
import unlar.edu.ar.StreamingMusicaTP.model.Cancion;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecomendacionDescubrimiento implements RecomendacionStrategy {
    @Override
    public List<Cancion> recomendar(List<Cancion> catalogo, Cancion base) {
        LocalDate haceDosAnios = LocalDate.now().minusYears(2);
        return catalogo.stream()
                .filter(c -> c.getReproducciones().get() < 1000)
                .filter(c -> c.getFechaLanzamiento().isAfter(haceDosAnios))
                .filter(c -> !c.getGenero().equals(base.getGenero()))
                .collect(Collectors.toList());
    }
}