package unlar.edu.ar.StreamingMusicaTP.service;

import org.springframework.stereotype.Service;
import unlar.edu.ar.StreamingMusicaTP.model.Cancion;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Service
public class ReproduccionService {

    // Simula 100 usuarios reproduciendo la canción al mismo tiempo
    public void reproducirCancionConcurrente(Cancion cancion) {
        ExecutorService executor = Executors.newFixedThreadPool(10); // 10 hilos trabajando

        for (int i = 0; i < 100; i++) {
            executor.submit(() -> {
                // El método incrementAndGet() de AtomicInteger es seguro para hilos
                cancion.getReproducciones().incrementAndGet();
            });
        }

        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}