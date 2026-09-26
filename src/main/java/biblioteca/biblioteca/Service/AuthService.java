package biblioteca.biblioteca.Service;

import biblioteca.biblioteca.Model.User;
import biblioteca.biblioteca.Repository.UserRepository;
import biblioteca.biblioteca.dto.LoginRequestDTO;
import biblioteca.biblioteca.dto.RegisterRequestDTO;
import org.mapstruct.control.MappingControl;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final AuthenticationManager authenticationManager;

    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    private final JwtService jwtService;

    public AuthService (AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder, UserRepository userRepository, JwtService jwtService){
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
    }

    public String login(LoginRequestDTO loginRequestDTO){

        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(
                        loginRequestDTO.getUsername(),
                        loginRequestDTO.getPassword()
                );

        Authentication authentication =
                authenticationManager.authenticate(token);

        return jwtService.createToken(authentication);
    }

    public void register(RegisterRequestDTO dto) {

        User userCreate = new User();
        userCreate.setUsername(dto.getUsername());
        userCreate.setRol(dto.getRol());
        userCreate.setPassword(
                passwordEncoder.encode(dto.getPassword())
        );

        userRepository.save(userCreate);
    }

}
