package com.yosmitha.enterprise_iam.config;
import io.jsonwebtoken.*;import io.jsonwebtoken.security.Keys;import org.springframework.beans.factory.annotation.Value;import org.springframework.stereotype.Service;
import javax.crypto.SecretKey;import java.util.*;import java.time.Instant;
@Service public class JwtService {
 private final SecretKey key;private final long accessMinutes;
 public JwtService(@Value("${app.jwt.secret}") String secret,@Value("${app.jwt.access-minutes}") long m){byte[] b=Base64.getDecoder().decode(secret);if(b.length<32)throw new IllegalStateException("JWT secret must decode to 32 bytes");key=Keys.hmacShaKeyFor(b);accessMinutes=m;}
 public String access(String email,Long id,List<String> authorities){Instant n=Instant.now();return Jwts.builder().subject(email).claim("uid",id).claim("authorities",authorities).issuedAt(Date.from(n)).expiration(Date.from(n.plusSeconds(accessMinutes*60))).signWith(key).compact();}
 public String refresh(String email,Long id,long days){Instant n=Instant.now();return Jwts.builder().subject(email).claim("uid",id).claim("type","refresh").issuedAt(Date.from(n)).expiration(Date.from(n.plusSeconds(days*86400))).signWith(key).compact();}
 public long expires(){return accessMinutes*60;}
}
