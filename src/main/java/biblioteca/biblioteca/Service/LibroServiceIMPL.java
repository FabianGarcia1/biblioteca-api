package biblioteca.biblioteca.Service;

import biblioteca.biblioteca.Model.Autor;
import biblioteca.biblioteca.Model.Libro;
import biblioteca.biblioteca.Repository.AutorRepository;
import biblioteca.biblioteca.Repository.LibroRepository;
import biblioteca.biblioteca.dto.LibroCreateDTO;
import biblioteca.biblioteca.dto.LibroResponseDTO;
import biblioteca.biblioteca.mapper.LibroMapper;
import org.springframework.stereotype.Service;


import java.lang.module.ResolutionException;
import java.util.ArrayList;
import java.util.List;

@Service
public class LibroServiceIMPL implements ILibroService{

    private final LibroRepository libroRepository;

    private final LibroMapper libroMapper;

    private final AutorRepository autorRepository;

    public LibroServiceIMPL(LibroRepository libroRepository, LibroMapper libroMapper, AutorRepository autorRepository) {
        this.libroRepository = libroRepository;
        this.libroMapper = libroMapper;
        this.autorRepository = autorRepository;
    }

    @Override
    public List<LibroResponseDTO> listLibros() {
        List<Libro> libros = libroRepository.findAll();

        List<LibroResponseDTO> librosDTO = new ArrayList<>();

        for (Libro libro : libros){
            librosDTO.add(libroMapper.toResponseDTO(libro));
        }
        return librosDTO;
    }


    @Override
    public LibroResponseDTO createLibro(LibroCreateDTO dto) {

        Autor autor = autorRepository.findById(dto.getAutorId())
                .orElseThrow(() -> new ResolutionException("Autor no encontrado"));

        Libro libro = libroMapper.toEntity(dto);

        libro.setAutor(autor);
        libro.setDisponible(true);

        Libro libroGuardado = libroRepository.save(libro);

        return libroMapper.toResponseDTO(libroGuardado);
    }

    @Override
    public LibroResponseDTO findLibroById(Long idLibro) {
        Libro libro = this.libroRepository.findById(idLibro).orElseThrow(() -> new ResolutionException("No se encontro el libro: " + idLibro));

        return libroMapper.toResponseDTO(libro);
    }

    @Override
    public LibroResponseDTO updateLibro(Long idLibro,LibroCreateDTO dto) {
        Libro libroExist = this.libroRepository.findById(idLibro)
                .orElseThrow(() -> new ResolutionException("No se encontro el libro: " + idLibro));

        libroMapper.updateEntity(dto, libroExist);

        Libro libroActualizado = libroRepository.save(libroExist);

        return libroMapper.toResponseDTO(libroActualizado);
    }

    @Override
    public void deleteLibro(Long idLibro) {
    this.libroRepository.deleteById(idLibro);
    }

}
