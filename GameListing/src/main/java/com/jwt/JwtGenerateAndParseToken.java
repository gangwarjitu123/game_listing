package com.jwt;

import java.util.Date;
import java.util.UUID;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;

@Component
public class JwtGenerateAndParseToken {
	private String signingKey = "@1234567";

	public String generateToken(JwtToken jwtToken) {
		JwtBuilder jwtsBuilder = Jwts.builder();
		jwtsBuilder.setIssuer(jwtToken.getIssuer());
		jwtsBuilder.setId(UUID.randomUUID().toString());
		jwtsBuilder.setIssuedAt(new Date());
		String token = jwtsBuilder.signWith(SignatureAlgorithm.HS256, signingKey).compact();
		return token;

	}

	public boolean parseJwtToken(String token) {

		try {

			Jwt jwtClaims = Jwts.parser().setSigningKey(signingKey).parse(token);
			Claims claims = (Claims) jwtClaims.getBody();
			String issuer = claims.getIssuer();
			return true;

		} catch (SignatureException e) {

			return false;

		}

	}

}
