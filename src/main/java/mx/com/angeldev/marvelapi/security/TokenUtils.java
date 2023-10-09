package mx.com.angeldev.marvelapi.security;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class TokenUtils {
	
	private TokenUtils() {
		
	}
	
	private final static String ACCESS_TOKEN_SECRET = "a611acf491a4464dcd30ef8a7f675fdb";//llaveSecreta
	
	private final static Long ACCESS_TOKEN_VALIDITY_SECONDS = 2_592_000L;//30 días
	
	
	public static String createToken(String nombre, String email) {
		
		long expirationTime = ACCESS_TOKEN_VALIDITY_SECONDS * 1000;
		
		Date expirationDate = new Date(System.currentTimeMillis()+expirationTime);
		
		Map<String, Object> extraParams = new HashMap<>();
		
		extraParams.put("nombre", nombre);
		
		return Jwts.builder()
				.setSubject(email)
				.setExpiration(expirationDate)
				.addClaims(extraParams)
				.signWith(Keys.hmacShaKeyFor(ACCESS_TOKEN_SECRET.getBytes()))
				.compact();
	}
	
	public static UsernamePasswordAuthenticationToken getAuthentication(String token) {
		try {
			Claims claims = Jwts.parserBuilder()
					.setSigningKey(ACCESS_TOKEN_SECRET.getBytes())
					.build()
					.parseClaimsJws(token)
					.getBody();
			
			String email = claims.getSubject();
			
			return new UsernamePasswordAuthenticationToken(email, null, Collections.emptyList());
			
		} catch (JwtException e) {
			return null;
		}
	}

}
