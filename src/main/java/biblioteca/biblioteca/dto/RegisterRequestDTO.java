package biblioteca.biblioteca.dto;

import biblioteca.biblioteca.Model.Rol;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class RegisterRequestDTO {
    private String username;
    private String password;
    private Rol rol;
}
