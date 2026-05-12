package unlar.edu.ar.StreamingMusicaTP.service;

import org.springframework.stereotype.Service;
import unlar.edu.ar.StreamingMusicaTP.model.Cancion;
import unlar.edu.ar.StreamingMusicaTP.model.Genero;
import java.util.*;

@Service
public class BusquedaOrdenamientoService {

    // 1. Busqueda binaria por titulo (Requiere lista preordenada)
    public int busquedaBinariaPorTitulo(List<Cancion> canciones, String tituloBuscado) {
    // 1. Primero ordenamos la lista por título
    canciones.sort(Comparator.comparing(Cancion::getTitulo));

    int inicio = 0;
    int fin = canciones.size() - 1;

    while (inicio <= fin) {
        int medio = inicio + (fin - inicio) / 2;
        String tituloMedio = canciones.get(medio).getTitulo();

        int comparacion = tituloMedio.compareToIgnoreCase(tituloBuscado);

        if (comparacion == 0) {
            return medio; // Encontrado
        }
        if (comparacion < 0) {
            inicio = medio + 1;
        } else {
            fin = medio - 1;
        }
    }
    return -1; // No encontrado
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