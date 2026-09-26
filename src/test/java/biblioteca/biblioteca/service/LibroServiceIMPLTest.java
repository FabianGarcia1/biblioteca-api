package biblioteca.biblioteca.service;

import biblioteca.biblioteca.Model.Autor;
import biblioteca.biblioteca.Model.Libro;
import biblioteca.biblioteca.Repository.AutorRepository;
import biblioteca.biblioteca.Repository.LibroRepository;
import biblioteca.biblioteca.Service.LibroServiceIMPL;
import biblioteca.biblioteca.dto.LibroCreateDTO;
import biblioteca.biblioteca.dto.LibroResponseDTO;
import biblioteca.biblioteca.mapper.LibroMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LibroServiceIMPLTest {

    @Mock
    private LibroRepository libroRepository;

    @Mock
    private AutorRepository autorRepository;

    @Mock
    private LibroMapper libroMapper;

    @InjectMocks
    private LibroServiceIMPL libroService;

    @Test
    void crearLibro_deberiaCrearLibroCorrectamente() {

        LibroCreateDTO dto = new LibroCreateDTO();
        dto.setTitulo("Cien años de soledad");
        dto.setAutorId(1L);

        Autor autor = new Autor();
        autor.setId(1L);

        when(autorRepository.findById(1L))
                .thenReturn(Optional.of(autor));

        Libro libro = new Libro();
        libro.setTitulo("Cien años de soledad");

        when(libroMapper.toEntity(dto))
                .thenReturn(libro);

        when(libroRepository.save(libro))
                .thenReturn(libro);

        LibroResponseDTO responseDTO = new LibroResponseDTO();

        when(libroMapper.toResponseDTO(libro))
                .thenReturn(responseDTO);

        LibroResponseDTO resultado = libroService.createLibro(dto);

        assertEquals(responseDTO, resultado);
        verify(autorRepository).findById(1L);
        verify(libroRepository).save(libro);
        verify(libroMapper).toResponseDTO(libro);
    }
}
