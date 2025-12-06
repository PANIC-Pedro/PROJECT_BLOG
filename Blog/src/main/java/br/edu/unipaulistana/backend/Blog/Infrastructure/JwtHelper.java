package br.edu.unipaulistana.backend.Blog.Infrastructure;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.swing.plaf.PanelUI;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Component
public class JwtHelper {
   private final String SECRET = "CHAVE_SECRETA_SUPER_FUCKER_SECRETA_PRA_CARAI_MERMO";
   private final int TOKEN_EXPIRATION_MS=1000*60*60*24*2;


   public  String generateToken(UserDetails userDetails){
       return Jwts.builder()
               .setSubject(userDetails.getUsername())
               .setIssuedAt(new Date())
               .setExpiration(new Date(System.currentTimeMillis() + TOKEN_EXPIRATION_MS))
               .signWith(this.getSigningKey())
               .compact();

   }
   public String extractUsername(String token){
       return Jwts.parserBuilder()
               .setSigningKey(this.getSigningKey())
               .build()
               .parseClaimsJwt(token)
               .getBody()
               .getSubject();
   }
public boolean isTokenExpired (String token){
      return Jwts.parserBuilder()
              //.Date expirationDate = Jwts.parserBuilder()
               .setSigningKey(this.getSigningKey())
               .build()
              .parseClaimsJwt(token)
              .getBody()
              .getExpiration().before(new Date());
}
public Key getSigningKey(){
       return Keys.hmacShaKeyFor(SECRET.getBytes());
}
public boolean isTokenValid(String token , UserDetails userDetails){
       final String username = this.extractUsername(token);
       return username.equals(userDetails.getUsername())
               && !isTokenExpired(token);

}



}
