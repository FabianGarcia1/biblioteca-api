package biblioteca.biblioteca.Controller;

import biblioteca.biblioteca.Service.IAutorService;
import biblioteca.biblioteca.dto.AutorConLibrosDTO;
import biblioteca.biblioteca.dto.AutorCreateDTO;
import biblioteca.biblioteca.dto.AutorResponseDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/autores")
public class AutorController {

    private final IAutorService autorService;

    public AutorController(IAutorService autorService) {
        this.autorService = autorService;
    }

    @PostMapping
    public ResponseEntity<AutorResponseDTO> createAutor(
            @Valid @RequestBody AutorCreateDTO dto) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(autorService.createAutor(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AutorConLibrosDTO> getAutorById(
            @PathVariable Long id) {

        return ResponseEntity.ok(autorService.getAutorById(id));
    }
}
