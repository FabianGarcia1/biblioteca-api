import io.jsonwebtoken.io.Encoders;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class JwtSecretGenerator {

    public static void main(String[] args) throws Exception {

        KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacSHA256");
        keyGenerator.init(256);

        SecretKey key = keyGenerator.generateKey();

        String secret = Encoders.BASE64.encode(key.getEncoded());

        System.out.println(secret);
    }
}