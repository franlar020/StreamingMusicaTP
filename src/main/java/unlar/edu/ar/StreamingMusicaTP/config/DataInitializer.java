package unlar.edu.ar.StreamingMusicaTP.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import unlar.edu.ar.StreamingMusicaTP.model.*;
import unlar.edu.ar.StreamingMusicaTP.repository.CatalogoRepository;
import java.time.LocalDate;
import java.util.ArrayList;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(CatalogoRepository repository) {
        return args -> {
            // 4 Productoras
            Productora sony = new Productora("P1", "Sony Music", new ArrayList<>());
            Productora warner = new Productora("P2", "Warner Music", new ArrayList<>());
            Productora universal = new Productora("P3", "Universal", new ArrayList<>());
            Productora indie = new Productora("P4", "Indie Records", new ArrayList<>());

            // --- CARGA DE 10 ARTISTAS / ÁLBUMES / CANCIONES ---

            // 1. Rock - Queen (Warner)
            Album a1 = new Album("AL1", "A Night at the Opera", "Queen", 1975, new ArrayList<>());
            Cancion c1 = new Cancion("C1", "Bohemian Rhapsody", "Queen", "A Night at the Opera", Genero.ROCK, 354, 5.0, LocalDate.of(1975, 10, 31));
            a1.getCanciones().add(c1);
            repository.guardar(c1);

            // 2. Pop - Michael Jackson (Sony)
            Album a2 = new Album("AL2", "Thriller", "Michael Jackson", 1982, new ArrayList<>());
            Cancion c2 = new Cancion("C2", "Billie Jean", "Michael Jackson", "Thriller", Genero.POP, 294, 4.9, LocalDate.of(1982, 1, 2));
            a2.getCanciones().add(c2);
            repository.guardar(c2);

            // 3. Jazz - Miles Davis (Sony)
            Album a3 = new Album("AL3", "Kind of Blue", "Miles Davis", 1959, new ArrayList<>());
            Cancion c3 = new Cancion("C3", "So What", "Miles Davis", "Kind of Blue", Genero.JAZZ, 562, 4.8, LocalDate.of(1959, 8, 17));
            a3.getCanciones().add(c3);
            repository.guardar(c3);

            // 4. Electrónica - Daft Punk (Warner)
            Album a4 = new Album("AL4", "Discovery", "Daft Punk", 2001, new ArrayList<>());
            Cancion c4 = new Cancion("C4", "One More Time", "Daft Punk", "Discovery", Genero.ELECTRONICA, 320, 4.7, LocalDate.of(2001, 2, 26));
            a4.getCanciones().add(c4);
            repository.guardar(c4);

            // 5. Clásica - Beethoven (Indie)
            Album a5 = new Album("AL5", "Symphony No. 9", "Beethoven", 1824, new ArrayList<>());
            Cancion c5 = new Cancion("C5", "Ode to Joy", "Beethoven", "Symphony No. 9", Genero.CLASICA, 840, 5.0, LocalDate.of(1824, 5, 7));
            a5.getCanciones().add(c5);
            repository.guardar(c5);

            // 6. Rock - Arctic Monkeys (Indie)
            Album a6 = new Album("AL6", "AM", "Arctic Monkeys", 2013, new ArrayList<>());
            Cancion c6 = new Cancion("C6", "Do I Wanna Know?", "Arctic Monkeys", "AM", Genero.ROCK, 272, 4.6, LocalDate.of(2013, 6, 18));
            a6.getCanciones().add(c6);
            repository.guardar(c6);

            // 7. Pop - Dua Lipa (Warner)
            Album a7 = new Album("AL7", "Future Nostalgia", "Dua Lipa", 2020, new ArrayList<>());
            Cancion c7 = new Cancion("C7", "Levitating", "Dua Lipa", "Future Nostalgia", Genero.POP, 203, 4.5, LocalDate.of(2020, 3, 27));
            a7.getCanciones().add(c7);
            repository.guardar(c7);

            // 8. Jazz - Norah Jones (Universal)
            Album a8 = new Album("AL8", "Come Away with Me", "Norah Jones", 2002, new ArrayList<>());
            Cancion c8 = new Cancion("C8", "Don't Know Why", "Norah Jones", "Come Away with Me", Genero.JAZZ, 186, 4.4, LocalDate.of(2002, 2, 26));
            a8.getCanciones().add(c8);
            repository.guardar(c8);

            // 9. Electrónica - Avicii (Universal)
            Album a9 = new Album("AL9", "True", "Avicii", 2013, new ArrayList<>());
            Cancion c9 = new Cancion("C9", "Wake Me Up", "Avicii", "True", Genero.ELECTRONICA, 247, 4.8, LocalDate.of(2013, 6, 17));
            a9.getCanciones().add(c9);
            repository.guardar(c9);

            // 10. Rock - Soda Stereo (Sony)
            Album a10 = new Album("AL10", "Canción Animal", "Soda Stereo", 1990, new ArrayList<>());
            Cancion c10 = new Cancion("C10", "De Música Ligera", "Soda Stereo", "Canción Animal", Genero.ROCK, 212, 4.9, LocalDate.of(1990, 8, 7));
            a10.getCanciones().add(c10);
            repository.guardar(c10);

            System.out.println("✓ Catálogo inicializado");
        };
    }
}