package unlar.edu.ar.StreamingMusicaTP.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//Esta se usa cuando se buscas algo (Canción, Artista, Álbum) y no existe en la lista
// Esta anotación le dice a Spring que devuelva un 404 automáticamente
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    
    public ResourceNotFoundException(String message) {
        super(message);
    }
}