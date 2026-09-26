package biblioteca.biblioteca.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LibroSimpleDTO {

    private Long id;
    private String titulo;
    private String editorial;
    private int anioPublicacion;
    private boolean disponible;
}
