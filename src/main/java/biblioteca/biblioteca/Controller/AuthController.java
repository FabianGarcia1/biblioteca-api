package biblioteca.biblioteca.Controller;

import biblioteca.biblioteca.Service.AuthService;
import biblioteca.biblioteca.dto.LoginRequestDTO;
import biblioteca.biblioteca.dto.RegisterRequestDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController (AuthService authService){
        this.authService = authService;
    }

    @PostMapping("/login")
    public String login (@RequestBody LoginRequestDTO dto){

        String token = authService.login(dto);

        return token;
    }

    @PostMapping("/register")
    public void register(@RequestBody RegisterRequestDTO dto) {
        authService.register(dto);
    }
}
