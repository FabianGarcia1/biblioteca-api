package biblioteca.biblioteca.Service;

import biblioteca.biblioteca.dto.AutorConLibrosDTO;
import biblioteca.biblioteca.dto.AutorCreateDTO;
import biblioteca.biblioteca.dto.AutorResponseDTO;

public interface IAutorService {

    AutorResponseDTO createAutor(AutorCreateDTO dto);

    AutorConLibrosDTO getAutorById(Long id);
}
