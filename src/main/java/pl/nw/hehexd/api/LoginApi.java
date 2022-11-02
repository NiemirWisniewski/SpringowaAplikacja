package pl.nw.hehexd.api;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class LoginApi {

    @PostMapping("/login")
    public ResponseEntity<String> Loging(String username, String password){
        Long currentTimeMillis = System.currentTimeMillis();
        String token = Jwts.builder()
                .setSubject(username)
                .claim("roles", "user")
                .setIssuedAt(new Date(currentTimeMillis))
                .setExpiration(new Date(currentTimeMillis + 20000))
                .signWith(SignatureAlgorithm.HS512, password)
                .compact();
        return ResponseEntity.ok().body(token);
    }
}
