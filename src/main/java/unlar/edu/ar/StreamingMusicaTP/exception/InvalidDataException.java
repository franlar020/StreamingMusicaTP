package unlar.edu.ar.StreamingMusicaTP.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


//Esta clase es para cuando los datos no cumplen las reglas de negocio (ejemplo: rating mayor a 5, duración negativa o título vacío).
// Esta anotación devuelve un 400 (Bad Request)
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidDataException extends RuntimeException {
    
    public InvalidDataException(String message) {
        super(message);
    }
}