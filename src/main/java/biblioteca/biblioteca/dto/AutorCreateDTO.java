package biblioteca.biblioteca.dto;

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
public class AutorCreateDTO {

    @NotBlank(message = "El autor no puede estar vacío")
    @Size(max = 80, message = "El autor no puede tener más de 80 caracteres")
    private String nombreAutor;

}
