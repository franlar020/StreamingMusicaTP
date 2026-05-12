# Streaming Music REST API - UNLaR

Plataforma de backend tipo Spotify desarrollada para la cátedra de **Programación Orientada a Objetos Avanzada**. El proyecto aplica procesamiento funcional, patrones de diseño y manejo de concurrencia.

<p align="center">
  <img src="https://www.reuters.com/resizer/v2/RLXKOPMF2JJ47OUQQB7MPTP4W4.jpg?auth=84ad223581307918ed72f4bdf958e1e0cb219731a3401beb161fd900ca26210d&width=1920&quality=80" alt="Cajero refencia" width="600"/>
</p>

## Información Académica
* **Institución:** Universidad Nacional de La Rioja (UNLaR).
* **Departamento:** DACEFYN (Departamento Académico de Ciencias Exactas, Físicas y Naturales).
* **Proyecto:** Backend de Plataforma de Streaming de Música.

<p align="center">
  <img src="https://www.unlar.edu.ar/images/Identidad/Logo-UNLAR.png" alt="Cajero refencia" width="600"/>
</p>

## Requisitos y Stack Tecnológico
| Componente | Tecnología |
|---|---|
| **Lenguaje** | Java 21+ |
| **Framework** | Spring Boot 4.x |
| **API** | REST + Swagger/OpenAPI |
| **Concurrencia** | AtomicInteger (Thread-safe) |
| **Almacenamiento** | In-memory (H2 o ArrayList) |
| **Build Tool** | Maven |

## Modelo de Datos
El sistema implementa un modelo de dominio normalizado que incluye:
* **Canción:** Posee ID (UUID), título, artista, álbum, género (Enum), duración en segundos, reproducciones, rating (0.0-5.0) y fecha de lanzamiento.
* **Relaciones:** Soporte para que un álbum contenga múltiples canciones y una discográfica/productora gestione múltiples álbumes y artistas.
* **Concurrencia:** Las reproducciones se gestionan mediante `AtomicInteger` para garantizar la integridad en entornos multihilo.

## Operaciones con Streams API
Se implementaron las siguientes funcionalidades avanzadas:
* **Filtrado Compuesto:** Por género, artista, rango de años y rating mínimo.
* **Top 10:** Las canciones más reproducidas utilizando comparadores y límites.
* **Estadísticas:** * Promedio de duración por género.
    * Artista más popular (máximo por reproducciones).
    * Distribución de catálogo por décadas.


## Patrón de Diseño: Strategy
El sistema de recomendaciones utiliza el patrón **Strategy** para definir algoritmos intercambiables:
1. **Recomendación Por Género:** Mismo género de la canción base, ordenadas por rating.
2. **Recomendación Por Popularidad:** Top 5 de las canciones más reproducidas globalmente.
3. **Recomendación Descubrimiento:** Canciones con menos de 1000 reproducciones, de género diferente y lanzamiento reciente (< 2 años).

## Endpoints Principales

| Método | Ruta | Descripción |
|---|---|---|
| `GET` | `/api/canciones` | Listado general con paginación opcional. |
| `GET` | `/api/canciones/{id}` | Búsqueda de canción por ID. |
| `GET` | `/api/canciones/buscar` | Búsqueda filtrada por título y artista. |
| `POST` | `/api/canciones/{id}/reproducir` | Incrementa el contador de reproducciones. |
| `GET` | `/api/{recurso}` | Listado de entidades (artistas, albumes, productoras). |

## 👨‍💻 Desarrolladores / Integrantes del equipo

<p align="center">
  <table align="center">
    <tr>
      <td align="center" valign="center" width="30%">
        <a href="https://github.com/IsmaDeveloper16">
          <img src="Imagenes necesarias/Isma.jpeg" width="300"/><br />
          <sub><b>Ismael Flores</b></sub>
        </a>
      </td>
      <td align="center" valign="center" width="30%">
        <a href="https://github.com/franlar020">
          <img src="Imagenes necesarias/Fran.jpeg" width="300"/><br />
          <sub><b>Francisco Antonio Gonzalez</b></sub>
        </a>
      </td>
      <td align="center" valign="center" width="30%">
        <a href="https://github.com/VirginiaVeraHerrera">
          <img src="Imagenes necesarias/Vir.jpeg" width="300"/><br />
          <sub><b>Virginia Vera</b></sub>
        </a>
      </td>
    </tr>
  </table>
</p>
