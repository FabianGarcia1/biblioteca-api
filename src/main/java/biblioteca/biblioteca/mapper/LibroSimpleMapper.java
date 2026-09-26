package biblioteca.biblioteca.mapper;

import biblioteca.biblioteca.Model.Libro;
import biblioteca.biblioteca.dto.LibroSimpleDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LibroSimpleMapper {

    LibroSimpleDTO toDTO(Libro libro);
}
