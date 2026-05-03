package unlar.edu.ar.StreamingMusicaTP.repository;

import org.springframework.stereotype.Repository;
import unlar.edu.ar.StreamingMusicaTP.model.Cancion;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CatalogoRepository {
    
    private final List<Cancion> canciones = new ArrayList<>();

    public List<Cancion> getCanciones() {
        return canciones;
    }

    public void guardar(Cancion cancion) {
        canciones.add(cancion);
    }
}