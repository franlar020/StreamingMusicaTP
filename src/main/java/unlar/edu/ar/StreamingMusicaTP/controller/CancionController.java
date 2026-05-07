package unlar.edu.ar.StreamingMusicaTP.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unlar.edu.ar.StreamingMusicaTP.model.Cancion;
import unlar.edu.ar.StreamingMusicaTP.model.Genero;
import unlar.edu.ar.StreamingMusicaTP.repository.CatalogoRepository;
import unlar.edu.ar.StreamingMusicaTP.service.*;
import unlar.edu.ar.StreamingMusicaTP.service.strategy.*;

import unlar.edu.ar.StreamingMusicaTP.service.StreamingService;
import unlar.edu.ar.StreamingMusicaTP.service.BusquedaOrdenamientoService;
import unlar.edu.ar.StreamingMusicaTP.service.ReproduccionService;
import unlar.edu.ar.StreamingMusicaTP.service.strategy.RecomendacionPorGenero;

import java.util.List;

@RestController
@RequestMapping("/api/canciones")
public class CancionController {

    @Autowired
    private CatalogoRepository repository;
    @Autowired
    private ReproduccionService reproduccionService;
    @Autowired
    private StreamingService streamingService;
    @Autowired
    private BusquedaOrdenamientoService busquedaService;
    @Autowired
    private RecomendacionPorGenero estrategiaGenero;


    // GET /api/canciones (Listar todas)
    @GetMapping
    public List<Cancion> listarTodas() {
        return repository.getCanciones();
    }

    // GET /api/canciones/{id} (Buscar por ID)
    @GetMapping("/{id}")
    public ResponseEntity<Cancion> buscarPorId(@PathVariable String id) {
        return repository.getCanciones().stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    // GET /api/canciones/top10
    @GetMapping("/top10")
    public List<Cancion> verTop10() {
        return streamingService.obtenerTop10(repository.getCanciones());
    }

    // GET /api/canciones/filtrar/genero=ROCK
    @GetMapping("/filtrar")
    public List<Cancion> filtrar(@RequestParam Genero genero, @RequestParam double rating) {
        return streamingService.filtrarCanciones(repository.getCanciones(), genero, rating);
    }



    // GET /api/canciones/buscar-binaria/titulo=Bohemian Rhapsody
    @GetMapping("/buscar-binaria")
    public ResponseEntity<Integer> busquedaBinaria(@RequestParam String titulo) {
        int posicion = busquedaService.busquedaBinariaPorTitulo(repository.getCanciones(), titulo);
        return ResponseEntity.ok(posicion);
    }


    // GET /api/canciones/{id}/recomendar
    @GetMapping("/{id}/recomendar")
    public List<Cancion> recomendar(@PathVariable String id) {
        Cancion base = repository.getCanciones().stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElseThrow();
        
        // Seteamos la estrategia (por ejemplo, por género)
        streamingService.setEstrategia(estrategiaGenero);
        return streamingService.ejecutarRecomendacion(repository.getCanciones(), base);
    }


    // POST /api/canciones/{id}/reproducir
    @PostMapping("/{id}/reproducir")
    public ResponseEntity<String> reproducir(@PathVariable String id) {
        return repository.getCanciones().stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .map(c -> {
                    reproduccionService.reproducirCancionConcurrente(c);
                    return ResponseEntity.ok("Reproducciones actuales de " + c.getTitulo() + ": " + c.getReproducciones().get());
                })
                .orElse(ResponseEntity.notFound().build());
    }
}