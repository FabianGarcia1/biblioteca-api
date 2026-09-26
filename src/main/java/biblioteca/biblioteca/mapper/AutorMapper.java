package biblioteca.biblioteca.mapper;

import biblioteca.biblioteca.Model.Autor;
import biblioteca.biblioteca.Model.Libro;
import biblioteca.biblioteca.dto.AutorConLibrosDTO;
import biblioteca.biblioteca.dto.AutorCreateDTO;
import biblioteca.biblioteca.dto.AutorResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = LibroMapper.class)
public interface AutorMapper {

    Autor toEntity(AutorCreateDTO dto);

    AutorResponseDTO toResponseDTO(Autor autor);

    AutorConLibrosDTO toAutorConLibrosDTO(Autor autor);

    void updateEntity(AutorCreateDTO dto, @MappingTarget Autor autor);

}
