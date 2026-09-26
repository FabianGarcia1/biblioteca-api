package biblioteca.biblioteca.Service;

import biblioteca.biblioteca.Model.Autor;
import biblioteca.biblioteca.Model.Libro;
import biblioteca.biblioteca.Repository.AutorRepository;
import biblioteca.biblioteca.Repository.LibroRepository;
import biblioteca.biblioteca.dto.AutorConLibrosDTO;
import biblioteca.biblioteca.dto.AutorCreateDTO;
import biblioteca.biblioteca.dto.AutorResponseDTO;
import biblioteca.biblioteca.dto.LibroSimpleDTO;
import biblioteca.biblioteca.mapper.AutorMapper;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;

@Service
public class AutorServiceIMPL implements IAutorService{

    private final LibroRepository libroRepository;

    private final AutorMapper autorMapper;

    private final AutorRepository autorRepository;

    public AutorServiceIMPL(AutorRepository autorRepository, AutorMapper autorMapper, LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
        this.autorMapper = autorMapper;
        this.autorRepository = autorRepository;
    }

    @Override
    public AutorResponseDTO createAutor(AutorCreateDTO dto) {
        Autor autor = autorMapper.toEntity(dto);

        Autor autorGuardado = autorRepository.save(autor);

        return autorMapper.toResponseDTO(autorGuardado);
    }

    @Override
    public AutorConLibrosDTO getAutorById(Long id) {
        Autor autor = autorRepository.findById(id)
                .orElseThrow(() -> new ResolutionException("Autor no encontrado"));

        return autorMapper.toAutorConLibrosDTO(autor);
    }

}
