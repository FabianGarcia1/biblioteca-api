package biblioteca.biblioteca.mapper;

import biblioteca.biblioteca.Model.Libro;
import biblioteca.biblioteca.dto.LibroCreateDTO;
import biblioteca.biblioteca.dto.LibroResponseDTO;
import biblioteca.biblioteca.dto.LibroSimpleDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface LibroMapper {

    LibroResponseDTO toResponseDTO(Libro libro);

    LibroSimpleDTO toSimpleDTO(Libro libro);

    Libro toEntity(LibroCreateDTO dto);

    void updateEntity(LibroCreateDTO dto, @MappingTarget Libro libroExist);
}