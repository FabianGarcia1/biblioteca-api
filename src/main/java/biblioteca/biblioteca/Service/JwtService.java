package biblioteca.biblioteca.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String secret;

    private SecretKey getSigningKey(){
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(secret));
    }

    public String createToken(Authentication authentication) {

        return Jwts.builder()
                .subject(authentication.getName())
                .expiration(new Date(new Date().getTime() + 3600000))
                .claim("rol",  authentication.getAuthorities().stream().findFirst().orElseThrow().getAuthority())
                .signWith(getSigningKey())
                .compact();
    }

    public String extractUsername(String token){

        return Jwts.parser().verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();

    }
}
