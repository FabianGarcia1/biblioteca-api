package biblioteca.biblioteca.Controller;

import biblioteca.biblioteca.Model.Libro;
import biblioteca.biblioteca.Service.ILibroService;
import biblioteca.biblioteca.dto.LibroCreateDTO;
import biblioteca.biblioteca.dto.LibroResponseDTO;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LibroController {

    private static final Logger logger = LoggerFactory.getLogger(LibroController.class);

    private final ILibroService libroService;

    public LibroController(ILibroService libroService) {
        this.libroService = libroService;
    }

    @GetMapping("/libros")
    public List<LibroResponseDTO> getAllLibros() {

        logger.info("Obteniendo todos los libros");

        List<LibroResponseDTO> libros = libroService.listLibros();

        logger.info("Se encontraron {} libros", libros.size());

        return libros;
    }

    @PostMapping("/libros")
    public LibroResponseDTO createLibro (@Valid @RequestBody LibroCreateDTO dto){
        logger.info("Libro creado: {}", dto);
        return this.libroService.createLibro(dto);
    }

    @GetMapping("libros/{id}")
    public LibroResponseDTO getLibroByid (@PathVariable Long id){

        LibroResponseDTO libro = libroService.findLibroById(id);

        logger.info("Libro encontrado: {}",libro);

        return libro;
    }

    @PutMapping("/libros/{id}")
    public ResponseEntity<LibroResponseDTO> updateLibro(@Valid @PathVariable Long id,
                                                        @RequestBody LibroCreateDTO dto) {

        LibroResponseDTO libroActualizado = libroService.updateLibro(id, dto);

        return ResponseEntity.ok(libroActualizado);
    }

    @DeleteMapping("/libros/{id}")
    public ResponseEntity<Void> deleteLibro(@PathVariable Long id) {

        libroService.deleteLibro(id);

        return ResponseEntity.noContent().build();
    }
}
