package biblioteca.biblioteca.Service;

import biblioteca.biblioteca.Model.Libro;
import biblioteca.biblioteca.dto.LibroCreateDTO;
import biblioteca.biblioteca.dto.LibroResponseDTO;

import java.util.List;

public interface ILibroService {

    List<LibroResponseDTO> listLibros();

    LibroResponseDTO createLibro (LibroCreateDTO dto);

    LibroResponseDTO findLibroById (Long idLibro);

    LibroResponseDTO updateLibro (Long id, LibroCreateDTO dto);

    void deleteLibro (Long idLibro);
}
