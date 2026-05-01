package unlar.edu.ar.StreamingMusicaTP.service;

import org.springframework.stereotype.Service;
import unlar.edu.ar.StreamingMusicaTP.model.Cancion;
import unlar.edu.ar.StreamingMusicaTP.model.Genero;
import java.util.*;

@Service
public class BusquedaOrdenamientoService {

    // 1. Busqueda binaria por titulo (Requiere lista preordenada)
    public int busquedaBinariaPorTitulo(List<Cancion> canciones, String tituloBuscado) {
        // Primero ordenamos por título como pide el PDF
        canciones.sort(Comparator.comparing(Cancion::getTitulo, Comparator.naturalOrder()));
        
        // Creamos una canción "dummy" solo con el titulo para que binarySearch compare
        Cancion dummy = new Cancion();
        dummy.setTitulo(tituloBuscado);
        
        return Collections.binarySearch(canciones, dummy, Comparator.comparing(Cancion::getTitulo));
    }

    // 2. Ordenamiento personalizado (Artista -> Fecha Lanzamiento -> Invertido)
    public void ordenarPersonalizado(List<Cancion> canciones) {
        canciones.sort(
            Comparator.comparing(Cancion::getArtista)
                      .thenComparing(Cancion::getFechaLanzamiento)
                      .reversed() //
        );
    }

    // 3. Busqueda lineal con predicados multiples
    public List<Cancion> busquedaLinealPredicados(List<Cancion> canciones, Genero genero, int anioMin, double ratingMin) {
        List<Cancion> resultados = new ArrayList<>();
        for (Cancion c : canciones) {
            // Aplicamos los 3 predicados: Genero AND Año > X AND Rating > Y
            if (c.getGenero().equals(genero) && 
                c.getFechaLanzamiento().getYear() > anioMin && 
                c.getRating() > ratingMin) {
                resultados.add(c);
            }
        }
        return resultados;
    }
}