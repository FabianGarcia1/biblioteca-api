package biblioteca.biblioteca.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LibroCreateDTO {

    @NotBlank(message = "El título no puede estar vacío")
    @Size(max = 100, message = "El título no puede tener más de 100 caracteres")
    private String titulo;

    private Long autorId;

    @NotBlank(message = "La editorial no puede estar vacía")
    @Size(max = 80, message = "La editorial no puede tener más de 80 caracteres")
    private String editorial;

    @Min(value = 1400, message = "El año de publicación debe ser mayor o igual a 1400")
    private int anioPublicacion;
}
